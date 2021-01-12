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

	private String spaceId;

	private String serviceId;

	private Boolean auto;
	
	private Boolean external;
	
	private Service service;

	private Service servicex;
	
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
	// Getters/Setters
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
	 * @param selector the selector
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
	 * @param spec the spec
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
	 * @param serviceName the serviceName
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
	 * @param connector the connector
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
	 * @param meta the meta
	 */
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	/**
	 * Get the value of property {@code spaceId}.
	 *
	 * @return the value of {@code spaceId}
	 */
	public String getSpaceId() {
		return spaceId;
	}

	/**
	 * Set the value of property {@code spaceId}.
	 *
	 * @param spaceId the value of {@code spaceId}
	 */
	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	/**
	 * Get the value of property {@code serviceId}.
	 *
	 * @return the value of {@code serviceId}
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * Set the value of property {@code serviceId}.
	 *
	 * @param serviceId the value of {@code serviceId}
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * Get the value of property {@code auto}.
	 *
	 * @return the value of {@code auto}
	 */
	public Boolean getAuto() {
		return auto;
	}

	/**
	 * Set the value of property {@code auto}.
	 *
	 * @param auto the value of {@code auto}
	 */
	public void setAuto(Boolean auto) {
		this.auto = auto;
	}

	/**
	 * Get the value of property {@code external}.
	 *
	 * @return the value of {@code external}
	 */
	public Boolean getExternal() {
		return external;
	}

	/**
	 * Set the value of property {@code external}.
	 *
	 * @param external the value of {@code external}
	 */
	public void setExternal(Boolean external) {
		this.external = external;
	}

	/**
	 * Get the value of property {@code service}.
	 *
	 * @return the value of {@code service}
	 */
	public Service getService() {
		return service;
	}

	/**
	 * Set the value of property {@code service}.
	 *
	 * @param service the value of {@code service}
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * Get the value of property {@code servicex}.
	 *
	 * @return the value of {@code servicex}
	 */
	public Service getServicex() {
		return servicex;
	}

	/**
	 * Set the value of property {@code servicex}.
	 *
	 * @param servicex the value of {@code servicex}
	 */
	public void setServicex(Service servicex) {
		this.servicex = servicex;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("selector", selector)
				.append("spec", spec)
				.append("serviceName", serviceName)
				.append("connector", connector)
				.append("meta", meta)
				.append("spaceId", spaceId)
				.append("serviceId", serviceId)
				.append("auto", auto)
				.append("external", external)
				.append("service", service)
				.append("servicex", servicex)
				;
	}


}
