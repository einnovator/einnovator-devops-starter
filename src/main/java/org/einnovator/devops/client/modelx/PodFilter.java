package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.DeploymentStatus;
import org.einnovator.devops.client.model.Pod;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Pod}s.
 *
 * @see Pod
 * @author support@einnovator.org
 *
 */
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
	 * @param q the q
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
	 * @param status the status
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
	 * @return this {@code PodFilter}
	 */
	public PodFilter withQ(String q) {
		this.q = q;
		return this;
	}
	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status
	 * @return this {@code PodFilter}
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
