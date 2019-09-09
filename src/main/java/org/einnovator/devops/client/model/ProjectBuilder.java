package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.util.security.Authority;

public class ProjectBuilder extends Project {

	
	public ProjectBuilder() {
	}
	
	
	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the key to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withKey(String key) {
		this.key = key;
		return this;
	}


	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the img to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withImg(String img) {
		this.img = img;
		return this;
	}

	
	/**
	 * Set the value of property {@code thumbnail}.
	 *
	 * @param thumbnail the thumbnail to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}


	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withDescription(String description) {
		this.description = description;
		return this;
	}


	/**
	 * Set the value of property {@code spaces}.
	 *
	 * @param spaces the spaces to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withSpaces(List<Space> spaces) {
		this.spaces = spaces;
		return this;
	}

	/**
	 * Set the value of property {@code authorities}.
	 *
	 * @param authorities the authorities to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
		return this;
	}

	/**
	 * Set the value of property {@code channelId}.
	 *
	 * @param channelId the channelId to with
	 * @return this {@code ProjectBuilder}
	 */
	public ProjectBuilder withChannelId(String channelId) {
		this.channelId = channelId;
		return this;
	}
	
	public Project build() {
		Project project = new Project(this);
		return project;
	}
}
