package org.einnovator.devops.client.modelx;


import org.einnovator.devops.client.model.Solution;
import org.einnovator.devops.client.model.SolutionType;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Solution}s.
 *
 * @see Solution
 * @author support@einnovator.org
 *
 */
public class SolutionFilter extends SolutionOptions {
	
	private String q;

	private SolutionType type;

	private String owner;

	private String group;
	
	private Boolean popular;
	
	private Boolean featured;

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
	 * @return the value of q
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
	 * @param owner the value of property owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
	 * @param type the value of property type
	 */
	public void setType(SolutionType type) {
		this.type = type;
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
	 * @param popular the value of property popular
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
	 * @param featured the value of property featured
	 */
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}
	
	//
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withOwner(String owner) {
		this.owner = owner;
		return this;		
	}
	
	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the value of property group
	 * @return this {@code SolutionFilter}
	 */
	public SolutionFilter withGroup(String group) {
		this.group = group;
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
			.append("type", type)
			.append("group", group)
			.append("owner", owner)
			.append("popular", popular)
			.append("featured", featured)
			;
	}
	
}
