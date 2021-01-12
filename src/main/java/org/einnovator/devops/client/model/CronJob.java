package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CronJob extends JobBase {

	protected CronJobStatus status;

	private String schedule;

	private Long startingDeadline;

	private ConcurrencyPolicy concurrencyPolicy;

	private String lastScheduleTime;
	
	private String lastScheduleAge;
	
	private Integer successfulJobsHistoryLimit;
	
	private Integer failedJobsHistoryLimit;
	
	private Boolean suspend;
	
	private Integer backoffLimit;

	public CronJob() {
	}
	
	public CronJob(CronJob job) {
		super(job);
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the value of {@code status}
	 */
	public CronJobStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of {@code status}
	 */
	public void setStatus(CronJobStatus status) {
		this.status = status;
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
	 * @param schedule the schedule
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
	 * @param startingDeadline the startingDeadline
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
	 * @param concurrencyPolicy the concurrencyPolicy
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
	 * @param lastScheduleTime the lastScheduleTime
	 */
	public void setLastScheduleTime(String lastScheduleTime) {
		this.lastScheduleTime = lastScheduleTime;
	}
	
	/**
	 * Get the value of property {@code lastScheduleAge}.
	 *
	 * @return the value of {@code lastScheduleAge}
	 */
	public String getLastScheduleAge() {
		return lastScheduleAge;
	}

	/**
	 * Set the value of property {@code lastScheduleAge}.
	 *
	 * @param lastScheduleAge the value of {@code lastScheduleAge}
	 */
	public void setLastScheduleAge(String lastScheduleAge) {
		this.lastScheduleAge = lastScheduleAge;
	}

	/**
	 * Get the value of property {@code suspend}.
	 *
	 * @return the value of {@code suspend}
	 */
	public Boolean getSuspend() {
		return suspend;
	}

	/**
	 * Set the value of property {@code suspend}.
	 *
	 * @param suspend the value of {@code suspend}
	 */
	public void setSuspend(Boolean suspend) {
		this.suspend = suspend;
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
	 * @param successfulJobsHistoryLimit the successfulJobsHistoryLimit
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
	 * @param failedJobsHistoryLimit the failedJobsHistoryLimit
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
	 * @param backoffLimit the backoffLimit
	 */
	public void setBackoffLimit(Integer backoffLimit) {
		this.backoffLimit = backoffLimit;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("schedule", schedule)
				.append("startingDeadline", startingDeadline)
				.append("concurrencyPolicy", concurrencyPolicy)
				.append("lastScheduleTime", lastScheduleTime)
				.append("lastScheduleAge", lastScheduleAge)
				.append("suspend", suspend)
				.append("successfulJobsHistoryLimit", successfulJobsHistoryLimit)
				.append("failedJobsHistoryLimit", failedJobsHistoryLimit)
				.append("backoffLimit", backoffLimit)
				;
	}

}
