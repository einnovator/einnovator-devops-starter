package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mount extends EntityBase {


	private MountType type;
	
	private String mountPath;

	private String name;

	private String secret;

	private String configmap;

	private String volumePath;

	private String size;
	
	private String mode;

	private AccessMode accessMode;
	
	private String storageClass;
	
	private Boolean newVolume;

	private String volc;

	private List<KeyPath> items;

	private Boolean remove;

	private Boolean readonly;

	private Boolean optional;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Mount}.
	 *
	 */
	public Mount() {
	}

	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public MountType getType() {
		return type;
	}



	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 */
	public void setType(MountType type) {
		this.type = type;
	}



	/**
	 * Get the value of property {@code mountPath}.
	 *
	 * @return the mountPath
	 */
	public String getMountPath() {
		return mountPath;
	}



	/**
	 * Set the value of property {@code mountPath}.
	 *
	 * @param mountPath the value of property mountPath
	 */
	public void setMountPath(String mountPath) {
		this.mountPath = mountPath;
	}



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
	 * Get the value of property {@code secret}.
	 *
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}



	/**
	 * Set the value of property {@code secret}.
	 *
	 * @param secret the value of property secret
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}



	/**
	 * Get the value of property {@code configmap}.
	 *
	 * @return the configmap
	 */
	public String getConfigmap() {
		return configmap;
	}



	/**
	 * Set the value of property {@code configmap}.
	 *
	 * @param configmap the value of property configmap
	 */
	public void setConfigmap(String configmap) {
		this.configmap = configmap;
	}



	/**
	 * Get the value of property {@code volumePath}.
	 *
	 * @return the volumePath
	 */
	public String getVolumePath() {
		return volumePath;
	}



	/**
	 * Set the value of property {@code volumePath}.
	 *
	 * @param volumePath the value of property volumePath
	 */
	public void setVolumePath(String volumePath) {
		this.volumePath = volumePath;
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
	 * @param size the value of property size
	 */
	public void setSize(String size) {
		this.size = size;
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
	 * @param mode the value of property mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}



	/**
	 * Get the value of property {@code accessMode}.
	 *
	 * @return the accessMode
	 */
	public AccessMode getAccessMode() {
		return accessMode;
	}



	/**
	 * Set the value of property {@code accessMode}.
	 *
	 * @param accessMode the value of property accessMode
	 */
	public void setAccessMode(AccessMode accessMode) {
		this.accessMode = accessMode;
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
	 * @param storageClass the value of property storageClass
	 */
	public void setStorageClass(String storageClass) {
		this.storageClass = storageClass;
	}



	/**
	 * Get the value of property {@code newVolume}.
	 *
	 * @return the newVolume
	 */
	public Boolean getNewVolume() {
		return newVolume;
	}



	/**
	 * Set the value of property {@code newVolume}.
	 *
	 * @param newVolume the value of property newVolume
	 */
	public void setNewVolume(Boolean newVolume) {
		this.newVolume = newVolume;
	}



	/**
	 * Get the value of property {@code volc}.
	 *
	 * @return the volc
	 */
	public String getVolc() {
		return volc;
	}



	/**
	 * Set the value of property {@code volc}.
	 *
	 * @param volc the value of property volc
	 */
	public void setVolc(String volc) {
		this.volc = volc;
	}



	/**
	 * Get the value of property {@code items}.
	 *
	 * @return the items
	 */
	public List<KeyPath> getItems() {
		return items;
	}



	/**
	 * Set the value of property {@code items}.
	 *
	 * @param items the value of property items
	 */
	public void setItems(List<KeyPath> items) {
		this.items = items;
	}



	/**
	 * Get the value of property {@code remove}.
	 *
	 * @return the remove
	 */
	public Boolean getRemove() {
		return remove;
	}



	/**
	 * Set the value of property {@code remove}.
	 *
	 * @param remove the value of property remove
	 */
	public void setRemove(Boolean remove) {
		this.remove = remove;
	}



	/**
	 * Get the value of property {@code readonly}.
	 *
	 * @return the readonly
	 */
	public Boolean getReadonly() {
		return readonly;
	}



	/**
	 * Set the value of property {@code readonly}.
	 *
	 * @param readonly the value of property readonly
	 */
	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}



	/**
	 * Get the value of property {@code optional}.
	 *
	 * @return the optional
	 */
	public Boolean getOptional() {
		return optional;
	}



	/**
	 * Set the value of property {@code optional}.
	 *
	 * @param optional the value of property optional
	 */
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}



	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("name", name)
				.append("mountPath", mountPath)
				.append("secret", secret)
				.append("configmap", configmap)
				.append("size", size)
				.append("storageClass", storageClass)
				.append("accessMode", accessMode)
				.append("mode", mode)
				.append("volumePath", volumePath)
				.append("newVolume", newVolume)
				.append("items", items)
				.append("optional", optional)
				.append("remove", remove)
				.append("volc", volc)

				;
	}


}
