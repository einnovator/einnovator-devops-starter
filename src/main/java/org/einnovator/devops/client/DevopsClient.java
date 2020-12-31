package org.einnovator.devops.client;

import static org.einnovator.util.UriUtils.makeURI;
import static org.einnovator.util.web.RequestOptions.isAdminRequest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.config.DevopsClientConfiguration;
import org.einnovator.devops.client.config.DevopsEndpoints;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Catalog;
import org.einnovator.devops.client.model.Cluster;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.CronJob;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Domain;
import org.einnovator.devops.client.model.Event;
import org.einnovator.devops.client.model.Instance;
import org.einnovator.devops.client.model.Job;
import org.einnovator.devops.client.model.License;
import org.einnovator.devops.client.model.Mount;
import org.einnovator.devops.client.model.NamedEntity;
import org.einnovator.devops.client.model.Registry;
import org.einnovator.devops.client.model.Repository;
import org.einnovator.devops.client.model.Resources;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.model.Solution;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.model.Variable;
import org.einnovator.devops.client.model.Vcs;
import org.einnovator.devops.client.model.VolumeClaim;
import org.einnovator.devops.client.modelx.CatalogFilter;
import org.einnovator.devops.client.modelx.CatalogOptions;
import org.einnovator.devops.client.modelx.ClusterFilter;
import org.einnovator.devops.client.modelx.ClusterOptions;
import org.einnovator.devops.client.modelx.CronJobFilter;
import org.einnovator.devops.client.modelx.CronJobOptions;
import org.einnovator.devops.client.modelx.DeploymentFilter;
import org.einnovator.devops.client.modelx.DeploymentOptions;
import org.einnovator.devops.client.modelx.DomainFilter;
import org.einnovator.devops.client.modelx.DomainOptions;
import org.einnovator.devops.client.modelx.EventFilter;
import org.einnovator.devops.client.modelx.ExecOptions;
import org.einnovator.devops.client.modelx.InstallOptions;
import org.einnovator.devops.client.modelx.JobFilter;
import org.einnovator.devops.client.modelx.JobOptions;
import org.einnovator.devops.client.modelx.LicenseFilter;
import org.einnovator.devops.client.modelx.LicenseOptions;
import org.einnovator.devops.client.modelx.LogOptions;
import org.einnovator.devops.client.modelx.ManifestOptions;
import org.einnovator.devops.client.modelx.RegistryFilter;
import org.einnovator.devops.client.modelx.RegistryOptions;
import org.einnovator.devops.client.modelx.SolutionFilter;
import org.einnovator.devops.client.modelx.SolutionOptions;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.devops.client.modelx.SpaceOptions;
import org.einnovator.devops.client.modelx.VcsFilter;
import org.einnovator.devops.client.modelx.VcsOptions;
import org.einnovator.devops.client.modelx.VolumeClaimFilter;
import org.einnovator.util.PageResult;
import org.einnovator.util.PageUtil;
import org.einnovator.util.UriUtils;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.security.Authority;
import org.einnovator.util.web.RequestOptions;
import org.einnovator.util.web.Result;
import org.einnovator.util.web.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 * Client to the Cloud Manager service.
 * 
 * <p>Provide methods for all server endpoints and resource types. 
 * <p>Including: {@link Cluster}, {@link Space}, {@link Deployment}, and {@link Job}.
 * <p>Errors are propagated using Java runtime exceptions.
 * <p>For caching enabled "high-level" API, see Manager classes.
 * <p>{@code DevopsClientConfiguration} specifies configuration details, including server URL and client credentials.
 * <p>Property {@link #getConfig()} provides the default {@code DevopsClientConfiguration} to use.
 * <p>Internally, {@code SocialClient} uses a {@code OAuth2RestTemplate} to invoke a remote server.
 * <p>When setup as a <b>Spring Bean</b> both {@code SocialClientConfiguration} and {@code OAuth2RestTemplate} are auto-configured.
 * <p>Requests use a session-scoped  {@code OAuth2ClientContext} if running in a web-environment.
 * <p>If the invoking thread does not have an associated web session, the default behavior is to fallback to use {@link #restTemplate0}.
 * 
 * @see org.einnovator.devops.client.manager.SpaceManager
 * @see org.einnovator.devops.client.manager.DeploymentManager
 * @see org.einnovator.devops.client.manager.VcsManager
 * 
 * @author support@einnovator.org
 *
 */
public class DevopsClient {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClientConfiguration config;
	
	@Autowired(required=false)
	@Qualifier("devopsRestTemplate")
	private OAuth2RestTemplate restTemplate;
	
	private RestTemplate restTemplate0;
	
	@Autowired
	public DevopsClient() {
	}

	/**
	 * Create instance of {@code DevopsClient}.
	 * 
	 * @param config the {@code DevopsClientConfiguration}
	 */
	public DevopsClient(DevopsClientConfiguration config) {
		this.config = config;
	}

	/**
	 * Create instance of {@code DevopsClient}.
	 * 
	 * @param restTemplate a {@code OAuth2RestTemplate}
	 * @param config the {@code DevopsClientConfiguration}
	 */
	public DevopsClient(OAuth2RestTemplate restTemplate, DevopsClientConfiguration config) {
		this.restTemplate = restTemplate;
		this.config = config;
	}

	/**
	 * Create instance of {@code DevopsClient}.
	 * 
	 * @param restTemplate a {@code RestTemplate}
	 * @param config the {@code DevopsClientConfiguration}
	 */
	public DevopsClient(RestTemplate restTemplate, DevopsClientConfiguration config) {
		this.restTemplate0 = restTemplate;
		this.config = config;
	}

	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code restTemplate}.
	 *
	 * @return the restTemplate
	 */
	public OAuth2RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/**
	 * Set the value of property {@code restTemplate}.
	 *
	 * @param restTemplate the value of property restTemplate
	 */
	public void setRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Get the value of property {@code restTemplate0}.
	 *
	 * @return the restTemplate0
	 */
	public RestTemplate getRestTemplate0() {
		return restTemplate0;
	}

	/**
	 * Set the value of property {@code restTemplate0}.
	 *
	 * @param restTemplate0 the value of property restTemplate0
	 */
	public void setRestTemplate0(RestTemplate restTemplate0) {
		this.restTemplate0 = restTemplate0;
	}

	/**
	 * Get the value of property {@code config}.
	 *
	 * @return the config
	 */
	public DevopsClientConfiguration getConfig() {
		return config;
	}

	/**
	 * Set the value of property {@code config}.
	 *
	 * @param config the value of property config
	 */
	public void setConfig(DevopsClientConfiguration config) {
		this.config = config;
	}


	//
	// Clusters
	//

	/**
	 * Get {@code Cluster} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Cluster#getSharing()} and {@link Cluster#getAuthorities()}.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code ClusterOptions} that tailor which fields are returned (projection)	
	 * @return the {@code Cluster}
	 * @throws RestClientException if request fails
	 */
	public Cluster getCluster(String id, ClusterOptions options) {
		URI uri = makeURI(DevopsEndpoints.cluster(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Cluster> result = exchange(request, Cluster.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code Cluster}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Cluster#getSharing()} and {@link Cluster#getAuthorities()}.
	 * 
	 * @param filter a {@code ClusterFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Cluster}s
	 * @throws RestClientException if request fails
	 */
	public Page<Cluster> listClusters(ClusterFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.clusters(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Cluster.class);
	}

	/**
	 * Create a new {@code Cluster}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param cluster the {@code Cluster}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Cluster}
	 * @throws RestClientException if request fails
	 */
	public URI createCluster(Cluster cluster, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.clusters(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Cluster> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(cluster);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Update existing {@code Cluster}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param cluster the {@code Cluster}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateCluster(String id, Cluster cluster, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cluster(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Cluster> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(cluster);		
		exchange(request, Cluster.class, options);
	}
	
	/**
	 * Update existing {@code Cluster}
	 * 
	 * ID is extracted from fields: UUID, ID, name;
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param cluster the {@code Cluster}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateCluster(Cluster cluster, RequestOptions options) {
		updateCluster(getId(cluster), cluster, options);
	}

	/**
	 * Delete existing {@code Cluster}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteCluster(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cluster(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// Spaces
	//

	/**
	 * Get {@code Space} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Space#getSharing()} and {@link Space#getAuthorities()}.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code SpaceOptions} that tailor which fields are returned (projection)	
	 * @return the {@code Space}
	 * @throws RestClientException if request fails
	 */
	public Space getSpace(String id, SpaceOptions options) {
		URI uri = makeURI(DevopsEndpoints.space(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Space> result = exchange(request, Space.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code Space}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Space#getSharing()} and {@link Space#getAuthorities()}.
	 * 
	 * @param filter a {@code SpaceFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Space}s
	 * @throws RestClientException if request fails
	 */
	public Page<Space> listSpaces(SpaceFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.spaces(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Space.class);
	}

	/**
	 * Create a new {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param space the {@code Space}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Space}
	 * @throws RestClientException if request fails
	 */
	public URI createSpace(Space space, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaces(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Space> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(space);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Attach a new {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param clusterId the {@code Cluster} identifier (id, uuid, unique name)
	 * @param space the name of the space
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the attachd {@code Space}
	 * @throws RestClientException if request fails
	 */
	public URI attachSpace(String clusterId, String space, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.clusterSpace(clusterId, space, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}
	
	/**
	 * Sync {@code Space} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code SpaceOptions}
	 * @throws RestClientException if request fails
	 */
	public void syncSpace(String id, SpaceOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceSync(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Update existing {@code Space}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param space the {@code Space}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateSpace(String id, Space space, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.space(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Space> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(space);		
		exchange(request, Space.class, options);
	}
	
	/**
	 * Update existing {@code Space}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param space the {@code Space}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateSpace(Space space, RequestOptions options) {
		updateSpace(getId(space), space, options);
	}

	/**
	 * Delete existing {@code Space}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteSpace(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.space(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// VolumeClaims
	//
	

	//
	// Deployment
	//
		
	/**
	 * List {@code VolumeClaim}s for a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param filter a {@code VolumeClaimFilter}
	 * @throws RestClientException if request fails
	 * @return a {@code List} with {@code VolumeClaim}s
	 * @throws RestClientException if request fails
	 */
	public List<VolumeClaim> listVolumeClaims(String spaceId, VolumeClaimFilter filter) {
		URI uri = makeURI(DevopsEndpoints.volumeclaims(spaceId, config, isAdminRequest(filter)));
		uri = processURI(uri, filter);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<VolumeClaim[]> result = exchange(request, VolumeClaim[].class, filter);
		return Arrays.asList(result.getBody());
	}
	
	//
	// Space Authorities
	//
	
	/**
	 * List {@code Authorities} for a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 * @return a {@code List} of {@code Authority}
	 * @throws RestClientException if request fails
	 */
	public List<Authority> listAuthorities(String spaceId, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceAuths(spaceId, config, isAdminRequest(options)));
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Authority[]> result = exchange(request, Authority[].class, options);
		return Arrays.asList(result.getBody());
		
	}
	/**
	 * Add a new {@code Authority} to a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param auth the {@code Authority}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Authority}
	 * @throws RestClientException if request fails
	 */
	public URI addAuthority(String spaceId, Authority auth, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceAuths(spaceId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Authority> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(auth);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}
	
	/**
	 * Update an {@code Authority} from a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param authId the {@code Authority} identifier (id,uuid,username,groupId)
	 * @param auth the {@code Authority}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateAuthority(String spaceId, String authId, Authority auth, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceAuth(spaceId, authId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Authority> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(auth);
		exchange(request, Void.class, options);
	}
	
	/**
	 * Remove an {@code Authority} from a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param authId the {@code Authority} identifier (id,uuid,username,groupId)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeAuthority(String spaceId, String authId, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceAuth(spaceId, authId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Get {@code Authority} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER set in the Space.
	 * 
	 * @param spaceId the identifier of the {@code Space} (uuid, id)
	 * @param id the identifier of the {@code Authority} (uuid, id,username,groupId)
	 * @param options (optional) the {@code SpaceOptions} that tailor which fields are returned (projection)
	 * @return the {@code Authority}
	 * @throws RestClientException if request fails
	 */
	public Authority getAuthority(String spaceId, String id, SpaceOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceAuth(spaceId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Authority> result = exchange(request, Authority.class, options);
		return result.getBody();
	}

	/**
	 * Resend notification of {@code Authority} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>:Matching the roles MANAGER set in the Space.
	 * 
	 * @param spaceId the identifier of the {@code Space} (uuid, id)
	 * @param id the identifier of the {@code Authority} (uuid, id)
	 * @param options (optional) {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void resendAuthority(String spaceId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceAuth(spaceId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// Deployment
	//
		
	/**
	 * List {@code Deployment}s for a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param filter a {@code DeploymentFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Deployment}s
	 * @throws RestClientException if request fails
	 */
	public Page<Deployment> listDeployments(String spaceId, DeploymentFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Deployment.class);
		
	}

	/**
	 * Get {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Deployment}
	 * @throws RestClientException if request fails
	 */
	public Deployment getDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Deployment> result = exchange(request, Deployment.class, options);
		return result.getBody();
	}
	
	/**
	 * Create a new {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param deploy the {@code Deployment}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Deployment}
	 * @throws RestClientException if request fails
	 */
	public URI createDeployment(String spaceId, Deployment deploy, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Deployment> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(deploy);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}
	
	/**
	 * Attach a new {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param spaceId the {@code Space} identifier (id, uuid, unique name)
	 * @param deployment the name of the deployment
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the attachd {@code Deployment}
	 * @throws RestClientException if request fails
	 */
	public URI attachDeployment(String spaceId, String deployment, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceDeployment(spaceId, deployment, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}
	

	/**
	 * Update existing {@code Deployment}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param deploy the {@code Deployment}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateDeployment(String id, Deployment deploy, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Deployment> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(deploy);
		exchange(request, Deployment.class, options);
	}

	
	/**
	 * Update existing {@code Deployment}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deploy the {@code Deployment}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateDeployment(Deployment deploy, RequestOptions options) {
		updateDeployment(getId(deploy), deploy, options);
	}
	
	/**
	 * Delete existing {@code Deployment}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	

	/**
	 * Get Manifest for {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) the {@code ManifestOptions} that manifest generation
	 * @return the manifest
	 * @throws RestClientException if request fails
	 */
	public String getDeploymentManifest(String id, ManifestOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentManifest(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<String> result = exchange(request, String.class, options);
		return result.getBody();
	}
	
	/**
	 * Scale {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param n number of replicas/pods/instances
	 * @param options (optional) {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void scaleDeployment(String id, int n, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentScale(id, config, isAdminRequest(options)));
		uri = processURI(uri, "n", n);
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}

	/**
	 * Scale Resources of {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param resources the {@code Resources}
	 * @param options (optional) {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void scaleDeployment(String id, Resources resources, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentRScale(id, config, isAdminRequest(options)));
		uri = processURI(uri, resources);
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}

	/**
	 * Start {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void startDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentStart(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Restart {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void restartDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentRestart(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Stop {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void stopDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentStop(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Sync {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void syncDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentSync(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Get log of {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code LogOptions}
	 * @return the log
	 * @throws RestClientException if request fails
	 */
	public String logDeployment(String id, LogOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentLog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<String> result = exchange(request, String.class, options);
		return result.getBody();
	}
	
	/**
	 * Execute command in pod/replica of {@code Deployment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code LogOptions}
	 * @return the log
	 * @throws RestClientException if request fails
	 */
	public String execDeployment(String id, ExecOptions options) {
		URI uri = makeURI(DevopsEndpoints.deploymentExec(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<String> result = exchange(request, String.class, options);
		return result.getBody();
	}
	
	
	/**
	 * List {@code Event}s for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code EventFilter}
	 * @return the list of {@code Event}
	 * @throws RestClientException if request fails
	 */
	public List<Event> listEvents(String deployId, EventFilter options, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.deploymentEvents(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		uri = processURI(uri, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Event[]> result = exchange(request, Event[].class, options);
		return Arrays.asList(result.getBody());
	}
	
	//
	// Deployment Instances (Pods/Replicas)
	//
	
	/**
	 * List Pod/Replica instances for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code DeploymentFilter}
	 * @return the list of {@code Instance}
	 * @throws RestClientException if request fails
	 */
	public List<Instance> listInstances(String deployId, DeploymentFilter options) {
		URI uri = makeURI(DevopsEndpoints.instances(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Instance[]> result = exchange(request, Instance[].class, options);
		return Arrays.asList(result.getBody());
	}
	
	/**
	 * Delete existing {@code Instance} for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param pod the identifier of the {@code Instance/Pod} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteInstance(String deployId, String pod, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.instance(deployId, pod, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Deployment Mount
	//
	
	/**
	 * List {@code Mount}s for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code DeploymentOptions}
	 * @return the list of {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public List<Mount> listMounts(String deployId, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.mounts(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Mount[]> result = exchange(request, Mount[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Mount} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public Mount getMount(String deployId, String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.mount(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Mount> result = exchange(request, Mount.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Mount} to a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param mount the {@code Mount}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public URI addMount(String deployId, Mount mount, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mounts(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Mount> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(mount);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}

	/**
	 * Update existing {@code Mount} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param mount the {@code Mount}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateMount(String deployId, String id, Mount mount, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mount(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Mount> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(mount);
		exchange(request, Mount.class, options);
	}

	/**
	 * Delete existing {@code Mount} from a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeMount(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mount(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Provision existing {@code Mount} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void provisionMount(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mount(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Deployment Variable
	//
	
	/**
	 * List {@code Variable}s for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code DeploymentOptions}
	 * @return the list of {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public List<Variable> listVariables(String deployId, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.vars(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Variable[]> result = exchange(request, Variable[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Variable} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public Variable getVariable(String deployId, String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.var(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Variable> result = exchange(request, Variable.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Variable} to a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param var the {@code Variable}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public URI addVariable(String deployId, Variable var, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vars(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Variable> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(var);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Variable} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param var the {@code Variable}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateVariable(String deployId, String id, Variable var, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.var(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Variable> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(var);
		exchange(request, Variable.class, options);
	}

	/**
	 * Delete existing {@code Variable} from a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeVariable(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.var(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// Deployment Route
	//
	
	/**
	 * List {@code Route}s for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code DeploymentOptions}
	 * @return the list of {@code Route}
	 * @throws RestClientException if request fails
	 */
	public List<Route> listRoutes(String deployId, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.routes(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Route[]> result = exchange(request, Route[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Route} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Route} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Route}
	 * @throws RestClientException if request fails
	 */
	public Route getRoute(String deployId, String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Route> result = exchange(request, Route.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Route} to a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param route the {@code Route}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Route}
	 * @throws RestClientException if request fails
	 */
	public URI addRoute(String deployId, Route route, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.routes(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(route);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Route} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Route} (uuid, id, unique host, or unique dns)
	 * @param route the {@code Route}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateRoute(String deployId, String id, Route route, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(route);
		exchange(request, Void.class, options);
	}

	/**
	 * Delete existing {@code Route} from a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Route} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeRoute(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Make existing {@code Route} of a {@code Deployment} primary.
	 * 
	 * Primary {@code Routes} are used when resolving connector and binding variables.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Route} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void primaryRoute(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.primaryRoute(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Deployment Binding
	//
	
	/**
	 * List {@code Binding}s for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code DeploymentOptions}
	 * @return the list of {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public List<Binding> listBindings(String deployId, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindings(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Binding[]> result = exchange(request, Binding[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Binding} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public Binding getBinding(String deployId, String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Binding> result = exchange(request, Binding.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Binding} to a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param binding the {@code Binding}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public URI addBinding(String deployId, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindings(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();		
	}

	/**
	 * Update existing {@code Binding} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param binding the {@code Binding}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateBinding(String deployId, String id, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		exchange(request, Binding.class, options);
	}

	/**
	 * Delete existing {@code Binding} from a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeBinding(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Refresh existing {@code Binding} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void refreshBinding(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Deployment Connector
	//

	/**
	 * List {@code Connector}s for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code DeploymentOptions}
	 * @return the list of {@code Connector}
	 * @throws RestClientException if request fails
	 */
	public List<Connector> listConnectors(String deployId, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.connectors(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Connector[]> result = exchange(request, Connector[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Connector} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Connector} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Connector}
	 * @throws RestClientException if request fails
	 */
	public Connector getConnector(String deployId, String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Connector> result = exchange(request, Connector.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Connector} to a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param connector the {@code Connector}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Connector}
	 * @throws RestClientException if request fails
	 */
	public URI addConnector(String deployId, Connector connector, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connectors(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Connector} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Connector} (uuid, id, unique host, or unique dns)
	 * @param connector the {@code Connector}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateConnector(String deployId, String id, Connector connector, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		exchange(request, Connector.class, options);
	}

	/**
	 * Delete existing {@code Connector} from a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Connector} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeConnector(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	/**
	 * Refresh existing {@code Connector} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Connector} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void refreshConnector(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Deployment Repository
	//
	
	/**
	 * List {@code Repository}s for a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param deployId the {@code Deployment} identifier (uuid)
	 * @param options (optional) {@code DeploymentOptions}
	 * @return the list of {@code Repository}
	 * @throws RestClientException if request fails
	 */
	public List<Repository> listRepositories(String deployId, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.repositories(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Repository[]> result = exchange(request, Repository[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Repository} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Repository} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Repository}
	 * @throws RestClientException if request fails
	 */
	public Repository getRepository(String deployId, String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Repository> result = exchange(request, Repository.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Repository} to a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param repository the {@code Repository}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Repository}
	 * @throws RestClientException if request fails
	 */
	public URI addRepository(String deployId, Repository repository, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repositories(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Repository} of a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Repository} (uuid, id, unique host, or unique dns)
	 * @param repository the {@code Repository}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateRepository(String deployId, String id, Repository repository, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		exchange(request, Repository.class, options);
	}

	/**
	 * Delete existing {@code Repository} from a {@code Deployment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deployId the identifier of the {@code Deployment} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Repository} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code DeploymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeRepository(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Job
	//
		
	/**
	 * List {@code Job}s for a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param filter a {@code JobFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Job}s
	 * @throws RestClientException if request fails
	 */
	public Page<Job> listJobs(String spaceId, JobFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.jobs(spaceId, config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Job.class);
		
	}

	/**
	 * Get {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) the {@code JobOptions} that tailor which fields are returned (projection)
	 * @return the {@code Job}
	 * @throws RestClientException if request fails
	 */
	public Job getJob(String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.job(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Job> result = exchange(request, Job.class, options);
		return result.getBody();
	}
	
	/**
	 * Create a new {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param job the {@code Job}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Job}
	 * @throws RestClientException if request fails
	 */
	public URI createJob(String spaceId, Job job, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobs(spaceId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Job> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(job);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}

	/**
	 * Attach a new {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param spaceId the {@code Space} identifier (id, uuid, unique name)
	 * @param job the name of the job
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the attachd {@code Job}
	 * @throws RestClientException if request fails
	 */
	public URI attachJob(String spaceId, String job, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceJob(spaceId, job, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}
	
	/**
	 * Update existing {@code Job}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param job the {@code Job}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateJob(String id, Job job, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.job(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Job> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(job);
		exchange(request, Job.class, options);
	}

	/**
	 * Update existing {@code Job}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param job the {@code Job}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateJob(Job job, RequestOptions options) {
		updateJob(getId(job), job, options);
	}
	
	/**
	 * Delete existing {@code Job}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteJob(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.job(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	/**
	 * Get Manifest for {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) the {@code ManifestOptions} that manifest generation
	 * @return the manifest
	 * @throws RestClientException if request fails
	 */
	public String getJobManifest(String id, ManifestOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobManifest(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<String> result = exchange(request, String.class, options);
		return result.getBody();
	}
	
	/**
	 * Scale Resources of {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param resources the {@code Resources}
	 * @param options (optional) {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void scaleJob(String id, Resources resources, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobRScale(id, config, isAdminRequest(options)));
		uri = processURI(uri, resources);
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}

	/**
	 * Start {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void startJob(String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobStart(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Restart {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void restartJob(String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobRestart(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Stop {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void stopJob(String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobStop(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Sync {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void syncJob(String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobSync(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Get log of {@code Job} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code LogOptions}
	 * @return the log
	 * @throws RestClientException if request fails
	 */
	public String logJob(String id, LogOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobLog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<String> result = exchange(request, String.class, options);
		return result.getBody();
	}
	
	//
	// Job Instances (Pods/Replicas)
	//
	
	/**
	 * List Pod/Replica instances for a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param jobId the {@code Job} identifier (uuid)
	 * @param options (optional) {@code JobOptions}
	 * @return the list of {@code Instance}
	 * @throws RestClientException if request fails
	 */
	public List<Instance> listInstancesForJob(String jobId, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.instancesJob(jobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Instance[]> result = exchange(request, Instance[].class, options);
		return Arrays.asList(result.getBody());
	}
	
	/**
	 * Delete existing {@code Instance} for a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param pod the identifier of the {@code Instance/Pod} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteInstanceForJob(String jobId, String pod, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.instanceJob(jobId, pod, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Job Mount
	//
	
	/**
	 * List {@code Mount}s for a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param jobId the {@code Job} identifier (uuid)
	 * @param options (optional) {@code JobOptions}
	 * @return the list of {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public List<Mount> listMountsJob(String jobId, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountsJob(jobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Mount[]> result = exchange(request, Mount[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Mount} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code JobOptions} that tailor which fields are returned (projection)
	 * @return the {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public Mount getMountJob(String jobId, String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Mount> result = exchange(request, Mount.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Mount} to a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param mount the {@code Mount}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public URI addMountJob(String jobId, Mount mount, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountsJob(jobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Mount> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(mount);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Mount} of a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param mount the {@code Mount}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateMountJob(String jobId, String id, Mount mount, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Mount> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(mount);
		exchange(request, Mount.class, options);
	}

	/**
	 * Delete existing {@code Mount} from a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeMountJob(String jobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Provision existing {@code Mount} of a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void provisionMountJob(String jobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Job Variable
	//
	
	/**
	 * List {@code Variable}s for a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param jobId the {@code Job} identifier (uuid)
	 * @param options (optional) {@code JobOptions}
	 * @return the list of {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public List<Variable> listVariablesJob(String jobId, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.varsJob(jobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Variable[]> result = exchange(request, Variable[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Variable} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code JobOptions} that tailor which fields are returned (projection)
	 * @return the {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public Variable getVariableJob(String jobId, String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.varJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Variable> result = exchange(request, Variable.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Variable} to a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param var the {@code Variable}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public URI addVariableJob(String jobId, Variable var, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.varsJob(jobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Variable> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(var);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Variable} of a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param var the {@code Variable}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateVariableJob(String jobId, String id, Variable var, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.varJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Variable> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(var);
		exchange(request, Variable.class, options);
	}

	/**
	 * Delete existing {@code Variable} from a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeVariableJob(String jobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.varJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// Job Binding
	//
	
	/**
	 * List {@code Binding}s for a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param jobId the {@code Job} identifier (uuid)
	 * @param options (optional) {@code JobOptions}
	 * @return the list of {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public List<Binding> listBindingsJob(String jobId, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingsJob(jobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Binding[]> result = exchange(request, Binding[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Binding} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code JobOptions} that tailor which fields are returned (projection)
	 * @return the {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public Binding getBindingJob(String jobId, String id, JobOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Binding> result = exchange(request, Binding.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Binding} to a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param binding the {@code Binding}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public URI addBindingJob(String jobId, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingsJob(jobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();		
	}

	/**
	 * Update existing {@code Binding} of a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param binding the {@code Binding}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateBindingJob(String jobId, String id, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		exchange(request, Binding.class, options);
	}

	/**
	 * Delete existing {@code Binding} from a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code JobOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeBindingJob(String jobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Refresh existing {@code Binding} of a {@code Job}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param jobId the identifier of the {@code Job} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void refreshBindingJob(String jobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingJob(jobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// CronJob
	//
		
	/**
	 * List {@code CronJob}s for a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param filter a {@code CronJobFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code CronJob}s
	 * @throws RestClientException if request fails
	 */
	public Page<CronJob> listCronJobs(String spaceId, CronJobFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.cronjobs(spaceId, config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  CronJob.class);
		
	}

	/**
	 * Get {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) the {@code CronJobOptions} that tailor which fields are returned (projection)
	 * @return the {@code CronJob}
	 * @throws RestClientException if request fails
	 */
	public CronJob getCronJob(String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjob(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<CronJob> result = exchange(request, CronJob.class, options);
		return result.getBody();
	}
	
	/**
	 * Create a new {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier (uuid)
	 * @param cronjob the {@code CronJob}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code CronJob}
	 * @throws RestClientException if request fails
	 */
	public URI createCronJob(String spaceId, CronJob cronjob, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobs(spaceId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<CronJob> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(cronjob);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	
	/**
	 * Attach a new {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param spaceId the {@code Space} identifier (id, uuid, unique name)
	 * @param cronjob the name of the cronjob
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the attachd {@code CronJob}
	 * @throws RestClientException if request fails
	 */
	public URI attachCronJob(String spaceId, String cronjob, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.spaceCronJob(spaceId, cronjob, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}
	

	
	/**
	 * Update existing {@code CronJob}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param cronjob the {@code CronJob}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateCronJob(String id, CronJob cronjob, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjob(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<CronJob> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(cronjob);
		exchange(request, CronJob.class, options);
	}

	/**
	 * Update existing {@code CronJob}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjob the {@code CronJob}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateCronJob(CronJob cronjob, RequestOptions options) {
		updateCronJob(getId(cronjob), cronjob, options);
	}
	
	/**
	 * Delete existing {@code CronJob}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the {@code CronJob} identifier (UUID)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteCronJob(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjob(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	/**
	 * Scale Resources of {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param resources the {@code Resources}
	 * @param options (optional) {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void scaleCronJob(String id, Resources resources, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobRScale(id, config, isAdminRequest(options)));
		uri = processURI(uri, resources);
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}

	/**
	 * Get Manifest for {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) the {@code ManifestOptions} that manifest generation
	 * @return the manifest
	 * @throws RestClientException if request fails
	 */
	public String getCronJobManifest(String id, ManifestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobManifest(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<String> result = exchange(request, String.class, options);
		return result.getBody();
	}
	
	/**
	 * Start {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void startCronJob(String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobStart(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Restart {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void restartCronJob(String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobRestart(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Stop {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void stopCronJob(String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobStop(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Suspend {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void suspendCronJob(String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobSuspend(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Sync {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void syncCronJob(String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobSync(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Get log of {@code CronJob} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param id the identifier (uuid, id, or qualified name)
	 * @param options (optional) {@code LogOptions}
	 * @return the log
	 * @throws RestClientException if request fails
	 */
	public String logCronJob(String id, LogOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjobLog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<String> result = exchange(request, String.class, options);
		return result.getBody();
	}
	
	//
	// Deployment Jobs (Pods/Replicas)
	//
	
	/**
	 * List Job instances for a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param cronjobId the {@code CronJob} identifier (uuid)
	 * @param options (optional) {@code CronJobOptions}
	 * @return the list of {@code Job}
	 * @throws RestClientException if request fails
	 */
	public List<Job> listJobsForCronJob(String cronjobId, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.jobsCronJob(cronjobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Job[]> result = exchange(request, Job[].class, options);
		return Arrays.asList(result.getBody());
	}
	
	//
	// CronJob Mount
	//
	
	/**
	 * List {@code Mount}s for a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param cronjobId the {@code CronJob} identifier (uuid)
	 * @param options (optional) {@code CronJobOptions}
	 * @return the list of {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public List<Mount> listMountsCronJob(String cronjobId, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountsCronJob(cronjobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Mount[]> result = exchange(request, Mount[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Mount} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code CronJobOptions} that tailor which fields are returned (projection)
	 * @return the {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public Mount getMountCronJob(String cronjobId, String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Mount> result = exchange(request, Mount.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Mount} to a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param mount the {@code Mount}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Mount}
	 * @throws RestClientException if request fails
	 */
	public URI addMountCronJob(String cronjobId, Mount mount, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountsCronJob(cronjobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Mount> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(mount);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Mount} of a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param mount the {@code Mount}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateMountCronJob(String cronjobId, String id, Mount mount, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Mount> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(mount);
		exchange(request, Mount.class, options);
	}

	/**
	 * Delete existing {@code Mount} from a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeMountCronJob(String cronjobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Provision existing {@code Mount} of a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Mount} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void provisionMountCronJob(String cronjobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.mountCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// CronJob Variable
	//
	
	/**
	 * List {@code Variable}s for a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param cronjobId the {@code CronJob} identifier (uuid)
	 * @param options (optional) {@code CronJobOptions}
	 * @return the list of {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public List<Variable> listVariablesCronJob(String cronjobId, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.varsCronJob(cronjobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Variable[]> result = exchange(request, Variable[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Variable} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code CronJobOptions} that tailor which fields are returned (projection)
	 * @return the {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public Variable getVariableCronJob(String cronjobId, String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.varCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Variable> result = exchange(request, Variable.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Variable} to a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param var the {@code Variable}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Variable}
	 * @throws RestClientException if request fails
	 */
	public URI addVariableCronJob(String cronjobId, Variable var, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.varsCronJob(cronjobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Variable> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(var);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	/**
	 * Update existing {@code Variable} of a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param var the {@code Variable}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateVariableCronJob(String cronjobId, String id, Variable var, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.varCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Variable> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(var);
		exchange(request, Variable.class, options);
	}

	/**
	 * Delete existing {@code Variable} from a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Variable} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeVariableCronJob(String cronjobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.varCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// CronJob Binding
	//
	
	/**
	 * List {@code Binding}s for a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param cronjobId the {@code CronJob} identifier (uuid)
	 * @param options (optional) {@code CronJobOptions}
	 * @return the list of {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public List<Binding> listBindingsCronJob(String cronjobId, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingsCronJob(cronjobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Binding[]> result = exchange(request, Binding[].class, options);
		return Arrays.asList(result.getBody());
	}

	/**
	 * Get {@code Binding} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options (optional) the {@code CronJobOptions} that tailor which fields are returned (projection)
	 * @return the {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public Binding getBindingCronJob(String cronjobId, String id, CronJobOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Binding> result = exchange(request, Binding.class, options);
		return result.getBody();
	}
	
	/**
	 * Add a new {@code Binding} to a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param binding the {@code Binding}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Binding}
	 * @throws RestClientException if request fails
	 */
	public URI addBindingCronJob(String cronjobId, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingsCronJob(cronjobId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();		
	}

	/**
	 * Update existing {@code Binding} of a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param binding the {@code Binding}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateBindingCronJob(String cronjobId, String id, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		exchange(request, Binding.class, options);
	}

	/**
	 * Delete existing {@code Binding} from a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code CronJobOptions}
	 * @throws RestClientException if request fails
	 */
	public void removeBindingCronJob(String cronjobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	/**
	 * Refresh existing {@code Binding} of a {@code CronJob}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjobId the identifier of the {@code CronJob} (uuid, id, or qualified name)
	 * @param id the identifier of the {@code Binding} (uuid, id, unique host, or unique dns)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void refreshBindingCronJob(String cronjobId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindingCronJob(cronjobId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.post(uri).build();
		exchange(request, Void.class, options);
	}

	//
	// Domain
	//
	
	/**
	 * Get {@code Domain} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Domain#getSharing()} and {@link Domain#getAuthorities()}.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code DomainOptions} that tailor which fields are returned (projection)	
	 * @return the {@code Domain}
	 * @throws RestClientException if request fails
	 */
	public Domain getDomain(String id, DomainOptions options) {
		URI uri = makeURI(DevopsEndpoints.domain(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Domain> result = exchange(request, Domain.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code Domain}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Domain#getSharing()} and {@link Domain#getAuthorities()}.
	 * 
	 * @param filter a {@code DomainFilter}
	 * @param pageable a {@code Pageable} (optional)	
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Domain}s
	 * @throws RestClientException if request fails
	 */
	public Page<Domain> listDomains(DomainFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.domains(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Domain.class);
	}

	/**
	 * Create a new {@code Domain}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param domain the {@code Domain}
	 * @param options optional {@code RequestOptions}
	
	 * @return the location {@code URI} for the created {@code Domain}
	 * @throws RestClientException if request fails
	 */
	public URI createDomain(Domain domain, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.domains(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Domain> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(domain);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Update existing {@code Domain}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param domain the {@code Domain}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateDomain(String id, Domain domain, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.domain(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Domain> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(domain);		
		exchange(request, Domain.class, options);
	}
	
	/**
	 * Update existing {@code Domain}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param domain the {@code Domain}
	 * @param options optional {@code RequestOptions}	
	 * @throws RestClientException if request fails
	 */
	public void updateDomain(Domain domain, RequestOptions options) {
		updateDomain(getId(domain), domain, options);
	}

	/**
	 * Delete existing {@code Domain}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteDomain(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.domain(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Registry
	//
	
	/**
	 * Get {@code Registry} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Registry#getSharing()} and {@link Registry#getAuthorities()}.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code RegistryOptions} that tailor which fields are returned (projection)	
	 * @return the {@code Registry}
	 * @throws RestClientException if request fails
	 */
	public Registry getRegistry(String id, RegistryOptions options) {
		URI uri = makeURI(DevopsEndpoints.registry(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Registry> result = exchange(request, Registry.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code Registry}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Registry#getSharing()} and {@link Registry#getAuthorities()}.
	 * 
	 * @param filter a {@code RegistryFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Registry}s
	 * @throws RestClientException if request fails
	 */
	public Page<Registry> listRegistries(RegistryFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.registries(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Registry.class);
	}

	/**
	 * Create a new {@code Registry}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param registry the {@code Registry}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Registry}
	 * @throws RestClientException if request fails
	 */
	public URI createRegistry(Registry registry, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.registries(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Registry> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(registry);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Update existing {@code Registry}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param registry the {@code Registry}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateRegistry(String id, Registry registry, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.registry(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Registry> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(registry);		
		exchange(request, Registry.class, options);
	}

	/**
	 * Update existing {@code Registry}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param registry the {@code Registry}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateRegistry(Registry registry, RequestOptions options) {
		updateRegistry(getId(registry), registry, options);
	}
	
	/**
	 * Delete existing {@code Registry}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteRegistry(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.registry(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// Vcs
	//
	
	/**
	 * Get {@code Vcs} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Vcs#getSharing()} and {@link Vcs#getAuthorities()}.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code VcsOptions} that tailor which fields are returned (projection)	
	 * @return the {@code Vcs}
	 * @throws RestClientException if request fails
	 */
	public Vcs getVcs(String id, VcsOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Vcs> result = exchange(request, Vcs.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code Vcs}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching {@link Vcs#getSharing()} and {@link Vcs#getAuthorities()}.
	 * 
	 * @param filter a {@code VcsFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Vcs}s
	 * @throws RestClientException if request fails
	 */
	public Page<Vcs> listVcss(VcsFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.vcss(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Vcs.class);
	}

	/**
	 * Create a new {@code Vcs}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param vcs the {@code Vcs}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Vcs}
	 * @throws RestClientException if request fails
	 */
	public URI createVcs(Vcs vcs, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcss(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Update existing {@code Vcs}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param vcs the {@code Vcs}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateVcs(String id, Vcs vcs, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(vcs);		
		exchange(request, Vcs.class, options);
	}
	
	/**
	 * Update existing {@code Vcs}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param vcs the {@code Vcs}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateVcs(Vcs vcs, RequestOptions options) {
		updateVcs(getId(vcs), vcs, options);
	}

	/**
	 * Delete existing {@code Vcs}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteVcs(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// Solution
	//
	
	/**
	 * Get {@code Solution} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Any if enabled, or admin.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code SolutionOptions} that tailor which fields are returned (projection)	
	 * @return the {@code Solution}
	 * @throws RestClientException if request fails
	 */
	public Solution getSolution(String id, SolutionOptions options) {
		URI uri = makeURI(DevopsEndpoints.solution(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Solution> result = exchange(request, Solution.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code Solution}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Any if enabled, or Admin (global role ADMIN).
	 * 
	 * @param filter a {@code SolutionFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Solution}s
	 * @throws RestClientException if request fails
	 */
	public Page<Solution> listSolutions(SolutionFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.solutions(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Solution.class);
	}

	/**
	 * Create a new {@code Solution}.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN).
	 * 
	 * @param solution the {@code Solution}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Solution}
	 * @throws RestClientException if request fails
	 */
	public URI createSolution(Solution solution, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.solutions(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Solution> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(solution);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Update existing {@code Solution}
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN).
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param solution the {@code Solution}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateSolution(String id, Solution solution, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.solution(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Solution> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(solution);		
		exchange(request, Solution.class, options);
	}
	
	/**
	 * Update existing {@code Solution}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN).
	 * 
	 * @param solution the {@code Solution}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateSolution(Solution solution, RequestOptions options) {
		updateSolution(getId(solution), solution, options);
	}

	/**
	 * Delete existing {@code Solution}
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN).
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteSolution(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.solution(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	
	/**
	 * Install {@code Solution} in a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param solutionId the identifier of the {@code Solution} (uuid, id, or unique/qualified name)
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created resource (main one)
	 * @throws RestClientException if request fails
	 */
	public URI install(String solutionId, InstallOptions options) {
		URI uri = makeURI(DevopsEndpoints.install(solutionId, config, isAdminRequest(options)));
		RequestEntity<InstallOptions> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(options);		
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	//
	// Catalog
	//
	
	
	/**
	 * Get {@code Catalog} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: If Enabled: any. If not enabled: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code CatalogOptions} that tailor which fields are returned (projection)	
	 * @return the {@code Catalog}
	 * @throws RestClientException if request fails
	 */
	public Catalog getCatalog(String id, CatalogOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Catalog> result = exchange(request, Catalog.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code Catalog}s.
	 * 
	 * <p><b>Required Security Credentials</b>: If Enabled: any. If not enabled: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param filter a {@code CatalogFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Catalog}s
	 * @throws RestClientException if request fails
	 */
	public Page<Catalog> listCatalogs(CatalogFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.catalogs(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Catalog.class);
	}

	/**
	 * Create a new {@code Catalog}.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param catalog the {@code Catalog}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Catalog}
	 * @throws RestClientException if request fails
	 */
	public URI createCatalog(Catalog catalog, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalogs(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Catalog> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(catalog);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Update existing {@code Catalog}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param catalog the {@code Catalog}
	 * @param options optional {@code RequestOptions}	
	 * @throws RestClientException if request fails
	 */
	public void updateCatalog(String id, Catalog catalog, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Catalog> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(catalog);		
		exchange(request, Catalog.class, options);
	}
	
	/**
	 * Update existing {@code Catalog}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param catalog the {@code Catalog}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateCatalog(Catalog catalog, RequestOptions options) {
		updateCatalog(getId(catalog), catalog, options);
	}

	/**
	 * Delete existing {@code Catalog}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteCatalog(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	
	/**
	 * List {@code Solution}s for a {@code Catalog}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any if enabled.
	 * 
	 * @param catalogId the identifier of the {@code Catalog} (uuid, id, or unique name)
	 * @param filter a {@code SolutionFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Solution}s
	 * @throws RestClientException if request fails
	 */
	public Page<Solution> listSolutionsFor(String catalogId, SolutionFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.solutionsFor(catalogId, config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(), Solution.class);
	}


	/**
	 * Install {@code Solution} from a {@code Catalog} in a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param catalogId the identifier of the {@code Catalog} (uuid, id, or unique name)
	 * @param solutionId the identifier of the {@code Solution} (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created resource (main one)
	 * @throws RestClientException if request fails
	 */
	public URI install(String catalogId, String solutionId, InstallOptions options) {
		URI uri = makeURI(DevopsEndpoints.installFromCatalog(catalogId, solutionId, config, isAdminRequest(options)));
		RequestEntity<InstallOptions> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(options);		
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	//
	// License
	//
	
	/**
	 * Get {@code License} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options (optional) the {@code LicenseOptions} that tailor which fields are returned (projection)	
	 * @return the {@code License}
	 * @throws RestClientException if request fails
	 */
	public License getLicense(String id, LicenseOptions options) {
		URI uri = makeURI(DevopsEndpoints.license(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<License> result = exchange(request, License.class, options);
		return result.getBody();
		
	}
	
	/**
	 * List {@code License}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN), or owner.
	 * 
	 * @param filter a {@code LicenseFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code License}s
	 * @throws RestClientException if request fails
	 */
	public Page<License> listLicenses(LicenseFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.licenses(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  License.class);
	}

	/**
	 * Create a new {@code License}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param license the {@code License}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code License}
	 * @throws RestClientException if request fails
	 */
	public URI createLicense(License license, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.licenses(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<License> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(license);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();	
	}

	/**
	 * Update existing {@code License}
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param license the {@code License}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateLicense(String id, License license, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.license(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<License> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(license);		
		exchange(request, License.class, options);
	}

	/**
	 * Update existing {@code License}
	 * 
	 * <p>ID is extracted from fields: UUID, ID, or name.
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN), or owner.
	 * 
	 * @param license the {@code License}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateLicense(License license, RequestOptions options) {
		updateLicense(getId(license), license, options);
	}
	
	/**
	 * Delete existing {@code License}
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (uuid, id, or unique name)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteLicense(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.license(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	//
	// HTTP Transport
	//
	
	
	/**
	 * Submit HTTP request.
	 * 
	 * If {@code context} is not null, use provided {@code OAuth2RestTemplate} if any.
	 * Otherwise, use session scoped {@code OAuth2RestTemplate} if in web request thread. 
	 * Otherwise, use client credentials singleton (non thread-safe) @code OAuth2RestTemplate}.
	 * 
	 * @param <T> response type
	 * @param request the {@code RequestEntity}
	 * @param responseType the response type
	 * @param options optional {@code RequestOptions}
	 * @return result {@code ResponseEntity}
	 * @throws RestClientException if request fails
	 */
	protected <T> ResponseEntity<T> exchange(RequestEntity<?> request, Class<T> responseType, RequestOptions options) throws RestClientException {
		RestTemplate restTemplate = getRequiredRestTemplate(options);
		try {
			return exchange(restTemplate, request, responseType);			
		} catch (RuntimeException e) {
			if (options!=null && !options.isSingleton()) {
				options.setResult(new Result<Object>(e));
			}
			throw e;
		}
	}

	/**
	 * Submit HTTP request.
	 * 
	 * May be overriden by sub-classes for custom/advanced functionality.
	 * 
	 * @param <T> response type
	 * @param restTemplate the {@code RestTemplate} to use
	 * @param request the {@code RequestEntity}
	 * @param responseType the response type
	 * @return the result {@code ResponseEntity}
	 * @throws RestClientException if request fails
	 */
	protected <T> ResponseEntity<T> exchange(RestTemplate restTemplate, RequestEntity<?> request, Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(request, responseType);
	}
	
	/**
	 * Get the {@code OAuth2RestTemplate} to use to perform a request.
	 * 
	 * Return the configured {@code OAuth2RestTemplate} in property {@link #restTemplate}.
	 * Check if current thread is bound to a web request with a session-scope. If not, fallback
	 * to client credential {@code OAuth2RestTemplate} in property {@link #restTemplate0}.
	 * 
	 * @param options the {@code RequestOptions}
	 * @return the {@code OAuth2RestTemplate}
	 */
	protected RestTemplate getRequiredRestTemplate(RequestOptions options) {
		RestTemplate restTemplate = this.restTemplate;
		if (this.restTemplate0!=null) {
			if (restTemplate==null || WebUtil.getHttpServletRequest()==null ) {
				restTemplate = this.restTemplate0;
			}		
		}
		return restTemplate;
	}


	//
	// Other
	//

	/**
	 * Process URI by adding parameters from properties of specified objectes.
	 * 
	 * @param uri the {@code URI}
	 * @param objs a variadic array of objects
	 * @return the processed {@code URI}
	 */
	private static URI processURI(URI uri, Object... objs) {
		return UriUtils.appendQueryParameters(uri, objs);
	}

	private static URI processURI(URI uri, String name, Object value) {
		return UriUtils.appendQueryParameter(uri, name, value);
	}

	private static String getId(EntityBase obj) {
		if (StringUtils.hasText(obj.getUuid())) {
			return obj.getUuid();
		}
		if (StringUtils.hasText(obj.getId())) {
			return obj.getId();
		}
		return null;
	}
	
	private static String getId(NamedEntity obj, boolean name) {
		String id = getId((EntityBase)obj);
		if (id!=null) {
			return id;
		}
		if (name && StringUtils.hasText(obj.getName())) {
			return obj.getName();
		}
		return null;
	}

	private static String getId(NamedEntity obj) {
		return getId(obj, true);
	}

}
