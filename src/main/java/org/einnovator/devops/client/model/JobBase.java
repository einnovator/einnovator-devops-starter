package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobBase extends Deployable {


	protected JobStatus status;
	

	public JobBase() {
	}
	
	public JobBase(JobBase job) {
		super(job);
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

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				;
	}

}
