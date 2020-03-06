package org.einnovator.devops.client.model;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class NamedEntity extends EntityBase {

	protected String name;

	protected String key;

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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param img the img to set
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
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("key", key)
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



	@JsonIgnore
	public String getRequiredKey() {
		return key!=null ? key : normalize(name);
	}


	public static String normalize(String s) {
		if (s==null) {
			return null;
		}
		s = s.trim();
		s = s.replaceAll(" +", " ");
		s = s.toLowerCase();
		s = s.replace(' ', '-');
		return s;
	}
}
