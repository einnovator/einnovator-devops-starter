package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.devops.client.model.SolutionRepoType;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Catalog}s.
 *
 * @see CatalogOptions
 * @author support@einnovator.org
 */
public class CatalogFilter extends CatalogOptions {

	private SolutionRepoType type;

	private String q;
	
	private Boolean featured;

	private String group;
	
	private List<String> groups;

	private Boolean enabled;

	private Boolean license;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SolutionRepoFilter}.
	 *
	 */
	public CatalogFilter() {
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
	 * @param q the value of property q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public SolutionRepoType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 */
	public void setType(SolutionRepoType type) {
		this.type = type;
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
	 * @param group the value of property group
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
	 * @param groups the value of property groups
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
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
	 * @param featured the value of property featured
	 */
	public void setFeatured(Boolean featured) {
		this.featured = featured;
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
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the enabled
	 * @return this {@code SolutionRepoFilter}
	 */
	public CatalogFilter withEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param featured the featured
	 * @return this {@code SolutionRepoFilter}
	 */
	public CatalogFilter withFeatured(Boolean featured) {
		this.featured = featured;
		return this;
	}


	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param license the license
	 * @return this {@code SolutionRepoFilter}
	 */
	public CatalogFilter withLicense(Boolean license) {
		this.license = license;
		return this;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("type", type)
				.append("group", group)
				.append("groups", groups)
				.append("enabled", enabled)
				.append("featured", featured)
				.append("license", license)
				;
	}
	
}
