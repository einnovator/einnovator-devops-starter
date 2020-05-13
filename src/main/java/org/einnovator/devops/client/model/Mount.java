package org.einnovator.devops.client.model;

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

	private String secretName;

	private String configmapName;

	private String volumePath;

	private String size;
	
	private String mode;

	private String storageClass;
	
	private ReclaimType reclaim;

	private Boolean newVolume;

	private String volc;

	private VolumeClaim claim;

	private Volume volume;

	private Secret secret;

	private Boolean remove;


	/**
	 * Create instance of {@code Mount}.
	 *
	 */
	public Mount() {
	}


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
	 * @param type the type to set
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
	 * @param mountPath the mountPath to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param volumePath the volumePath to set
	 */
	public void setVolumePath(String volumePath) {
		this.volumePath = volumePath;
	}

	/**
	 * Get the value of property {@code secretName}.
	 *
	 * @return the secretName
	 */
	public String getSecretName() {
		return secretName;
	}

	/**
	 * Get the value of property {@code configmapName}.
	 *
	 * @return the configmapName
	 */
	public String getConfigmapName() {
		return configmapName;
	}

	/**
	 * Set the value of property {@code configmapName}.
	 *
	 * @param configmapName the configmapName to set
	 */
	public void setConfigmapName(String configmapName) {
		this.configmapName = configmapName;
	}

	/**
	 * Set the value of property {@code secretName}.
	 *
	 * @param secretName the secretName to set
	 */
	public void setSecretName(String secretName) {
		this.secretName = secretName;
	}

	/**
	 * Get the value of property {@code claim}.
	 *
	 * @return the claim
	 */
	public VolumeClaim getClaim() {
		return claim;
	}

	/**
	 * Set the value of property {@code claim}.
	 *
	 * @param claim the claim to set
	 */
	public void setClaim(VolumeClaim claim) {
		this.claim = claim;
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
	 * Get the value of property {@code secret}.
	 *
	 * @return the secret
	 */
	public Secret getSecret() {
		return secret;
	}

	/**
	 * Set the value of property {@code secret}.
	 *
	 * @param secret the secret to set
	 */
	public void setSecret(Secret secret) {
		this.secret = secret;
	}

	/**
	 * Get the value of property {@code reclaim}.
	 *
	 * @return the reclaim
	 */
	public ReclaimType getReclaim() {
		return reclaim;
	}

	/**
	 * Set the value of property {@code reclaim}.
	 *
	 * @param reclaim the reclaim to set
	 */
	public void setReclaim(ReclaimType reclaim) {
		this.reclaim = reclaim;
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
	 * @param newVolume the newVolume to set
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
	 * @param volc the volc to set
	 */
	public void setVolc(String volc) {
		this.volc = volc;
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
	 * @param remove the remove to set
	 */
	public void setRemove(Boolean remove) {
		this.remove = remove;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("name", name)
				.append("mountPath", mountPath)
				.append("secretName", secretName)
				.append("configmapName", configmapName)
				.append("reclaim", reclaim)
				.append("size", size)
				.append("storageClass", storageClass)
				.append("mode", mode)
				.append("volumePath", volumePath)
				.append("newVolume", newVolume)
				.append("remove", remove)
				.append("volc", volc)

				;
	}


}
