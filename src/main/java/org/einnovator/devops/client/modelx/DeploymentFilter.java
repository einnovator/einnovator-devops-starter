package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.DeploymentStatus;
import org.einnovator.devops.client.model.DeploymentKind;
import org.einnovator.devops.client.model.SolutionCategory;
import org.einnovator.devops.client.modelx.DeploymentFilter;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Deployment}s.
 *
 * @see Deployment
 * @author support@einnovator.org
 *
 */
public class DeploymentFilter extends DeploymentOptions {
	
	private String q;
	
	private SolutionCategory category;

	private DeploymentStatus status;
	
	private DeploymentKind kind;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code DeploymentFilter}.
	 *
	 */
	public DeploymentFilter() {
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
	 * @param q the value of property q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code category}.
	 *
	 * @return the category
	 */
	public SolutionCategory getCategory() {
		return category;
	}


	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the value of property category
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
	 * @param status the value of property status
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code kind}.
	 *
	 * @return the kind
	 */
	public DeploymentKind getKind() {
		return kind;
	}

	/**
	 * Set the value of property {@code kind}.
	 *
	 * @param kind the value of property kind
	 */
	public void setKind(DeploymentKind kind) {
		this.kind = kind;
	}


	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the value of property category
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withCategory(SolutionCategory category) {
		this.category = category;
		return this;
	}


	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withStatus(DeploymentStatus status) {
		this.status = status;
		return this;
	}


	/**
	 * Set the value of property {@code kind}.
	 *
	 * @param kind the value of property kind
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withKind(DeploymentKind kind) {
		this.kind = kind;
		return this;
	}

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("category", category)
			.append("status", status)
			.append("kind", kind)
			;
	}

}
