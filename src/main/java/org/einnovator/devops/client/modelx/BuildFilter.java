package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Build}s.
 *
 * @see BuildOptions
 * @author support@einnovator.org
 */
public class BuildFilter extends BuildOptions {
	
	private String type;

	private String q;

	private String builder;
	
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
	 * Get the value of property {@code type}.
	 *
	 * @return the value of {@code type}
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of {@code type}
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * Get the value of property {@code builder}.
	 *
	 * @return the value of {@code builder}
	 */
	public String getBuilder() {
		return builder;
	}


	/**
	 * Set the value of property {@code builder}.
	 *
	 * @param builder the value of {@code builder}
	 */
	public void setBuilder(String builder) {
		this.builder = builder;
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
				.append("type", type)
				.append("q", q)
				.append("builder", builder)
				.append("deployId", deployId)
				;
	}
	
}
