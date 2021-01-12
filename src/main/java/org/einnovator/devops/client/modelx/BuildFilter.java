package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;

public class BuildFilter extends BuildOptions {
	
	private String q;
	
	private String deployId;

	public BuildFilter() {
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
	 * Get the value of property {@code deployId}.
	 *
	 * @return the deployId
	 */
	public String getDeployId() {
		return deployId;
	}


	/**
	 * Set the value of property {@code deployId}.
	 *
	 * @param deployId the value of property deployId
	 */
	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}	

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("deployId", deployId)
				;
	}
	
}
