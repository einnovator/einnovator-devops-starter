/**
 * 
 */
package org.einnovator.devops.client.modelx;

import java.util.LinkedHashMap;
import java.util.Map;

import org.einnovator.devops.client.model.SolutionType;
import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Statistic for {@code Solution}s.
 *
 * @author support@einnovator.org
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolutionStats extends ObjectBase {

	private Long total;

	
	private Map<SolutionType, Long> countByType = new LinkedHashMap<>();

	/**
	 * Create instance of {@code RequestStats}.
	 *
	 */
	public SolutionStats() {
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
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
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
	 * @param countByType the countByType to set
	 */
	public void setCountByType(Map<SolutionType, Long> countByType) {
		this.countByType = countByType;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator
				.append("total", total)
				.append("countByType", countByType)
				);
	}

}
