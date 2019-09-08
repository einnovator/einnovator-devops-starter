package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Deployment;
import org.einnovator.devops.client.model.DeploymentStatus;
import org.einnovator.devops.client.model.SolutionType;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

public class DeploymentFilter extends DeploymentOptions {
	
	private String q;
	
	private Boolean strict;

	private SolutionType type;

	private DeploymentStatus status;
	
	public DeploymentFilter() {
	}

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
	 * Get the value of property {@code strict}.
	 *
	 * @return the strict
	 */
	public Boolean getStrict() {
		return strict;
	}


	/**
	 * Set the value of property {@code strict}.
	 *
	 * @param strict the strict to set
	 */
	public void setStrict(Boolean strict) {
		this.strict = strict;
	}

	
	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public SolutionType getType() {
		return type;
	}


	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(SolutionType type) {
		this.type = type;
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
	 * @param status the status to set
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}

	//
	

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to with
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code strict}.
	 *
	 * @param strict the strict to with
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withStrict(Boolean strict) {
		this.strict = strict;
		return this;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to with
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withType(SolutionType type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status to with
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withStatus(DeploymentStatus status) {
		this.status = status;
		return this;
	}


	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to set
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withRunAs(String runAs) {
		setRunAs(runAs);
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to set
	 * @return this {@code DeploymentFilter}
	 */
	public DeploymentFilter withAdmin(Boolean admin) {
		setAdmin(admin);
		return this;

	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
			.append("q", q)
			.append("strict", strict)
			.append("type", type)
			.append("status", status);

	}

	/**
	 * Inmemory check if this {@code DeploymentFilter} matches a {@code Deployment}
	 * 
	 * @param deploy the {@code Deployment}
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
