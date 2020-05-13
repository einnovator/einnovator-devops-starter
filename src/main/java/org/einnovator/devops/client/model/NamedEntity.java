package org.einnovator.devops.client.model;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class NamedEntity extends EntityBase {

	protected String name;

	protected String displayName;

	protected String description;

	protected String img;

	protected String thumbnail;	
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code TitleEntity}.
	 *
	 */
	public NamedEntity() {
	}
	

	/**
	 * Create instance of {@code NamedEntity}.
	 *
	 * @param obj the prototype Object
	 */
	public NamedEntity(Object obj) {
		super(obj);
	}
	
	//
	// Getters/Setters
	//


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
	 * @param name the value of property name
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
	 * Get the value of property {@code description}.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the value of property description
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Get the value of property {@code img}.
	 *
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the value of property img
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * Get the value of property {@code thumbnail}.
	 *
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * Set the value of property {@code thumbnail}.
	 *
	 * @param thumbnail the value of property thumbnail
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	//
	// With
	//
	

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the value of property name
	 * @return this {@code NamedEntity}
	 */
	public NamedEntity withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code displayName}.
	 *
	 * @param displayName the value of property displayName
	 * @return this {@code NamedEntity}
	 */
	public NamedEntity withDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the value of property description
	 * @return this {@code NamedEntity}
	 */
	public NamedEntity withDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the value of property img
	 * @return this {@code NamedEntity}
	 */
	public NamedEntity withImg(String img) {
		this.img = img;
		return this;
	}

	/**
	 * Set the value of property {@code thumbnail}.
	 *
	 * @param thumbnail the value of property thumbnail
	 * @return this {@code NamedEntity}
	 */
	public NamedEntity withThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("displayName", displayName)
				.append("name", name)
				;
	}
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(creator
				//.append("description", description)
				.append("img", img)
				.append("thumbnail", thumbnail)
				);
	}

}
