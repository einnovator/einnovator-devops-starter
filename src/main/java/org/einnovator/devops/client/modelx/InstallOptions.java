package org.einnovator.devops.client.modelx;

import java.util.List;
import java.util.Map;

import org.einnovator.devops.client.model.Mount;
import org.einnovator.devops.client.model.Resources;
import org.einnovator.util.model.ToStringCreator;
import org.einnovator.util.web.RequestOptions;

/**
 * A standalone or catalog {@code Solution} installation options.
 *
 * @author support@einnovator.org
 */
public class InstallOptions extends RequestOptions {

	private String name;

	private String plan;
	
	private String subplan;
	
	private String version;
	
	private String displayName;

	private String space;
	
	private String catalog;

	private Integer instances;

	private Resources resources;
	
	private Boolean route;

	private String host;

	private String domain;

	private Boolean start;
	
	private List<Mount> mounts;
	
	private Map<String, Object> config;
	
	private String profile;

	public InstallOptions() {
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
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code displayName}.
	 *
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Set the value of property {@code displayName}.
	 *
	 * @param displayName the value of property displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	 * @param start the start
	 */
	public void setStart(Boolean start) {
		this.start = start;
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
	 * @param resources the resources
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
	}

	/**
	 * Get the value of property {@code plan}.
	 *
	 * @return the plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * Set the value of property {@code plan}.
	 *
	 * @param plan the plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}

	/**
	 * Get the value of property {@code version}.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Set the value of property {@code version}.
	 *
	 * @param version the value of property version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Get the value of property {@code space}.
	 *
	 * @return the space
	 */
	public String getSpace() {
		return space;
	}

	/**
	 * Set the value of property {@code space}.
	 *
	 * @param space the space
	 */
	public void setSpace(String space) {
		this.space = space;
	}

	/**
	 * Get the value of property {@code route}.
	 *
	 * @return the value of {@code route}
	 */
	public Boolean getRoute() {
		return route;
	}

	/**
	 * Set the value of property {@code route}.
	 *
	 * @param route the value of {@code route}
	 */
	public void setRoute(Boolean route) {
		this.route = route;
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
	 * @param host the host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Get the value of property {@code domain}.
	 *
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Set the value of property {@code domain}.
	 *
	 * @param domain the domain
	 */
	public void setDomain(String domain) {
		this.domain = domain;
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
	 * @param instances the instances
	 */
	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	/**
	 * Get the value of property {@code subplan}.
	 *
	 * @return the subplan
	 */
	public String getSubplan() {
		return subplan;
	}

	/**
	 * Set the value of property {@code subplan}.
	 *
	 * @param subplan the subplan
	 */
	public void setSubplan(String subplan) {
		this.subplan = subplan;
	}
	
	/**
	 * Get the value of property {@code mounts}.
	 *
	 * @return the mounts
	 */
	public List<Mount> getMounts() {
		return mounts;
	}

	/**
	 * Set the value of property {@code mounts}.
	 *
	 * @param mounts the mounts
	 */
	public void setMounts(List<Mount> mounts) {
		this.mounts = mounts;
	}

	/**
	 * Get the value of property {@code catalog}.
	 *
	 * @return the catalog
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * Set the value of property {@code catalog}.
	 *
	 * @param catalog the value of property catalog
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * Get the value of property {@code config}.
	 *
	 * @return the config
	 */
	public Map<String, Object> getConfig() {
		return config;
	}

	/**
	 * Set the value of property {@code config}.
	 *
	 * @param config the value of property config
	 */
	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}
	
	/**
	 * Get the value of property {@code profile}.
	 *
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * Set the value of property {@code profile}.
	 *
	 * @param profile the value of property profile
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
			.append("name", name)
			.append("catalog", catalog)
			.append("space", space)
			.append("plan", plan)
			.append("subplan", subplan)
			.append("displayName", displayName)
			.append("version", version)
			.append("route", route)
			.append("host", host)
			.append("domain", domain)
			.append("instances", instances)
			.append("resources", resources)
			.append("start", start)
			.append("mounts", mounts)
			.append("profile", profile)
			.append("config", config)
			;
	}
}
