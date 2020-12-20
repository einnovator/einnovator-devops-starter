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
public class Pod extends NamedEntity {

	private DeploymentStatus status;

	private Integer index;
	
	private Endpoint endpoint;

	private Resources resources;

	private String reason;
	
	private Map<String, Object> meta;

	private String startedAtFormatted;
	
	private Date startedAt;

	private String finishedAtFormatted;
	
	private Date finishedAt;

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
	 * @param status the status to set
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
	 * @param index the index to set
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
	 * @param endpoint the endpoint to set
	 */
	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	/**
	 * Get the value of property {@code resources}.
	 *
	 * @return the resources
	 */
	public Resources getResources() {
		return resources;
	}

	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the resources to set
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
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
	 * @param reason the reason to set
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
	 * @param meta the meta to set
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
	 * @param startedAtFormatted the startedAtFormatted to set
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
	 * @param startedAt the startedAt to set
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
	 * @param finishedAtFormatted the finishedAtFormatted to set
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
	 * @param finishedAt the finishedAt to set
	 */
	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
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
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("reason", reason)
				.append("index", index)
				.append("endpoint", endpoint)
				.append("resources", resources)
				;
	}

}
