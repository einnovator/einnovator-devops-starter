package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.devops.client.model.Space;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

public class SpaceFilter extends SpaceOptions {
	
	private String q;
	
	private Boolean strict;
	
	private String group;
	
	private List<String> groups;

	public SpaceFilter() {
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

	//

	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to set
	 */
	public SpaceFilter withRunAs(String runAs) {
		setRunAs(runAs);
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to set
	 */
	public SpaceFilter withAdmin(Boolean admin) {
		setAdmin(admin);
		return this;

	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("group", group)
				.append("groups", groups)
				;
	}
	
	/**
	 * @param space
	 * @return
	 */
	public boolean check(Space space) {
		if (space==null) {
			return false;
		}
		if (StringUtils.hasText(q) && (space.getName()==null || !space.getName().contains(q))) {
			return false;
		}
		return true;
	}
	
}
