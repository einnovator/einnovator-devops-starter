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

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("uri", uri)
				;
	}
	

	
}
