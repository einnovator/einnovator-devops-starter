package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.CronJob;
import org.einnovator.devops.client.modelx.CronJobOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class CronJobManagerImpl implements CronJobManager {

	public static final String CACHE_DEPLOYMENT = "CronJob";
	public static final String CACHE_SPACE = "CronJob";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public CronJobManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public CronJobManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	/**
	 * Create instance of {@code CronJobManagerImpl}.
	 *
	 */
	public CronJobManagerImpl() {
	}


	@Override
	public CronJob getCronJob(String id) {
		return getCronJob(id, null);
	}

	@Override
	public CronJob getCronJob(String id, CronJobOptions options) {
		try {
			CronJob cronjob = client.getCronJob(id, options);		
			if (cronjob==null) {
				logger.error("getCronJob" + id);
			}
			return cronjob;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getCronJob: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getCronJob: %s %s %s", e, id, options));
			return null;
		}
	}

	@Override
	@CachePut(value=CACHE_DEPLOYMENT, key="#cronjob.uuid")
	public CronJob updateCronJob(CronJob cronjob, RequestOptions options) {
		try {
			client.updateCronJob(cronjob, options);
			return cronjob;
		} catch (RuntimeException e) {
			logger.error(String.format("updateCronJob: %s %s", e, cronjob));
			return null;
		}
	}

	
	@Override
	@CacheEvict(value=CACHE_DEPLOYMENT, key="#id")
	public boolean deleteCronJob(String id, RequestOptions options) {
		try {
			client.deleteCronJob(id, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteCronJob: %s %s", e, id));
			return false;
		}
	}

	@Override
	public void onCronJobUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getCronJobCache();
			if (cache!=null) {
				CronJob cronjob = (CronJob) cache.get(id);
				if (cronjob!=null) {
					if (details!=null) {
						cronjob.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onCronJobUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getCronJobCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getCronJobCache() {
		Cache cache = cacheManager.getCache(CronJobManagerImpl.CACHE_DEPLOYMENT);
		return cache;
	}


	//
	// Binding
	//
	
	@Override
	public URI addBinding(String cronjobId, Binding binding, RequestOptions options) {
		try {
			return client.addBindingCronJob(cronjobId, binding, options);
		} catch (RuntimeException e) {
			logger.error(String.format("addBinding: %s %s %s", e, cronjobId, binding));
			return null;
		}
	}

	@Override
	public boolean removeBinding(String cronjobId, String bindingId, RequestOptions options) {
		try {
			client.removeBindingCronJob(cronjobId, bindingId, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeBinding: %s %s %s", e, cronjobId, bindingId));
			return false;
		}
		
	}

	@Override
	public Binding updateBinding(String cronjobId, String bindingId, Binding binding, RequestOptions options) {
		try {
			client.updateBindingCronJob(cronjobId, bindingId, binding, options);
			return binding;
		} catch (RuntimeException e) {
			logger.error(String.format("removeBinding: %s %s %s", e, cronjobId, binding));
			return null;
		}
	}

	
}
