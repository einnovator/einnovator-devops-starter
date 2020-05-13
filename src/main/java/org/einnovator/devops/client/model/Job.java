package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Job extends JobBase {
	
	private Integer completions;

	private Integer parallelism;

	private Integer backoffLimit;

	private Boolean manualSelector;
		
	private Integer ttlSecondsAfterFinished;
	

	public Job() {
	}
	
	public Job(Job job) {
		super(job);
	}

	/**
	 * Get the value of property {@code completions}.
	 *
	 * @return the completions
	 */
	public Integer getCompletions() {
		return completions;
	}

	/**
	 * Set the value of property {@code completions}.
	 *
	 * @param completions the completions to set
	 */
	public void setCompletions(Integer completions) {
		this.completions = completions;
	}

	/**
	 * Get the value of property {@code parallelism}.
	 *
	 * @return the parallelism
	 */
	public Integer getParallelism() {
		return parallelism;
	}

	/**
	 * Set the value of property {@code parallelism}.
	 *
	 * @param parallelism the parallelism to set
	 */
	public void setParallelism(Integer parallelism) {
		this.parallelism = parallelism;
	}

	/**
	 * Get the value of property {@code backoffLimit}.
	 *
	 * @return the backoffLimit
	 */
	public Integer getBackoffLimit() {
		return backoffLimit;
	}

	/**
	 * Set the value of property {@code backoffLimit}.
	 *
	 * @param backoffLimit the backoffLimit to set
	 */
	public void setBackoffLimit(Integer backoffLimit) {
		this.backoffLimit = backoffLimit;
	}
	
	/**
	 * Get the value of property {@code manualSelector}.
	 *
	 * @return the manualSelector
	 */
	public Boolean getManualSelector() {
		return manualSelector;
	}

	/**
	 * Set the value of property {@code manualSelector}.
	 *
	 * @param manualSelector the manualSelector to set
	 */
	public void setManualSelector(Boolean manualSelector) {
		this.manualSelector = manualSelector;
	}


	/**
	 * Get the value of property {@code ttlSecondsAfterFinished}.
	 *
	 * @return the ttlSecondsAfterFinished
	 */
	public Integer getTtlSecondsAfterFinished() {
		return ttlSecondsAfterFinished;
	}

	/**
	 * Set the value of property {@code ttlSecondsAfterFinished}.
	 *
	 * @param ttlSecondsAfterFinished the ttlSecondsAfterFinished to set
	 */
	public void setTtlSecondsAfterFinished(Integer ttlSecondsAfterFinished) {
		this.ttlSecondsAfterFinished = ttlSecondsAfterFinished;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("completions", completions)
				.append("parallelism", parallelism)
				.append("backoffLimit", backoffLimit)
				.append("manualSelector", manualSelector)
				.append("ttlSecondsAfterFinished", ttlSecondsAfterFinished)
				;
	}
}
