package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.modelx.DeploymentOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;

public interface DeploymentManager {
	
	//
	// Deployment CRUD
	//

	Deployment getDeployment(String id, DevopsClientContext context);
	
	Deployment getDeployment(String id, DeploymentOptions options, DevopsClientContext context);
	
	Deployment updateDeployment(Deployment deployment, RequestOptions options, DevopsClientContext context);
	
	boolean deleteDeployment(String id, RequestOptions options, DevopsClientContext context);

	//
	// Routes
	//

	URI addRoute(String deployId, Route route, RequestOptions options, DevopsClientContext context);
	boolean removeRoute(String deployId, String routeId, RequestOptions options, DevopsClientContext context);
	Route updateRoute(String deployId, Route route, RequestOptions options, DevopsClientContext context);

	//
	// Bindings
	//

	URI addBinding(String deployId, Binding binding, RequestOptions options, DevopsClientContext context);
	boolean removeBinding(String deployId, String bindingId, RequestOptions options, DevopsClientContext context);
	Binding updateBinding(String deployId, Binding binding, RequestOptions options, DevopsClientContext context);

	//
	// Connectors
	//
	
	URI addConnector(String deployId, Connector connector, RequestOptions options, DevopsClientContext context);
	boolean removeConnector(String deployId, String connectorId, RequestOptions options, DevopsClientContext context);
	Connector updateConnector(String deployId, Connector connector, RequestOptions options, DevopsClientContext context);

	
	
	void onDeploymentUpdate(String id, Map<String, Object> details, DevopsClientContext context);

	void clearCache();
	
	Cache getDeploymentCache();


}
