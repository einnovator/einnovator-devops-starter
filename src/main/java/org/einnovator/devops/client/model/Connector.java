package org.einnovator.devops.client.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Connector extends EntityBase {

	private String name;
	
	private Map<String, Object> spec;

	private Map<String, Object> meta;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Binding}.
	 *
	 */
	public Connector() {
	}
	
	//
	// Getters and setters
	//


	/**
	 * Create instance of {@code Connector}.
	 *
	 * @param name the name
	 */
	public Connector(String name) {
		this.name = name;
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

	public void putInSpec(String key, Object value) {
		if (this.spec==null) {
			this.spec = new LinkedHashMap<>();
		}
		this.spec.put(key, value);
	}

	public Object getFromSpec(String key) {
		if (this.spec==null) {
			return null;
		}
		return this.spec.get(key);
	}

	public void put(String key, Object value) {
		if (this.spec==null) {
			this.spec = new LinkedHashMap<>();
		}
		this.spec.put(key, value);
	}

	public Object get(String key) {
		if (this.spec==null) {
			return null;
		}
		return this.spec.get(key);
	}

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("spec", spec)
				.append("meta", meta)
				;
	}


}