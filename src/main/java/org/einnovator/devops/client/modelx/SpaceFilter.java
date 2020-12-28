package org.einnovator.devops.client.modelx;

import java.util.List;

import org.einnovator.devops.client.model.ProviderType;
import org.einnovator.devops.client.model.Region;
import org.einnovator.devops.client.model.Space;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Space}s.
 *
 * @see Space
 * @author support@einnovator.org
 *
 */
public class SpaceFilter extends SpaceOptions {
	
	private String q;
		
	private String group;
	
	private List<String> groups;
	
	private String owner;

	private String cluster;

	private Boolean auth;
	
	private Region region;

	private ProviderType provider;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code SpaceFilter}.
	 *
	 */
	public SpaceFilter() {
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
	 * @param group the value of property group
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
	 * @param groups the value of property groups
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
	 * @param owner the value of property owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Get the value of property {@code cluster}.
	 *
	 * @return the cluster
	 */
	public String getCluster() {
		return cluster;
	}

	/**
	 * Set the value of property {@code cluster}.
	 *
	 * @param cluster the value of property cluster
	 */
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	/**
	 * Get the value of property {@code auth}.
	 *
	 * @return the auth
	 */
	public Boolean getAuth() {
		return auth;
	}

	/**
	 * Set the value of property {@code auth}.
	 *
	 * @param auth the value of property auth
	 */
	public void setAuth(Boolean auth) {
		this.auth = auth;
	}

	/**
	 * Get the value of property {@code region}.
	 *
	 * @return the value of {@code region}
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the value of {@code region}
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Get the value of property {@code provider}.
	 *
	 * @return the value of {@code provider}
	 */
	public ProviderType getProvider() {
		return provider;
	}

	/**
	 * Set the value of property {@code provider}.
	 *
	 * @param provider the value of {@code provider}
	 */
	public void setProvider(ProviderType provider) {
		this.provider = provider;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the value of property group
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * Set the value of property {@code groups}.
	 *
	 * @param groups the value of property groups
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withGroups(List<String> groups) {
		this.groups = groups;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withOwner(String owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * Set the value of property {@code cluster}.
	 *
	 * @param cluster the value of property cluster
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withCluster(String cluster) {
		this.cluster = cluster;
		return this;
	}

	/**
	 * Set the value of property {@code auth}.
	 *
	 * @param auth the value of property auth
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withAuth(Boolean auth) {
		this.auth = auth;
		return this;
	}
	
	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the value of {@code region}
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withRegion(Region region) {
		this.region = region;
		return this;
	}

	/**
	 * Set the value of property {@code provider}.
	 *
	 * @param provider the value of {@code provider}
	 * @return this {@code SpaceFilter}
	 */
	public SpaceFilter withProvider(ProviderType provider) {
		this.provider = provider;
		return this;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("provider", provider)
				.append("region", region)
				.append("group", group)
				.append("groups", groups)
				.append("owner", owner)
				.append("cluster", cluster)
				.append("auth", auth)
				;
	}
	
}
