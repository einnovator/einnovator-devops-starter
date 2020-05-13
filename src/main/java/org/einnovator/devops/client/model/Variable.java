package org.einnovator.devops.client.model;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Variable extends EntityBase {

	private VarCategory category;

	private String name;
	
	private String value;
	
	private String type;
	
	private Scope scope;

	private String configmap;

	private String secret;

	private String container;

	private String path;
	
	private Boolean optional;

	private Object decoded;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Variable}.
	 *
	 */
	public Variable() {
	}
	
	/**
	 * Create instance of {@code Variable}.
	 *
	 * @param obj a prototype
	 */
	public Variable(Object obj) {
		super(obj);
	}

	/**
	 * Create instance of {@code Variable}.
	 *
	 * @param name the name for this {@code Variable}
	 * @param value the value for this {@code Variable}
	 */
	public Variable(String name, String value) {
		this.name = name;
		this.value = value;
		this.category = VarCategory.VALUE;
	}

	//
	// Getter/Setter
	//


	/**
	 * Get the value of property {@code category}.
	 *
	 * @return the category
	 */
	public VarCategory getCategory() {
		return category;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the value of property category
	 */
	public void setCategory(VarCategory category) {
		this.category = category;
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
	 * @param name the value of property name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param value the value of property value
	 */
	public void setValue(String value) {
		this.value = value;
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
	 * @param type the value of property type
	 */
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
	 * @param scope the value of property scope
	 */
	public void setScope(Scope scope) {
		this.scope = scope;
	}

	/**
	 * Get the value of property {@code configmap}.
	 *
	 * @return the configmap
	 */
	public String getConfigmap() {
		return configmap;
	}

	/**
	 * Set the value of property {@code configmap}.
	 *
	 * @param configmap the value of property configmap
	 */
	public void setConfigmap(String configmap) {
		this.configmap = configmap;
	}

	/**
	 * Get the value of property {@code secret}.
	 *
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * Set the value of property {@code secret}.
	 *
	 * @param secret the value of property secret
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * Get the value of property {@code container}.
	 *
	 * @return the container
	 */
	public String getContainer() {
		return container;
	}

	/**
	 * Set the value of property {@code container}.
	 *
	 * @param container the value of property container
	 */
	public void setContainer(String container) {
		this.container = container;
	}

	/**
	 * Get the value of property {@code path}.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Set the value of property {@code path}.
	 *
	 * @param path the value of property path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Get the value of property {@code optional}.
	 *
	 * @return the optional
	 */
	public Boolean getOptional() {
		return optional;
	}

	/**
	 * Set the value of property {@code optional}.
	 *
	 * @param optional the value of property optional
	 */
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	/**
	 * Get the value of property {@code decoded}.
	 *
	 * @return the decoded
	 */
	public Object getDecoded() {
		return decoded;
	}

	/**
	 * Set the value of property {@code decoded}.
	 *
	 * @param decoded the value of property decoded
	 */
	public void setDecoded(Object decoded) {
		this.decoded = decoded;
	}

	//
	// With
	//

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 * @return this {@code Variable}
	 */
	public Variable withType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code scope}.
	 *
	 * @param scope the value of property scope
	 * @return this {@code Variable}
	 */
	public Variable withScope(Scope scope) {
		this.scope = scope;
		return this;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the value of property category
	 * @return this {@code Variable}
	 */
	public Variable withCategory(VarCategory category) {
		this.category = category;
		return this;
	}

	/**
	 * Set the value of property {@code configmap}.
	 *
	 * @param configmap the value of property configmap
	 * @return this {@code Variable}
	 */
	public Variable withConfigmap(String configmap) {
		this.configmap = configmap;
		return this;
	}

	/**
	 * Set the value of property {@code secret}.
	 *
	 * @param secret the value of property secret
	 * @return this {@code Variable}
	 */
	public Variable withSecret(String secret) {
		this.secret = secret;
		return this;
	}

	/**
	 * Set the value of property {@code container}.
	 *
	 * @param container the value of property container
	 * @return this {@code Variable}
	 */
	public Variable withContainer(String container) {
		this.container = container;
		return this;
	}

	/**
	 * Set the value of property {@code path}.
	 *
	 * @param path the value of property path
	 * @return this {@code Variable}
	 */
	public Variable withPath(String path) {
		this.path = path;
		return this;
	}

	/**
	 * Set the value of property {@code optional}.
	 *
	 * @param optional the value of property optional
	 * @return this {@code Variable}
	 */
	public Variable withOptional(Boolean optional) {
		this.optional = optional;
		return this;
	}

	/**
	 * Set the value of property {@code decoded}.
	 *
	 * @param decoded the value of property decoded
	 * @return this {@code Variable}
	 */
	public Variable withDecoded(Object decoded) {
		this.decoded = decoded;
		return this;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("category", category)
				.append("configmap", configmap)
				.append("secret", secret)
				.append("container", container)
				.append("path", path)
				.append("scope", scope)
				.append("optional", optional)
				;
	}
}
