/**
 * 
 */
package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

/**
 *
 */
public class LogOptions extends ObjectBase {

	private String container;
	
	private Boolean pretty;
	
	private Boolean follow;

	private Integer limitBytes;

	private Integer sinceSeconds;
	
	private Integer tailLines;
	
	private Boolean timestamps;
	
	private Boolean previous;

	/**
	 * Create instance of {@code LogOptions}.
	 *
	 */
	public LogOptions() {
	}

	/**
	 * Get the value of property {@code container}.
	 *
	 * @return the container
	 */
	public String getContainer() {
		return container;
	}

	/**
	 * Set the value of property {@code container}.
	 *
	 * @param container the container to set
	 */
	public void setContainer(String container) {
		this.container = container;
	}


	/**
	 * Get the value of property {@code follow}.
	 *
	 * @return the follow
	 */
	public Boolean getFollow() {
		return follow;
	}

	/**
	 * Set the value of property {@code follow}.
	 *
	 * @param follow the follow to set
	 */
	public void setFollow(Boolean follow) {
		this.follow = follow;
	}

	/**
	 * Get the value of property {@code sinceSeconds}.
	 *
	 * @return the sinceSeconds
	 */
	public Integer getSinceSeconds() {
		return sinceSeconds;
	}

	/**
	 * Set the value of property {@code sinceSeconds}.
	 *
	 * @param sinceSeconds the sinceSeconds to set
	 */
	public void setSinceSeconds(Integer sinceSeconds) {
		this.sinceSeconds = sinceSeconds;
	}

	/**
	 * Get the value of property {@code tailLines}.
	 *
	 * @return the tailLines
	 */
	public Integer getTailLines() {
		return tailLines;
	}

	/**
	 * Set the value of property {@code tailLines}.
	 *
	 * @param tailLines the tailLines to set
	 */
	public void setTailLines(Integer tailLines) {
		this.tailLines = tailLines;
	}

	/**
	 * Get the value of property {@code timestamps}.
	 *
	 * @return the timestamps
	 */
	public Boolean getTimestamps() {
		return timestamps;
	}

	/**
	 * Set the value of property {@code timestamps}.
	 *
	 * @param timestamps the timestamps to set
	 */
	public void setTimestamps(Boolean timestamps) {
		this.timestamps = timestamps;
	}

	
	/**
	 * Get the value of property {@code limitBytes}.
	 *
	 * @return the limitBytes
	 */
	public Integer getLimitBytes() {
		return limitBytes;
	}

	/**
	 * Set the value of property {@code limitBytes}.
	 *
	 * @param limitBytes the limitBytes to set
	 */
	public void setLimitBytes(Integer limitBytes) {
		this.limitBytes = limitBytes;
	}
	

	/**
	 * Get the value of property {@code pretty}.
	 *
	 * @return the pretty
	 */
	public Boolean getPretty() {
		return pretty;
	}

	/**
	 * Set the value of property {@code pretty}.
	 *
	 * @param pretty the pretty to set
	 */
	public void setPretty(Boolean pretty) {
		this.pretty = pretty;
	}

	
	/**
	 * Get the value of property {@code previous}.
	 *
	 * @return the previous
	 */
	public Boolean getPrevious() {
		return previous;
	}

	/**
	 * Set the value of property {@code previous}.
	 *
	 * @param previous the previous to set
	 */
	public void setPrevious(Boolean previous) {
		this.previous = previous;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("container", container)
				.append("pretty", pretty)
				.append("follow", follow)
				.append("sinceSeconds", sinceSeconds)
				.append("tailLines", tailLines)
				.append("timestamps", timestamps)
				.append("limitBytes", limitBytes)
				.append("previous", previous)
				;
	}
	
}
