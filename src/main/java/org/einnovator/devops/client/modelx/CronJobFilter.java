package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.CronJob;
import org.einnovator.devops.client.model.CronJobStatus;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code CronJob}s.
 *
 * @see CronJob
 * @author support@einnovator.org
 *
 */
public class CronJobFilter extends CronJobOptions {
	
	private String q;
	
	private CronJobStatus status;

	private CronJobStatus[] anyStatus;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code CronJobFilter}.
	 *
	 */
	public CronJobFilter() {
	}

	//
	// Getters/Setters
	//
	
	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public CronJobStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 */
	public void setStatus(CronJobStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code anyStatus}.
	 *
	 * @return the value of {@code anyStatus}
	 */
	public CronJobStatus[] getAnyStatus() {
		return anyStatus;
	}

	/**
	 * Set the value of property {@code anyStatus}.
	 *
	 * @param anyStatus the value of {@code anyStatus}
	 */
	public void setAnyStatus(CronJobStatus[] anyStatus) {
		this.anyStatus = anyStatus;
	}
	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code CronJobFilter}
	 */
	public CronJobFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 * @return this {@code CronJobFilter}
	 */
	public CronJobFilter withStatus(CronJobStatus status) {
		this.status = status;
		return this;
	}

	/**
	 * Set the value of property {@code anyStatus}.
	 *
	 * @param anyStatus the value of property anyStatus
	 * @return this {@code CronJobFilter}
	 */
	public CronJobFilter withAnyStatus(CronJobStatus[] anyStatus) {
		this.anyStatus = anyStatus;
		return this;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("status", status)
			.append("anyStatus", anyStatus)
			;
	}

}
