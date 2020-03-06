package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Deployment;
import org.einnovator.util.model.EntityOptions;
import org.einnovator.util.model.ToStringCreator;

/**
 * Options to retrieve {@code Deployment}s.
 *
 * @see Deployment
 * @author support@einnovator.org
 */
public class DeploymentOptions extends EntityOptions<Deployment> {

	private Boolean instances;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code DeploymentOptions}.
	 *
	 */
	public DeploymentOptions() {
	}
	

	/**
	 * Get the value of property {@code instances}.
	 *
	 * @return the instances
	 */
	public Boolean getInstances() {
		return instances;
	}

	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances
	 */
	public void setInstances(Boolean instances) {
		this.instances = instances;
	}

	
	//
	// With
	//
	
	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances
	 * @return this {@code DeploymentOptions}
	 */
	public DeploymentOptions withInstances(Boolean instances) {
		this.instances = instances;
		return this;
	}


	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
			.append("instances", instances)
			;
	}
}
