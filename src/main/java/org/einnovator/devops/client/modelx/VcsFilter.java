package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.devops.client.model.Vcs;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Vcs}s.
 *
 * @see Vcs
 * @author support@einnovator.org
 *
 */
public class VcsFilter extends VcsOptions {
	
	private String q;
		
	private String group;
	
	private List<String> groups;

	private String owner;
	
	public VcsFilter() {
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
	 * @param groups the groups
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
	 * @param owner the owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs
	 * @return this {@code VcsFilter}
	 */
	public VcsFilter withRunAs(String runAs) {
		setRunAs(runAs);
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin
	 * @return this {@code VcsFilter}
	 */
	public VcsFilter withAdmin(Boolean admin) {
		setAdmin(admin);
		return this;

	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("group", group)
				.append("groups", groups)
				.append("owner", owner)
				;
	}
	
}
