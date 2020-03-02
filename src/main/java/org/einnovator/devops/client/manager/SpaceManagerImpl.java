package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.DeploymentFilter;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.devops.client.modelx.SpaceOptions;
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

public class SpaceManagerImpl implements SpaceManager {

	public static final String CACHE_SPACE = "Deployment";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public SpaceManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public SpaceManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	public SpaceManagerImpl() {
	}


	@Override
	public Space getSpace(String id, DevopsClientContext context) {
		return getSpace(id, null, context);
	}

	@Override
	public Space getSpace(String id, SpaceOptions options, DevopsClientContext context) {
		try {
			Space space = client.getSpace(id, options, context);		
			if (space==null) {
				logger.error("getSpace" + id);
			}
			return space;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getSpace: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getSpace: %s %s %s", e, id, options));
			return null;
		}
	}


	@Override
	@CachePut(value=CACHE_SPACE, key="#space.uuid")
	public Space updateSpace(Space space, RequestOptions options, DevopsClientContext context) {
		try {
			client.updateSpace(space, null, context);
			return space;
		} catch (RuntimeException e) {
			logger.error(String.format("updateSpace: %s %s", e, space));
			return null;
		}
	}

	
	@Override
	@CacheEvict(value=CACHE_SPACE, key="#id")
	public boolean deleteSpace(String id, RequestOptions options, DevopsClientContext context) {
		try {
			client.deleteSpace(id, null, context);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteSpace: %s %s %s", e, id));
			return false;
		}
	}
	
	
	@Override
	public Page<Space> listSpaces(SpaceFilter filter, Pageable pageable, DevopsClientContext context) {
		try {
			return client.listSpaces(filter, pageable, context);
		} catch (RuntimeException e) {
			logger.error(String.format("listSpaces: %s %s %s", e, filter, pageable));
			return null;
		}
	}
	
	
	public void onSpaceUpdate(String id, Map<String, Object> details, DevopsClientContext context) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getSpaceCache();
			if (cache!=null) {
				Space space = (Space) cache.get(id);
				if (space!=null) {
					if (details!=null) {
						space.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onSpaceUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getSpaceCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getSpaceCache() {
		Cache cache = cacheManager.getCache(DeploymentManagerImpl.CACHE_SPACE);
		return cache;
	}

	@Override
	public Page<Deployment> listDeployments(String spaceId, DeploymentFilter filter, Pageable pageable, DevopsClientContext context) {
		try {
			return client.listDeployments(spaceId, filter, pageable, context);
		} catch (RuntimeException e) {
			logger.error(String.format("listDeployments: %s %s %s %s", e, spaceId, filter, pageable));
			return null;
		}
	}

	@Override
	public URI createDeployment(String spaceId, Deployment deploy, RequestOptions options, DevopsClientContext context) {
		try {
			return client.createDeployment(spaceId, deploy, null, context);
		} catch (RuntimeException e) {
			logger.error(String.format("postDeployment: %s %s %s", e, spaceId, deploy));
			return null;
		}
	}

	
}
