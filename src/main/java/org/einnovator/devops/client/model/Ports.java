package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ports extends ObjectBase {

	private String name;

	private Integer nodePort;

	private Integer port;

	private String protocol;

	private Integer targetPort;

	private String targetPortName;


	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code TitleEntity}.
	 *
	 */
	public Ports() {
	}

	
	//
	// Getters and setters
	//

	/**
	 * Create instance of {@code Ports}.
	 *
	 * @param name
	 * @param nodePort
	 * @param port
	 * @param protocol
	 * @param targetPort
	 * @param targetPortName
	 */
	public Ports(String name, Integer nodePort, Integer port, String protocol, Integer targetPort, String targetPortName) {
		super();
		this.name = name;
		this.nodePort = nodePort;
		this.port = port;
		this.protocol = protocol;
		this.targetPort = targetPort;
		this.targetPortName = targetPortName;
	}


	/**
	 * Create instance of {@code Ports}.
	 *
	 * @param ports
	 */
	public Ports(Object obj) {
		super(obj);
	}


	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code nodePort}.
	 *
	 * @return the nodePort
	 */
	public Integer getNodePort() {
		return nodePort;
	}

	/**
	 * Set the value of property {@code nodePort}.
	 *
	 * @param nodePort the nodePort to set
	 */
	public void setNodePort(Integer nodePort) {
		this.nodePort = nodePort;
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
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * Get the value of property {@code protocol}.
	 *
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * Set the value of property {@code protocol}.
	 *
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * Get the value of property {@code targetPort}.
	 *
	 * @return the targetPort
	 */
	public Integer getTargetPort() {
		return targetPort;
	}

	/**
	 * Set the value of property {@code targetPort}.
	 *
	 * @param targetPort the targetPort to set
	 */
	public void setTargetPort(Integer targetPort) {
		this.targetPort = targetPort;
	}

	/**
	 * Get the value of property {@code targetPortName}.
	 *
	 * @return the targetPortName
	 */
	public String getTargetPortName() {
		return targetPortName;
	}

	/**
	 * Set the value of property {@code targetPortName}.
	 *
	 * @param targetPortName the targetPortName to set
	 */
	public void setTargetPortName(String targetPortName) {
		this.targetPortName = targetPortName;
	}



	

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("name", name)
				.append("port", port)
				.append("nodePort", nodePort)
				.append("protocol", protocol)
				.append("targetPort", targetPort)
				.append("targetPortName", targetPortName)
				);
	}

}
