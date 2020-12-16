package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;

import org.einnovator.devops.client.model.Solution;
import org.einnovator.devops.client.modelx.SolutionFilter;
import org.einnovator.devops.client.modelx.SolutionOptions;
import org.einnovator.util.UriUtils;
import org.einnovator.util.cache.CacheUtils;
import org.einnovator.util.web.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class SolutionManagerImpl implements SolutionManager {

	public static final String CACHE_SOLUTION = "Solution";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public SolutionManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public SolutionManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public SolutionManagerImpl() {
	}


	

	@Override
	public Solution getSolution(String id, SolutionOptions options) {
		try {
			
			if (isCachable(options)) {
				Solution project = CacheUtils.getCacheValue(Solution.class, getSolutionCache(), id);
				if (project!=null) {
					return project;
				}	
			}
			Solution project = client.getSolution(id, options);		
			if (project==null) {
				logger.error("getSolution" + id);
			}
			if (isCachable(options)) {
				CacheUtils.putCacheValue(project, getSolutionCache(), id);				
			}

			return project;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getSolution: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getSolution: %s %s %s", e, id, options));
			return null;
		}
	}


	protected boolean isCachable(SolutionOptions options) {
		return options==null;
	}
	
	@Override
	public URI createSolution(Solution project, RequestOptions options) {
		try {
			return client.createSolution(project, null);
		} catch (RuntimeException e) {
			logger.error(String.format("createSolution: %s %s", e, project));
			return null;
		}
	}
	
	@Override
	@CachePut(value=CACHE_SOLUTION, key="#project.uuid")
	public Solution updateSolution(Solution project, RequestOptions options) {
		try {
			client.updateSolution(project, null);
			return project;
		} catch (RuntimeException e) {
			logger.error(String.format("updateSolution: %s %s", e, project));
			return null;
		}
	}

	@Override
	public Solution createOrUpdateSolution(Solution project, RequestOptions options) {
		if (project.getUuid()==null) {
			URI uri = createSolution(project, null);
			if (uri==null) {
				return null;
			}
			project.setUuid(UriUtils.extractId(uri));
			return project;
		} else {
			return updateSolution(project, null);
		}
	}
	
	
	@Override
	@CacheEvict(value=CACHE_SOLUTION, key="#id")
	public boolean deleteSolution(String id, RequestOptions options) {
		try {
			client.deleteSolution(id, null);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteSolution: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<Solution> listSolutions(SolutionFilter filter, Pageable pageable) {
		try {
			return client.listSolutions(filter, pageable);
		} catch (RuntimeException e) {
			logger.error(String.format("listSolutions: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	
	public void onSolutionUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getSolutionCache();
			if (cache!=null) {
				Solution project = (Solution) cache.get(id);
				if (project!=null) {
					if (details!=null) {
						project.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onSolutionUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getSolutionCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getSolutionCache() {
		Cache cache = cacheManager.getCache(SolutionManagerImpl.CACHE_SOLUTION);
		return cache;
	}




	
}
