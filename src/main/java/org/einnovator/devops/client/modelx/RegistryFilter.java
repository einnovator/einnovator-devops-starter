package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Registry;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Registry}s.
 *
 * @see Registry
 * @author support@einnovator.org
 *
 */
public class RegistryFilter extends RegistryOptions {
	
	private String q;

	private String owner;

	private String group;
	
	private Boolean private_;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code RegistryFilter}.
	 *
	 */
	public RegistryFilter() {
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
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code RegistryFilter}
	 */
	public RegistryFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code RegistryFilter}
	 */
	public RegistryFilter withOwner(String owner) {
		this.owner = owner;
		return this;		
	}
	
	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the value of property group
	 * @return this {@code RegistryFilter}
	 */
	public RegistryFilter withGroup(String group) {
		this.group = group;
		return this;		

	}
	
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("owner", owner)
				.append("group", group)
				.append("private", private_)
				;
	}
	
}
