package org.einnovator.devops.client.model;

import java.math.BigDecimal;

import org.einnovator.util.StringUtil;
import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeSpec extends ObjectBase {

	private String name;

	private String displayName;

	private String type;

	private Integer vcpu;

	private Integer cpu;
	
	private Integer gpu;

	private Integer creditsHour;

	private Integer mem;

	private String storageType;

	private Integer disks;

	private Integer storage;

	private Boolean ssd;

	private Integer bandwidth;

	private Integer eni;
	
	private Integer ips;
	
	private BigDecimal price;

	private String currency;
	
	private boolean k8s;

	//
	// Constructors
	//

	/**
	 * Create instance of {@code NodeType}.
	 *
	 */
	public NodeSpec() {
	}

	//
	// Getter/Setter
	//
	
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
	 * Get the value of property {@code displayName}.
	 *
	 * @return the value of {@code displayName}
	 */
	public String getDisplayName() {
		return displayName;
	}
	
	/**
	 * Set the value of property {@code displayName}.
	 *
	 * @param displayName the value of {@code displayName}
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonIgnore
	public String getRequiredDisplayName() {
		return StringUtil.hasText(displayName) ? displayName : name;
	}

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
	 * Get the value of property {@code vcpu}.
	 *
	 * @return the value of {@code vcpu}
	 */
	public Integer getVcpu() {
		return vcpu;
	}

	/**
	 * Set the value of property {@code vcpu}.
	 *
	 * @param vcpu the value of {@code vcpu}
	 */
	public void setVcpu(Integer vcpu) {
		this.vcpu = vcpu;
	}

	/**
	 * Get the value of property {@code cpu}.
	 *
	 * @return the value of {@code cpu}
	 */
	public Integer getCpu() {
		return cpu;
	}

	/**
	 * Set the value of property {@code cpu}.
	 *
	 * @param cpu the value of {@code cpu}
	 */
	public void setCpu(Integer cpu) {
		this.cpu = cpu;
	}

	/**
	 * Get the value of property {@code creditsHour}.
	 *
	 * @return the value of {@code creditsHour}
	 */
	public Integer getCreditsHour() {
		return creditsHour;
	}

	/**
	 * Set the value of property {@code creditsHour}.
	 *
	 * @param creditsHour the value of {@code creditsHour}
	 */
	public void setCreditsHour(Integer creditsHour) {
		this.creditsHour = creditsHour;
	}

	/**
	 * Get the value of property {@code mem}.
	 *
	 * @return the value of {@code mem}
	 */
	public Integer getMem() {
		return mem;
	}

	/**
	 * Set the value of property {@code mem}.
	 *
	 * @param mem the value of {@code mem}
	 */
	public void setMem(Integer mem) {
		this.mem = mem;
	}

	/**
	 * Get the value of property {@code storageType}.
	 *
	 * @return the value of {@code storageType}
	 */
	public String getStorageType() {
		return storageType;
	}

	/**
	 * Set the value of property {@code storageType}.
	 *
	 * @param storageType the value of {@code storageType}
	 */
	public void setStorageType(String storageType) {
		this.storageType = storageType;
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
	 * Get the value of property {@code ssd}.
	 *
	 * @return the value of {@code ssd}
	 */
	public Boolean getSsd() {
		return ssd;
	}

	/**
	 * Set the value of property {@code ssd}.
	 *
	 * @param ssd the value of {@code ssd}
	 */
	public void setSsd(Boolean ssd) {
		this.ssd = ssd;
	}

	/**
	 * Get the value of property {@code bandwidth}.
	 *
	 * @return the value of {@code bandwidth}
	 */
	public Integer getBandwidth() {
		return bandwidth;
	}

	/**
	 * Set the value of property {@code bandwidth}.
	 *
	 * @param bandwidth the value of {@code bandwidth}
	 */
	public void setBandwidth(Integer bandwidth) {
		this.bandwidth = bandwidth;
	}

	/**
	 * Get the value of property {@code price}.
	 *
	 * @return the value of {@code price}
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Set the value of property {@code price}.
	 *
	 * @param price the value of {@code price}
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the value of {@code currency}
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the value of {@code currency}
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Get the value of property {@code gpu}.
	 *
	 * @return the value of {@code gpu}
	 */
	public Integer getGpu() {
		return gpu;
	}

	/**
	 * Set the value of property {@code gpu}.
	 *
	 * @param gpu the value of {@code gpu}
	 */
	public void setGpu(Integer gpu) {
		this.gpu = gpu;
	}

	/**
	 * Get the value of property {@code k8s}.
	 *
	 * @return the value of {@code k8s}
	 */
	public boolean isK8s() {
		return k8s;
	}

	/**
	 * Set the value of property {@code k8s}.
	 *
	 * @param k8s the value of {@code k8s}
	 */
	public void setK8s(boolean k8s) {
		this.k8s = k8s;
	}

	/**
	 * Get the value of property {@code eni}.
	 *
	 * @return the value of {@code eni}
	 */
	public Integer getEni() {
		return eni;
	}

	/**
	 * Set the value of property {@code eni}.
	 *
	 * @param eni the value of {@code eni}
	 */
	public void setEni(Integer eni) {
		this.eni = eni;
	}

	/**
	 * Get the value of property {@code ips}.
	 *
	 * @return the value of {@code ips}
	 */
	public Integer getIps() {
		return ips;
	}

	/**
	 * Set the value of property {@code ips}.
	 *
	 * @param ips the value of {@code ips}
	 */
	public void setIps(Integer ips) {
		this.ips = ips;
	}

	/**
	 * Get the value of property {@code disks}.
	 *
	 * @return the value of {@code disks}
	 */
	public Integer getDisks() {
		return disks;
	}

	/**
	 * Set the value of property {@code disks}.
	 *
	 * @param disks the value of {@code disks}
	 */
	public void setDisks(Integer disks) {
		this.disks = disks;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("displayName", displayName)
				.append("type", type)
				.append("vcpu", vcpu)
				.append("cpu", cpu)
				.append("gpu", gpu)
				.append("creditsHour", creditsHour)
				.append("mem", mem)
				.append("storageType", storageType)
				.append("storage", storage)
				.append("disks", disks)
				.append("ssd", ssd)
				.append("bandwidth", bandwidth)
				.append("eni", eni)
				.append("ips", ips)
				.append("price", price)
				.append("currency", currency)
				.append("k8s", k8s)
				;
	}
}
