package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.model.Domain;
import org.einnovator.devops.client.modelx.DomainFilter;
import org.einnovator.devops.client.modelx.DomainOptions;
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

public class DomainManagerImpl implements DomainManager {

	public static final String CACHE_VCS = "Domain";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public DomainManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public DomainManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public DomainManagerImpl() {
	}


	

	@Override
	public Domain getDomain(String id, DomainOptions options) {
		try {
			
			if (isCachable(options)) {
				Domain project = CacheUtils.getCacheValue(Domain.class, getDomainCache(), id);
				if (project!=null) {
					return project;
				}	
			}
			Domain project = client.getDomain(id, options);		
			if (project==null) {
				logger.error("getDomain" + id);
			}
			if (isCachable(options)) {
				CacheUtils.putCacheValue(project, getDomainCache(), id);				
			}

			return project;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getDomain: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getDomain: %s %s %s", e, id, options));
			return null;
		}
	}


	protected boolean isCachable(DomainOptions options) {
		return options==null;
	}
	
	@Override
	public URI createDomain(Domain project, RequestOptions options) {
		try {
			return client.createDomain(project, null);
		} catch (RuntimeException e) {
			logger.error(String.format("createDomain: %s %s", e, project));
			return null;
		}
	}
	
	@Override
	@CachePut(value=CACHE_VCS, key="#project.uuid")
	public Domain updateDomain(Domain project, RequestOptions options) {
		try {
			client.updateDomain(project, null);
			return project;
		} catch (RuntimeException e) {
			logger.error(String.format("updateDomain: %s %s", e, project));
			return null;
		}
	}

	@Override
	public Domain createOrUpdateDomain(Domain project, RequestOptions options) {
		if (project.getUuid()==null) {
			URI uri = createDomain(project, null);
			if (uri==null) {
				return null;
			}
			project.setUuid(UriUtils.extractId(uri));
			return project;
		} else {
			return updateDomain(project, null);
		}
	}
	
	
	@Override
	@CacheEvict(value=CACHE_VCS, key="#id")
	public boolean deleteDomain(String id, RequestOptions options) {
		try {
			client.deleteDomain(id, null);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteDomain: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<Domain> listDomains(DomainFilter filter, Pageable pageable) {
		try {
			return client.listDomains(filter, pageable);
		} catch (RuntimeException e) {
			logger.error(String.format("listDomains: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	
	public void onDomainUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getDomainCache();
			if (cache!=null) {
				Domain project = (Domain) cache.get(id);
				if (project!=null) {
					if (details!=null) {
						project.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onDomainUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getDomainCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getDomainCache() {
		Cache cache = cacheManager.getCache(DomainManagerImpl.CACHE_VCS);
		return cache;
	}




	
}
