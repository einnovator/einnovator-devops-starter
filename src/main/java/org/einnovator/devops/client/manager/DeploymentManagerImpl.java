package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;
import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.modelx.DeploymentOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class DeploymentManagerImpl implements DeploymentManager {

	public static final String CACHE_DEPLOYMENT = "Deployment";
	public static final String CACHE_SPACE = "Deployment";

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private DevopsClient client;
	
	private CacheManager cacheManager;

	@Autowired
	public DeploymentManagerImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public DeploymentManagerImpl(DevopsClient client, CacheManager cacheManager) {
		this.client = client;
		this.cacheManager = cacheManager;
	}
	
	/**
	 * Create instance of {@code DeploymentManagerImpl}.
	 *
	 */
	public DeploymentManagerImpl() {
	}


	@Override
	public Deployment getDeployment(String id, DevopsClientContext context) {
		return getDeployment(id, null, context);
	}

	@Override
	public Deployment getDeployment(String id, DeploymentOptions options, DevopsClientContext context) {
		try {
			Deployment deploy = client.getDeployment(id, options, context);		
			if (deploy==null) {
				logger.error("getDeployment" + id);
			}
			return deploy;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error(String.format("getDeployment: %s %s %s", e, id, options));
			}
			return null;
		} catch (RuntimeException e) {
			logger.error(String.format("getDeployment: %s %s %s", e, id, options));
			return null;
		}
	}

	@Override
	@CachePut(value=CACHE_DEPLOYMENT, key="#deploy.uuid")
	public Deployment updateDeployment(Deployment deploy, DevopsClientContext context) {
		try {
			client.updateDeployment(deploy, context);
			return deploy;
		} catch (RuntimeException e) {
			logger.error(String.format("updateDeployment: %s %s", e, deploy));
			return null;
		}
	}

	
	@Override
	@CacheEvict(value=CACHE_DEPLOYMENT, key="#id")
	public boolean deleteDeployment(String id, DevopsClientContext context) {
		try {
			client.deleteDeployment(id, context);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteDeployment: %s %s", e, id));
			return false;
		}
	}

	@Override
	public void onDeploymentUpdate(String id, Map<String, Object> details, DevopsClientContext context) {
		if (id==null) {
			return;
		}
		try {
			Cache cache = getDeploymentCache();
			if (cache!=null) {
				Deployment deploy = (Deployment) cache.get(id);
				if (deploy!=null) {
					if (details!=null) {
						deploy.updateFrom(details);						
					} else {
						cache.evict(id);
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(String.format("onDeploymentUpdate: %s", e));
		}
	}

	@Override
	public void clearCache() {
		Cache cache = getDeploymentCache();
		if (cache!=null) {
			cache.clear();
		}
	}

	@Override
	public Cache getDeploymentCache() {
		Cache cache = cacheManager.getCache(DeploymentManagerImpl.CACHE_DEPLOYMENT);
		return cache;
	}


	//
	// Route
	//
	
	@Override
	public URI addRoute(String deployId, Route route, DevopsClientContext context) {
		try {
			return client.addRoute(deployId, route, context);
		} catch (RuntimeException e) {
			logger.error(String.format("addRoute: %s %s %s", e, deployId, route));
			return null;
		}
	}
	
	@Override
	public boolean removeRoute(String deployId, String routeId, DevopsClientContext context) {
		try {
			client.removeRoute(deployId, routeId, context);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeRoute: %s %s %s", e, deployId, routeId));
			return false;
		}
		
	}

	@Override
	public Route updateRoute(String deployId, Route route, DevopsClientContext context) {
		try {
			client.updateRoute(deployId, route, context);
			return route;
		} catch (RuntimeException e) {
			logger.error(String.format("removeRoute: %s %s %s", e, deployId, route));
			return null;
		}
	}

	//
	// Binding
	//
	
	@Override
	public URI addBinding(String deployId, Binding binding, DevopsClientContext context) {
		try {
			return client.addBinding(deployId, binding, context);
		} catch (RuntimeException e) {
			logger.error(String.format("addBinding: %s %s %s", e, deployId, binding));
			return null;
		}
	}

	@Override
	public boolean removeBinding(String deployId, String bindingId, DevopsClientContext context) {
		try {
			client.removeBinding(deployId, bindingId, context);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeBinding: %s %s %s", e, deployId, bindingId));
			return false;
		}
		
	}

	@Override
	public Binding updateBinding(String deployId, Binding binding, DevopsClientContext context) {
		try {
			client.updateBinding(deployId, binding, context);
			return binding;
		} catch (RuntimeException e) {
			logger.error(String.format("removeBinding: %s %s %s", e, deployId, binding));
			return null;
		}
	}

	//
	// Connector
	//
	
	@Override
	public URI addConnector(String deployId, Connector connector, DevopsClientContext context) {
		try {
			return client.addConnector(deployId, connector, context);
		} catch (RuntimeException e) {
			logger.error(String.format("addConnector: %s %s %s", e, deployId, connector));
			return null;
		}
	}
	
	@Override
	public boolean removeConnector(String deployId, String connectorId, DevopsClientContext context) {
		try {
			client.removeConnector(deployId, connectorId, context);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeConnector: %s %s %s", e, deployId, connectorId));
			return false;
		}
		
	}

	@Override
	public Connector updateConnector(String deployId, Connector connector, DevopsClientContext context) {
		try {
			client.updateConnector(deployId, connector, context);
			return connector;
		} catch (RuntimeException e) {
			logger.error(String.format("removeConnector: %s %s %s", e, deployId, connector));
			return null;
		}
	}

	
}
