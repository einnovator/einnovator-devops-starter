package org.einnovator.devops.client.model;

import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node extends AnnotatedEntity {

	private String type;

	private NodeStatus status;

	private String providerStatus;

	private String message;

	private Region region;

	private String providerRegion;

	private String imageId;

	private OSImage image;

	private String[] ips;

	private String[] ipv6;

	private String hypervisor;
	
	private Integer storage;

	private Integer memory;

	private Integer transfer;

	private Integer vcpus;

	private Integer cpus;

	private Integer gpus;

	private Boolean booted;

	private Boolean autobackup;

	private String backupId;

	private String scriptId;

	private Map<String,String> scriptData;

	private String group;
	
	private String network;
	
	private String role;

	private String rootPassword;

	private String key;

	private String keyId;
	
	private String project;

	private Map<String, Object> raw;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Node}.
	 *
	 */
	public Node() {
	}

	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the value of {@code type}
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of {@code type}
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * Get the value of property {@code ips}.
	 *
	 * @return the value of {@code ips}
	 */
	public String[] getIps() {
		return ips;
	}

	/**
	 * Set the value of property {@code ips}.
	 *
	 * @param ips the value of {@code ips}
	 */
	public void setIps(String[] ips) {
		this.ips = ips;
	}

	/**
	 * Get the value of property {@code ipv6}.
	 *
	 * @return the value of {@code ipv6}
	 */
	public String[] getIpv6() {
		return ipv6;
	}

	/**
	 * Set the value of property {@code ipv6}.
	 *
	 * @param ipv6 the value of {@code ipv6}
	 */
	public void setIpv6(String[] ipv6) {
		this.ipv6 = ipv6;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the value of {@code status}
	 */
	public NodeStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of {@code status}
	 */
	public void setStatus(NodeStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code providerStatus}.
	 *
	 * @return the value of {@code providerStatus}
	 */
	public String getProviderStatus() {
		return providerStatus;
	}

	/**
	 * Set the value of property {@code providerStatus}.
	 *
	 * @param providerStatus the value of {@code providerStatus}
	 */
	public void setProviderStatus(String providerStatus) {
		this.providerStatus = providerStatus;
	}

	/**
	 * Get the value of property {@code message}.
	 *
	 * @return the value of {@code message}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the value of property {@code message}.
	 *
	 * @param message the value of {@code message}
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the value of property {@code region}.
	 *
	 * @return the value of {@code region}
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the value of {@code region}
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Get the value of property {@code providerRegion}.
	 *
	 * @return the value of {@code providerRegion}
	 */
	public String getProviderRegion() {
		return providerRegion;
	}

	/**
	 * Set the value of property {@code providerRegion}.
	 *
	 * @param providerRegion the value of {@code providerRegion}
	 */
	public void setProviderRegion(String providerRegion) {
		this.providerRegion = providerRegion;
	}

	
	/**
	 * Get the value of property {@code imageId}.
	 *
	 * @return the value of {@code imageId}
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * Set the value of property {@code imageId}.
	 *
	 * @param imageId the value of {@code imageId}
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	/**
	 * Get the value of property {@code image}.
	 *
	 * @return the value of {@code image}
	 */
	public OSImage getImage() {
		return image;
	}

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the value of {@code image}
	 */
	public void setImage(OSImage image) {
		this.image = image;
	}

	/**
	 * Get the value of property {@code hypervisor}.
	 *
	 * @return the value of {@code hypervisor}
	 */
	public String getHypervisor() {
		return hypervisor;
	}

	/**
	 * Set the value of property {@code hypervisor}.
	 *
	 * @param hypervisor the value of {@code hypervisor}
	 */
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	/**
	 * Get the value of property {@code storage}.
	 *
	 * @return the value of {@code storage}
	 */
	public Integer getStorage() {
		return storage;
	}

	/**
	 * Set the value of property {@code storage}.
	 *
	 * @param storage the value of {@code storage}
	 */
	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	/**
	 * Get the value of property {@code memory}.
	 *
	 * @return the value of {@code memory}
	 */
	public Integer getMemory() {
		return memory;
	}

	/**
	 * Set the value of property {@code memory}.
	 *
	 * @param memory the value of {@code memory}
	 */
	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	/**
	 * Get the value of property {@code transfer}.
	 *
	 * @return the value of {@code transfer}
	 */
	public Integer getTransfer() {
		return transfer;
	}

	/**
	 * Set the value of property {@code transfer}.
	 *
	 * @param transfer the value of {@code transfer}
	 */
	public void setTransfer(Integer transfer) {
		this.transfer = transfer;
	}

	/**
	 * Get the value of property {@code vcpus}.
	 *
	 * @return the value of {@code vcpus}
	 */
	public Integer getVcpus() {
		return vcpus;
	}

	/**
	 * Set the value of property {@code vcpus}.
	 *
	 * @param vcpus the value of {@code vcpus}
	 */
	public void setVcpus(Integer vcpus) {
		this.vcpus = vcpus;
	}

	/**
	 * Get the value of property {@code cpus}.
	 *
	 * @return the value of {@code cpus}
	 */
	public Integer getCpus() {
		return cpus;
	}

	/**
	 * Set the value of property {@code cpus}.
	 *
	 * @param cpus the value of {@code cpus}
	 */
	public void setCpus(Integer cpus) {
		this.cpus = cpus;
	}

	/**
	 * Get the value of property {@code gpus}.
	 *
	 * @return the value of {@code gpus}
	 */
	public Integer getGpus() {
		return gpus;
	}

	/**
	 * Set the value of property {@code gpus}.
	 *
	 * @param gpus the value of {@code gpus}
	 */
	public void setGpus(Integer gpus) {
		this.gpus = gpus;
	}

	/**
	 * Get the value of property {@code booted}.
	 *
	 * @return the value of {@code booted}
	 */
	public Boolean getBooted() {
		return booted;
	}

	/**
	 * Set the value of property {@code booted}.
	 *
	 * @param booted the value of {@code booted}
	 */
	public void setBooted(Boolean booted) {
		this.booted = booted;
	}

	/**
	 * Get the value of property {@code autobackup}.
	 *
	 * @return the value of {@code autobackup}
	 */
	public Boolean getAutobackup() {
		return autobackup;
	}

	/**
	 * Set the value of property {@code autobackup}.
	 *
	 * @param autobackup the value of {@code autobackup}
	 */
	public void setAutobackup(Boolean autobackup) {
		this.autobackup = autobackup;
	}

	/**
	 * Get the value of property {@code backupId}.
	 *
	 * @return the value of {@code backupId}
	 */
	public String getBackupId() {
		return backupId;
	}

	/**
	 * Set the value of property {@code backupId}.
	 *
	 * @param backupId the value of {@code backupId}
	 */
	public void setBackupId(String backupId) {
		this.backupId = backupId;
	}

	/**
	 * Get the value of property {@code scriptId}.
	 *
	 * @return the value of {@code scriptId}
	 */
	public String getScriptId() {
		return scriptId;
	}

	/**
	 * Set the value of property {@code scriptId}.
	 *
	 * @param scriptId the value of {@code scriptId}
	 */
	public void setScriptId(String scriptId) {
		this.scriptId = scriptId;
	}

	/**
	 * Get the value of property {@code scriptData}.
	 *
	 * @return the value of {@code scriptData}
	 */
	public Map<String, String> getScriptData() {
		return scriptData;
	}

	/**
	 * Set the value of property {@code scriptData}.
	 *
	 * @param scriptData the value of {@code scriptData}
	 */
	public void setScriptData(Map<String, String> scriptData) {
		this.scriptData = scriptData;
	}

	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the value of {@code group}
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the value of {@code group}
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Get the value of property {@code rootPassword}.
	 *
	 * @return the value of {@code rootPassword}
	 */
	public String getRootPassword() {
		return rootPassword;
	}

	/**
	 * Set the value of property {@code rootPassword}.
	 *
	 * @param rootPassword the value of {@code rootPassword}
	 */
	public void setRootPassword(String rootPassword) {
		this.rootPassword = rootPassword;
	}

	/**
	 * Get the value of property {@code network}.
	 *
	 * @return the value of {@code network}
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * Set the value of property {@code network}.
	 *
	 * @param network the value of {@code network}
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * Get the value of property {@code role}.
	 *
	 * @return the value of {@code role}
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Set the value of property {@code role}.
	 *
	 * @param role the value of {@code role}
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Get the value of property {@code key}.
	 *
	 * @return the value of {@code key}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the value of {@code key}
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the value of property {@code keyId}.
	 *
	 * @return the value of {@code keyId}
	 */
	public String getKeyId() {
		return keyId;
	}

	/**
	 * Set the value of property {@code keyId}.
	 *
	 * @param keyId the value of {@code keyId}
	 */
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	/**
	 * Get the value of property {@code project}.
	 *
	 * @return the value of {@code project}
	 */
	public String getProject() {
		return project;
	}

	/**
	 * Set the value of property {@code project}.
	 *
	 * @param project the value of {@code project}
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Get the value of property {@code raw}.
	 *
	 * @return the value of {@code raw}
	 */
	public Map<String, Object> getRaw() {
		return raw;
	}

	/**
	 * Set the value of property {@code raw}.
	 *
	 * @param raw the value of {@code raw}
	 */
	public void setRaw(Map<String, Object> raw) {
		this.raw = raw;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("providerStatus", providerStatus)
				.append("message", message)
				.append("type", type)
				.append("status", status)
				.append("region", region)
				.append("region", providerRegion)
				.append("imageId", imageId)
				.append("image", image)
				.append("ips", ips)
				.append("ipv6", ipv6)
				.append("hypervisor", hypervisor)
				.append("storage", storage)
				.append("memory", memory)
				.append("transfer", transfer)
				.append("vcpus", vcpus)
				.append("cpus", cpus)
				.append("gpus", gpus)
				.append("vcpus", vcpus)
				.append("booted", booted)
				.append("autobackup", autobackup)
				.append("backupId", backupId)
				.append("scriptId", scriptId)
				.append("scriptData", scriptData)
				.append("group", group)
				.append("network", network)
				.append("role", role)
				.append("keyId", keyId)
				.append("key", key!=null ? "****" : null)
				.append("rootPassword", rootPassword!=null ? "****" : null)
				;
	}
	

	
}
