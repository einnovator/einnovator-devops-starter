package org.einnovator.devops.client;

import static org.einnovator.util.UriUtils.makeURI;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.config.DevopsClientConfiguration;
import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.config.DevopsEndpoints;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.Repository;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.model.Vcs;
import org.einnovator.devops.client.modelx.DeploymentFilter;
import org.einnovator.devops.client.modelx.DeploymentOptions;
import org.einnovator.devops.client.modelx.ProjectFilter;
import org.einnovator.devops.client.modelx.ProjectOptions;
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

	

	//
	// Project
	//
	
	public Project getProject(String id, DevopsClientContext context) {
		return getProject(id, null, context);
	}
	
	public Project getProject(String id, ProjectOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.project(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Project> result = exchange(request, Project.class, context);
		return result.getBody();
	}

	
	public Page<Project> listProjects(ProjectFilter filter, Pageable pageable, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.projects(config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, context);
		return PageUtil.create2(result.getBody(),  Project.class);
	}
	
	public URI createProject(Project project, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.projects(config));
		uri = processURI(uri, options);
		RequestEntity<Project> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(project);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();
	}
	
	public void updateProject(Project project, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.project(project.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Project> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(project);
		exchange(request, Project.class, context);
	}
	
	public void deleteProject(String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.project(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}

	//
	// Spaces
	//

	public Page<Space> listSpaces(SpaceFilter filter, Pageable pageable, DevopsClientContext context) {
		return listSpaces(null, filter, pageable, context);
	}

	public Page<Space> listSpaces(String projectId, SpaceFilter filter, Pageable pageable, DevopsClientContext context) {
		URI uri = makeURI(projectId!=null ? DevopsEndpoints.spaces(projectId, config) : DevopsEndpoints.spaces(config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, context);
		return PageUtil.create2(result.getBody(),  Space.class);
	}

	public URI createSpace(String projectId, Space space, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.spaces(projectId, config));
		uri = processURI(uri, options);		
		RequestEntity<Space> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(space);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();	
	}

	public Space getSpace(String id, SpaceOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.space(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Space> result = exchange(request, Space.class, context);
		return result.getBody();
		
	}
	
	public void updateSpace(Space space, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.space(space.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Space> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(space);		
		exchange(request, Space.class, context);
	}

	public void deleteSpace(String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.space(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}
	
	//
	// Deployment
	//
	
	
	public Page<Deployment> listDeployments(String spaceId, DeploymentFilter filter, Pageable pageable, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, context);
		return PageUtil.create2(result.getBody(),  Deployment.class);
		
	}

	public URI createDeployment(String spaceId, Deployment deploy, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config));
		uri = processURI(uri, options);		
		RequestEntity<Deployment> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(deploy);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();
		
	}

	public Deployment getDeployment(String id, DeploymentOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Deployment> result = exchange(request, Deployment.class, context);
		return result.getBody();
		
	}
	
	public void updateDeployment(Deployment deploy, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.deployment(deploy.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Deployment> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(deploy);
		exchange(request, Deployment.class, context);
	}

	public void deleteDeployment(String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}

	
	//
	// Route
	//
	
	public URI addRoute(String deployId, Route route, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.routes(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(route);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();
		
	}

	public void updateRoute(String deployId, Route route, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, route.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Route> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(route);
		exchange(request, Route.class, context);
	}

	public void removeRoute(String deployId, String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, id, config));
		uri = processURI(uri, options);	
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}
	
	//
	// Binding
	//
	
	public URI addBinding(String deployId, Binding binding, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.bindings(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();
		
	}

	public void updateBinding(String deployId, Binding binding, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, binding.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Binding> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		exchange(request, Binding.class, context);
	}

	public void removeBinding(String deployId, String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}
	
	//
	// Connector
	//
	
	public URI addConnector(String deployId, Connector connector, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.connectors(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();
		
	}

	public void updateConnector(String deployId, Connector connector, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, connector.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Connector> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		exchange(request, Connector.class, context);
	}

	public void removeConnector(String deployId, String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}

	
	//
	// Repository
	//
	
	public URI addRepository(String deployId, Repository repository, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.repositories(deployId, config));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();
		
	}

	public void updateRepository(String deployId, Repository repository, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, repository.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Repository> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		exchange(request, Repository.class, context);
	}

	public void removeRepository(String deployId, String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}
	
	
	//
	// Vcs
	//
	
	public Vcs getVcs(String id, VcsOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Vcs> result = exchange(request, Vcs.class, context);
		return result.getBody();
	}

	
	public Page<Vcs> listVcss(VcsFilter filter, Pageable pageable, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.vcss(config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, context);
		return PageUtil.create2(result.getBody(),  Vcs.class);
	}
	
	public URI createVcs(Vcs vcs, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.vcss(config));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		ResponseEntity<Void> result = exchange(request, Void.class, context);
		return result.getHeaders().getLocation();
	}
	
	public void updateVcs(Vcs vcs, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.vcs(vcs.getUuid(), config));
		uri = processURI(uri, options);		
		RequestEntity<Vcs> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		exchange(request, Vcs.class, context);
	}
	
	public void deleteVcs(String id, RequestOptions options, DevopsClientContext context) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class, context);
	}
	
	//
	// HTTP transport
	//
	
	protected <T> ResponseEntity<T> exchange(RequestEntity<?> request, Class<T> responseType, DevopsClientContext context) throws RestClientException {
		OAuth2RestTemplate restTemplate = getRequiredRestTemplate(context);

		try {
			return exchange(restTemplate, request, responseType);			
		} catch (RuntimeException e) {
			if (context!=null && !context.isSingleton()) {
				context.setResult(new Result<Object>(e));
			}
			throw e;
		}
	}


	protected OAuth2RestTemplate getRequiredRestTemplate(DevopsClientContext context) {
		OAuth2RestTemplate restTemplate = this.restTemplate;
		if (context!=null && context.getRestTemplate()!=null) {
			restTemplate = context.getRestTemplate();
		} else {
			if (WebUtil.getHttpServletRequest()==null && this.restTemplate0!=null) {
				restTemplate = this.restTemplate0;
			}			
		}
		return restTemplate;
	}
	

	protected <T> ResponseEntity<T> exchange(OAuth2RestTemplate restTemplate, RequestEntity<?> request, Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(request, responseType);
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
