package org.einnovator.devops.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpaceBuilder extends Space {

	
	public SpaceBuilder() {
	}
	
	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the key to with
	 */
	public SpaceBuilder withKey(String key) {
		this.key = key;
		return this;
	}


	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to with
	 */
	public SpaceBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the img to with
	 */
	public SpaceBuilder withImg(String img) {
		this.img = img;
		return this;
	}

	
	/**
	 * Set the value of property {@code thumbnail}.
	 *
	 * @param thumbnail the thumbnail to with
	 */
	public SpaceBuilder withThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}


	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description to with
	 */
	public SpaceBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Set the value of property {@code cluster}.
	 *
	 * @param cluster the cluster to with
	 */
	public SpaceBuilder withCluster(Cluster cluster) {
		this.cluster = cluster;
		return this;
	}


	/**
	 * Set the value of property {@code namespace}.
	 *
	 * @param namespace the namespace to with
	 */
	public void withNamespace(String namespace) {
		this.namespace = namespace;
	}


	
	public Space build() {
		Space space = new Space(this);
		return space;
	}


}
