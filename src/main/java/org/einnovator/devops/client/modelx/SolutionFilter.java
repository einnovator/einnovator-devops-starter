package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.devops.client.model.SolutionType;
import org.einnovator.util.model.ToStringCreator;

public class SolutionFilter extends SolutionOptions {
	
	private String q;
	
	private Boolean strict;

	private SolutionType type;

	private String group;
	
	private List<String> groups;

	private Boolean popular;
	
	private Boolean featured;

	public SolutionFilter() {
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
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public SolutionType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(SolutionType type) {
		this.type = type;
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
	 * Get the value of property {@code popular}.
	 *
	 * @return the popular
	 */
	public Boolean getPopular() {
		return popular;
	}

	/**
	 * Set the value of property {@code popular}.
	 *
	 * @param popular the popular to set
	 */
	public void setPopular(Boolean popular) {
		this.popular = popular;
	}

	/**
	 * Get the value of property {@code featured}.
	 *
	 * @return the featured
	 */
	public Boolean getFeatured() {
		return featured;
	}

	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param featured the featured to set
	 */
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to with
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code strict}.
	 *
	 * @param strict the strict to with
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withStrict(Boolean strict) {
		this.strict = strict;
		return this;
	}
	
	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to with
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withType(SolutionType type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group to with
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the groups to with
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withGroups(List<String> groups) {
		this.groups = groups;
		return this;
	}
	

	/**
	 * Set the value of property {@code popular}.
	 *
	 * @param popular the popular to with
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withPopular(Boolean popular) {
		this.popular = popular;
		return this;
	}

	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param featured the featured to with
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withFeatured(Boolean featured) {
		this.featured = featured;
		return this;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("strict", strict)
			.append("type", type)
			.append("group", group)
			.append("groups", groups)
			.append("popular", popular)
			.append("featured", featured)
			;
	}
	
}
