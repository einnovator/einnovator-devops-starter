package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.util.model.ToStringCreator;

public class RegistryFilter extends RegistryOptions {
	
	private String q;
	
	private Boolean strict;
	
	private String group;
	
	private List<String> groups;

	private Boolean private_;
	
	public RegistryFilter() {
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
	 * Get the value of property {@code private_}.
	 *
	 * @return the private_
	 */
	public Boolean getPrivate() {
		return private_;
	}


	/**
	 * Set the value of property {@code private_}.
	 *
	 * @param private_ the private_ to set
	 */
	public void setPrivate(Boolean private_) {
		this.private_ = private_;
	}

	//

	//

	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to set
	 */
	public RegistryFilter withRunAs(String runAs) {
		setRunAs(runAs);
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to set
	 */
	public RegistryFilter withAdmin(Boolean admin) {
		setAdmin(admin);
		return this;

	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("group", group)
				.append("groups", groups)
				.append("private", private_)
				;
	}
	
}
