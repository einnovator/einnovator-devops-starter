package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Space;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

/**
 * A filter for {@code Space}s.
 *
 * @see Space
 * @author support@einnovator.org
 *
 */
public class SpaceFilter extends SpaceOptions {
	
	private String q;

	private String owner;

	public SpaceFilter() {
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


	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withOwner(String owner) {
		this.owner = owner;
		return this;		
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("owner", owner)
			;
	}
	
	/**
	 * Inmemory check if this {@code SpaceFilter} matches a {@code Space}
	 * 
	 * @param space the {@code Space}
	 * @return true, if match
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
