package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;
import org.einnovator.util.web.RequestOptions;

/**
 * Command execution options.
 *
 * @author support@einnovator.org
 */
public class ExecOptions extends RequestOptions {

	private String cmd;

	private String pod;

	//
	// Constructors
	//

	/**
	 * Create instance of {@code ExecOptions}.
	 *
	 */
	public ExecOptions() {
	}

	
	//
	// Getter/Setter
	//
	
	/**
	 * Get the value of property {@code cmd}.
	 *
	 * @return the value of {@code cmd}
	 */
	public String getCmd() {
		return cmd;
	}

	/**
	 * Set the value of property {@code cmd}.
	 *
	 * @param cmd the value of {@code cmd}
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

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
	
	//
	// With
	//
	
	/**
	 * Set the value of property {@code cmd}.
	 *
	 * @param cmd the value of {@code cmd}
	 * @return this {@code ExecOptions}
	 */
	public ExecOptions withCmd(String cmd) {
		this.cmd = cmd;
		return this;
	}

	/**
	 * Set the value of property {@code pod}.
	 *
	 * @param pod the value of {@code pod}
	 * @return this {@code ExecOptions}
	 */
	public ExecOptions withPod(String pod) {
		this.pod = pod;
		return this;
	}
	
	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("cmd", cmd)
				.append("pod", pod)
				;
	}

}
