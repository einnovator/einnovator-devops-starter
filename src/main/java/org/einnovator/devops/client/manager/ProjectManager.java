package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.config.DevopsClientContext;
import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.ProjectFilter;
import org.einnovator.devops.client.modelx.ProjectOptions;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectManager {
	
	//
	// Project CRUD
	//

	
	Project getProject(String id, ProjectOptions options, DevopsClientContext context);


	Page<Project> listProjects(ProjectFilter filter, Pageable pageable, DevopsClientContext context);

	/**
	 * Create Project.
	 * 
	 * @param project the {@code Project}
	 * @param options TODO
	 * @param context TODO
	 * @return the {@code URI} for te created {@code Project}.
	 */

	URI createProject(Project project, RequestOptions options, DevopsClientContext context);
	
	Project updateProject(Project project, RequestOptions options, DevopsClientContext context);
	

	/**
	 * Create or Update Project.
	 * 
	 * If {@code Project.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param project the {@code Project}
	 * @param options TODO
	 * @param context TODO
	 * @return the {@code Project} with {@code uuid} property set; or null if error.
	 */
	Project createOrUpdateProject(Project project, RequestOptions options, DevopsClientContext context);
	
	boolean deleteProject(String id, RequestOptions options, DevopsClientContext context);
	
	//
	// Spaces
	//
	
	Page<Space> listSpaces(String projectId, SpaceFilter filter, Pageable pageable, DevopsClientContext context);

	URI createSpace(String projectId, Space space, RequestOptions options, DevopsClientContext context);

	//
	//
	//
	
	void onProjectUpdate(String id, Map<String, Object> details, DevopsClientContext context);

	void clearCache();
	
	Cache getProjectCache();


}
