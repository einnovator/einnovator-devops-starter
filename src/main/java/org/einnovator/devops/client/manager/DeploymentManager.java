package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.modelx.DeploymentOptions;
import org.springframework.cache.Cache;

public interface DeploymentManager {
	
	Deployment getDeployment(String id, DevopsClientContext context);
	
	Deployment getDeployment(String id, DeploymentOptions options, DevopsClientContext context);
	
	Deployment updateDeployment(Deployment deployment, DevopsClientContext context);

	
	boolean deleteDeployment(String id, DevopsClientContext context);
	
	URI addRoute(String deployId, Route route, DevopsClientContext context);
	boolean removeRoute(String deployId, String routeId, DevopsClientContext context);
	Route updateRoute(String deployId, Route route, DevopsClientContext context);

	URI addBinding(String deployId, Binding binding, DevopsClientContext context);
	boolean removeBinding(String deployId, String bindingId, DevopsClientContext context);
	Binding updateBinding(String deployId, Binding binding, DevopsClientContext context);

	URI addConnector(String deployId, Connector connector, DevopsClientContext context);
	boolean removeConnector(String deployId, String connectorId, DevopsClientContext context);
	Connector updateConnector(String deployId, Connector connector, DevopsClientContext context);

	void onDeploymentUpdate(String id, Map<String, Object> details, DevopsClientContext context);

	void clearCache();
	
	Cache getDeploymentCache();


}
