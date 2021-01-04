package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.DeploymentStatus;
import org.einnovator.util.model.ToStringCreator;

public class PodFilter extends PodOptions {
	
	private String q;

	private DeploymentStatus status;
	
	private DeploymentStatus[] anyStatus;

	public PodFilter() {
	}

	public PodFilter(Object prototype) {
		super(prototype);
	}
	
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
	 * @param q the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public DeploymentStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status to set
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code anyStatus}.
	 *
	 * @return the value of {@code anyStatus}
	 */
	public DeploymentStatus[] getAnyStatus() {
		return anyStatus;
	}

	/**
	 * Set the value of property {@code anyStatus}.
	 *
	 * @param anyStatus the value of {@code anyStatus}
	 */
	public void setAnyStatus(DeploymentStatus[] anyStatus) {
		this.anyStatus = anyStatus;
	}
	
	//
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q
	 */
	public PodFilter withQ(String q) {
		this.q = q;
		return this;
	}
	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status
	 */
	public PodFilter withStatus(DeploymentStatus status) {
		this.status = status;
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
