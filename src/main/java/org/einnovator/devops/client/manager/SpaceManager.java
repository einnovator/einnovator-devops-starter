package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.DeploymentFilter;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.devops.client.modelx.SpaceOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpaceManager {
	
	Space getSpace(String id);
	
	Space getSpace(String id, SpaceOptions options);

	Page<Space> listSpaces(SpaceFilter filter, Pageable pageable);

	/**
	 * Create Space.
	 * 
	 * @param space the {@code Space}
	 * @return the {@code URI} for te created {@code Space}.
	 */
	
	Space updateSpace(Space space);
	
	
	boolean deleteSpace(String id);
	
	Page<Deployment> listDeployments(String spaceId, DeploymentFilter filter, Pageable pageable);

	URI createDeployment(String spaceId, Deployment deploy);

	void onSpaceUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getSpaceCache();


}
