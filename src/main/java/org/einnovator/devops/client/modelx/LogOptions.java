/**
 * 
 */
package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;


/**
 * A {@code LogOptions}.
 *
 * @author support@einnovator.org
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

	//
	// Constructors
	//

	/**
	 * Create instance of {@code LogOptions}.
	 *
	 */
	public LogOptions() {
	}

	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code container}.
	 *
	 * @return the value of container
	 */
	public String getContainer() {
		return container;
	}

	/**
	 * Set the value of property {@code container}.
	 *
	 * @param container the value of container
	 */
	public void setContainer(String container) {
		this.container = container;
	}


	/**
	 * Get the value of property {@code follow}.
	 *
	 * @return the value of follow
	 */
	public Boolean getFollow() {
		return follow;
	}

	/**
	 * Set the value of property {@code follow}.
	 *
	 * @param follow the value of follow
	 */
	public void setFollow(Boolean follow) {
		this.follow = follow;
	}

	/**
	 * Get the value of property {@code sinceSeconds}.
	 *
	 * @return the value of sinceSeconds
	 */
	public Integer getSinceSeconds() {
		return sinceSeconds;
	}

	/**
	 * Set the value of property {@code sinceSeconds}.
	 *
	 * @param sinceSeconds the value of sinceSeconds
	 */
	public void setSinceSeconds(Integer sinceSeconds) {
		this.sinceSeconds = sinceSeconds;
	}

	/**
	 * Get the value of property {@code tailLines}.
	 *
	 * @return the value of tailLines
	 */
	public Integer getTailLines() {
		return tailLines;
	}

	/**
	 * Set the value of property {@code tailLines}.
	 *
	 * @param tailLines the value of tailLines
	 */
	public void setTailLines(Integer tailLines) {
		this.tailLines = tailLines;
	}

	/**
	 * Get the value of property {@code timestamps}.
	 *
	 * @return the value of timestamps
	 */
	public Boolean getTimestamps() {
		return timestamps;
	}

	/**
	 * Set the value of property {@code timestamps}.
	 *
	 * @param timestamps the value of timestamps
	 */
	public void setTimestamps(Boolean timestamps) {
		this.timestamps = timestamps;
	}

	
	/**
	 * Get the value of property {@code limitBytes}.
	 *
	 * @return the value of limitBytes
	 */
	public Integer getLimitBytes() {
		return limitBytes;
	}

	/**
	 * Set the value of property {@code limitBytes}.
	 *
	 * @param limitBytes the value of limitBytes
	 */
	public void setLimitBytes(Integer limitBytes) {
		this.limitBytes = limitBytes;
	}
	

	/**
	 * Get the value of property {@code pretty}.
	 *
	 * @return the value of pretty
	 */
	public Boolean getPretty() {
		return pretty;
	}

	/**
	 * Set the value of property {@code pretty}.
	 *
	 * @param pretty the value of pretty
	 */
	public void setPretty(Boolean pretty) {
		this.pretty = pretty;
	}

	
	/**
	 * Get the value of property {@code previous}.
	 *
	 * @return the value of previous
	 */
	public Boolean getPrevious() {
		return previous;
	}

	/**
	 * Set the value of property {@code previous}.
	 *
	 * @param previous the value of previous
	 */
	public void setPrevious(Boolean previous) {
		this.previous = previous;
	}
	
	//
	// With
	//
	
	/**
	 * Set the value of property {@code container}.
	 *
	 * @param container the value of container
	 * @return this {@code LogOptions}
	 */
	public LogOptions withContainer(String container) {
		this.container = container;
		return this;
	}

	/**
	 * Set the value of property {@code follow}.
	 *
	 * @param follow the value of follow
	 * @return this {@code LogOptions}
	 */
	public LogOptions withFollow(Boolean follow) {
		this.follow = follow;
		return this;
	}

	/**
	 * Set the value of property {@code sinceSeconds}.
	 *
	 * @param sinceSeconds the value of sinceSeconds
	 * @return this {@code LogOptions}
	 */
	public LogOptions withSinceSeconds(Integer sinceSeconds) {
		this.sinceSeconds = sinceSeconds;
		return this;
	}

	/**
	 * Set the value of property {@code tailLines}.
	 *
	 * @param tailLines the value of tailLines
	 * @return this {@code LogOptions}
	 */
	public LogOptions withTailLines(Integer tailLines) {
		this.tailLines = tailLines;
		return this;
	}

	/**
	 * Set the value of property {@code timestamps}.
	 *
	 * @param timestamps the value of timestamps
	 * @return this {@code LogOptions}
	 */
	public LogOptions withTimestamps(Boolean timestamps) {
		this.timestamps = timestamps;
		return this;
	}

	/**
	 * Set the value of property {@code limitBytes}.
	 *
	 * @param limitBytes the value of limitBytes
	 * @return this {@code LogOptions}
	 */
	public LogOptions withLimitBytes(Integer limitBytes) {
		this.limitBytes = limitBytes;
		return this;
	}

	/**
	 * Set the value of property {@code pretty}.
	 *
	 * @param pretty the value of pretty
	 * @return this {@code LogOptions}
	 */
	public LogOptions withPretty(Boolean pretty) {
		this.pretty = pretty;
		return this;
	}

	/**
	 * Set the value of property {@code previous}.
	 *
	 * @param previous the value of previous
	 * @return this {@code LogOptions}
	 */
	public LogOptions withPrevious(Boolean previous) {
		this.previous = previous;
		return this;
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
