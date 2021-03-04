package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue extends ObjectBase {

	private String code;
	
	private String message;
	
	private List<String> resourceIds;
	

	//
	// Constructors
	//

	public Issue() {
	}


	/**
	 * Get the value of property {@code message}.
	 *
	 * @return the value of {@code message}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the value of property {@code message}.
	 *
	 * @param message the value of {@code message}
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the value of property {@code code}.
	 *
	 * @return the value of {@code code}
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set the value of property {@code code}.
	 *
	 * @param code the value of {@code code}
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * Get the value of property {@code resourceIds}.
	 *
	 * @return the value of {@code resourceIds}
	 */
	public List<String> getResourceIds() {
		return resourceIds;
	}

	/**
	 * Set the value of property {@code resourceIds}.
	 *
	 * @param resourceIds the value of {@code resourceIds}
	 */
	public void setResourceIds(List<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("message", message)
				.append("code", code)
				.append("resourceIds", resourceIds)
				;
	}
}
