package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image extends ObjectBase {

	private String name;
	
	private ImageType type;

	private String registryId;
	
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
	 * @param type the type
	 */
	public void setType(ImageType type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the value of {@code name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the value of {@code name}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code registryId}.
	 *
	 * @return the value of {@code registryId}
	 */
	public String getRegistryId() {
		return registryId;
	}

	/**
	 * Set the value of property {@code registryId}.
	 *
	 * @param registryId the value of {@code registryId}
	 */
	public void setRegistryId(String registryId) {
		this.registryId = registryId;
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
	 * @param registry the registry
	 */
	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("name", name)
			.append("type", type)
			.append("registryId", registryId)
			.append("registry", registry)
			;
	}
	
	
}
