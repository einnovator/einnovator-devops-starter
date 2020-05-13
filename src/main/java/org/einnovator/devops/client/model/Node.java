package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node extends AnnotatedEntity {

	private String ip;

	private Resources resources;
	
	
	public Node() {
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
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * Get the value of property {@code resources}.
	 *
	 * @return the resources
	 */
	public Resources getResources() {
		return resources;
	}

	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the resources to set
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("resources", resources)
				.append("ip", ip)
				;
	}
	

	
}
