package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.model.Catalog;
import org.einnovator.devops.client.modelx.CatalogFilter;
import org.einnovator.devops.client.modelx.CatalogOptions;
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

public class CatalogManagerImpl implements CatalogManager {

	public static final String CACHE_CATALOG = "Catalog";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public CatalogManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public CatalogManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public CatalogManagerImpl() {
	}


	

	@Override
	public Catalog getCatalog(String id, CatalogOptions options) {
		try {
			
			if (isCachable(options)) {
				Catalog project = CacheUtils.getCacheValue(Catalog.class, getCatalogCache(), id);
				if (project!=null) {
					return project;
				}	
			}
			Catalog project = client.getCatalog(id, options);		
			if (project==null) {
				logger.error("getCatalog" + id);
			}
			if (isCachable(options)) {
				CacheUtils.putCacheValue(project, getCatalogCache(), id);				
			}

			return project;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getCatalog: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getCatalog: %s %s %s", e, id, options));
			return null;
		}
	}


	protected boolean isCachable(CatalogOptions options) {
		return options==null;
	}
	
	@Override
	public URI createCatalog(Catalog project, RequestOptions options) {
		try {
			return client.createCatalog(project, null);
		} catch (RuntimeException e) {
			logger.error(String.format("createCatalog: %s %s", e, project));
			return null;
		}
	}
	
	@Override
	@CachePut(value=CACHE_CATALOG, key="#project.uuid")
	public Catalog updateCatalog(Catalog project, RequestOptions options) {
		try {
			client.updateCatalog(project, null);
			return project;
		} catch (RuntimeException e) {
			logger.error(String.format("updateCatalog: %s %s", e, project));
			return null;
		}
	}

	@Override
	public Catalog createOrUpdateCatalog(Catalog project, RequestOptions options) {
		if (project.getUuid()==null) {
			URI uri = createCatalog(project, null);
			if (uri==null) {
				return null;
			}
			project.setUuid(UriUtils.extractId(uri));
			return project;
		} else {
			return updateCatalog(project, null);
		}
	}
	
	
	@Override
	@CacheEvict(value=CACHE_CATALOG, key="#id")
	public boolean deleteCatalog(String id, RequestOptions options) {
		try {
			client.deleteCatalog(id, null);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteCatalog: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<Catalog> listCatalogs(CatalogFilter filter, Pageable pageable) {
		try {
			return client.listCatalogs(filter, pageable);
		} catch (RuntimeException e) {
			logger.error(String.format("listCatalogs: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	
	public void onCatalogUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getCatalogCache();
			if (cache!=null) {
				Catalog project = (Catalog) cache.get(id);
				if (project!=null) {
					if (details!=null) {
						project.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onCatalogUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getCatalogCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getCatalogCache() {
		Cache cache = cacheManager.getCache(CatalogManagerImpl.CACHE_CATALOG);
		return cache;
	}

	
}
