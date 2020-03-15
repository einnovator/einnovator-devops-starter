package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;


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

	Deployment getDeployment(String id);
	
	Deployment getDeployment(String id, DeploymentOptions options);
	
	Deployment updateDeployment(Deployment deployment, RequestOptions options);
	
	boolean deleteDeployment(String id, RequestOptions options);

	//
	// Routes
	//

	URI addRoute(String deployId, Route route, RequestOptions options);
	boolean removeRoute(String deployId, String routeId, RequestOptions options);
	Route updateRoute(String deployId, Route route, RequestOptions options);

	//
	// Bindings
	//

	URI addBinding(String deployId, Binding binding, RequestOptions options);
	boolean removeBinding(String deployId, String bindingId, RequestOptions options);
	Binding updateBinding(String deployId, Binding binding, RequestOptions options);

	//
	// Connectors
	//
	
	URI addConnector(String deployId, Connector connector, RequestOptions options);
	boolean removeConnector(String deployId, String connectorId, RequestOptions options);
	Connector updateConnector(String deployId, Connector connector, RequestOptions options);

	
	
	void onDeploymentUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getDeploymentCache();


}
