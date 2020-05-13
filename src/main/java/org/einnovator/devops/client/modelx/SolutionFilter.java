package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.devops.client.model.Solution;
import org.einnovator.devops.client.model.SolutionCategory;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Solution}s.
 *
 * @see Solution
 * @author support@einnovator.org
 */
public class SolutionFilter extends SolutionOptions {

	private String q;
	
	private SolutionCategory category;

	private String group;
	
	private List<String> groups;

	private Boolean popular;
	
	private Boolean featured;

	private Boolean enabled;

	private Boolean license;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SolutionFilter}.
	 *
	 */
	public SolutionFilter() {
	}

	//
	// Getters/Setters
	//

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
	 * Get the value of property {@code category}.
	 *
	 * @return the category
	 */
	public SolutionCategory getCategory() {
		return category;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the category to set
	 */
	public void setCategory(SolutionCategory category) {
		this.category = category;
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
	 * @param enabled the value of property enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Get the value of property {@code license}.
	 *
	 * @return the license
	 */
	public Boolean getLicense() {
		return license;
	}

	/**
	 * Set the value of property {@code license}.
	 *
	 * @param license the value of property license
	 */
	public void setLicense(Boolean license) {
		this.license = license;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the category to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withCategory(SolutionCategory category) {
		this.category = category;
		return this;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the groups to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withGroups(List<String> groups) {
		this.groups = groups;
		return this;
	}
	

	/**
	 * Set the value of property {@code popular}.
	 *
	 * @param popular the popular to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withPopular(Boolean popular) {
		this.popular = popular;
		return this;
	}

	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param featured the featured to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withFeatured(Boolean featured) {
		this.featured = featured;
		return this;
	}

	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the featured to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}


	/**
	 * Set the value of property {@code license}.
	 *
	 * @param license the featured to set
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withLicense(Boolean license) {
		this.license = license;
		return this;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("category", category)
			.append("group", group)
			.append("groups", groups)
			.append("popular", popular)
			.append("featured", featured)
			.append("enabled", enabled)
			.append("license", license)
			;
	}
	
}
