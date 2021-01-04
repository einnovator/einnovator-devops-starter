package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.DeploymentStatus;
import org.einnovator.util.model.ToStringCreator;

public class ReplicaSetFilter extends ReplicaSetOptions {
	
	private String q;
	
	private DeploymentStatus status;
	
	private DeploymentStatus[] anyStatus;

	public ReplicaSetFilter() {
	}

	public ReplicaSetFilter(Object prototype) {
		super(prototype);
	}
	
	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the value q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}
	
	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the value status
	 */
	public DeploymentStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value status to set
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
	 * @param q the value q
	 */
	public ReplicaSetFilter withQ(String q) {
		this.q = q;
		return this;
	}
	
	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value status
	 */
	public ReplicaSetFilter withStatus(DeploymentStatus status) {
		this.status = status;
		return this;
	}

	/**
	 * Set the value of property {@code anyStatus}.
	 *
	 * @param anyStatus the value anyStatus
	 */
	public ReplicaSetFilter withAnyStatus(DeploymentStatus[] anyStatus) {
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
