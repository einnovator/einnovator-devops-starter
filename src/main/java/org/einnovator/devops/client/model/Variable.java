package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Variable extends EntityBase {

	private String name;
	
	private String value;

	private String type;
	
	private Scope scope;

	private Variable overrides;

	public Variable() {
	}
	
	/**
	 * Create instance of {@code Variable}.
	 *
	 * @param prototype a prototype
	 */
	public Variable(Object prototype) {
		super(prototype);
		this.id = null;
	}

	/**
	 * Create instance of {@code Variable}.
	 *
	 * @param name the name
	 * @param value the value
	 */
	public Variable(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	/**
	 * Get the value of property {@code scope}.
	 *
	 * @return the scope
	 */
	public Scope getScope() {
		return scope;
	}

	/**
	 * Set the value of property {@code scope}.
	 *
	 * @param scope the scope to set
	 */
	public void setScope(Scope scope) {
		this.scope = scope;
	}
	
	/**
	 * Get the value of property {@code overrides}.
	 *
	 * @return the overrides
	 */
	public Variable getOverrides() {
		return overrides;
	}

	/**
	 * Set the value of property {@code overrides}.
	 *
	 * @param overrides the overrides to set
	 */
	public void setOverrides(Variable overrides) {
		this.overrides = overrides;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("value", value)
				.append("type", type)
				.append("scope", scope)
				.append("overrides", overrides)
				;
	}
	
	public static final List<Variable> toVars(Map<String, Object> env) {
		if (env==null) {
			return null;
		}
		List<Variable> vars = new ArrayList<>();
		return vars;
	}
}
