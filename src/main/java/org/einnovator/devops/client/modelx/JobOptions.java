package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Job;
import org.einnovator.util.model.EntityOptions;
import org.einnovator.util.model.ToStringCreator;

/**
 * Options to retrieve or delete {@code Job}s.
 *
 * @see Job
 * @author support@einnovator.org
 *
 */
public class JobOptions extends EntityOptions<Job> {

	private Boolean pods;

	private Boolean job;

	private Boolean unprocessed;

	private Boolean resolve;

	public JobOptions() {
	}
	
	/**
	 * Set the value of property {@code pods}.
	 *
	 * @param pods the pods to set
	 */
	public void setPods(Boolean pods) {
		this.pods = pods;
	}

	/**
	 * Get the value of property {@code job}.
	 *
	 * @return the value of {@code job}
	 */
	public Boolean getJob() {
		return job;
	}

	/**
	 * Set the value of property {@code job}.
	 *
	 * @param job the value of {@code job}
	 */
	public void setJob(Boolean job) {
		this.job = job;
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
	 * Set the value of property {@code pods}.
	 *
	 * @param pods the pods to set
	 * @return this {@code JobOptions}
	 */
	public JobOptions withPods(Boolean pods) {
		this.pods = pods;		
		return this;
	}
	
	/**
	 * Set the value of property {@code job}.
	 *
	 * @param job the value of {@code job}
	 * @return this {@code JobOptions}
	 */
	public JobOptions withJob(Boolean job) {
		this.job = job;
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
				.append("pods", pods)
				.append("job", job)
				.append("unprocessed", unprocessed)
				.append("resolve", resolve)
				;
	}
}
