package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.DeploymentStatus;
import org.einnovator.devops.client.model.SolutionType;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

/**
 * A filter for {@code Deployment}s.
 *
 * @see Deployment
 * @author support@einnovator.org
 *
 */
public class DeploymentFilter extends DeploymentOptions {
	
	private String q;
	
	private SolutionType type;

	private DeploymentStatus status;
	
	
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
	 * @return the value of q
	 */
	public String getQ() {
		return q;
	}


	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of q 
	 */
	public void setQ(String q) {
		this.q = q;
	}
	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the value of type
	 */
	public SolutionType getType() {
		return type;
	}


	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of type 
	 */
	public void setType(SolutionType type) {
		this.type = type;
	}


	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the value of status
	 */
	public DeploymentStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of status 
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}
	
	
	//
	// With
	//
	

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of q
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of type
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withType(SolutionType type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of status
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withStatus(DeploymentStatus status) {
		this.status = status;
		return this;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("type", type)
			.append("status", status);

	}

	/**
	 * Inmemory check if this {@code DeploymentFilter} matches a {@code Deployment}
	 * 
	 * @param deploy the value of {@code Deployment}
	 * @return true, if match
	 */
	public boolean check(Deployment deploy) {
		if (deploy==null) {
			return false;
		}
		if (status!=null && status!=deploy.getStatus()) {
			return false;
		}
		if (type!=null && (deploy.getSolution()==null || type!=deploy.getSolution().getType())) {
			return false;
		}
		if (StringUtils.hasText(q) && (deploy.getName()==null || !deploy.getName().contains(q))) {
			return false;
		}
		return true;
	}
	
}
