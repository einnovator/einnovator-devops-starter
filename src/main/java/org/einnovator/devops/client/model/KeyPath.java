/**
 * 
 */
package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A {@code KeyPath}.
 *
 * @author support@einnovator.org
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyPath extends ObjectBase {

	private String key;
	
	private String path;

	private String mode;

	/**
	 * Create instance of {@code KeyPath}.
	 *
	 */
	public KeyPath() {
	}


	/**
	 * Get the value of property {@code key}.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the value of property key
	 */
	public void setKey(String key) {
		this.key = key;
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
	 * Get the value of property {@code mode}.
	 *
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * Set the value of property {@code mode}.
	 *
	 * @param mode the value of property mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("key", key)
				.append("path", path)
				;
	}

}
