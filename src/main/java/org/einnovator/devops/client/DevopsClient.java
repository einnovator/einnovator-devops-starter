package org.einnovator.devops.client;

import static org.einnovator.util.UriUtils.makeURI;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.config.DevopsClientConfiguration;

import org.einnovator.devops.client.config.DevopsEndpoints;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Cluster;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Job;
import org.einnovator.devops.client.model.Repository;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.model.Vcs;
import org.einnovator.devops.client.modelx.DeploymentFilter;
import org.einnovator.devops.client.modelx.DeploymentOptions;
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
	
	@Autowired
	@Qualifier("metaRestTemplate")
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
		URI uri = makeURI(DevopsEndpoints.space(id, config));
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
		URI uri = makeURI(DevopsEndpoints.spaces(config));
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
		URI uri = makeURI(DevopsEndpoints.spaces(config));
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
		URI uri = makeURI(DevopsEndpoints.space(space.getUuid(), config));
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
		URI uri = makeURI(DevopsEndpoints.space(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Deployment
	//
	
	
	/**
	 * List {@code Deployment}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Matching any roles set in the Space.
	 * 
	 * @param filter a {@code DeploymentFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Deployment}s
	 * @throws RestClientException if request fails
	 */
	public Page<Deployment> listDeployments(String spaceId, DeploymentFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config));
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
	 * @param id the identifier
	 * @param options (optional) the {@code DeploymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Deployment}
	 * @throws RestClientException if request fails
	 */
	public Deployment getDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config));
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
	 * @param deploy the {@code Deployment}
	 * @param options optional {@code RequestOptions}
	 * @return the location {@code URI} for the created {@code Deployment}
	 * @throws RestClientException if request fails
	 */
	public URI createDeployment(String spaceId, Deployment deploy, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config));
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
		URI uri = makeURI(DevopsEndpoints.deployment(deploy.getUuid(), config));
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
		URI uri = makeURI(DevopsEndpoints.deployment(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	
	//
	// Route
	//
	
	public URI addRoute(String deployId, Route route, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.routes(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(route);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateRoute(String deployId, Route route, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, route.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(route);
		exchange(request, Route.class, options);
	}

	public void removeRoute(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, id, config));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Binding
	//
	
	public URI addBinding(String deployId, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.bindings(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateBinding(String deployId, Binding binding, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, binding.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		exchange(request, Binding.class, options);
	}

	public void removeBinding(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	//
	// Connector
	//
	
	public URI addConnector(String deployId, Connector connector, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connectors(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateConnector(String deployId, Connector connector, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, connector.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		exchange(request, Connector.class, options);
	}

	public void removeConnector(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}

	
	//
	// Repository
	//
	
	public URI addRepository(String deployId, Repository repository, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repositories(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
		
	}

	public void updateRepository(String deployId, Repository repository, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, repository.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		exchange(request, Repository.class, options);
	}

	public void removeRepository(String deployId, String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, options);
	}
	
	
	//
	// Vcs
	//
	
	public Vcs getVcs(String id, VcsOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Vcs> result = exchange(request, Vcs.class, options);
		return result.getBody();
	}

	
	public Page<Vcs> listVcss(VcsFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.vcss(config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(),  Vcs.class);
	}
	
	public URI createVcs(Vcs vcs, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcss(config));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		ResponseEntity<Void> result = exchange(request, Void.class, options);
		return result.getHeaders().getLocation();
	}
	
	public void updateVcs(Vcs vcs, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(vcs.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		exchange(request, Vcs.class, options);
	}
	
	public void deleteVcs(String id, RequestOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config));
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
