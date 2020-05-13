package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Endpoint extends ObjectBase {

	protected Integer port;
	
	private String host;

	private String ip;

	private String node;

	private String target;

	protected String uri;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Endpoint}.
	 *
	 */
	public Endpoint() {
	}
	
	//
	// Getters/Setters
	//


	/**
	 * Get the value of property {@code uri}.
	 *
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Get the value of property {@code host}.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Set the value of property {@code host}.
	 *
	 * @param host the value of property host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Get the value of property {@code ip}.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Set the value of property {@code ip}.
	 *
	 * @param ip the value of property ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Get the value of property {@code node}.
	 *
	 * @return the node
	 */
	public String getNode() {
		return node;
	}

	/**
	 * Set the value of property {@code node}.
	 *
	 * @param node the value of property node
	 */
	public void setNode(String node) {
		this.node = node;
	}

	/**
	 * Get the value of property {@code target}.
	 *
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * Set the value of property {@code target}.
	 *
	 * @param target the value of property target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * Set the value of property {@code uri}.
	 *
	 * @param uri the value of property uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Get the value of property {@code port}.
	 *
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * Set the value of property {@code port}.
	 *
	 * @param port the value of property port
	 */
	public void setPort(Integer port) {
		this.port = port;
	}



	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("port", port)
				.append("host", host)
				.append("ip", ip)
				.append("target", target)
				.append("port", port)
				.append("uri", uri)
				);
	}



}
