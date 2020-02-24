package org.einnovator.devops.client.web;

import java.net.URI;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.einnovator.devops.client.manager.SpaceManager;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Space;
import org.einnovator.devops.client.modelx.DeploymentFilter;
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
@RequestMapping("/api/space")
public class SpaceRestController extends ControllerBase {

	@Autowired
	private SpaceManager manager;


	@GetMapping
	public ResponseEntity<Page<Space>> listSpaces(SpaceFilter filter, PageOptions options,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			Page<Space> spaces = manager.listSpaces(filter, options.toPageRequest(), null);
			return ok(spaces, "listSpaces", response, PageUtil.toString(spaces), filter, options);
		} catch (RuntimeException e) {
			return status("listSpace", e, response, filter, options);
		}
	}
	

	
	@GetMapping("/{id:.*}")
	public ResponseEntity<Space> getSpace(@PathVariable String id, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			Space space = manager.getSpace(id, null);
			if (space==null) {
				return badrequest("getSpace", response);				
			}
			return ok(space, "getSpace", response);
		} catch (RuntimeException e) {
			return status("getSpace", e, response, id);
		}		
	}
	
	@PutMapping("/{id:.*}")
	public ResponseEntity<Void> updateSpace(@RequestBody Space space, @PathVariable String id, @RequestParam(required=false) Boolean publish, 
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (manager.updateSpace(space, null)==null) {
				return badrequest("getSpace", response);
			}
			return nocontent("getSpace", response);
		} catch (RuntimeException e) {
			return status("getSpace", e, response, id);
		}		
	}
	
	@DeleteMapping("/{spaceId:.*}")
	public ResponseEntity<Void> deleteSpace(@PathVariable String id, @RequestParam(required=false) Boolean publish,
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (!manager.deleteSpace(id, null)) {
				return badrequest("deleteSpace", response);
			}
			return nocontent("deleteSpace", response);
		} catch (RuntimeException e) {
			return status("deleteSpace", e, response, id);
		}		
	}
	

	@GetMapping("/{pid:.*}/deployment")
	public ResponseEntity<Page<Deployment>> listDeploymentsFor(@PathVariable("pid") String pid, DeploymentFilter filter, PageOptions options,
			Principal principal, HttpServletResponse response) {		
		try {
			setupToken(principal);
			Page<Deployment> page = manager.listDeployments(pid, filter, options.toPageRequest(), null);
			return ok(page, "listDeploymentsFor", response);
		} catch (RuntimeException e) {
			return status("listDeploymentsFor", e, response, pid);
		}	
	}

	@PostMapping("/{sid:.*}/deployment")
	public ResponseEntity<Void> createDeployment(@PathVariable(name="sid") String spaceId, @RequestBody Deployment deploy, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			URI location =  manager.createDeployment(spaceId, deploy, null);
			if (location==null) {
				return badrequest("createDeployment", response, spaceId, deploy);				
			}
			return created(location, "createDeployment", response, spaceId, deploy);
		} catch (RuntimeException e) {
			return status("createDeployment", e, response, spaceId, deploy);
		}
	}
	


}
