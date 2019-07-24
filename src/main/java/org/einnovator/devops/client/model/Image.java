package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image extends NamedEntity {

	private ImageType type;

	private String uri;

	private Registry registry;
	
	public Image() {
	}

	public Image(Object obj) {
		super(obj);
	}


	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public ImageType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(ImageType type) {
		this.type = type;
	}

	

	/**
	 * Get the value of property {@code registry}.
	 *
	 * @return the registry
	 */
	public Registry getRegistry() {
		return registry;
	}


	/**
	 * Set the value of property {@code registry}.
	 *
	 * @param registry the registry to set
	 */
	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	//yml config hack
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("uri", uri)
				;
	}
	

	
}
