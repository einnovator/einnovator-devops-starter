/**
 * 
 */
package org.einnovator.devops.client.modelx;

import java.util.LinkedHashMap;
import java.util.Map;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import org.einnovator.devops.client.model.DeploymentStatus;
import org.einnovator.devops.client.model.SolutionType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeploymentStats extends ObjectBase {

	private Long total;

	
	private Map<DeploymentStatus, Long> countByStatus = new LinkedHashMap<>();

	private Map<SolutionType, Long> countByType = new LinkedHashMap<>();

	/**
	 * Create instance of {@code RequestStats}.
	 *
	 */
	public DeploymentStats() {
	}
	
	/**
	 * Get the value of property {@code total}.
	 *
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * Set the value of property {@code total}.
	 *
	 * @param total the total
	 */
	public void setTotal(Long total) {
		this.total = total;
	}
	
	/**
	 * Get the value of property {@code countByStatus}.
	 *
	 * @return the countByStatus
	 */
	public Map<DeploymentStatus, Long> getCountByStatus() {
		return countByStatus;
	}

	/**
	 * Set the value of property {@code countByStatus}.
	 *
	 * @param countByStatus the countByStatus
	 */
	public void setCountByStatus(Map<DeploymentStatus, Long> countByStatus) {
		this.countByStatus = countByStatus;
	}

	/**
	 * Get the value of property {@code countByType}.
	 *
	 * @return the countByType
	 */
	public Map<SolutionType, Long> getCountByType() {
		return countByType;
	}

	/**
	 * Set the value of property {@code countByType}.
	 *
	 * @param countByType the countByType
	 */
	public void setCountByType(Map<SolutionType, Long> countByType) {
		this.countByType = countByType;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator
				.append("total", total)
				.append("countByType", countByType)
				.append("countByStatus", countByStatus)
				);
	}

}
