package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.ConfigMap;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code ConfigMap}s.
 *
 * @see ConfigMap
 * @see ConfigMapOptions
 * @author support@einnovator.org
 */
public class ConfigMapFilter extends ConfigMapOptions {
	
	private String q;

	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code ConfigMapFilter}.
	 *
	 */
	public ConfigMapFilter() {
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
	 * @return this {@code ConfigMapFilter}
	 */
	public ConfigMapFilter withQ(String q) {
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
