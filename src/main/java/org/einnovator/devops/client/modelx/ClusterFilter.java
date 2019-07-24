package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.util.model.ToStringCreator;

public class ClusterFilter extends ClusterOptions {
	
	private String q;
	
	private Boolean strict;
	
	private String region;
	
	private String group;
	
	private List<String> groups;

	private String owner;
	
	private Boolean shared;
	
	public ClusterFilter() {
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
	 * Get the value of property {@code strict}.
	 *
	 * @return the strict
	 */
	public Boolean getStrict() {
		return strict;
	}


	/**
	 * Set the value of property {@code strict}.
	 *
	 * @param strict the strict to set
	 */
	public void setStrict(Boolean strict) {
		this.strict = strict;
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
	 * @param region the region to set
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
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}


	/**
	 * Get the value of property {@code groups}.
	 *
	 * @return the groups
	 */
	public List<String> getGroups() {
		return groups;
	}


	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the groups to set
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
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
	 * @param owner the owner to set
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
	 * @param shared the shared to set
	 */
	public void setShared(Boolean shared) {
		this.shared = shared;
	}


	//



	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to set
	 */
	public ClusterFilter withRunAs(String runAs) {
		setRunAs(runAs);
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to set
	 */
	public ClusterFilter withAdmin(Boolean admin) {
		setAdmin(admin);
		return this;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("region", region)
				.append("group", group)
				.append("groups", groups)
				.append("owner", owner)
				.append("shared", shared)
				;
	}
	
}
