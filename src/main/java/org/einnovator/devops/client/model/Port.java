package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.util.MappingUtils;
import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Port extends ObjectBase {

	private String name;

	private Integer nodePort;

	private Integer port;

	private String protocol;

	private Integer targetPort;

	private String targetPortName;

	private String hostIP;

	private Integer hostPort;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code TitleEntity}.
	 *
	 */
	public Port() {
	}

	
	//
	// Getters/Setters
	//

	/**
	 * Create instance of {@code Ports}.
	 *
	 * @param name the name
	 * @param nodePort the nodePort
	 * @param port the port
	 * @param protocol the protocol
	 * @param targetPort the targetPort
	 * @param targetPortName the targetPortName
	 */
	public Port(String name, Integer nodePort, Integer port, String protocol, Integer targetPort, String targetPortName) {
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
	 * @param obj a prototype
	 */
	public Port(Object obj) {
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
	 * @param name the name
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
	 * @param nodePort the nodePort
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
	 * @param port the port
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
	 * @param protocol the protocol
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
	 * @param targetPort the targetPort
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
	 * @param targetPortName the targetPortName
	 */
	public void setTargetPortName(String targetPortName) {
		this.targetPortName = targetPortName;
	}

	/**
	 * Get the value of property {@code hostIP}.
	 *
	 * @return the hostIP
	 */
	public String getHostIP() {
		return hostIP;
	}


	/**
	 * Set the value of property {@code hostIP}.
	 *
	 * @param hostIP the value of property hostIP
	 */
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}


	/**
	 * Get the value of property {@code hostPort}.
	 *
	 * @return the hostPort
	 */
	public Integer getHostPort() {
		return hostPort;
	}


	/**
	 * Set the value of property {@code hostPort}.
	 *
	 * @param hostPort the value of property hostPort
	 */
	public void setHostPort(Integer hostPort) {
		this.hostPort = hostPort;
	}


	@JsonIgnore
	public Integer getRequiredPort() {
		if (targetPort!=null) {
			return targetPort;
		}
		return port;
	}
	
	public void merge(Port port, boolean override) {
		port = new Port(port);
		if (!override) {
			MappingUtils.updateObjectFromNonNull(port, this.port);			
		}
		MappingUtils.updateObjectFromNonNull(this.port, port);
	}
	
	public static List<Port> merge(List<Port> ports, List<Port> ports2, boolean override) {
		if (ports==null) {
			return ports2;
		}
		if (ports2==null) {
			return ports;
		}
		int i = 0;
		for (Port port: ports2) {
			if (i<ports.size()) {
				ports.get(i).merge(port, override);
			}
			i++;
		}
		return ports;
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
				.append("hostIP", hostIP)
				.append("hostPort", hostPort)
				);
	}


}
