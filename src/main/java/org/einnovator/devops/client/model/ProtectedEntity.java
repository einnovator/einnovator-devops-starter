package org.einnovator.devops.client.model;


import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProtectedEntity extends OwnedEntity {

	protected Boolean publik;
	
	protected Boolean restricted;

	/**
	 * Create instance of {@code OwnedEntity}.
	 *
	 */
	public ProtectedEntity() {
	}
	

	/**
	 * Create instance of {@code ProtectedEntity}.
	 *
	 * @param obj the prototype Object
	 */
	public ProtectedEntity(Object obj) {
		super(obj);
	}


	/**
	 * Get the value of property {@code publik}.
	 *
	 * @return the publik
	 */
	public Boolean getPublik() {
		return publik;
	}



	/**
	 * Set the value of property {@code publik}.
	 *
	 * @param publik the publik to set
	 */
	public void setPublik(Boolean publik) {
		this.publik = publik;
	}



	/**
	 * Get the value of property {@code restricted}.
	 *
	 * @return the restricted
	 */
	public Boolean getRestricted() {
		return restricted;
	}



	/**
	 * Set the value of property {@code restricted}.
	 *
	 * @param restricted the restricted to set
	 */
	public void setRestricted(Boolean restricted) {
		this.restricted = restricted;
	}



	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString2(creator
				.append("publik", publik)
				.append("restricted", restricted)
				);
	}
	
}
