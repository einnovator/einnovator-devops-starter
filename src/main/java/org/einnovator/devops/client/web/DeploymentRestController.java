package org.einnovator.devops.client.web;

import java.net.URI;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.einnovator.devops.client.manager.DeploymentManager;
import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Connector;
import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/deploy")
public class DeploymentRestController extends ControllerBase {

	@Autowired
	private DeploymentManager manager;

	
	@GetMapping("/{id:.*}")
	public ResponseEntity<Deployment> getDeployment(@PathVariable String id, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			Deployment deploy = manager.getDeployment(id, null);
			if (deploy==null) {
				return badrequest("getDeployment", response);				
			}
			return ok(deploy, "getDeployment", response);
		} catch (RuntimeException e) {
			return status("getDeployment", e, response, id);
		}		
	}
	
	@PutMapping("/{id:.*}")
	public ResponseEntity<Void> updateDeployment(@RequestBody Deployment deploy, @PathVariable String id, @RequestParam(required=false) Boolean publish, 
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (manager.updateDeployment(deploy, null)==null) {
				return badrequest("getDeployment", response);
			}
			return nocontent("getDeployment", response);
		} catch (RuntimeException e) {
			return status("getDeployment", e, response, id);
		}		
	}
	
	@DeleteMapping("/{deployId:.*}")
	public ResponseEntity<Void> deleteDeployment(@PathVariable String id, @RequestParam(required=false) Boolean publish,
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (!manager.deleteDeployment(id, null)) {
				return badrequest("deleteDeployment", response);
			}
			return nocontent("deleteDeployment", response);
		} catch (RuntimeException e) {
			return status("deleteDeployment", e, response, id);
		}		
	}

	//
	// Route
	//
	
	@PostMapping("/{sid:.*}/route")
	public ResponseEntity<Void> addRoute(@PathVariable(name="sid") String deployId, @RequestBody Route route, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			URI location =  manager.addRoute(deployId, route, null);
			if (location==null) {
				return badrequest("addRoute", response, deployId, route);				
			}
			return created(location, "addRoute", response, deployId, route);
		} catch (RuntimeException e) {
			return status("addRoute", e, response, deployId, route);
		}
	}
	
	@DeleteMapping("/{did:.*}/route/{id:.*}")
	public ResponseEntity<Void> removeRoute(@PathVariable("did") String deployId, @PathVariable("id") String id,  
			@RequestParam(required=false) Boolean publish,
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (!manager.removeRoute(deployId, id, null)) {
				return badrequest("removeRoute", response);
			}
			return nocontent("removeRoute", response);
		} catch (RuntimeException e) {
			return status("removeRoute", e, response, id);
		}		
	}
	
	@PutMapping("/{sid:.*}/route")
	public ResponseEntity<Void> updateRoute(@PathVariable(name="sid") String deployId, @RequestBody Route route, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			if (manager.updateRoute(deployId, route, null)==null) {
				return badrequest("updateRoute", response, deployId, route);				
			}
			return nocontent("updateRoute", response);
		} catch (RuntimeException e) {
			return status("updateRoute", e, response, deployId, route);
		}
	}

	//
	// Binding
	//
	
	@PostMapping("/{sid:.*}/binding")
	public ResponseEntity<Void> addBinding(@PathVariable(name="sid") String deployId, @RequestBody Binding binding, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			URI location =  manager.addBinding(deployId, binding, null);
			if (location==null) {
				return badrequest("addBinding", response, deployId, binding);				
			}
			return created(location, "addBinding", response, deployId, binding);
		} catch (RuntimeException e) {
			return status("addBinding", e, response, deployId, binding);
		}
	}
	
	@DeleteMapping("/{did:.*}/binding/{id:.*}")
	public ResponseEntity<Void> removeBinding(@PathVariable("did") String deployId, @PathVariable("id") String id,  
			@RequestParam(required=false) Boolean publish,
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (!manager.removeBinding(deployId, id, null)) {
				return badrequest("removeBinding", response);
			}
			return nocontent("removeBinding", response);
		} catch (RuntimeException e) {
			return status("removeBinding", e, response, id);
		}		
	}
	
	@PutMapping("/{sid:.*}/binding")
	public ResponseEntity<Void> updateBinding(@PathVariable(name="sid") String deployId, @RequestBody Binding binding, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			if (manager.updateBinding(deployId, binding, null)==null) {
				return badrequest("updateBinding", response, deployId, binding);				
			}
			return nocontent("updateBinding", response);
		} catch (RuntimeException e) {
			return status("updateBinding", e, response, deployId, binding);
		}
	}
	
	//
	// Connector
	//
	
	@PostMapping("/{sid:.*}/connector")
	public ResponseEntity<Void> addConnector(@PathVariable(name="sid") String deployId, @RequestBody Connector connector, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			URI location =  manager.addConnector(deployId, connector, null);
			if (location==null) {
				return badrequest("addConnector", response, deployId, connector);				
			}
			return created(location, "addConnector", response, deployId, connector);
		} catch (RuntimeException e) {
			return status("addConnector", e, response, deployId, connector);
		}
	}
	
	@DeleteMapping("/{did:.*}/connector/{id:.*}")
	public ResponseEntity<Void> removeConnector(@PathVariable("did") String deployId, @PathVariable("id") String id,  
			@RequestParam(required=false) Boolean publish,
			Principal principal, HttpServletResponse response) {			
		try {
			setupToken(principal);
			if (!manager.removeConnector(deployId, id, null)) {
				return badrequest("removeConnector", response);
			}
			return nocontent("removeConnector", response);
		} catch (RuntimeException e) {
			return status("removeConnector", e, response, id);
		}		
	}
	
	@PutMapping("/{sid:.*}/connector")
	public ResponseEntity<Void> updateConnector(@PathVariable(name="sid") String deployId, @RequestBody Connector connector, 
		HttpServletRequest request, @RequestParam(required=false) Boolean publish,
		Principal principal, HttpServletResponse response) {
		try {
			setupToken(principal);
			if (manager.updateConnector(deployId, connector, null)==null) {
				return badrequest("updateConnector", response, deployId, connector);				
			}
			return nocontent("updateConnector", response);
		} catch (RuntimeException e) {
			return status("updateConnector", e, response, deployId, connector);
		}
	}



}
