package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Secret;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Secret}s.
 *
 * @see Secret
 * @see SecretOptions
 * @author support@einnovator.org
 */
public class SecretFilter extends SecretOptions {
	
	private String q;

	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SecretFilter}.
	 *
	 */
	public SecretFilter() {
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
	 * @param q the q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	//
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of q 
	 * @return this {@code SecretFilter}
	 */
	public SecretFilter withQ(String q) {
		this.q = q;
		return this;
	}

	
	//
	// Other
	//

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				;
	}
	
}
