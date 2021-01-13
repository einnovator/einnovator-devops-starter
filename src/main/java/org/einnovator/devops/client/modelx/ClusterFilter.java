package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.devops.client.model.Cluster;
import org.einnovator.devops.client.model.ProviderType;
import org.einnovator.devops.client.model.Region;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Cluster}s.
 *
 * @see Cluster
 * @see ClusterOptions
 * @author support@einnovator.org
 */
public class ClusterFilter extends ClusterOptions {
	
	private String q;

	private Boolean enabled;

	private Boolean valid;
	
	private Region region;

	private ProviderType provider;

	private String group;
	
	private List<String> groups;

	private String owner;
	
	private Boolean shared;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code ClusterFilter}.
	 *
	 */
	public ClusterFilter() {
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
	 * @param q the q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code region}.
	 *
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the region
	 */
	public void setRegion(Region region) {
		this.region = region;
	}


	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Get the value of property {@code groups}.
	 *
	 * @return the groups
	 */
	public List<String> getGroups() {
		return groups;
	}

	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the groups
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	/**
	 * Get the value of property {@code owner}.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}


	/**
	 * Get the value of property {@code shared}.
	 *
	 * @return the shared
	 */
	public Boolean getShared() {
		return shared;
	}

	/**
	 * Set the value of property {@code shared}.
	 *
	 * @param shared the shared
	 */
	public void setShared(Boolean shared) {
		this.shared = shared;
	}

	/**
	 * Get the value of property {@code provider}.
	 *
	 * @return the provider
	 */
	public ProviderType getProvider() {
		return provider;
	}


	/**
	 * Set the value of property {@code provider}.
	 *
	 * @param provider the value of property provider
	 */
	public void setProvider(ProviderType provider) {
		this.provider = provider;
	}

	
	/**
	 * Get the value of property {@code valid}.
	 *
	 * @return the valid
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * Set the value of property {@code valid}.
	 *
	 * @param valid the value of property valid
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}


	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the value of property enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * Get the value of property {@code enabled}.
	 *
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	//
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of q 
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the value of group 
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the value of groups 
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withGroups(List<String> groups) {
		this.groups = groups;
		return this;
	}

	/**
	 * Set the value of property {@code provider}.
	 *
	 * @param provider the value of provider 
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withProvider(ProviderType provider) {
		this.provider = provider;
		return this;
	}

	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the value of enabled 
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withRegion(Region region) {
		this.region = region;
		return this;
	}

	/**
	 * Set the value of property {@code shared}.
	 *
	 * @param shared the value of enabled 
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withShared(Boolean shared) {
		this.shared = shared;
		return this;
	}
	
	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withOwner(String owner) {
		this.owner = owner;
		return this;
	}
	/**
	 * Set the value of property {@code valid}.
	 *
	 * @param valid the value of property valid
	 * @return this {@code ClusterFilter}
	 */
	public ClusterFilter withValid(Boolean valid) {
		this.valid = valid;
		return this;
	}

	//
	// Other
	//

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("provider", provider)
				.append("region", region)
				.append("valid", valid)
				.append("owner", owner)
				.append("group", group)
				.append("groups", groups)
				.append("shared", shared)
				;
	}
	
}
