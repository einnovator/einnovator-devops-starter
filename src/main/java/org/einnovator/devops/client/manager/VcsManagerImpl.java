package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;

import org.einnovator.devops.client.model.Vcs;
import org.einnovator.devops.client.modelx.VcsFilter;
import org.einnovator.devops.client.modelx.VcsOptions;
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

public class VcsManagerImpl implements VcsManager {

	public static final String CACHE_VCS = "Vcs";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public VcsManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public VcsManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public VcsManagerImpl() {
	}


	

	@Override
	public Vcs getVcs(String id, VcsOptions options) {
		try {
			
			if (isCachable(options)) {
				Vcs project = CacheUtils.getCacheValue(Vcs.class, getVcsCache(), id);
				if (project!=null) {
					return project;
				}	
			}
			Vcs project = client.getVcs(id, options);		
			if (project==null) {
				logger.error("getVcs" + id);
			}
			if (isCachable(options)) {
				CacheUtils.putCacheValue(project, getVcsCache(), id);				
			}

			return project;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getVcs: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getVcs: %s %s %s", e, id, options));
			return null;
		}
	}


	protected boolean isCachable(VcsOptions options) {
		return options==null;
	}
	
	@Override
	public URI createVcs(Vcs project, RequestOptions options) {
		try {
			return client.createVcs(project, null);
		} catch (RuntimeException e) {
			logger.error(String.format("createVcs: %s %s", e, project));
			return null;
		}
	}
	
	@Override
	@CachePut(value=CACHE_VCS, key="#project.uuid")
	public Vcs updateVcs(Vcs project, RequestOptions options) {
		try {
			client.updateVcs(project, null);
			return project;
		} catch (RuntimeException e) {
			logger.error(String.format("updateVcs: %s %s", e, project));
			return null;
		}
	}

	@Override
	public Vcs createOrUpdateVcs(Vcs project, RequestOptions options) {
		if (project.getUuid()==null) {
			URI uri = createVcs(project, null);
			if (uri==null) {
				return null;
			}
			project.setUuid(UriUtils.extractId(uri));
			return project;
		} else {
			return updateVcs(project, null);
		}
	}
	
	
	@Override
	@CacheEvict(value=CACHE_VCS, key="#id")
	public boolean deleteVcs(String id, RequestOptions options) {
		try {
			client.deleteVcs(id, null);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteVcs: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<Vcs> listVcss(VcsFilter filter, Pageable pageable) {
		try {
			return client.listVcss(filter, pageable);
		} catch (RuntimeException e) {
			logger.error(String.format("listVcss: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	
	public void onVcsUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getVcsCache();
			if (cache!=null) {
				Vcs project = (Vcs) cache.get(id);
				if (project!=null) {
					if (details!=null) {
						project.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onVcsUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getVcsCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getVcsCache() {
		Cache cache = cacheManager.getCache(VcsManagerImpl.CACHE_VCS);
		return cache;
	}




	
}
