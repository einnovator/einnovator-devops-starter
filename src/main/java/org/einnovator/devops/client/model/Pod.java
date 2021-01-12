package org.einnovator.devops.client.model;

import java.util.Date;
import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A {@code Pod} is a unit of {@code Deployment}.
 *
 * @author support@einnovator.org
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pod extends DeploymentBase {

	private DeploymentStatus status;

	private Integer index;
	
	private Endpoint endpoint;

	private String reason;
	
	private Map<String, Object> meta;

	private String startedAtFormatted;
	
	private Date startedAt;

	private String finishedAtFormatted;
	
	private Date finishedAt;

	private Integer restarts;

	private Integer containers;
	
	private Integer readyContainers;
	
	private Bill bill;

	public Pod() {
	}


	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public DeploymentStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code index}.
	 *
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * Set the value of property {@code index}.
	 *
	 * @param index the index
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * Get the value of property {@code endpoint}.
	 *
	 * @return the endpoint
	 */
	public Endpoint getEndpoint() {
		return endpoint;
	}

	/**
	 * Set the value of property {@code endpoint}.
	 *
	 * @param endpoint the endpoint
	 */
	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	/**
	 * Get the value of property {@code reason}.
	 *
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Set the value of property {@code reason}.
	 *
	 * @param reason the reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * Get the value of property {@code meta}.
	 *
	 * @return the meta
	 */
	public Map<String, Object> getMeta() {
		return meta;
	}


	/**
	 * Set the value of property {@code meta}.
	 *
	 * @param meta the meta
	 */
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	/**
	 * Get the value of property {@code startedAtFormatted}.
	 *
	 * @return the startedAtFormatted
	 */
	public String getStartedAtFormatted() {
		return startedAtFormatted;
	}

	/**
	 * Set the value of property {@code startedAtFormatted}.
	 *
	 * @param startedAtFormatted the startedAtFormatted
	 */
	public void setStartedAtFormatted(String startedAtFormatted) {
		this.startedAtFormatted = startedAtFormatted;
	}

	/**
	 * Get the value of property {@code startedAt}.
	 *
	 * @return the startedAt
	 */
	public Date getStartedAt() {
		return startedAt;
	}

	/**
	 * Set the value of property {@code startedAt}.
	 *
	 * @param startedAt the startedAt
	 */
	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	/**
	 * Get the value of property {@code finishedAtFormatted}.
	 *
	 * @return the finishedAtFormatted
	 */
	public String getFinishedAtFormatted() {
		return finishedAtFormatted;
	}

	/**
	 * Set the value of property {@code finishedAtFormatted}.
	 *
	 * @param finishedAtFormatted the finishedAtFormatted
	 */
	public void setFinishedAtFormatted(String finishedAtFormatted) {
		this.finishedAtFormatted = finishedAtFormatted;
	}


	/**
	 * Get the value of property {@code finishedAt}.
	 *
	 * @return the finishedAt
	 */
	public Date getFinishedAt() {
		return finishedAt;
	}

	/**
	 * Set the value of property {@code finishedAt}.
	 *
	 * @param finishedAt the finishedAt
	 */
	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	/**
	 * Get the value of property {@code restarts}.
	 *
	 * @return the value of {@code restarts}
	 */
	public Integer getRestarts() {
		return restarts;
	}


	/**
	 * Set the value of property {@code restarts}.
	 *
	 * @param restarts the value of {@code restarts}
	 */
	public void setRestarts(Integer restarts) {
		this.restarts = restarts;
	}


	/**
	 * Get the value of property {@code containers}.
	 *
	 * @return the value of {@code containers}
	 */
	public Integer getContainers() {
		return containers;
	}


	/**
	 * Set the value of property {@code containers}.
	 *
	 * @param containers the value of {@code containers}
	 */
	public void setContainers(Integer containers) {
		this.containers = containers;
	}


	/**
	 * Get the value of property {@code readyContainers}.
	 *
	 * @return the value of {@code readyContainers}
	 */
	public Integer getReadyContainers() {
		return readyContainers;
	}


	/**
	 * Set the value of property {@code readyContainers}.
	 *
	 * @param readyContainers the value of {@code readyContainers}
	 */
	public void setReadyContainers(Integer readyContainers) {
		this.readyContainers = readyContainers;
	}


	/**
	 * Get the value of property {@code bill}.
	 *
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * Set the value of property {@code bill}.
	 *
	 * @param bill the bill
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("restarts", restarts)
				.append("containers", containers)
				.append("readyContainers", readyContainers)
				.append("status", status)
				.append("reason", reason)
				.append("index", index)
				.append("endpoint", endpoint)
				;
	}

}
