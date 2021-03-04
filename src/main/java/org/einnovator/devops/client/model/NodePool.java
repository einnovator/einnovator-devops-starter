package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodePool extends AnnotatedEntity {

	private NodeStatus status;

	private String providerStatus;

	private String message;
	
	private Integer size;

	private Integer minSize;

	private Integer maxSize;

	private Integer storage;

	private String type;

	private List<NodeSpec> nodeSpecs;

	private String version;
	
	private List<Issue> issues;

	private Boolean autohealing;
	private Boolean autoscaling;
	private Boolean autoupgrade;
	
	private String os;
	private String image;
	private String containerRuntime;

	private String network;
	private List<String> subnets;
	
	private String role;
	

	//
	// Constructors
	//

	public NodePool() {
	}

	//
	// Getter/Setter
	//
	
	/**
	 * Get the value of property {@code size}.
	 *
	 * @return the value of {@code size}
	 */
	public Integer getSize() {
		return size;
	}


	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the value of {@code size}
	 */
	public void setSize(Integer size) {
		this.size = size;
	}


	/**
	 * Get the value of property {@code minSize}.
	 *
	 * @return the value of {@code minSize}
	 */
	public Integer getMinSize() {
		return minSize;
	}


	/**
	 * Set the value of property {@code minSize}.
	 *
	 * @param minSize the value of {@code minSize}
	 */
	public void setMinSize(Integer minSize) {
		this.minSize = minSize;
	}


	/**
	 * Get the value of property {@code maxSize}.
	 *
	 * @return the value of {@code maxSize}
	 */
	public Integer getMaxSize() {
		return maxSize;
	}


	/**
	 * Set the value of property {@code maxSize}.
	 *
	 * @param maxSize the value of {@code maxSize}
	 */
	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
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
	 * Get the value of property {@code version}.
	 *
	 * @return the value of {@code version}
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Set the value of property {@code version}.
	 *
	 * @param version the value of {@code version}
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * Get the value of property {@code issues}.
	 *
	 * @return the value of {@code issues}
	 */
	public List<Issue> getIssues() {
		return issues;
	}

	/**
	 * Set the value of property {@code issues}.
	 *
	 * @param issues the value of {@code issues}
	 */
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	/**
	 * Get the value of property {@code nodeSpecs}.
	 *
	 * @return the value of {@code nodeSpecs}
	 */
	public List<NodeSpec> getNodeSpecs() {
		return nodeSpecs;
	}

	/**
	 * Set the value of property {@code nodeSpecs}.
	 *
	 * @param nodeSpecs the value of {@code nodeSpecs}
	 */
	public void setNodeSpecs(List<NodeSpec> nodeSpecs) {
		this.nodeSpecs = nodeSpecs;
	}

	/**
	 * Get the value of property {@code subnets}.
	 *
	 * @return the value of {@code subnets}
	 */
	public List<String> getSubnets() {
		return subnets;
	}

	/**
	 * Set the value of property {@code subnets}.
	 *
	 * @param subnets the value of {@code subnets}
	 */
	public void setSubnets(List<String> subnets) {
		this.subnets = subnets;
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
	 * Get the value of property {@code autohealing}.
	 *
	 * @return the value of {@code autohealing}
	 */
	public Boolean getAutohealing() {
		return autohealing;
	}

	/**
	 * Set the value of property {@code autohealing}.
	 *
	 * @param autohealing the value of {@code autohealing}
	 */
	public void setAutohealing(Boolean autohealing) {
		this.autohealing = autohealing;
	}

	/**
	 * Get the value of property {@code autoscaling}.
	 *
	 * @return the value of {@code autoscaling}
	 */
	public Boolean getAutoscaling() {
		return autoscaling;
	}

	/**
	 * Get the value of property {@code autoupgrade}.
	 *
	 * @return the value of {@code autoupgrade}
	 */
	public Boolean getAutoupgrade() {
		return autoupgrade;
	}

	/**
	 * Set the value of property {@code autoupgrade}.
	 *
	 * @param autoupgrade the value of {@code autoupgrade}
	 */
	public void setAutoupgrade(Boolean autoupgrade) {
		this.autoupgrade = autoupgrade;
	}

	/**
	 * Set the value of property {@code autoscaling}.
	 *
	 * @param autoscaling the value of {@code autoscaling}
	 */
	public void setAutoscaling(Boolean autoscaling) {
		this.autoscaling = autoscaling;
	}

	/**
	 * Get the value of property {@code os}.
	 *
	 * @return the value of {@code os}
	 */
	public String getOs() {
		return os;
	}

	/**
	 * Set the value of property {@code os}.
	 *
	 * @param os the value of {@code os}
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * Get the value of property {@code image}.
	 *
	 * @return the value of {@code image}
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the value of {@code image}
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Get the value of property {@code containerRuntime}.
	 *
	 * @return the value of {@code containerRuntime}
	 */
	public String getContainerRuntime() {
		return containerRuntime;
	}

	/**
	 * Set the value of property {@code containerRuntime}.
	 *
	 * @param containerRuntime the value of {@code containerRuntime}
	 */
	public void setContainerRuntime(String containerRuntime) {
		this.containerRuntime = containerRuntime;
	}

	public void addIssue(Issue issue) {
		if (issues==null) {
			issues = new ArrayList<>();
		}
		issues.add(issue);
	}

	@JsonIgnore
	public String getRequiredType() {
		if (nodeSpecs!=null && nodeSpecs.size()>0) {
			return nodeSpecs.get(0).getType()!=null ? nodeSpecs.get(0).getType() : nodeSpecs.get(0).getName();
		}
		if (StringUtils.hasText(type)) {
			return type;
		}
		return null; 
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

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("nodeSpecs", nodeSpecs)
				.append("status", status)
				.append("providerStatus", providerStatus)
				.append("message", message)
				.append("size", size)
				.append("minSize", minSize)
				.append("maxSize", maxSize)
				.append("type", type)
				.append("storage", storage)
				.append("os", os)
				.append("image", image)
				.append("version", version)
				.append("autohealing", autohealing)
				.append("autoscaling", autoscaling)
				.append("autoupgrade", autoupgrade)
				.append("containerRuntime", containerRuntime)
				.append("network", network)
				.append("subnets", subnets)
				.append("role", role)
				;
	}

	
}
