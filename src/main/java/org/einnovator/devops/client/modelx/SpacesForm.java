package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

public class SpacesForm extends ObjectBase {

	private Boolean dev;

	private Boolean qa;

	private Boolean prod;

	public SpacesForm() {
	}

	
	/**
	 * Get the value of property {@code dev}.
	 *
	 * @return the dev
	 */
	public Boolean getDev() {
		return dev;
	}


	/**
	 * Set the value of property {@code dev}.
	 *
	 * @param dev the dev to set
	 */
	public void setDev(Boolean dev) {
		this.dev = dev;
	}


	/**
	 * Get the value of property {@code qa}.
	 *
	 * @return the qa
	 */
	public Boolean getQa() {
		return qa;
	}


	/**
	 * Set the value of property {@code qa}.
	 *
	 * @param qa the qa to set
	 */
	public void setQa(Boolean qa) {
		this.qa = qa;
	}


	/**
	 * Get the value of property {@code prod}.
	 *
	 * @return the prod
	 */
	public Boolean getProd() {
		return prod;
	}


	/**
	 * Set the value of property {@code prod}.
	 *
	 * @param prod the prod to set
	 */
	public void setProd(Boolean prod) {
		this.prod = prod;
	}


	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
			.append("dev", dev)
			.append("qa", qa)
			.append("prod", prod)
			;
	}
}
