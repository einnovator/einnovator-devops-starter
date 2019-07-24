package org.einnovator.devops.client.model;

import java.util.Map;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Binding extends EntityBase {

	private String selector;

	private String serviceName;
	
	private Connector connector;

	private Map<String, Object> spec;

	private Map<String, Object> meta;

	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Binding}.
	 *
	 */
	public Binding() {
	}
	
	//
	// Getters and setters
	//
	

	/**
	 * Get the value of property {@code selector}.
	 *
	 * @return the selector
	 */
	public String getSelector() {
		return selector;
	}

	/**
	 * Set the value of property {@code selector}.
	 *
	 * @param selector the selector to set
	 */
	public void setSelector(String selector) {
		this.selector = selector;
	}

	/**
	 * Get the value of property {@code spec}.
	 *
	 * @return the spec
	 */
	public Map<String, Object> getSpec() {
		return spec;
	}

	/**
	 * Set the value of property {@code spec}.
	 *
	 * @param spec the spec to set
	 */
	public void setSpec(Map<String, Object> spec) {
		this.spec = spec;
	}


	/**
	 * Get the value of property {@code serviceName}.
	 *
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * Set the value of property {@code serviceName}.
	 *
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * Get the value of property {@code connector}.
	 *
	 * @return the connector
	 */
	public Connector getConnector() {
		return connector;
	}

	/**
	 * Set the value of property {@code connector}.
	 *
	 * @param connector the connector to set
	 */
	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	/**
	 * Get the value of property {@code meta}.
	 *
	 * @return the meta
	 */
	public Map<String, Object> getMeta() {
		return meta;
	}

	/**
	 * Set the value of property {@code meta}.
	 *
	 * @param meta the meta to set
	 */
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("selector", selector)
				.append("spec", spec)
				.append("serviceName", serviceName)
				.append("connector", connector)
				.append("meta", meta)
				;
	}


}
