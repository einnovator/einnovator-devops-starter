package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Job;
import org.einnovator.devops.client.modelx.JobOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class JobManagerImpl implements JobManager {

	public static final String CACHE_DEPLOYMENT = "Job";
	public static final String CACHE_SPACE = "Job";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public JobManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public JobManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	/**
	 * Create instance of {@code JobManagerImpl}.
	 *
	 */
	public JobManagerImpl() {
	}


	@Override
	public Job getJob(String id) {
		return getJob(id, null);
	}

	@Override
	public Job getJob(String id, JobOptions options) {
		try {
			Job job = client.getJob(id, options);		
			if (job==null) {
				logger.error("getJob" + id);
			}
			return job;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getJob: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getJob: %s %s %s", e, id, options));
			return null;
		}
	}

	@Override
	@CachePut(value=CACHE_DEPLOYMENT, key="#job.uuid")
	public Job updateJob(Job job, RequestOptions options) {
		try {
			client.updateJob(job, options);
			return job;
		} catch (RuntimeException e) {
			logger.error(String.format("updateJob: %s %s", e, job));
			return null;
		}
	}

	
	@Override
	@CacheEvict(value=CACHE_DEPLOYMENT, key="#id")
	public boolean deleteJob(String id, RequestOptions options) {
		try {
			client.deleteJob(id, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteJob: %s %s", e, id));
			return false;
		}
	}

	@Override
	public void onJobUpdate(String id, Map<String, Object> details) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getJobCache();
			if (cache!=null) {
				Job job = (Job) cache.get(id);
				if (job!=null) {
					if (details!=null) {
						job.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onJobUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getJobCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getJobCache() {
		Cache cache = cacheManager.getCache(JobManagerImpl.CACHE_DEPLOYMENT);
		return cache;
	}


	//
	// Binding
	//
	
	@Override
	public URI addBinding(String jobId, Binding binding, RequestOptions options) {
		try {
			return client.addBindingJob(jobId, binding, options);
		} catch (RuntimeException e) {
			logger.error(String.format("addBinding: %s %s %s", e, jobId, binding));
			return null;
		}
	}

	@Override
	public boolean removeBinding(String jobId, String bindingId, RequestOptions options) {
		try {
			client.removeBindingJob(jobId, bindingId, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeBinding: %s %s %s", e, jobId, bindingId));
			return false;
		}
		
	}

	@Override
	public Binding updateBinding(String jobId, String bindingId, Binding binding, RequestOptions options) {
		try {
			client.updateBindingJob(jobId, bindingId, binding, options);
			return binding;
		} catch (RuntimeException e) {
			logger.error(String.format("removeBinding: %s %s %s", e, jobId, binding));
			return null;
		}
	}

	
}
