package org.einnovator.devops.client.model;

import java.util.List;
import java.util.Map;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Connector extends EntityBase {

	private String name;
	
	private String type;

	private List<String> tags;

	private Map<String, Object> spec;

	private Map<String, Object> meta;
	
	private Boolean external;

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
	// Getters/Setters
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
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the value of {@code type}
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of {@code type}
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code tags}.
	 *
	 * @return the value of {@code tags}
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Set the value of property {@code tags}.
	 *
	 * @param tags the value of {@code tags}
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
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

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("type", type)
				.append("tags", tags)
				.append("spec", spec)
				.append("meta", meta)
				.append("external", external)
				;
	}


}
