package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Space extends NamedEntity {

	protected List<Deployment> deployments;

	protected Cluster cluster;

	protected String namespace;
	
	protected Map<DeploymentStatus, Integer> deployStats;

	protected List<VolumeClaim> volumeClaims;

	protected Bill bill;
	
	/**
	 * Create instance of {@code Space}.
	 *
	 */
	public Space() {
	}

	

	/**
	 * Create instance of {@code Space}.
	 *
	 * @param obj the prototype Object
	 */
	public Space(Object obj) {
		super(obj);
	}

	
	/**
	 * Get the value of property {@code deployments}.
	 *
	 * @return the deployments
	 */
	public List<Deployment> getDeployments() {
		return deployments;
	}


	/**
	 * Set the value of property {@code deployments}.
	 *
	 * @param deployments the deployments to set
	 */
	public void setDeployments(List<Deployment> deployments) {
		this.deployments = deployments;
	}

	public void addDeployment(Deployment deploy) {
		if (deployments==null) {
			deployments = new ArrayList<Deployment>();
		}
		deployments.add(deploy);
	}

	public Deployment removeDeployment(int index) {
		if (deployments==null || index <0 || index>= deployments.size()) {
			return null;
		}
		return deployments.remove(index);
	}

	public Deployment getDeployment(int index) {
		if (deployments==null || index <0 || index>= deployments.size()) {
			return null;
		}
		return deployments.get(index);
	}

	public Deployment findDeployment(Deployment deploy) {
		if (deploy!=null && deployments!=null) {
			for (Deployment deploy2: deployments) {
				if ((deploy2.getId()!=null && deploy2.getId().equals(deploy.getId())) || (deploy2.getUuid()!=null && deploy2.getUuid().equals(deploy.getUuid()))) {
					return deploy;
				}
			}
		}
		return null;
	}

	public Deployment findDeployment(String id) {
		if (id!=null && deployments!=null) {
			for (Deployment deploy: deployments) {
				if (id.equals(deploy.getUuid()) || id.equals(deploy.getKey())) {
					return deploy;
				}
			}
		}
		return null;
	}

	public Deployment removeDeployment(Deployment deploy) {
		if (deploy!=null && deployments!=null) {
			for (int i=0; i<deployments.size(); i++) {
				Deployment deploy2 = deployments.get(i);
				if ((deploy2.getId()!=null && deploy2.getId().equals(deploy.getId())) || (deploy2.getUuid()!=null && deploy2.getUuid().equals(deploy.getUuid()))) {
					return deployments.remove(i);
				}
			}
		}
		return null;
	}
	

	
	/**
	 * Get the value of property {@code cluster}.
	 *
	 * @return the cluster
	 */
	public Cluster getCluster() {
		return cluster;
	}

	/**
	 * Set the value of property {@code cluster}.
	 *
	 * @param cluster the cluster to set
	 */
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	/**
	 * Get the value of property {@code namespace}.
	 *
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * Set the value of property {@code namespace}.
	 *
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}


	/**
	 * Get the value of property {@code deployStats}.
	 *
	 * @return the deployStats
	 */
	public Map<DeploymentStatus, Integer> getDeployStats() {
		return deployStats;
	}

	/**
	 * Set the value of property {@code deployStats}.
	 *
	 * @param deployStats the deployStats to set
	 */
	public void setDeployStats(Map<DeploymentStatus, Integer> deployStats) {
		this.deployStats = deployStats;
	}


	/**
	 * Get the value of property {@code volumeClaims}.
	 *
	 * @return the volumeClaims
	 */
	public List<VolumeClaim> getVolumeClaims() {
		return volumeClaims;
	}

	/**
	 * Set the value of property {@code volumeClaims}.
	 *
	 * @param volumeClaims the volumeClaims to set
	 */
	public void setVolumeClaims(List<VolumeClaim> volumeClaims) {
		this.volumeClaims = volumeClaims;
	}

	
	/**
	 * Get the value of property {@code bill}.
	 *
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * Set the value of property {@code bill}.
	 *
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("namespace", namespace)
				.append("deployments", deployments)
				.append("volumeClaims", volumeClaims)
				.append("bill", bill)
				;
	}


}
