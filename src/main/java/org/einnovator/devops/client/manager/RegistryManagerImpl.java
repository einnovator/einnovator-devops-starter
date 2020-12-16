package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.model.Registry;
import org.einnovator.devops.client.modelx.RegistryFilter;
import org.einnovator.devops.client.modelx.RegistryOptions;
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

public class RegistryManagerImpl implements RegistryManager {

	public static final String CACHE_REGISTRY = "Registry";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public RegistryManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public RegistryManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public RegistryManagerImpl() {
	}


	

	@Override
	public Registry getRegistry(String id, RegistryOptions options) {
		try {
			
			if (isCachable(options)) {
				Registry project = CacheUtils.getCacheValue(Registry.class, getRegistryCache(), id);
				if (project!=null) {
					return project;
				}	
			}
			Registry project = client.getRegistry(id, options);		
			if (project==null) {
				logger.error("getRegistry" + id);
			}
			if (isCachable(options)) {
				CacheUtils.putCacheValue(project, getRegistryCache(), id);				
			}

			return project;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getRegistry: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getRegistry: %s %s %s", e, id, options));
			return null;
		}
	}


	protected boolean isCachable(RegistryOptions options) {
		return options==null;
	}
	
	@Override
	public URI createRegistry(Registry project, RequestOptions options) {
		try {
			return client.createRegistry(project, null);
		} catch (RuntimeException e) {
			logger.error(String.format("createRegistry: %s %s", e, project));
			return null;
		}
	}
	
	@Override
	@CachePut(value=CACHE_REGISTRY, key="#project.uuid")
	public Registry updateRegistry(Registry project, RequestOptions options) {
		try {
			client.updateRegistry(project, null);
			return project;
		} catch (RuntimeException e) {
			logger.error(String.format("updateRegistry: %s %s", e, project));
			return null;
		}
	}

	@Override
	public Registry createOrUpdateRegistry(Registry project, RequestOptions options) {
		if (project.getUuid()==null) {
			URI uri = createRegistry(project, null);
			if (uri==null) {
				return null;
			}
			project.setUuid(UriUtils.extractId(uri));
			return project;
		} else {
			return updateRegistry(project, null);
		}
	}
	
	
	@Override
	@CacheEvict(value=CACHE_REGISTRY, key="#id")
	public boolean deleteRegistry(String id, RequestOptions options) {
		try {
			client.deleteRegistry(id, null);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteRegistry: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<Registry> listRegistries(RegistryFilter filter, Pageable pageable) {
		try {
			return client.listRegistries(filter, pageable);
		} catch (RuntimeException e) {
			logger.error(String.format("listRegistries: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	
	public void onRegistryUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getRegistryCache();
			if (cache!=null) {
				Registry project = (Registry) cache.get(id);
				if (project!=null) {
					if (details!=null) {
						project.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onRegistryUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getRegistryCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getRegistryCache() {
		Cache cache = cacheManager.getCache(RegistryManagerImpl.CACHE_REGISTRY);
		return cache;
	}




	
}
