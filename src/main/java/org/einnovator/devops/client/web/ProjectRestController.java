package org.einnovator.devops.client.web;

import java.net.URI;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.einnovator.devops.client.manager.ProjectManager;
import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.ProjectFilter;
import org.einnovator.devops.client.modelx.SpaceFilter;
import org.einnovator.util.PageOptions;
import org.einnovator.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/project")
public class ProjectRestController extends ControllerBase {

	@Autowired
	private ProjectManager manager;


	@GetMapping
	public ResponseEntity<Page<Project>> listProject(ProjectFilter filter, PageOptions options, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			Page<Project> projects = manager.listProjects(filter, options.toPageRequest(), null);
			return ok(projects, "listProject", response, PageUtil.toString(projects), filter, options);
		} catch (RuntimeException e) {
			return status("listProject", e, response, filter, options);
		}
	}
	

	
	@PostMapping
	public ResponseEntity<Void> createProject(@RequestBody Project project, HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			URI location =  manager.createProject(project, null, null);
			if (location==null) {
				return badrequest("createProject", response, project);				
			}
			return created(location, "createProject", response, project);
		} catch (RuntimeException e) {
			return status("createProject", e, response, project);
		}
	}
	
	@GetMapping("/{id:.*}")
	public ResponseEntity<Project> getProject(@PathVariable String id, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			Project project = manager.getProject(id, null, null);
			if (project==null) {
				return notfound("getProject", response);				
			}
			return ok(project, "getProject", response);
		} catch (RuntimeException e) {
			return status("getProject", e, response, id);
		}		
	}
	
	@PutMapping("/{id:.*}")
	public ResponseEntity<Void> updateProject(@RequestBody Project project, @PathVariable String id, @RequestParam(required=false) Boolean publish, 
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (manager.updateProject(project, null, null)==null) {
				return badrequest("getProject", response);
			}
			return nocontent("getProject", response);
		} catch (RuntimeException e) {
			return status("getProject", e, response, id);
		}		
	}
	
	@DeleteMapping("/{projectId:.*}")
	public ResponseEntity<Void> deleteProject(@PathVariable String id, @RequestParam(required=false) Boolean publish,
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (!manager.deleteProject(id, null, null)) {
				return badrequest("deleteProject", response);
			}
			return nocontent("deleteProject", response);
		} catch (RuntimeException e) {
			return status("deleteProject", e, response, id);
		}		
	}
	

	@GetMapping("/{pid:.*}/space")
	public ResponseEntity<Page<Space>> listSpacesFor(@PathVariable("pid") String pid, SpaceFilter filter, PageOptions options,
			Principal principal, HttpServletResponse response) {		
		try {
			setupToken(principal);
			Page<Space> page = manager.listSpaces(pid, filter, options.toPageRequest(), null);
			return ok(page, "listSpacesFor", response);
		} catch (RuntimeException e) {
			return status("listSpacesFor", e, response, pid);
		}	
	}

	@PostMapping("/{sid:.*}/space")
	public ResponseEntity<Void> createSpace(@PathVariable(name="sid") String projectId, @RequestBody Space space, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			URI location =  manager.createSpace(projectId, space, null, null);
			if (location==null) {
				return badrequest("createSpace", response, projectId, space);				
			}
			return created(location, "createSpace", response, projectId, space);
		} catch (RuntimeException e) {
			return status("createSpace", e, response, projectId, space);
		}
	}
	

}
