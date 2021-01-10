package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Build extends NamedEntity {

	private String status;

	private String message;

	private String shortMessage;

	private String pod;

	private String step;

	private String container;

	private String startTime;

	private String endTime;

	private String startAge;

	private String endAge;

	private String duration;

	private Workspace workspace;
	
	private String serviceAccountName;
	
	public Build() {
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the shortMessage
	 */
	public String getShortMessage() {
		return shortMessage;
	}

	/**
	 * @param shortMessage the shortMessage to set
	 */
	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}

	/**
	 * @return the pod
	 */
	public String getPod() {
		return pod;
	}

	/**
	 * @param pod the pod to set
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * @return the step
	 */
	public String getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(String step) {
		this.step = step;
	}

	/**
	 * @return the container
	 */
	public String getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(String container) {
		this.container = container;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	/**
	 * Get the value of property {@code startAge}.
	 *
	 * @return the value of {@code startAge}
	 */
	public String getStartAge() {
		return startAge;
	}

	/**
	 * Set the value of property {@code startAge}.
	 *
	 * @param startAge the value of {@code startAge}
	 */
	public void setStartAge(String startAge) {
		this.startAge = startAge;
	}

	/**
	 * Get the value of property {@code endAge}.
	 *
	 * @return the value of {@code endAge}
	 */
	public String getEndAge() {
		return endAge;
	}

	/**
	 * Set the value of property {@code endAge}.
	 *
	 * @param endAge the value of {@code endAge}
	 */
	public void setEndAge(String endAge) {
		this.endAge = endAge;
	}

	/**
	 * Get the value of property {@code duration}.
	 *
	 * @return the value of {@code duration}
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Set the value of property {@code duration}.
	 *
	 * @param duration the value of {@code duration}
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	/**
	 * Get the value of property {@code serviceAccountName}.
	 *
	 * @return the serviceAccountName
	 */
	public String getServiceAccountName() {
		return serviceAccountName;
	}

	/**
	 * Set the value of property {@code serviceAccountName}.
	 *
	 * @param serviceAccountName the value of property serviceAccountName
	 */
	public void setServiceAccountName(String serviceAccountName) {
		this.serviceAccountName = serviceAccountName;
	}

	/**
	 * Get the value of property {@code workspace}.
	 *
	 * @return the value of {@code workspace}
	 */
	public Workspace getWorkspace() {
		return workspace;
	}

	/**
	 * Set the value of property {@code workspace}.
	 *
	 * @param workspace the value of {@code workspace}
	 */
	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("serviceAccountName", serviceAccountName)
				.append("status", status)
				.append("message", message)
				.append("pod", pod)
				.append("step", step)
				.append("container", container)
				.append("startTime", startTime)
				.append("endTime", endTime)
				.append("startAge", startAge)
				.append("endAge", endAge)
				.append("duration", duration)
				;
	}
}
