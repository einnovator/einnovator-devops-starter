/**
 * 
 */
package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

/**
 *
 */
public class IngressRuntime extends ObjectBase {

	private IngressType type;

	private RuntimeStatus status;

	private Boolean install;
	
	
	/**
	 * Create instance of {@code IngressRuntime}.
	 *
	 */
	public IngressRuntime() {
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the value of {@code type}
	 */
	public IngressType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of {@code type}
	 */
	public void setType(IngressType type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the value of {@code status}
	 */
	public RuntimeStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of {@code status}
	 */
	public void setStatus(RuntimeStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code install}.
	 *
	 * @return the value of {@code install}
	 */
	public Boolean getInstall() {
		return install;
	}

	/**
	 * Set the value of property {@code install}.
	 *
	 * @param install the value of {@code install}
	 */
	public void setInstall(Boolean install) {
		this.install = install;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("status", status)
				.append("install", install)
				;
	}
}
