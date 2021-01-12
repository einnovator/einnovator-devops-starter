package org.einnovator.devops.client.model;

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
	 * @param status the status
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
