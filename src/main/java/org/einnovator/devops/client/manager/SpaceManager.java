package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.DeploymentFilter;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.devops.client.modelx.SpaceOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpaceManager {
	
	//
	// Space CRUD
	//
	
	Space getSpace(String id, DevopsClientContext context);
	
	Space getSpace(String id, SpaceOptions options, DevopsClientContext context);

	Page<Space> listSpaces(SpaceFilter filter, Pageable pageable, DevopsClientContext context);

	/**
	 * Create Space.
	 * 
	 * @param space the {@code Space}
	 * @param options TODO
	 * @return the {@code URI} for te created {@code Space}.
	 */
	Space updateSpace(Space space, RequestOptions options, DevopsClientContext context);
	
	
	boolean deleteSpace(String id, RequestOptions options, DevopsClientContext context);

	//
	// Deployments
	//
	
	Page<Deployment> listDeployments(String spaceId, DeploymentFilter filter, Pageable pageable, DevopsClientContext context);

	URI createDeployment(String spaceId, Deployment deploy, RequestOptions options, DevopsClientContext context);

	//
	// Caching
	//
	
	
	void onSpaceUpdate(String id, Map<String, Object> details, DevopsClientContext context);

	void clearCache();
	
	Cache getSpaceCache();


}
