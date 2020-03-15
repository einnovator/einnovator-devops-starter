package org.einnovator.devops.client.manager;

import java.net.URI;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.devops.client.DevopsClient;

import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.modelx.DeploymentOptions;
import org.einnovator.util.web.RequestOptions;
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
	public Deployment getDeployment(String id) {
		return getDeployment(id, null);
	}

	@Override
	public Deployment getDeployment(String id, DeploymentOptions options) {
		try {
			Deployment deploy = client.getDeployment(id, options);		
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
	public Deployment updateDeployment(Deployment deploy, RequestOptions options) {
		try {
			client.updateDeployment(deploy, options);
			return deploy;
		} catch (RuntimeException e) {
			logger.error(String.format("updateDeployment: %s %s", e, deploy));
			return null;
		}
	}

	
	@Override
	@CacheEvict(value=CACHE_DEPLOYMENT, key="#id")
	public boolean deleteDeployment(String id, RequestOptions options) {
		try {
			client.deleteDeployment(id, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("deleteDeployment: %s %s", e, id));
			return false;
		}
	}

	@Override
	public void onDeploymentUpdate(String id, Map<String, Object> details) {
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
	public URI addRoute(String deployId, Route route, RequestOptions options) {
		try {
			return client.addRoute(deployId, route, options);
		} catch (RuntimeException e) {
			logger.error(String.format("addRoute: %s %s %s", e, deployId, route));
			return null;
		}
	}
	
	@Override
	public boolean removeRoute(String deployId, String routeId, RequestOptions options) {
		try {
			client.removeRoute(deployId, routeId, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeRoute: %s %s %s", e, deployId, routeId));
			return false;
		}
		
	}

	@Override
	public Route updateRoute(String deployId, Route route, RequestOptions options) {
		try {
			client.updateRoute(deployId, route, options);
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
	public URI addBinding(String deployId, Binding binding, RequestOptions options) {
		try {
			return client.addBinding(deployId, binding, options);
		} catch (RuntimeException e) {
			logger.error(String.format("addBinding: %s %s %s", e, deployId, binding));
			return null;
		}
	}

	@Override
	public boolean removeBinding(String deployId, String bindingId, RequestOptions options) {
		try {
			client.removeBinding(deployId, bindingId, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeBinding: %s %s %s", e, deployId, bindingId));
			return false;
		}
		
	}

	@Override
	public Binding updateBinding(String deployId, Binding binding, RequestOptions options) {
		try {
			client.updateBinding(deployId, binding, options);
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
	public URI addConnector(String deployId, Connector connector, RequestOptions options) {
		try {
			return client.addConnector(deployId, connector, options);
		} catch (RuntimeException e) {
			logger.error(String.format("addConnector: %s %s %s", e, deployId, connector));
			return null;
		}
	}
	
	@Override
	public boolean removeConnector(String deployId, String connectorId, RequestOptions options) {
		try {
			client.removeConnector(deployId, connectorId, options);
			return true;
		} catch (RuntimeException e) {
			logger.error(String.format("removeConnector: %s %s %s", e, deployId, connectorId));
			return false;
		}
		
	}

	@Override
	public Connector updateConnector(String deployId, Connector connector, RequestOptions options) {
		try {
			client.updateConnector(deployId, connector, options);
			return connector;
		} catch (RuntimeException e) {
			logger.error(String.format("removeConnector: %s %s %s", e, deployId, connector));
			return null;
		}
	}

	
}
