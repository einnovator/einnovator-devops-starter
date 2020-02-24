package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.ProjectFilter;
import org.einnovator.devops.client.modelx.ProjectOptions;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.util.UriUtils;
import org.einnovator.util.cache.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ProjectManagerImpl implements ProjectManager {

	public static final String CACHE_PROJECT = "Project";
	public static final String CACHE_SPACE = "Space";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public ProjectManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public ProjectManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public ProjectManagerImpl() {
	}


	@Override
	public Project getProject(String id, DevopsClientContext context) {
		if (id==null) {
			return null;
		}
			
		try {
			Project project = CacheUtils.getCacheValue(Project.class, getProjectCache(), id);
			if (project!=null) {
				return project;
			}	
			project = client.getProject(id, context);		
			if (project==null) {
				logger.error(String.format("getProject: %s", id));
				return null;
			}
			return CacheUtils.putCacheValue(project, getProjectCache(), id);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getProject: %s %s", e, id));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getProject: %s %s", e, id));
			return null;
		}
	}

	@Override
	public Project getProject(String id, ProjectOptions options, DevopsClientContext context) {
		try {
			Project project = client.getProject(id, options, context);		
			if (project==null) {
				logger.error("getProject" + id);
			}
			return project;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getProject: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getProject: %s %s %s", e, id, options));
			return null;
		}
	}

	@Override
	public URI createProject(Project project, DevopsClientContext context) {
		try {
			return client.createProject(project, null);
		} catch (RuntimeException e) {
			logger.error(String.format("createProject: %s %s", e, project));
			return null;
		}
	}
	
	@Override
	@CachePut(value=CACHE_PROJECT, key="#project.uuid")
	public Project updateProject(Project project, DevopsClientContext context) {
		try {
			client.updateProject(project, context);
			return project;
		} catch (RuntimeException e) {
			logger.error(String.format("updateProject: %s %s", e, project));
			return null;
		}
	}

	@Override
	public Project createOrUpdateProject(Project project, DevopsClientContext context) {
		if (project.getUuid()==null) {
			URI uri = createProject(project, context);
			if (uri==null) {
				return null;
			}
			project.setUuid(UriUtils.extractId(uri));
			return project;
		} else {
			return updateProject(project, context);
		}
	}
	
	
	@Override
	@CacheEvict(value=CACHE_PROJECT, key="#id")
	public boolean deleteProject(String id, DevopsClientContext context) {
		try {
			client.deleteProject(id, context);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteProject: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<Project> listProjects(ProjectFilter filter, Pageable pageable, DevopsClientContext context) {
		try {
			return client.listProjects(filter, pageable, context);
		} catch (RuntimeException e) {
			logger.error(String.format("listProjects: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	@Override
	public void onProjectUpdate(String id, Map<String, Object> details, DevopsClientContext context) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getProjectCache();
			if (cache!=null) {
				Project project = (Project) cache.get(id);
				if (project!=null) {
					if (details!=null) {
						project.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onProjectUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getProjectCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getProjectCache() {
		Cache cache = cacheManager.getCache(ProjectManagerImpl.CACHE_PROJECT);
		return cache;
	}

	@Override
	public Page<Space> listSpaces(String projectId, SpaceFilter filter, Pageable pageable, DevopsClientContext context) {
		try {
			return client.listSpaces(projectId, filter, pageable, context);
		} catch (RuntimeException e) {
			logger.error(String.format("listSpaces: %s %s %s %s", e, projectId, filter, pageable));
			return null;
		}
	}

	@Override
	public URI createSpace(String projectId, Space space, DevopsClientContext context) {
		try {
			return client.createSpace(projectId, space, context);
		} catch (RuntimeException e) {
			logger.error(String.format("postSpace: %s %s %s", e, projectId, space));
			return null;
		}
	}


	
}
