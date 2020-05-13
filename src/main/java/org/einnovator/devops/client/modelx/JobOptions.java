package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Job;
import org.einnovator.util.model.EntityOptions;
import org.einnovator.util.model.ToStringCreator;

/**
 * Options to retrieve {@code Job}s.
 *
 * @see Job
 * @author support@einnovator.org
 *
 */
public class JobOptions extends EntityOptions<Job> {

	private Boolean instances;

	private Boolean unprocessed;

	private Boolean resolve;

	public JobOptions() {
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
	 * @param instances the instances to set
	 */
	public void setInstances(Boolean instances) {
		this.instances = instances;
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

	//
	// With
	//


	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances to set
	 * @return this {@code JobOptions}
	 */
	public JobOptions withInstances(Boolean instances) {
		this.instances = instances;
		return this;
	}

	
	/**
	 * Set the value of property {@code unprocessed}.
	 *
	 * @param unprocessed the unprocessed to set
	 * @return this {@code JobOptions}
	 */
	public JobOptions withUnprocessed(Boolean unprocessed) {
		this.unprocessed = unprocessed;
		return this;
	}
	

	/**
	 * Set the value of property {@code resolve}.
	 *
	 * @param resolve the resolve to set
	 * @return this {@code JobOptions}
	 */
	public JobOptions withResolve(Boolean resolve) {
		this.resolve = resolve;
		return this;
	}
	
	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("unprocessed", unprocessed)
				.append("resolve", resolve)
				;
	}
}
