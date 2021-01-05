package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.CronJob;
import org.einnovator.util.model.EntityOptions;
import org.einnovator.util.model.ToStringCreator;

/**
 * Options to retrieve or delete {@code CronJob}s.
 *
 * @see CronJob
 * @author support@einnovator.org
 *
 */
public class CronJobOptions extends EntityOptions<CronJob> {

	private Boolean jobs;

	private Boolean cronJob;

	private Boolean unprocessed;

	private Boolean resolve;

	public CronJobOptions() {
	}
	
	/**
	 * Get the value of property {@code jobs}.
	 *
	 * @return the value of {@code jobs}
	 */
	public Boolean getJobs() {
		return jobs;
	}

	/**
	 * Set the value of property {@code jobs}.
	 *
	 * @param jobs the value of {@code jobs}
	 */
	public void setJobs(Boolean jobs) {
		this.jobs = jobs;
	}

	/**
	 * Get the value of property {@code cronJob}.
	 *
	 * @return the value of {@code cronJob}
	 */
	public Boolean getCronJob() {
		return cronJob;
	}

	/**
	 * Set the value of property {@code cronJob}.
	 *
	 * @param cronJob the value of {@code cronJob}
	 */
	public void setCronJob(Boolean cronJob) {
		this.cronJob = cronJob;
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
	 * Set the value of property {@code jobs}.
	 *
	 * @param jobs the value of jobs
	 */
	public CronJobOptions withJobs(Boolean jobs) {
		this.jobs = jobs;
		return this;
	}

	/**
	 * Set the value of property {@code cronJob}.
	 *
	 * @param cronJob the value of cronJob
	 */
	public CronJobOptions withCronJob(Boolean cronJob) {
		this.cronJob = cronJob;
		return this;
	}
	
	/**
	 * Set the value of property {@code unprocessed}.
	 *
	 * @param unprocessed the unprocessed to set
	 * @return this {@code CronJobOptions}
	 */
	public CronJobOptions withUnprocessed(Boolean unprocessed) {
		this.unprocessed = unprocessed;
		return this;
	}

	/**
	 * Set the value of property {@code resolve}.
	 *
	 * @param resolve the resolve to set
	 * @return this {@code CronJobOptions}
	 */
	public CronJobOptions withResolve(Boolean resolve) {
		this.resolve = resolve;
		return this;
	}
	
	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("jobs", jobs)
				.append("cronJob", cronJob)
				.append("unprocessed", unprocessed)
				.append("resolve", resolve)
				;
	}
}
