package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Cluster}s.
 *
 * @see Cluster
 * @author support@einnovator.org
 *
 */
public class ClusterFilter extends ClusterOptions {
	
	private String q;
	
	private String region;
	
	private String group;
	
	private String owner;
	
	private Boolean shared;
	
	public ClusterFilter() {
	}


	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the value of q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code region}.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the region
	 */
	public void setRegion(String region) {
		this.region = region;
	}


	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}


	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Get the value of property {@code owner}.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Get the value of property {@code shared}.
	 *
	 * @return the shared
	 */
	public Boolean getShared() {
		return shared;
	}

	/**
	 * Set the value of property {@code shared}.
	 *
	 * @param shared the shared
	 */
	public void setShared(Boolean shared) {
		this.shared = shared;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("region", region)
				.append("owner", owner)
				.append("group", group)
				.append("shared", shared)
				;
	}
	
}
