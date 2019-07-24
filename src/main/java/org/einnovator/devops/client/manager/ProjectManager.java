package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.ProjectFilter;
import org.einnovator.devops.client.modelx.ProjectOptions;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.devops.client.modelx.SpaceOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectManager {
	
	Project getProject(String id);
	
	Project getProject(String id, ProjectOptions options);

	Page<Project> listProjects(ProjectFilter filter, Pageable pageable);

	/**
	 * Create Project.
	 * 
	 * @param project the {@code Project}
	 * @return the {@code URI} for te created {@code Project}.
	 */

	URI createProject(Project project);
	
	Project updateProject(Project project);
	

	/**
	 * Create or Update Project.
	 * 
	 * If {@code Project.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param project the {@code Project}
	 * @return the {@code Project} with {@code uuid} property set; or null if error.
	 */
	Project createOrUpdateProject(Project project);
	
	boolean deleteProject(String id);
	
	Page<Space> listSpaces(String projectId, SpaceFilter filter, Pageable pageable);

	URI createSpace(String projectId, Space space);

	Space getSpace(String id, SpaceOptions options);
	
	Space updateSpace(Space space);

	boolean deleteSpace(String id);

	void onProjectUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getProjectCache();


}
