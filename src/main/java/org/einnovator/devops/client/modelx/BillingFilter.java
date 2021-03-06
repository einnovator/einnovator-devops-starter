package org.einnovator.devops.client.modelx;


import org.einnovator.devops.client.model.Billing;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Billing}s.
 *
 * @see Billing
 * @author support@einnovator.org
 *
 */
public class BillingFilter extends BillingOptions {
	
private String q;
	
	private String owner;
	
	private String group;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code BillingFilter}.
	 *
	 */
	public BillingFilter() {
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
	
	//
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code BillingFilter}
	 */
	public BillingFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code BillingFilter}
	 */
	public BillingFilter withOwner(String owner) {
		this.owner = owner;
		return this;		
	}
	
	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the value of property group
	 * @return this {@code BillingFilter}
	 */
	public BillingFilter withGroup(String group) {
		this.group = group;
		return this;		

	}
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("owner", owner)
				.append("group", group)
				;
	}
	
}
