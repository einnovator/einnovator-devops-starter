package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;

import org.einnovator.devops.client.model.License;
import org.einnovator.devops.client.modelx.LicenseFilter;
import org.einnovator.devops.client.modelx.LicenseOptions;
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

public class LicenseManagerImpl implements LicenseManager {

	public static final String CACHE_LICENSE = "License";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public LicenseManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public LicenseManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public LicenseManagerImpl() {
	}

	@Override
	public License getLicense(String id, LicenseOptions options) {
		try {
			
			if (isCachable(options)) {
				License project = CacheUtils.getCacheValue(License.class, getLicenseCache(), id);
				if (project!=null) {
					return project;
				}	
			}
			License project = client.getLicense(id, options);		
			if (project==null) {
				logger.error("getLicense" + id);
			}
			if (isCachable(options)) {
				CacheUtils.putCacheValue(project, getLicenseCache(), id);				
			}

			return project;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getLicense: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getLicense: %s %s %s", e, id, options));
			return null;
		}
	}


	protected boolean isCachable(LicenseOptions options) {
		return options==null;
	}
	
	@Override
	public URI createLicense(License project, RequestOptions options) {
		try {
			return client.createLicense(project, null);
		} catch (RuntimeException e) {
			logger.error(String.format("createLicense: %s %s", e, project));
			return null;
		}
	}
	
	@Override
	@CachePut(value=CACHE_LICENSE, key="#project.uuid")
	public License updateLicense(License project, RequestOptions options) {
		try {
			client.updateLicense(project, null);
			return project;
		} catch (RuntimeException e) {
			logger.error(String.format("updateLicense: %s %s", e, project));
			return null;
		}
	}

	@Override
	public License createOrUpdateLicense(License project, RequestOptions options) {
		if (project.getUuid()==null) {
			URI uri = createLicense(project, null);
			if (uri==null) {
				return null;
			}
			project.setUuid(UriUtils.extractId(uri));
			return project;
		} else {
			return updateLicense(project, null);
		}
	}
	
	
	@Override
	@CacheEvict(value=CACHE_LICENSE, key="#id")
	public boolean deleteLicense(String id, RequestOptions options) {
		try {
			client.deleteLicense(id, null);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteLicense: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<License> listLicenses(LicenseFilter filter, Pageable pageable) {
		try {
			return client.listLicenses(filter, pageable);
		} catch (RuntimeException e) {
			logger.error(String.format("listLicenses: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	
	public void onLicenseUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getLicenseCache();
			if (cache!=null) {
				License project = (License) cache.get(id);
				if (project!=null) {
					if (details!=null) {
						project.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onLicenseUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getLicenseCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getLicenseCache() {
		Cache cache = cacheManager.getCache(LicenseManagerImpl.CACHE_LICENSE);
		return cache;
	}




	
}
