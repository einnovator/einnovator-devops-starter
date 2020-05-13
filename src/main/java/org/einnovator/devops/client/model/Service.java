package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Service extends AnnotatedEntity {

	private DeploymentStatus status;

	private ServiceType type;

	private SolutionCategory category;
	
	private List<Endpoint> endpoints;

	private List<Port> ports;

	private String clusterIP;

	private List<String> externalIPs;

	private String externalName;

	private String loadBalancerIP;

	private String externalTrafficPolicy;

	private Integer healthCheckNodePort;

	private List<String> loadBalancerSourceRanges;

	private List<Route> routes;
	
	/**
	 * Create instance of {@code Service}.
	 *
	 */
	public Service() {
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public ServiceType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 */
	public void setType(ServiceType type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code category}.
	 *
	 * @return the category
	 */
	public SolutionCategory getCategory() {
		return category;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the value of property category
	 */
	public void setCategory(SolutionCategory category) {
		this.category = category;
	}

	/**
	 * Get the value of property {@code endpoints}.
	 *
	 * @return the endpoints
	 */
	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	/**
	 * Set the value of property {@code endpoints}.
	 *
	 * @param endpoints the value of property endpoints
	 */
	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	/**
	 * Get the value of property {@code ports}.
	 *
	 * @return the ports
	 */
	public List<Port> getPorts() {
		return ports;
	}

	/**
	 * Set the value of property {@code ports}.
	 *
	 * @param ports the value of property ports
	 */
	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	/**
	 * Get the value of property {@code clusterIP}.
	 *
	 * @return the clusterIP
	 */
	public String getClusterIP() {
		return clusterIP;
	}

	/**
	 * Set the value of property {@code clusterIP}.
	 *
	 * @param clusterIP the value of property clusterIP
	 */
	public void setClusterIP(String clusterIP) {
		this.clusterIP = clusterIP;
	}

	/**
	 * Get the value of property {@code externalIPs}.
	 *
	 * @return the externalIPs
	 */
	public List<String> getExternalIPs() {
		return externalIPs;
	}

	/**
	 * Set the value of property {@code externalIPs}.
	 *
	 * @param externalIPs the value of property externalIPs
	 */
	public void setExternalIPs(List<String> externalIPs) {
		this.externalIPs = externalIPs;
	}

	/**
	 * Get the value of property {@code externalName}.
	 *
	 * @return the externalName
	 */
	public String getExternalName() {
		return externalName;
	}

	/**
	 * Set the value of property {@code externalName}.
	 *
	 * @param externalName the value of property externalName
	 */
	public void setExternalName(String externalName) {
		this.externalName = externalName;
	}

	/**
	 * Get the value of property {@code loadBalancerIP}.
	 *
	 * @return the loadBalancerIP
	 */
	public String getLoadBalancerIP() {
		return loadBalancerIP;
	}

	/**
	 * Set the value of property {@code loadBalancerIP}.
	 *
	 * @param loadBalancerIP the value of property loadBalancerIP
	 */
	public void setLoadBalancerIP(String loadBalancerIP) {
		this.loadBalancerIP = loadBalancerIP;
	}

	/**
	 * Get the value of property {@code externalTrafficPolicy}.
	 *
	 * @return the externalTrafficPolicy
	 */
	public String getExternalTrafficPolicy() {
		return externalTrafficPolicy;
	}

	/**
	 * Set the value of property {@code externalTrafficPolicy}.
	 *
	 * @param externalTrafficPolicy the value of property externalTrafficPolicy
	 */
	public void setExternalTrafficPolicy(String externalTrafficPolicy) {
		this.externalTrafficPolicy = externalTrafficPolicy;
	}

	/**
	 * Get the value of property {@code healthCheckNodePort}.
	 *
	 * @return the healthCheckNodePort
	 */
	public Integer getHealthCheckNodePort() {
		return healthCheckNodePort;
	}

	/**
	 * Set the value of property {@code healthCheckNodePort}.
	 *
	 * @param healthCheckNodePort the value of property healthCheckNodePort
	 */
	public void setHealthCheckNodePort(Integer healthCheckNodePort) {
		this.healthCheckNodePort = healthCheckNodePort;
	}

	/**
	 * Get the value of property {@code loadBalancerSourceRanges}.
	 *
	 * @return the loadBalancerSourceRanges
	 */
	public List<String> getLoadBalancerSourceRanges() {
		return loadBalancerSourceRanges;
	}

	/**
	 * Set the value of property {@code loadBalancerSourceRanges}.
	 *
	 * @param loadBalancerSourceRanges the value of property loadBalancerSourceRanges
	 */
	public void setLoadBalancerSourceRanges(List<String> loadBalancerSourceRanges) {
		this.loadBalancerSourceRanges = loadBalancerSourceRanges;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public DeploymentStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status to set
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code routes}.
	 *
	 * @return the routes
	 */
	public List<Route> getRoutes() {
		return routes;
	}

	/**
	 * Set the value of property {@code routes}.
	 *
	 * @param routes the value of property routes
	 */
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}


	//
	// Ports
	//


	public void addPort(Port port) {
		if (ports == null) {
			ports = new ArrayList<Port>();
		}
		ports.add(port);
	}

	public Port removePort(int index) {
		if (ports == null || index < 0 || index >= ports.size()) {
			return null;
		}
		return ports.remove(index);
	}

	public Port getPort(int index) {
		if (ports == null || index < 0 || index >= ports.size()) {
			return null;
		}
		return ports.get(index);
	}

	public Port findPort(Port port) {
		if (port != null && ports != null) {
			for (Port port2 : ports) {
				if ((port2.getPort() != null && port2.getPort().equals(port.getPort()))
						|| (port2.getName() != null && port2.getName().equals(port.getName()))) {
					return port2;
				}
			}
		}
		return null;
	}

	public Port findPort(String id) {
		if (id != null && ports != null) {
			for (Port port : ports) {
				if (id.equals(port.getName())) {
					return port;
				}
			}
		}
		return null;
	}
	
	public Port findPort(Integer n) {
		if (n != null && ports != null) {
			for (Port port : ports) {
				if (n.equals(port.getPort())) {
					return port;
				}
			}
		}
		return null;
	}


	public Port removePort(Port port) {
		if (port != null && ports != null) {
			for (int i = 0; i < ports.size(); i++) {
				Port port2 = ports.get(i);
				if ((port2.getPort() != null && port2.getPort().equals(port.getPort()))
						|| (port2.getName() != null && port2.getName().equals(port.getName()))) {
					return ports.remove(i);
				}
			}
		}
		return null;
	}
	
	//
	// Endpoints
	//

	public void addEndpoint(Endpoint endpoint) {
		if (endpoints == null) {
			endpoints = new ArrayList<Endpoint>();
		}
		endpoints.add(endpoint);
	}

	public Endpoint removeEndpoint(int index) {
		if (endpoints == null || index < 0 || index >= endpoints.size()) {
			return null;
		}
		return endpoints.remove(index);
	}

	public Endpoint getEndpoint(int index) {
		if (endpoints == null || index < 0 || index >= endpoints.size()) {
			return null;
		}
		return endpoints.get(index);
	}

	public Endpoint findEndpoint(Endpoint endpoint) {
		if (endpoint != null && endpoints != null) {
			for (Endpoint endpoint2 : endpoints) {
				if ((endpoint2.getPort() != null && endpoint2.getPort().equals(endpoint.getPort()))
						|| (endpoint2.getUri() != null && endpoint2.getUri().equals(endpoint.getUri()))) {
					return endpoint2;
				}
			}
		}
		return null;
	}

	public Endpoint findEndpoint(String id) {
		if (id != null && endpoints != null) {
			for (Endpoint endpoint : endpoints) {
				if (id.equals(endpoint.getUri())) {
					return endpoint;
				}
			}
		}
		return null;
	}

	public Endpoint removeEndpoint(Endpoint endpoint) {
		if (endpoint != null && endpoints != null) {
			for (int i = 0; i < endpoints.size(); i++) {
				Endpoint endpoint2 = endpoints.get(i);
				if ((endpoint2.getPort() != null && endpoint2.getPort().equals(endpoint.getPort()))
						|| (endpoint2.getUri() != null && endpoint2.getUri().equals(endpoint.getUri()))) {
					return endpoints.remove(i);
				}
			}
		}
		return null;
	}

	//
	// Routes
	//

	public void addRoute(Route route) {
		if (routes == null) {
			routes = new ArrayList<Route>();
		}
		routes.add(route);
	}
	
	public void addRoutes(List<Route> routes) {
		if (routes!=null) {
			for (Route route: routes) {
				addRoute(route);
			}
		}
	}

	public Route removeRoute(int index) {
		if (routes == null || index < 0 || index >= routes.size()) {
			return null;
		}
		return routes.remove(index);
	}

	public Route getRoute(int index) {
		if (routes == null || index < 0 || index >= routes.size()) {
			return null;
		}
		return routes.get(index);
	}

	public Route findRoute(Route route) {
		if (route != null && routes != null) {
			for (Route route2 : routes) {
				if ((route2.getId() != null && route2.getId().equals(route.getId()))
						|| (route2.getUuid() != null && route2.getUuid().equals(route.getUuid()))
						|| (route2.getRequiredDns() != null
								&& route2.getRequiredDns().equals(route.getRequiredDns()))) {
					return route2;
				}
			}
		}
		return null;
	}

	public Route findRoute(String id) {
		if (id != null && routes != null) {
			for (Route route : routes) {
				if (id.equals(route.getRequiredDns()) || id.equals(route.getHost())) {
					return route;
				}
			}
		}
		return null;
	}

	public Route removeRoute(Route route) {
		if (route != null && routes != null) {
			for (int i = 0; i < routes.size(); i++) {
				Route route2 = routes.get(i);
				if (route2.getUuid() != null && route2.getUuid().equals(route.getUuid())) {
					return routes.remove(i);
				}
			}
		}
		return null;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("type", type)
				.append("ports", ports)
				.append("endpoints", endpoints)
				.append("clusterIP", clusterIP)
				.append("externalIPs", externalIPs)
				.append("externalName", externalName)
				.append("loadBalancerIP", loadBalancerIP)
				.append("externalTrafficPolicy", externalTrafficPolicy)
				.append("healthCheckNodePort", healthCheckNodePort)
				.append("loadBalancerSourceRanges", loadBalancerSourceRanges)
				.append("routes", routes)
				;
	}
	
}
