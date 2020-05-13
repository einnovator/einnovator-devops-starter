package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CronJob extends JobBase {

	private String schedule;

	private Long startingDeadline;

	private ConcurrencyPolicy concurrencyPolicy;

	private String lastScheduleTime;
	
	private Integer successfulJobsHistoryLimit;
	
	private Integer failedJobsHistoryLimit;
	
	private Boolean suspeded;
	
	private Integer backoffLimit;

	public CronJob() {
	}
	
	public CronJob(CronJob job) {
		super(job);
	}

	/**
	 * Get the value of property {@code schedule}.
	 *
	 * @return the schedule
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * Set the value of property {@code schedule}.
	 *
	 * @param schedule the schedule to set
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	/**
	 * Get the value of property {@code startingDeadline}.
	 *
	 * @return the startingDeadline
	 */
	public Long getStartingDeadline() {
		return startingDeadline;
	}

	/**
	 * Set the value of property {@code startingDeadline}.
	 *
	 * @param startingDeadline the startingDeadline to set
	 */
	public void setStartingDeadline(Long startingDeadline) {
		this.startingDeadline = startingDeadline;
	}

	/**
	 * Get the value of property {@code concurrencyPolicy}.
	 *
	 * @return the concurrencyPolicy
	 */
	public ConcurrencyPolicy getConcurrencyPolicy() {
		return concurrencyPolicy;
	}

	/**
	 * Set the value of property {@code concurrencyPolicy}.
	 *
	 * @param concurrencyPolicy the concurrencyPolicy to set
	 */
	public void setConcurrencyPolicy(ConcurrencyPolicy concurrencyPolicy) {
		this.concurrencyPolicy = concurrencyPolicy;
	}

	/**
	 * Get the value of property {@code lastScheduleTime}.
	 *
	 * @return the lastScheduleTime
	 */
	public String getLastScheduleTime() {
		return lastScheduleTime;
	}

	/**
	 * Set the value of property {@code lastScheduleTime}.
	 *
	 * @param lastScheduleTime the lastScheduleTime to set
	 */
	public void setLastScheduleTime(String lastScheduleTime) {
		this.lastScheduleTime = lastScheduleTime;
	}

	/**
	 * Get the value of property {@code suspeded}.
	 *
	 * @return the suspeded
	 */
	public Boolean getSuspeded() {
		return suspeded;
	}

	/**
	 * Set the value of property {@code suspeded}.
	 *
	 * @param suspeded the suspeded to set
	 */
	public void setSuspeded(Boolean suspeded) {
		this.suspeded = suspeded;
	}
	
	/**
	 * Get the value of property {@code successfulJobsHistoryLimit}.
	 *
	 * @return the successfulJobsHistoryLimit
	 */
	public Integer getSuccessfulJobsHistoryLimit() {
		return successfulJobsHistoryLimit;
	}

	/**
	 * Set the value of property {@code successfulJobsHistoryLimit}.
	 *
	 * @param successfulJobsHistoryLimit the successfulJobsHistoryLimit to set
	 */
	public void setSuccessfulJobsHistoryLimit(Integer successfulJobsHistoryLimit) {
		this.successfulJobsHistoryLimit = successfulJobsHistoryLimit;
	}

	/**
	 * Get the value of property {@code failedJobsHistoryLimit}.
	 *
	 * @return the failedJobsHistoryLimit
	 */
	public Integer getFailedJobsHistoryLimit() {
		return failedJobsHistoryLimit;
	}

	/**
	 * Set the value of property {@code failedJobsHistoryLimit}.
	 *
	 * @param failedJobsHistoryLimit the failedJobsHistoryLimit to set
	 */
	public void setFailedJobsHistoryLimit(Integer failedJobsHistoryLimit) {
		this.failedJobsHistoryLimit = failedJobsHistoryLimit;
	}

	/**
	 * Get the value of property {@code backoffLimit}.
	 *
	 * @return the backoffLimit
	 */
	public Integer getBackoffLimit() {
		return backoffLimit;
	}

	/**
	 * Set the value of property {@code backoffLimit}.
	 *
	 * @param backoffLimit the backoffLimit to set
	 */
	public void setBackoffLimit(Integer backoffLimit) {
		this.backoffLimit = backoffLimit;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("schedule", schedule)
				.append("startingDeadline", startingDeadline)
				.append("concurrencyPolicy", concurrencyPolicy)
				.append("lastScheduleTime", lastScheduleTime)
				.append("suspeded", suspeded)
				.append("successfulJobsHistoryLimit", successfulJobsHistoryLimit)
				.append("failedJobsHistoryLimit", failedJobsHistoryLimit)
				.append("backoffLimit", backoffLimit)
				;
	}

}
