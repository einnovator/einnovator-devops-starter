/**
 * 
 */
package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;
import org.einnovator.util.web.RequestOptions;

/**
 * A {@code LogOptions}.
 *
 * @author support@einnovator.org
 *
 */
public class LogOptions extends RequestOptions {

	private String pod;
	
	private String container;
	
	private Boolean pretty;
	
	private Boolean follow;

	private Integer limitBytes;

	private Integer sinceSeconds;
	
	private Integer tailLines;
	
	private Boolean timestamps;
	
	private Boolean previous;

	private Boolean html;

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
	// Getter/Setter
	//
	
	/**
	 * Get the value of property {@code pod}.
	 *
	 * @return the value of {@code pod}
	 */
	public String getPod() {
		return pod;
	}

	/**
	 * Set the value of property {@code pod}.
	 *
	 * @param pod the value of {@code pod}
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
	 * @param container the container
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
	 * @param follow the follow
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
	 * @param sinceSeconds the sinceSeconds
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
	 * @param tailLines the tailLines
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
	 * @param timestamps the timestamps
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
	 * @param limitBytes the limitBytes
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
	 * @param pretty the pretty
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
	 * @param previous the previous
	 */
	public void setPrevious(Boolean previous) {
		this.previous = previous;
	}


	/**
	 * Get the value of property {@code html}.
	 *
	 * @return the value of {@code html}
	 */
	public Boolean getHtml() {
		return html;
	}

	/**
	 * Set the value of property {@code html}.
	 *
	 * @param html the value of {@code html}
	 */
	public void setHtml(Boolean html) {
		this.html = html;
	}
	//
	// With
	//

	/**
	 * Set the value of property {@code pod}.
	 *
	 * @param pod the value of {@code pod}
	 * @return this {@code LogOptions}
	 */
	public LogOptions withPod(String pod) {
		this.pod = pod;
		return this;
	}

	/**
	 * Set the value of property {@code container}.
	 *
	 * @param container the container to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withContainer(String container) {
		this.container = container;return this;
	}

	/**
	 * Set the value of property {@code follow}.
	 *
	 * @param follow the follow to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withFollow(Boolean follow) {
		this.follow = follow;
		return this;
	}

	/**
	 * Set the value of property {@code sinceSeconds}.
	 *
	 * @param sinceSeconds the sinceSeconds to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withSinceSeconds(Integer sinceSeconds) {
		this.sinceSeconds = sinceSeconds;
		return this;
	}

	/**
	 * Set the value of property {@code tailLines}.
	 *
	 * @param tailLines the tailLines to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withTailLines(Integer tailLines) {
		this.tailLines = tailLines;
		return this;
	}

	/**
	 * Set the value of property {@code timestamps}.
	 *
	 * @param timestamps the timestamps to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withTimestamps(Boolean timestamps) {
		this.timestamps = timestamps;
		return this;
	}

	/**
	 * Set the value of property {@code limitBytes}.
	 *
	 * @param limitBytes the limitBytes to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withLimitBytes(Integer limitBytes) {
		this.limitBytes = limitBytes;
		return this;
	}

	/**
	 * Set the value of property {@code pretty}.
	 *
	 * @param pretty the pretty to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withPretty(Boolean pretty) {
		this.pretty = pretty;
		return this;
	}

	/**
	 * Set the value of property {@code previous}.
	 *
	 * @param previous the previous to with
	 * @return this {@code LogOptions}
	 */
	public LogOptions withPrevious(Boolean previous) {
		this.previous = previous;
		return this;
	}
	
	/**
	 * Set the value of property {@code html}.
	 *
	 * @param html the value of {@code html}
	 * @return this {@code LogOptions}
	 */
	public LogOptions withHtml(Boolean html) {
		this.html = html;
		return this;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("pod", pod)
				.append("container", container)
				.append("pretty", pretty)
				.append("follow", follow)
				.append("sinceSeconds", sinceSeconds)
				.append("tailLines", tailLines)
				.append("timestamps", timestamps)
				.append("limitBytes", limitBytes)
				.append("previous", previous)
				.append("html", html)
				;
	}
	
}

