/**
 * 
 */
package org.einnovator.devops.client.model;

import java.util.Map;

import org.einnovator.util.MappingUtils;
import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A {@code Strategy}.
 *
 * @author support@einnovator.org
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Strategy extends ObjectBase {

	private DeploymentStrategy strategy;
	private String maxSurge;
	private String maxUnavailable;

	
	/**
	 * Create instance of {@code Probe}.
	 *
	 */
	public Strategy() {
	}

	/**
	 * Get the value of property {@code strategy}.
	 *
	 * @return the strategy
	 */
	public DeploymentStrategy getStrategy() {
		return strategy;
	}

	@JsonIgnore
	public DeploymentStrategy getRequiredStrategy() {
		return strategy!=null ? strategy : DeploymentStrategy.ROLLING_UPDATE;
	}

	/**
	 * Set the value of property {@code strategy}.
	 *
	 * @param strategy the value of property strategy
	 */
	public void setStrategy(DeploymentStrategy strategy) {
		this.strategy = strategy;
	}
	/**
	 * Get the value of property {@code maxSurge}.
	 *
	 * @return the maxSurge
	 */
	public String getMaxSurge() {
		return maxSurge;
	}

	/**
	 * Set the value of property {@code maxSurge}.
	 *
	 * @param maxSurge the value of property maxSurge
	 */
	public void setMaxSurge(String maxSurge) {
		this.maxSurge = maxSurge;
	}

	/**
	 * Get the value of property {@code maxUnavailable}.
	 *
	 * @return the maxUnavailable
	 */
	public String getMaxUnavailable() {
		return maxUnavailable;
	}

	/**
	 * Set the value of property {@code maxUnavailable}.
	 *
	 * @param maxUnavailable the value of property maxUnavailable
	 */
	public void setMaxUnavailable(String maxUnavailable) {
		this.maxUnavailable = maxUnavailable;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("strategy", strategy)
				.append("maxSurge", maxSurge)
				.append("maxUnavailable", maxUnavailable)
				);
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = MappingUtils.toMap(this);
		map.put("strategy", getRequiredStrategy());
		return map;
	}

}
