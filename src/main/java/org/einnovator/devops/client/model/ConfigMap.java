package org.einnovator.devops.client.model;

import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigMap extends AnnotatedEntity {
	
	private String kind;
	
	private Map<String, String> data;
	
	private Map<String, String> binData;

	private Map<String, Object> meta;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code ConfigMap}.
	 *
	 */
	public ConfigMap() {
	}

	
	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code kind}.
	 *
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * Set the value of property {@code kind}.
	 *
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * Get the value of property {@code data}.
	 *
	 * @return the data
	 */
	public Map<String, String> getData() {
		return data;
	}

	/**
	 * Set the value of property {@code data}.
	 *
	 * @param data the data to set
	 */
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
	/**
	 * Get the value of property {@code binData}.
	 *
	 * @return the binData
	 */
	public Map<String, String> getBinData() {
		return binData;
	}

	/**
	 * Set the value of property {@code binData}.
	 *
	 * @param binData the binData to set
	 */
	public void setBinData(Map<String, String> binData) {
		this.binData = binData;
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
		return super.toString1(creator
				.append("name", name)
				.append("kind", kind)
				.append("data", data)
				.append("binData", binData)
				);
	}

	public String getItem(String name) {
		if (data==null) {
			return null;
		}
		String value = data.get(name);
		return value;
	}
}
