package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VolumeClaim extends OwnedEntity {

	private String namespace;
	
	private String volumeName;
	
	private String mode;

	private String storageClass;

	private String size;

	private Volume volume;
	

	public VolumeClaim() {
	}

	
	/**
	 * Get the value of property {@code volume}.
	 *
	 * @return the volume
	 */
	public Volume getVolume() {
		return volume;
	}


	/**
	 * Set the value of property {@code volume}.
	 *
	 * @param volume the volume to set
	 */
	public void setVolume(Volume volume) {
		this.volume = volume;
	}


	/**
	 * Get the value of property {@code namespace}.
	 *
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}


	/**
	 * Set the value of property {@code namespace}.
	 *
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}


	/**
	 * Get the value of property {@code volumeName}.
	 *
	 * @return the volumeName
	 */
	public String getVolumeName() {
		return volumeName;
	}


	/**
	 * Set the value of property {@code volumeName}.
	 *
	 * @param volumeName the volumeName to set
	 */
	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}


	/**
	 * Get the value of property {@code mode}.
	 *
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * Set the value of property {@code mode}.
	 *
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}


	/**
	 * Get the value of property {@code storageClass}.
	 *
	 * @return the storageClass
	 */
	public String getStorageClass() {
		return storageClass;
	}


	/**
	 * Set the value of property {@code storageClass}.
	 *
	 * @param storageClass the storageClass to set
	 */
	public void setStorageClass(String storageClass) {
		this.storageClass = storageClass;
	}


	/**
	 * Get the value of property {@code size}.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}


	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("volumeName", volumeName)
				.append("size", size)
				.append("mode", mode)
				.append("storageClass", storageClass)
				.append("namespace", namespace)
				.append("volume", volume)
				;
	}
	
	
}
