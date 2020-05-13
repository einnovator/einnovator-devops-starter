package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Service;
import org.einnovator.devops.client.model.ServiceType;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Service}s.
 *
 * @see Service
 * @author support@einnovator.org
 */
public class ServiceFilter extends ServiceOptions {
	
	private String q;
	
	private ServiceType type;


	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code ServiceFilter}.
	 *
	 */
	public ServiceFilter() {
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
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public ServiceType getType() {
		return type;
	}


	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(ServiceType type) {
		this.type = type;
	}

	
	//
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to with
	 * @return this {@code ServiceFilter}
	 */
	public ServiceFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to with
	 * @return this {@code ServiceFilter}
	 */
	public ServiceFilter withType(ServiceType type) {
		this.type = type;
		return this;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("type", type)
			;
	}

	
}
