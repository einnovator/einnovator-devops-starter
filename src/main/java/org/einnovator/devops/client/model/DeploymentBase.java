package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
abstract public class DeploymentBase extends Deployable {

	
	private SolutionCategory category;

	protected DeploymentStatus status;
	
	public DeploymentBase() {
	}
	
	public DeploymentBase(Object obj) {
		super(obj);
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public SolutionCategory getCategory() {
		return category;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param category the category
	 */
	public void setCategory(SolutionCategory category) {
		this.category = category;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public DeploymentStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}
	

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("category", category)
				.append("status", status)
				;
	}

}
