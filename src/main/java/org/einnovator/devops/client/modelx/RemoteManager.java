/**
 * 
 */
package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemoteManager extends ObjectBase {

	private String namespace;

	private String pod;

	private String container;

	private String bin;

	/**
	 * Create instance of {@code RemoteManager}.
	 *
	 */
	public RemoteManager() {
	}
	
	/**
	 * Get the value of property {@code namespace}.
	 *
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * Set the value of property {@code namespace}.
	 *
	 * @param namespace the value of property namespace
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * Get the value of property {@code pod}.
	 *
	 * @return the pod
	 */
	public String getPod() {
		return pod;
	}

	/**
	 * Set the value of property {@code pod}.
	 *
	 * @param pod the value of property pod
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
	 * @param container the value of property container
	 */
	public void setContainer(String container) {
		this.container = container;
	}


	/**
	 * Get the value of property {@code bin}.
	 *
	 * @return the bin
	 */
	public String getBin() {
		return bin;
	}

	/**
	 * Set the value of property {@code bin}.
	 *
	 * @param bin the value of property bin
	 */
	public void setBin(String bin) {
		this.bin = bin;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("namespace", namespace)
				.append("pod", pod)
				.append("container", container)
				.append("bin", bin)
				;
	}
}
