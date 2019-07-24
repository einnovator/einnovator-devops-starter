package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.util.model.ToStringCreator;

public class DomainFilter extends DomainOptions {
	
	private String q;
	
	private Boolean strict;
	
	private String group;
	
	private List<String> groups;

	private Boolean root;

	private Boolean enabled;

	private String type;
	
	public DomainFilter() {
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
	 * Get the value of property {@code root}.
	 *
	 * @return the root
	 */
	public Boolean getRoot() {
		return root;
	}

	/**
	 * Set the value of property {@code root}.
	 *
	 * @param root the root to set
	 */
	public void setRoot(Boolean root) {
		this.root = root;
	}


	/**
	 * Get the value of property {@code enabled}.
	 *
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}


	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	
	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to set
	 */
	public DomainFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code strict}.
	 *
	 * @param strict the strict to set
	 */
	public DomainFilter withStrict(Boolean strict) {
		this.strict = strict;
		return this;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group to set
	 */
	public DomainFilter withGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the groups to set
	 */
	public DomainFilter withGroups(List<String> groups) {
		this.groups = groups;
		return this;
	}

	/**
	 * Set the value of property {@code root}.
	 *
	 * @param root the root to set
	 */
	public DomainFilter withRoot(Boolean root) {
		this.root = root;
		return this;
	}

	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the enabled to set
	 */
	public DomainFilter withEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}
	
	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to set
	 */
	public DomainFilter withRunAs(String runAs) {
		setRunAs(runAs);
		return this;
	}
	
	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to set
	 */
	public DomainFilter withAdmin(Boolean admin) {
		setAdmin(admin);
		return this;
	}


	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("group", group)
				.append("groups", groups)
				.append("root", root)
				.append("enabled", enabled)
				.append("type", type)
				;
	}
	
}
