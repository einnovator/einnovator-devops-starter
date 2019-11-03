package org.einnovator.devops.client;

import static org.einnovator.util.UriUtils.appendQueryParameters;
import static org.einnovator.util.UriUtils.makeURI;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.config.DevopsClientConfiguration;
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

import org.einnovator.util.MappingUtils;
import org.einnovator.util.PageUtil;
import org.einnovator.util.PageOptions;
import org.einnovator.util.PageResult;
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
	
	public OAuth2RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	//
	// Project
	//
	
	public Project getProject(String id) {
		return getProject(id, null);
	}
	
	public Project getProject(String id, ProjectOptions options) {
		URI uri = makeURI(DevopsEndpoints.project(id, config));
		if (options!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (options!=null) {
				params.putAll(MappingUtils.toMapFormatted(options));
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Project> result = exchange(request, Project.class);
		return result.getBody();
	}

	
	public Page<Project> listProjects(ProjectFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.projects(config));
		if (pageable!=null || filter!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (pageable!=null) {
				params.putAll(MappingUtils.toMapFormatted(new PageOptions(pageable)));
			}
			if (filter!=null) {
				params.putAll(MappingUtils.toMapFormatted(filter));				
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class);
		return PageUtil.create2(result.getBody(),  Project.class);
	}
	
	public URI createProject(Project project) {
		URI uri = makeURI(DevopsEndpoints.projects(config));
		RequestEntity<Project> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(project);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
	}
	
	public void updateProject(Project project) {
		URI uri = makeURI(DevopsEndpoints.project(project.getUuid(), config));
		RequestEntity<Project> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(project);
		
		exchange(request, Project.class);
	}
	
	public void deleteProject(String id) {
		URI uri = makeURI(DevopsEndpoints.project(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}

	//
	// Spaces
	//

	public Page<Space> listSpaces(SpaceFilter filter, Pageable pageable) {
		return listSpaces(null, filter, pageable);
	}

	public Page<Space> listSpaces(String projectId, SpaceFilter filter, Pageable pageable) {
		URI uri = makeURI(projectId!=null ? DevopsEndpoints.spaces(projectId, config) : DevopsEndpoints.spaces(config));
		if (pageable!=null || filter!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (pageable!=null) {
				params.putAll(MappingUtils.toMapFormatted(new PageOptions(pageable)));
			}
			if (filter!=null) {
				params.putAll(MappingUtils.toMapFormatted(filter));				
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class);
		return PageUtil.create2(result.getBody(),  Space.class);
		
	}

	public URI createSpace(String projectId, Space space) {
		URI uri = makeURI(DevopsEndpoints.spaces(projectId, config));
		RequestEntity<Space> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(space);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
		
	}

	public Space getSpace(String id, SpaceOptions options) {
		URI uri = makeURI(DevopsEndpoints.space(id, config));
		if (options!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (options!=null) {
				params.putAll(MappingUtils.toMapFormatted(options));
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Space> result = exchange(request, Space.class);
		return result.getBody();
		
	}
	
	public void updateSpace(Space space) {
		URI uri = makeURI(DevopsEndpoints.space(space.getUuid(), config));
		RequestEntity<Space> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(space);
		
		exchange(request, Space.class);
	}

	public void deleteSpace(String id) {
		URI uri = makeURI(DevopsEndpoints.space(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}
	
	//
	// Deployment
	//
	
	
	public Page<Deployment> listDeployments(String spaceId, DeploymentFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config));
		if (pageable!=null || filter!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (pageable!=null) {
				params.putAll(MappingUtils.toMapFormatted(new PageOptions(pageable)));
			}
			if (filter!=null) {
				params.putAll(MappingUtils.toMapFormatted(filter));				
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class);
		return PageUtil.create2(result.getBody(),  Deployment.class);
		
	}

	public URI createDeployment(String spaceId, Deployment deploy) {
		URI uri = makeURI(DevopsEndpoints.deployments(spaceId, config));
		RequestEntity<Deployment> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(deploy);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
		
	}

	public Deployment getDeployment(String id, DeploymentOptions options) {
		URI uri = makeURI(DevopsEndpoints.deployment(id, config));
		if (options!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (options!=null) {
				params.putAll(MappingUtils.toMapFormatted(options));
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Deployment> result = exchange(request, Deployment.class);
		return result.getBody();
		
	}
	
	public void updateDeployment(Deployment deploy) {
		URI uri = makeURI(DevopsEndpoints.deployment(deploy.getUuid(), config));
		RequestEntity<Deployment> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(deploy);
		
		exchange(request, Deployment.class);
	}

	public void deleteDeployment(String id) {
		URI uri = makeURI(DevopsEndpoints.deployments(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}

	
	//
	// Route
	//
	
	public URI addRoute(String deployId, Route route) {
		URI uri = makeURI(DevopsEndpoints.routes(deployId, config));
		RequestEntity<Route> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(route);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
		
	}

	public void updateRoute(String deployId, Route route) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, route.getUuid(), config));
		RequestEntity<Route> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(route);
		
		exchange(request, Route.class);
	}

	public void removeRoute(String deployId, String id) {
		URI uri = makeURI(DevopsEndpoints.route(deployId, id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}
	
	//
	// Binding
	//
	
	public URI addBinding(String deployId, Binding binding) {
		URI uri = makeURI(DevopsEndpoints.bindings(deployId, config));
		RequestEntity<Binding> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
		
	}

	public void updateBinding(String deployId, Binding binding) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, binding.getUuid(), config));
		RequestEntity<Binding> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(binding);
		
		exchange(request, Binding.class);
	}

	public void removeBinding(String deployId, String id) {
		URI uri = makeURI(DevopsEndpoints.binding(deployId, id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}
	
	//
	// Connector
	//
	
	public URI addConnector(String deployId, Connector connector) {
		URI uri = makeURI(DevopsEndpoints.connectors(deployId, config));
		RequestEntity<Connector> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
		
	}

	public void updateConnector(String deployId, Connector connector) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, connector.getUuid(), config));
		RequestEntity<Connector> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(connector);
		
		exchange(request, Connector.class);
	}

	public void removeConnector(String deployId, String id) {
		URI uri = makeURI(DevopsEndpoints.connector(deployId, id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}

	
	//
	// Repository
	//
	
	public URI addRepository(String deployId, Repository repository) {
		URI uri = makeURI(DevopsEndpoints.repositories(deployId, config));
		RequestEntity<Repository> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
		
	}

	public void updateRepository(String deployId, Repository repository) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, repository.getUuid(), config));
		RequestEntity<Repository> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(repository);
		
		exchange(request, Repository.class);
	}

	public void removeRepository(String deployId, String id) {
		URI uri = makeURI(DevopsEndpoints.repository(deployId, id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}
	
	
	//
	// Vcs
	//
	
	public Vcs getVcs(String id) {
		return getVcs(id, null);
	}
	
	public Vcs getVcs(String id, VcsOptions options) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config));
		if (options!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (options!=null) {
				params.putAll(MappingUtils.toMapFormatted(options));
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Vcs> result = exchange(request, Vcs.class);
		return result.getBody();
	}

	
	public Page<Vcs> listVcss(VcsFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.vcss(config));
		if (pageable!=null || filter!=null) {
			Map<String, String> params = new LinkedHashMap<>();
			if (pageable!=null) {
				params.putAll(MappingUtils.toMapFormatted(new PageOptions(pageable)));
			}
			if (filter!=null) {
				params.putAll(MappingUtils.toMapFormatted(filter));				
			}
			uri = appendQueryParameters(uri, params);
		}
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		@SuppressWarnings("rawtypes")
		ResponseEntity<PageResult> result = exchange(request, PageResult.class);
		return PageUtil.create2(result.getBody(),  Vcs.class);
	}
	
	public URI createVcs(Vcs vcs) {
		URI uri = makeURI(DevopsEndpoints.vcss(config));
		RequestEntity<Vcs> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		
		ResponseEntity<Void> result = exchange(request, Void.class);
		return result.getHeaders().getLocation();
	}
	
	public void updateVcs(Vcs vcs) {
		URI uri = makeURI(DevopsEndpoints.vcs(vcs.getUuid(), config));
		RequestEntity<Vcs> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(vcs);
		
		exchange(request, Vcs.class);
	}
	
	public void deleteVcs(String id) {
		URI uri = makeURI(DevopsEndpoints.vcs(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}
	
	protected <T> ResponseEntity<T> exchange(RequestEntity<?> request, Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(request, responseType);
	}

}
