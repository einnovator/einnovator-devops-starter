package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Domain;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Domain}s.
 *
 * @see Domain
 * @author support@einnovator.org
 *
 */
public class DomainFilter extends DomainOptions {
	
	private String q;
	
	private String owner;

	private Boolean root;

	private Boolean enabled;

	private String type;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code DomainFilter}.
	 *
	 */
	public DomainFilter() {
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
	 * @param root the root
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
	 * @param enabled the enabled
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
	 * @param type the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withOwner(String owner) {
		this.owner = owner;
		return this;		
	}
	
	/**
	 * Set the value of property {@code root}.
	 *
	 * @param root the root
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withRoot(Boolean root) {
		this.root = root;
		return this;
	}

	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the enabled
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}
	

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("owner", owner)
				.append("root", root)
				.append("enabled", enabled)
				.append("type", type)
				;
	}
	
}
