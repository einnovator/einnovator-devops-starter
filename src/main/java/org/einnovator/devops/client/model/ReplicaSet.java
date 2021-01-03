package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplicaSet extends DeploymentBase {

	private Integer replicas;
	
	private Integer desiredReplicas;

	private Integer readyReplicas;

	private Integer availableReplicas;

	private Integer fullyLabeledReplicas;
	
	protected Object selector;

	public ReplicaSet() {
	}

	/**
	 * Get the value of property {@code replicas}.
	 *
	 * @return the value of {@code replicas}
	 */
	public Integer getReplicas() {
		return replicas;
	}

	/**
	 * Set the value of property {@code replicas}.
	 *
	 * @param replicas the value of {@code replicas}
	 */
	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}

	/**
	 * Get the value of property {@code desiredReplicas}.
	 *
	 * @return the value of {@code desiredReplicas}
	 */
	public Integer getDesiredReplicas() {
		return desiredReplicas;
	}

	/**
	 * Set the value of property {@code desiredReplicas}.
	 *
	 * @param desiredReplicas the value of {@code desiredReplicas}
	 */
	public void setDesiredReplicas(Integer desiredReplicas) {
		this.desiredReplicas = desiredReplicas;
	}

	/**
	 * Get the value of property {@code readyReplicas}.
	 *
	 * @return the value of {@code readyReplicas}
	 */
	public Integer getReadyReplicas() {
		return readyReplicas;
	}

	/**
	 * Set the value of property {@code readyReplicas}.
	 *
	 * @param readyReplicas the value of {@code readyReplicas}
	 */
	public void setReadyReplicas(Integer readyReplicas) {
		this.readyReplicas = readyReplicas;
	}

	/**
	 * Get the value of property {@code availableReplicas}.
	 *
	 * @return the value of {@code availableReplicas}
	 */
	public Integer getAvailableReplicas() {
		return availableReplicas;
	}

	/**
	 * Set the value of property {@code availableReplicas}.
	 *
	 * @param availableReplicas the value of {@code availableReplicas}
	 */
	public void setAvailableReplicas(Integer availableReplicas) {
		this.availableReplicas = availableReplicas;
	}

	/**
	 * Get the value of property {@code fullyLabeledReplicas}.
	 *
	 * @return the value of {@code fullyLabeledReplicas}
	 */
	public Integer getFullyLabeledReplicas() {
		return fullyLabeledReplicas;
	}

	/**
	 * Set the value of property {@code fullyLabeledReplicas}.
	 *
	 * @param fullyLabeledReplicas the value of {@code fullyLabeledReplicas}
	 */
	public void setFullyLabeledReplicas(Integer fullyLabeledReplicas) {
		this.fullyLabeledReplicas = fullyLabeledReplicas;
	}

	/**
	 * Get the value of property {@code selector}.
	 *
	 * @return the value of {@code selector}
	 */
	public Object getSelector() {
		return selector;
	}

	/**
	 * Set the value of property {@code selector}.
	 *
	 * @param selector the value of {@code selector}
	 */
	public void setSelector(Object selector) {
		this.selector = selector;
	}

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("replicas", replicas)
				.append("desiredReplicas", desiredReplicas)
				.append("readyReplicas", readyReplicas)
				.append("availableReplicas", availableReplicas)
				.append("fullyLabeledReplicas", fullyLabeledReplicas)
				.append("selector", selector)
				;
	}

}
