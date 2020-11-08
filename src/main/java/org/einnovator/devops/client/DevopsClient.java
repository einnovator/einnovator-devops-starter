package org.einnovator.devops.client;

import static org.einnovator.util.UriUtils.makeURI;

import java.net.URI;

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
import org.einnovator.devops.client.model.Job;
import org.einnovator.devops.client.model.License;
import org.einnovator.devops.client.model.Registry;
import org.einnovator.devops.client.model.Repository;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.model.Solution;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.model.Vcs;
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
import org.einnovator.devops.client.modelx.JobFilter;
import org.einnovator.devops.client.modelx.JobOptions;
import org.einnovator.devops.client.modelx.LicenseFilter;
import org.einnovator.devops.client.modelx.LicenseOptions;
import org.einnovator.devops.client.modelx.RegistryFilter;
import org.einnovator.devops.client.modelx.RegistryOptions;
import org.einnovator.devops.client.modelx.SolutionFilter;
import org.einnovator.devops.client.modelx.SolutionOptions;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.devops.client.modelx.SpaceOptions;
import org.einnovator.devops.client.modelx.VcsFilter;
import org.einnovator.devops.client.modelx.VcsOptions;
import org.einnovator.util.PageResult;
import org.einnovator.util.PageUtil;
import org.einnovator.util.UriUtils;
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
import org.springframework.web.client.RestClientException;
import static org.einnovator.util.web.RequestOptions.isAdminRequest;


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
	
	private OAuth2RestTemplate restTemplate0;
	
	@Autowired
	public DevopsClient() {
	}
	
	public DevopsClient(DevopsClientConfiguration config) {
		this.config = config;
	}

	public DevopsClient(OAuth2RestTemplate restTemplate, DevopsClientConfiguration config) {
		this.restTemplate = restTemplate;
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
	public OAuth2RestTemplate getRestTemplate0() {
		return restTemplate0;
	}

	/**
	 * Set the value of property {@code restTemplate0}.
	 *
	 * @param restTemplate0 the value of property restTemplate0
	 */
	public void setRestTemplate0(OAuth2RestTemplate restTemplate0) {
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
	 * @param id the identifier
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
	 * @param cluster the {@code Cluster}
	 * @param options optional {@code RequestOptions}
	
	 * @throws RestClientException if request fails
	 */
	public void updateCluster(Cluster cluster, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cluster(cluster.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Cluster> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(cluster);		
		exchange(request, Cluster.class, options);
	}

	/**
	 * Delete existing {@code Cluster}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the {@code Cluster} identifier (UUID)
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
	 * @param id the identifier
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
	 * Update existing {@code Space}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param space the {@code Space}
	 * @param options optional {@code RequestOptions}
	
	 * @throws RestClientException if request fails
	 */
	public void updateSpace(Space space, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.space(space.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Space> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(space);		
		exchange(request, Space.class, options);
	}

	/**
	 * Delete existing {@code Space}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the {@code Space} identifier (UUID)
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
	// Deployment
	//
		
	/**
	 * List {@code Deployment}s for a {@code Space}.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param spaceId the {@code Space} identifier ({@code uuid})
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
	 * <p><b>Required Security Credentials</b>: Matching the any set in the Space.
	 * 
	 * @param id the identifier ({@code uuid})
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
	 * @param spaceId the {@code Space} identifier ({@code uuid})
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
	 * Update existing {@code Deployment}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param deploy the {@code Deployment}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateDeployment(Deployment deploy, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployment(deploy.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Deployment> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(deploy);
		exchange(request, Deployment.class, options);
	}

	/**
	 * Delete existing {@code Deployment}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the {@code Deployment} identifier (UUID)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteDeployment(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Route
	//
	
	public URI addRoute(String deployId, Route route, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.routes(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(route);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateRoute(String deployId, Route route, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, route.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(route);
		exchange(request, Route.class, options);
	}

	public void removeRoute(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Binding
	//
	
	public URI addBinding(String deployId, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindings(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateBinding(String deployId, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, binding.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		exchange(request, Binding.class, options);
	}

	public void removeBinding(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Connector
	//
	
	public URI addConnector(String deployId, Connector connector, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connectors(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateConnector(String deployId, Connector connector, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, connector.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		exchange(request, Connector.class, options);
	}

	public void removeConnector(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	
	//
	// Repository
	//
	
	public URI addRepository(String deployId, Repository repository, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repositories(deployId, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateRepository(String deployId, Repository repository, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, repository.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		exchange(request, Repository.class, options);
	}

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
	 * @param spaceId the {@code Space} identifier ({@code uuid})
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
	 * <p><b>Required Security Credentials</b>: Matching the any set in the Space.
	 * 
	 * @param id the identifier ({@code uuid})
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
	 * @param spaceId the {@code Space} identifier ({@code uuid})
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
	 * Update existing {@code Job}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param job the {@code Job}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateJob(Job job, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.job(job.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Job> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(job);
		exchange(request, Job.class, options);
	}

	/**
	 * Delete existing {@code Job}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param id the {@code Job} identifier (UUID)
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteJob(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.job(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
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
	 * @param spaceId the {@code Space} identifier ({@code uuid})
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
	 * <p><b>Required Security Credentials</b>: Matching the any set in the Space.
	 * 
	 * @param id the identifier ({@code uuid})
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
	 * @param spaceId the {@code Space} identifier ({@code uuid})
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
	 * Update existing {@code CronJob}
	 * 
	 * <p><b>Required Security Credentials</b>: Matching the roles MANAGER, DEVELOPER set in the Space.
	 * 
	 * @param cronjob the {@code CronJob}
	 * @param options optional {@code RequestOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateCronJob(CronJob cronjob, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.cronjob(cronjob.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<CronJob> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(cronjob);
		exchange(request, CronJob.class, options);
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

	//
	// Domain
	//
	
	public Domain getDomain(String id, DomainOptions options) {
		URI uri = makeURI(DevopsEndpoints.domain(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Domain> result = exchange(request, Domain.class, options);
		return result.getBody();
	}

	
	public Page<Domain> listDomains(DomainFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.domains(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Domain.class);
	}
	
	public URI createDomain(Domain domain, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.domains(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Domain> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(domain);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}
	
	public void updateDomain(Domain domain, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.domain(domain.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Domain> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(domain);
		exchange(request, Domain.class, options);
	}
	
	public void deleteDomain(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.domain(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Registry
	//
	
	public Registry getRegistry(String id, RegistryOptions options) {
		URI uri = makeURI(DevopsEndpoints.registry(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Registry> result = exchange(request, Registry.class, options);
		return result.getBody();
	}

	
	public Page<Registry> listRegistrys(RegistryFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.registries(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Registry.class);
	}
	
	public URI createRegistry(Registry registry, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.registries(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Registry> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(registry);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}
	
	public void updateRegistry(Registry registry, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.registry(registry.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Registry> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(registry);
		exchange(request, Registry.class, options);
	}
	
	public void deleteRegistry(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.registry(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Vcs
	//
	
	public Vcs getVcs(String id, VcsOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Vcs> result = exchange(request, Vcs.class, options);
		return result.getBody();
	}

	
	public Page<Vcs> listVcss(VcsFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.vcss(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Vcs.class);
	}
	
	public URI createVcs(Vcs vcs, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcss(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}
	
	public void updateVcs(Vcs vcs, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(vcs.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		exchange(request, Vcs.class, options);
	}
	
	public void deleteVcs(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	
	//
	// Solution
	//
	
	public Solution getSolution(String id, SolutionOptions options) {
		URI uri = makeURI(DevopsEndpoints.solution(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Solution> result = exchange(request, Solution.class, options);
		return result.getBody();
	}

	
	public Page<Solution> listSolutions(SolutionFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.solutions(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Solution.class);
	}
	
	public URI createSolution(Solution solution, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.solutions(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Solution> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(solution);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}
	
	public void updateSolution(Solution solution, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.solution(solution.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Solution> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(solution);
		exchange(request, Solution.class, options);
	}
	
	public void deleteSolution(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.solution(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Catalog
	//
	
	public Catalog getCatalog(String id, CatalogOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Catalog> result = exchange(request, Catalog.class, options);
		return result.getBody();
	}

	
	public Page<Catalog> listCatalogs(CatalogFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.catalogs(config, isAdminRequest(filter)));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Catalog.class);
	}
	
	public URI createCatalog(Catalog catalog, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalogs(config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Catalog> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(catalog);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}
	
	public void updateCatalog(Catalog catalog, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalog(catalog.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Catalog> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(catalog);
		exchange(request, Catalog.class, options);
	}
	
	public void deleteCatalog(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.catalog(id, config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// License
	//
	
	/**
	 * Get {@code License} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier
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
	 * @param license the {@code License}
	 * @param options optional {@code RequestOptions}
	
	 * @throws RestClientException if request fails
	 */
	public void updateLicense(License license, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.license(license.getUuid(), config, isAdminRequest(options)));
		uri = processURI(uri, options);		
		RequestEntity<License> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(license);		
		exchange(request, License.class, options);
	}

	/**
	 * Delete existing {@code License}
	 * 
	 * <p><b>Required Security Credentials</b>: Admin (global role ADMIN), or owner.
	 * 
	 * @param id the {@code License} identifier (UUID)
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
		OAuth2RestTemplate restTemplate = getRequiredRestTemplate(options);
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
	 * @param restTemplate the {@code OAuth2RestTemplate} to use
	 * @param request the {@code RequestEntity}
	 * @param responseType the response type
	 * @return the result {@code ResponseEntity}
	 * @throws RestClientException if request fails
	 */
	protected <T> ResponseEntity<T> exchange(OAuth2RestTemplate restTemplate, RequestEntity<?> request, Class<T> responseType) throws RestClientException {
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
	protected OAuth2RestTemplate getRequiredRestTemplate(RequestOptions options) {
		OAuth2RestTemplate restTemplate = this.restTemplate;
		if (WebUtil.getHttpServletRequest()==null && this.restTemplate0!=null) {
			restTemplate = this.restTemplate0;
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
	
	
}
