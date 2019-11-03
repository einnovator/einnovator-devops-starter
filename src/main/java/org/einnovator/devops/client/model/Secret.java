package org.einnovator.devops.client.model;

import java.util.Map;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Secret extends EntityBase {

	private String name;

	private String type;
	
	private String kind;
	
	private Map<String, String> data;

	private Map<String, String> strData;

	@JsonIgnore
	private Map<String, Object> meta;
	
	
	private String value;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Secret}.
	 *
	 */
	public Secret() {
	}


	//
	// Getters and setters
	//


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
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code value}.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the value of property {@code value}.
	 *
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

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
	 * Get the value of property {@code strData}.
	 *
	 * @return the strData
	 */
	public Map<String, String> getStrData() {
		return strData;
	}


	/**
	 * Set the value of property {@code strData}.
	 *
	 * @param strData the strData to set
	 */
	public void setStrData(Map<String, String> strData) {
		this.strData = strData;
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
				.append("type", type)
				.append("kind", kind)
				.append("data", data)
				.append("strData", strData)
				.append("value", value)
				);
	}

	
}
