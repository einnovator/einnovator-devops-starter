package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Deployment;
import org.einnovator.util.model.EntityOptions;
import org.einnovator.util.model.ToStringCreator;

/**
 * Options to retrieve or delete {@code Deployment}s.
 *
 * @see Deployment
 * @author support@einnovator.org
 */
public class DeploymentOptions extends EntityOptions<Deployment> {

	private Boolean pods;

	private Boolean service;
	
	private Boolean unprocessed;

	private Boolean resolve;
	
	private Boolean deployment;
	
	private Boolean ingress;

	
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
	 * Create instance of {@code DeploymentOptions}.
	 *
	 * @param obj a prototype
	 */
	public DeploymentOptions(Object obj) {
		super(obj);
	}
	
	//
	// Getter/Setter
	//
	
	/**
	 * Get the value of property {@code pods}.
	 *
	 * @return the pods
	 */
	public Boolean getPods() {
		return pods;
	}

	/**
	 * Set the value of property {@code pods}.
	 *
	 * @param pods the pods
	 */
	public void setPods(Boolean pods) {
		this.pods = pods;
	}

	/**
	 * Get the value of property {@code service}.
	 *
	 * @return the service
	 */
	public Boolean getService() {
		return service;
	}

	/**
	 * Set the value of property {@code service}.
	 *
	 * @param service the service
	 */
	public void setService(Boolean service) {
		this.service = service;
	}

	/**
	 * Get the value of property {@code unprocessed}.
	 *
	 * @return the unprocessed
	 */
	public Boolean getUnprocessed() {
		return unprocessed;
	}

	/**
	 * Set the value of property {@code unprocessed}.
	 *
	 * @param unprocessed the value of property unprocessed
	 */
	public void setUnprocessed(Boolean unprocessed) {
		this.unprocessed = unprocessed;
	}

	/**
	 * Get the value of property {@code resolve}.
	 *
	 * @return the resolve
	 */
	public Boolean getResolve() {
		return resolve;
	}

	/**
	 * Set the value of property {@code resolve}.
	 *
	 * @param resolve the value of property resolve
	 */
	public void setResolve(Boolean resolve) {
		this.resolve = resolve;
	}


	/**
	 * Get the value of property {@code deployment}.
	 *
	 * @return the value of {@code deployment}
	 */
	public Boolean getDeployment() {
		return deployment;
	}

	/**
	 * Set the value of property {@code deployment}.
	 *
	 * @param deployment the value of {@code deployment}
	 */
	public void setDeployment(Boolean deployment) {
		this.deployment = deployment;
	}

	/**
	 * Get the value of property {@code ingress}.
	 *
	 * @return the value of {@code ingress}
	 */
	public Boolean getIngress() {
		return ingress;
	}

	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the value of {@code ingress}
	 */
	public void setIngress(Boolean ingress) {
		this.ingress = ingress;
	}

	//
	// With
	//


	/**
	 * Set the value of property {@code pods}.
	 *
	 * @param pods the pods
	 * @return this {@code DeploymentOptions}
	 */
	public DeploymentOptions withPods(Boolean pods) {
		this.pods = pods;
		return this;
	}

	/**
	 * Set the value of property {@code service}.
	 *
	 * @param service the service
	 * @return this {@code DeploymentOptions}
	 */
	public DeploymentOptions withService(Boolean service) {
		this.service = service;
		return this;
	}
	

	/**
	 * Set the value of property {@code unprocessed}.
	 *
	 * @param unprocessed the unprocessed
	 * @return this {@code DeploymentOptions}
	 */
	public DeploymentOptions withUnprocessed(Boolean unprocessed) {
		this.unprocessed = unprocessed;
		return this;
	}
	

	/**
	 * Set the value of property {@code resolve}.
	 *
	 * @param resolve the resolve
	 * @return this {@code DeploymentOptions}
	 */
	public DeploymentOptions withResolve(Boolean resolve) {
		this.resolve = resolve;
		return this;
	}
	

	/**
	 * Set the value of property {@code deployment}.
	 *
	 * @param deployment the value of {@code deployment}
	 * @return this {@code DeploymentOptions}
	 */
	public DeploymentOptions withDeployment(Boolean deployment) {
		this.deployment = deployment;
		return this;
	}

	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the value of {@code ingress}
	 * @return this {@code DeploymentOptions}
	 */
	public DeploymentOptions withIngress(Boolean ingress) {
		this.ingress = ingress;
		return this;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("pods", pods)
				.append("service", service)
				.append("unprocessed", unprocessed)
				.append("resolve", resolve)
				.append("deployment", deployment)
				.append("ingress", ingress)
				;
	}
	
}
