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
import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.ProjectFilter;
import org.einnovator.devops.client.modelx.ProjectOptions;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.devops.client.modelx.SpaceOptions;
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


	// Project
	
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

	public Page<Space> listSpaces(String projectId, SpaceFilter filter, Pageable pageable) {
		URI uri = makeURI(DevopsEndpoints.spaces(projectId, config));
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

	protected <T> ResponseEntity<T> exchange(RequestEntity<?> request, Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(request, responseType);
	}

}
