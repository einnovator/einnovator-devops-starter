/**
 * 
 */
package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A {@code Probe}.
 *
 * @author support@einnovator.org
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Probe extends ObjectBase {

	private List<String> exec;

	private Integer initialDelaySeconds;

	private Integer periodSeconds;

	private Integer timeoutSeconds;

	private Integer successThreshold;

	private Integer failureThreshold;
		
	/**
	 * Create instance of {@code Probe}.
	 *
	 */
	public Probe() {
	}

	/**
	 * Get the value of property {@code exec}.
	 *
	 * @return the exec
	 */
	public List<String> getExec() {
		return exec;
	}

	/**
	 * Set the value of property {@code exec}.
	 *
	 * @param exec the value of property exec
	 */
	public void setExec(List<String> exec) {
		this.exec = exec;
	}

	@JsonIgnore
	public String getExecAsString() {
		if (exec==null || exec.isEmpty() || exec.get(0)==null || !StringUtils.hasText(exec.get(0))) {
			return null;
		}
		String s = String.join(" ", exec);
		s = s.trim();
		return s;
	}

	@JsonIgnore
	public void setExecAsString(String s) {
		if (!StringUtils.hasText(s)) {
			exec = null;
		}
		s = s.trim();
		String[] a = s.split(" ");
		this.exec = new ArrayList<>(Arrays.asList(a));
	}
	
	/**
	 * Get the value of property {@code initialDelaySeconds}.
	 *
	 * @return the initialDelaySeconds
	 */
	public Integer getInitialDelaySeconds() {
		return initialDelaySeconds;
	}

	/**
	 * Set the value of property {@code initialDelaySeconds}.
	 *
	 * @param initialDelaySeconds the value of property initialDelaySeconds
	 */
	public void setInitialDelaySeconds(Integer initialDelaySeconds) {
		this.initialDelaySeconds = initialDelaySeconds;
	}

	/**
	 * Get the value of property {@code periodSeconds}.
	 *
	 * @return the periodSeconds
	 */
	public Integer getPeriodSeconds() {
		return periodSeconds;
	}

	/**
	 * Set the value of property {@code periodSeconds}.
	 *
	 * @param periodSeconds the value of property periodSeconds
	 */
	public void setPeriodSeconds(Integer periodSeconds) {
		this.periodSeconds = periodSeconds;
	}

	/**
	 * Get the value of property {@code timeoutSeconds}.
	 *
	 * @return the timeoutSeconds
	 */
	public Integer getTimeoutSeconds() {
		return timeoutSeconds;
	}

	/**
	 * Set the value of property {@code timeoutSeconds}.
	 *
	 * @param timeoutSeconds the value of property timeoutSeconds
	 */
	public void setTimeoutSeconds(Integer timeoutSeconds) {
		this.timeoutSeconds = timeoutSeconds;
	}
	
	/**
	 * Get the value of property {@code successThreshold}.
	 *
	 * @return the successThreshold
	 */
	public Integer getSuccessThreshold() {
		return successThreshold;
	}

	/**
	 * Set the value of property {@code successThreshold}.
	 *
	 * @param successThreshold the value of property successThreshold
	 */
	public void setSuccessThreshold(Integer successThreshold) {
		this.successThreshold = successThreshold;
	}

	/**
	 * Get the value of property {@code failureThreshold}.
	 *
	 * @return the failureThreshold
	 */
	public Integer getFailureThreshold() {
		return failureThreshold;
	}

	/**
	 * Set the value of property {@code failureThreshold}.
	 *
	 * @param failureThreshold the value of property failureThreshold
	 */
	public void setFailureThreshold(Integer failureThreshold) {
		this.failureThreshold = failureThreshold;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("exec", exec)
				.append("initialDelaySeconds", initialDelaySeconds)
				.append("periodSeconds", periodSeconds)
				.append("timeoutSeconds", timeoutSeconds)
				.append("successThreshold", successThreshold)
				.append("failureThreshold", failureThreshold)
				);
	}

}
