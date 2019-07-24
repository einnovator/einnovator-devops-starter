package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Cluster;
import org.einnovator.devops.client.model.Domain;
import org.einnovator.devops.client.model.Image;
import org.einnovator.devops.client.model.Plan;
import org.einnovator.devops.client.model.Project;
import org.einnovator.devops.client.model.Resources;
import org.einnovator.devops.client.model.Solution;
import org.einnovator.devops.client.model.Space;
import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

public class SolutionInstall extends ObjectBase {

	private Solution solution;

	private Plan plan;
	
	private Plan subplan;
	
	private Integer instances;

	private Resources resources;
	
	private Project project;

	private Space space;

	private String key;

	private String name;

	private String host;

	private Domain domain;

	private Cluster cluster;

	private Image image;
	
	private Boolean start;
	
	public SolutionInstall() {
	}
	
	/**
	 * Get the value of property {@code key}.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code start}.
	 *
	 * @return the start
	 */
	public Boolean getStart() {
		return start;
	}


	/**
	 * Set the value of property {@code start}.
	 *
	 * @param start the start to set
	 */
	public void setStart(Boolean start) {
		this.start = start;
	}

	/**
	 * Get the value of property {@code solution}.
	 *
	 * @return the solution
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * Set the value of property {@code solution}.
	 *
	 * @param solution the solution to set
	 */
	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	/**
	 * Get the value of property {@code plan}.
	 *
	 * @return the plan
	 */
	public Plan getPlan() {
		return plan;
	}

	/**
	 * Set the value of property {@code plan}.
	 *
	 * @param plan the plan to set
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	/**
	 * Get the value of property {@code subplan}.
	 *
	 * @return the subplan
	 */
	public Plan getSubplan() {
		return subplan;
	}

	/**
	 * Set the value of property {@code subplan}.
	 *
	 * @param subplan the subplan to set
	 */
	public void setSubplan(Plan subplan) {
		this.subplan = subplan;
	}

	/**
	 * Get the value of property {@code instances}.
	 *
	 * @return the instances
	 */
	public Integer getInstances() {
		return instances;
	}

	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances to set
	 */
	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	/**
	 * Get the value of property {@code resources}.
	 *
	 * @return the resources
	 */
	public Resources getResources() {
		return resources;
	}

	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the resources to set
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
	}

	/**
	 * Get the value of property {@code project}.
	 *
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Set the value of property {@code project}.
	 *
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * Get the value of property {@code space}.
	 *
	 * @return the space
	 */
	public Space getSpace() {
		return space;
	}

	/**
	 * Set the value of property {@code space}.
	 *
	 * @param space the space to set
	 */
	public void setSpace(Space space) {
		this.space = space;
	}

	/**
	 * Get the value of property {@code host}.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Set the value of property {@code host}.
	 *
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Get the value of property {@code domain}.
	 *
	 * @return the domain
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * Set the value of property {@code domain}.
	 *
	 * @param domain the domain to set
	 */
	public void setDomain(Domain domain) {
		this.domain = domain;
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
	 * Get the value of property {@code image}.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
			.append("solution", solution)
			.append("plan", plan)
			.append("subplan", subplan)
			.append("project", project)
			.append("space", space)
			.append("key", key)
			.append("name", name)
			.append("host", host)
			.append("domain", domain)
			.append("cluster", cluster)
			.append("instances", instances)
			.append("resources", resources)
			.append("image", image)
			.append("start", start)
			;
	}
}
