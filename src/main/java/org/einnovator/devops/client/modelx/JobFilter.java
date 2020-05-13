package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Job;
import org.einnovator.devops.client.model.JobStatus;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Job}s.
 *
 * @see Job
 * @author support@einnovator.org
 *
 */
public class JobFilter extends JobOptions {
	
	private String q;
	
	private JobStatus status;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code JobFilter}.
	 *
	 */
	public JobFilter() {
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
	public JobStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 */
	public void setStatus(JobStatus status) {
		this.status = status;
	}


	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code JobFilter}
	 */
	public JobFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 * @return this {@code JobFilter}
	 */
	public JobFilter withStatus(JobStatus status) {
		this.status = status;
		return this;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("status", status)
			;

	}

}
