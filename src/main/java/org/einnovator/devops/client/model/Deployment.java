package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deployment extends DeploymentBase {

public static final String SEPARATOR = ",";
	
	private Integer replicas;

	private String replicaSetName;
	
	private Integer desiredReplicas;

	private Integer readyReplicas;

	private Integer availableReplicas;

	private Integer unavailableReplicas;

	private Integer updatedReplicas;

	private Boolean binds;

	private String serviceName;

	private ServiceType serviceType;

	private String ingress;

	private Boolean autoConnectors;

	private Integer revisionHistoryLimit;
	
	private Integer minReadySeconds;
	
	private Integer progressDeadlineSeconds;

	private Strategy strategy;

	private Boolean sandbox;

	
	protected List<Connector> connectors;
	
	protected List<Route> routes;
	
	protected List<Port> ports;

	public Deployment() {
	}

	public Deployment(Object obj) {
		super(obj);
	}

	/**
	 * Get the value of property {@code sandbox}.
	 *
	 * @return the sandbox
	 */
	public Boolean getSandbox() {
		return sandbox;
	}

	/**
	 * Set the value of property {@code sandbox}.
	 *
	 * @param sandbox the sandbox to set
	 */
	public void setSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
	}

	/**
	 * Get the value of property {@code replicaSetName}.
	 *
	 * @return the replicaSetName
	 */
	public String getReplicaSetName() {
		return replicaSetName;
	}

	/**
	 * Set the value of property {@code replicaSetName}.
	 *
	 * @param replicaSetName the value of property replicaSetName
	 */
	public void setReplicaSetName(String replicaSetName) {
		this.replicaSetName = replicaSetName;
	}

	/**
	 * Get the value of property {@code replicas}.
	 *
	 * @return the replicas
	 */
	public Integer getReplicas() {
		return replicas;
	}

	/**
	 * Set the value of property {@code replicas}.
	 *
	 * @param replicas the replicas to set
	 */
	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}

	/**
	 * Get the value of property {@code desiredReplicas}.
	 *
	 * @return the desiredReplicas
	 */
	public Integer getDesiredReplicas() {
		return desiredReplicas;
	}

	/**
	 * Set the value of property {@code desiredReplicas}.
	 *
	 * @param desiredReplicas the desiredReplicas to set
	 */
	public void setDesiredReplicas(Integer desiredReplicas) {
		this.desiredReplicas = desiredReplicas;
	}

	/**
	 * Get the value of property {@code readyReplicas}.
	 *
	 * @return the readyReplicas
	 */
	public Integer getReadyReplicas() {
		return readyReplicas;
	}

	/**
	 * Set the value of property {@code readyReplicas}.
	 *
	 * @param readyReplicas the readyReplicas to set
	 */
	public void setReadyReplicas(Integer readyReplicas) {
		this.readyReplicas = readyReplicas;
	}

	/**
	 * Get the value of property {@code availableReplicas}.
	 *
	 * @return the availableReplicas
	 */
	public Integer getAvailableReplicas() {
		return availableReplicas;
	}

	/**
	 * Set the value of property {@code availableReplicas}.
	 *
	 * @param availableReplicas the availableReplicas to set
	 */
	public void setAvailableReplicas(Integer availableReplicas) {
		this.availableReplicas = availableReplicas;
	}

	/**
	 * Get the value of property {@code unavailableReplicas}.
	 *
	 * @return the unavailableReplicas
	 */
	public Integer getUnavailableReplicas() {
		return unavailableReplicas;
	}

	/**
	 * Set the value of property {@code unavailableReplicas}.
	 *
	 * @param unavailableReplicas the unavailableReplicas to set
	 */
	public void setUnavailableReplicas(Integer unavailableReplicas) {
		this.unavailableReplicas = unavailableReplicas;
	}

	/**
	 * Get the value of property {@code updatedReplicas}.
	 *
	 * @return the updatedReplicas
	 */
	public Integer getUpdatedReplicas() {
		return updatedReplicas;
	}

	/**
	 * Set the value of property {@code updatedReplicas}.
	 *
	 * @param updatedReplicas the updatedReplicas to set
	 */
	public void setUpdatedReplicas(Integer updatedReplicas) {
		this.updatedReplicas = updatedReplicas;
	}


	/**
	 * Get the value of property {@code binds}.
	 *
	 * @return the binds
	 */
	public Boolean getBinds() {
		return binds;
	}

	/**
	 * Set the value of property {@code binds}.
	 *
	 * @param binds the binds to set
	 */
	public void setBinds(Boolean binds) {
		this.binds = binds;
	}

	/**
	 * Get the value of property {@code serviceName}.
	 *
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * Set the value of property {@code serviceName}.
	 *
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	/**
	 * Get the value of property {@code serviceType}.
	 *
	 * @return the serviceType
	 */
	public ServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * Set the value of property {@code serviceType}.
	 *
	 * @param serviceType the value of property serviceType
	 */
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * Get the value of property {@code strategy}.
	 *
	 * @return the strategy
	 */
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * Set the value of property {@code strategy}.
	 *
	 * @param strategy the value of property strategy
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Get the value of property {@code ingress}.
	 *
	 * @return the ingress
	 */
	public String getIngress() {
		return ingress;
	}

	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the ingress to set
	 */
	public void setIngress(String ingress) {
		this.ingress = ingress;
	}

	/**
	 * Get the value of property {@code autoConnectors}.
	 *
	 * @return the autoConnectors
	 */
	public Boolean getAutoConnectors() {
		return autoConnectors;
	}

	/**
	 * Set the value of property {@code autoConnectors}.
	 *
	 * @param autoConnectors the autoConnectors to set
	 */
	public void setAutoConnectors(Boolean autoConnectors) {
		this.autoConnectors = autoConnectors;
	}


	/**
	 * Get the value of property {@code revisionHistoryLimit}.
	 *
	 * @return the revisionHistoryLimit
	 */
	public Integer getRevisionHistoryLimit() {
		return revisionHistoryLimit;
	}

	/**
	 * Set the value of property {@code revisionHistoryLimit}.
	 *
	 * @param revisionHistoryLimit the value of property revisionHistoryLimit
	 */
	public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
		this.revisionHistoryLimit = revisionHistoryLimit;
	}

	/**
	 * Get the value of property {@code minReadySeconds}.
	 *
	 * @return the minReadySeconds
	 */
	public Integer getMinReadySeconds() {
		return minReadySeconds;
	}

	/**
	 * Set the value of property {@code minReadySeconds}.
	 *
	 * @param minReadySeconds the value of property minReadySeconds
	 */
	public void setMinReadySeconds(Integer minReadySeconds) {
		this.minReadySeconds = minReadySeconds;
	}


	/**
	 * Get the value of property {@code progressDeadlineSeconds}.
	 *
	 * @return the progressDeadlineSeconds
	 */
	public Integer getProgressDeadlineSeconds() {
		return progressDeadlineSeconds;
	}

	/**
	 * Set the value of property {@code progressDeadlineSeconds}.
	 *
	 * @param progressDeadlineSeconds the value of property progressDeadlineSeconds
	 */
	public void setProgressDeadlineSeconds(Integer progressDeadlineSeconds) {
		this.progressDeadlineSeconds = progressDeadlineSeconds;
	}

	//
	// With
	//

	/**
	 * Set the value of property {@code sandbox}.
	 *
	 * @param sandbox the sandbox to with
	 * @return this {@code Deployment}
	 */
	public Deployment withSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
		return this;
	}

	/**
	 * Set the value of property {@code replicaSetName}.
	 *
	 * @param replicaSetName the value of property replicaSetName
	 * @return this {@code Deployment}
	 */
	public Deployment withReplicaSetName(String replicaSetName) {
		this.replicaSetName = replicaSetName;
		return this;
	}


	/**
	 * Set the value of property {@code replicas}.
	 *
	 * @param replicas the replicas to with
	 * @return this {@code Deployment}
	 */
	public Deployment withReplicas(Integer replicas) {
		this.replicas = replicas;
		return this;
	}

	/**
	 * Set the value of property {@code desiredReplicas}.
	 *
	 * @param desiredReplicas the desiredReplicas to with
	 * @return this {@code Deployment}
	 */
	public Deployment withDesiredReplicas(Integer desiredReplicas) {
		this.desiredReplicas = desiredReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code readyReplicas}.
	 *
	 * @param readyReplicas the readyReplicas to with
	 * @return this {@code Deployment}
	 */
	public Deployment withReadyReplicas(Integer readyReplicas) {
		this.readyReplicas = readyReplicas;
		return this;
	}


	/**
	 * Set the value of property {@code availableReplicas}.
	 *
	 * @param availableReplicas the availableReplicas to with
	 * @return this {@code Deployment}
	 */
	public Deployment withAvailableReplicas(Integer availableReplicas) {
		this.availableReplicas = availableReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code unavailableReplicas}.
	 *
	 * @param unavailableReplicas the unavailableReplicas to with
	 * @return this {@code Deployment}
	 */
	public Deployment withUnavailableReplicas(Integer unavailableReplicas) {
		this.unavailableReplicas = unavailableReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code updatedReplicas}.
	 *
	 * @param updatedReplicas the updatedReplicas to with
	 * @return this {@code Deployment}
	 */
	public Deployment withUpdatedReplicas(Integer updatedReplicas) {
		this.updatedReplicas = updatedReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code binds}.
	 *
	 * @param binds the binds to with
	 * @return this {@code Deployment}
	 */
	public Deployment withBinds(Boolean binds) {
		this.binds = binds;
		return this;
	}

	/**
	 * Set the value of property {@code serviceName}.
	 *
	 * @param serviceName the serviceName to with
	 * @return this {@code Deployment}
	 */
	public Deployment withServiceName(String serviceName) {
		this.serviceName = serviceName;
		return this;
	}

	/**
	 * Set the value of property {@code serviceType}.
	 *
	 * @param serviceType the value of property serviceType
	 * @return this {@code Deployment}
	 */
	public Deployment withServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	/**
	 * Set the value of property {@code strategy}.
	 *
	 * @param strategy the value of property strategy
	 * @return this {@code Deployment}
	 */
	public Deployment withStrategy(Strategy strategy) {
		this.strategy = strategy;
		return this;
	}


	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the ingress to with
	 * @return this {@code Deployment}
	 */
	public Deployment withIngress(String ingress) {
		this.ingress = ingress;
		return this;
	}


	/**
	 * Set the value of property {@code autoConnectors}.
	 *
	 * @param autoConnectors the autoConnectors to with
	 * @return this {@code Deployment}
	 */
	public Deployment withAutoConnectors(Boolean autoConnectors) {
		this.autoConnectors = autoConnectors;
		return this;
	}

	/**
	 * Set the value of property {@code revisionHistoryLimit}.
	 *
	 * @param revisionHistoryLimit the value of property revisionHistoryLimit
	 * @return this {@code Deployment}
	 */
	public Deployment withRevisionHistoryLimit(Integer revisionHistoryLimit) {
		this.revisionHistoryLimit = revisionHistoryLimit;
		return this;
	}

	/**
	 * Set the value of property {@code minReadySeconds}.
	 *
	 * @param minReadySeconds the value of property minReadySeconds
	 * @return this {@code Deployment}
	 */
	public Deployment withMinReadySeconds(Integer minReadySeconds) {
		this.minReadySeconds = minReadySeconds;
		return this;
	}

	/**
	 * Set the value of property {@code progressDeadlineSeconds}.
	 *
	 * @param progressDeadlineSeconds the value of property progressDeadlineSeconds
	 * @return this {@code Deployment}
	 */
	public Deployment widthProgressDeadlineSeconds(Integer progressDeadlineSeconds) {
		this.progressDeadlineSeconds = progressDeadlineSeconds;
		return this;
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
				if ((route2.getUuid() != null && route2.getUuid().equals(route.getUuid()))
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
				if (id.equals(route.getUuid())) {
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
				.append("replicas", replicas)
				.append("readyReplicas", readyReplicas)
				.append("availableReplicas", availableReplicas)
				.append("unavailableReplicas", unavailableReplicas)
				.append("updatedReplicas", updatedReplicas)
				.append("binds", binds)
				.append("serviceName", serviceName)
				.append("ingress", ingress)
				;
	}

}
