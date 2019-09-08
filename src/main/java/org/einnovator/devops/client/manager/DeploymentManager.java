package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Route;
import org.einnovator.devops.client.modelx.DeploymentOptions;
import org.springframework.cache.Cache;

public interface DeploymentManager {
	
	Deployment getDeployment(String id);
	
	Deployment getDeployment(String id, DeploymentOptions options);
	
	Deployment updateDeployment(Deployment deployment);

	
	boolean deleteDeployment(String id);
	
	URI addRoute(String deployId, Route route);
	boolean removeRoute(String deployId, String routeId);
	Route updateRoute(String deployId, Route route);

	URI addBinding(String deployId, Binding binding);
	boolean removeBinding(String deployId, String bindingId);
	Binding updateBinding(String deployId, Binding binding);

	URI addConnector(String deployId, Connector connector);
	boolean removeConnector(String deployId, String connectorId);
	Connector updateConnector(String deployId, Connector connector);

	void onDeploymentUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getDeploymentCache();


}
