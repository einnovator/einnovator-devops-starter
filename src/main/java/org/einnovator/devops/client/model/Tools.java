/**
 * 
 */
package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

/**
 *
 */
public class Tools extends ObjectBase {

	private String namespace;

	private String pod;

	private String container;

	private String kubectl;

	private String helm;

	private String ytt;

	private RuntimeStatus status;
	
	private Boolean install;
	
	/**
	 * Create instance of {@code Exec}.
	 *
	 */
	public Tools() {
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
	 * Get the value of property {@code status}.
	 *
	 * @return the value of {@code status}
	 */
	public RuntimeStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of {@code status}
	 */
	public void setStatus(RuntimeStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code kubectl}.
	 *
	 * @return the value of {@code kubectl}
	 */
	public String getKubectl() {
		return kubectl;
	}

	/**
	 * Set the value of property {@code kubectl}.
	 *
	 * @param kubectl the value of {@code kubectl}
	 */
	public void setKubectl(String kubectl) {
		this.kubectl = kubectl;
	}
	
	/**
	 * Get the value of property {@code helm}.
	 *
	 * @return the helm
	 */
	public String getHelm() {
		return helm;
	}
	
	/**
	 * Set the value of property {@code helm}.
	 *
	 * @param helm the value of property helm
	 */
	public void setHelm(String helm) {
		this.helm = helm;
	}


	/**
	 * Get the value of property {@code ytt}.
	 *
	 * @return the value of {@code ytt}
	 */
	public String getYtt() {
		return ytt;
	}

	/**
	 * Set the value of property {@code ytt}.
	 *
	 * @param ytt the value of {@code ytt}
	 */
	public void setYtt(String ytt) {
		this.ytt = ytt;
	}

	
	/**
	 * Get the value of property {@code install}.
	 *
	 * @return the value of {@code install}
	 */
	public Boolean getInstall() {
		return install;
	}

	/**
	 * Set the value of property {@code install}.
	 *
	 * @param install the value of {@code install}
	 */
	public void setInstall(Boolean install) {
		this.install = install;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("namespace", namespace)
				.append("pod", pod)
				.append("container", container)
				.append("helm", helm)
				.append("ytt", ytt)
				.append("install", install)
				;
	}
}
