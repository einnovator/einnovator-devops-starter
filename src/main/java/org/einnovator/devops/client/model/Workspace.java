package org.einnovator.devops.client.model;

import org.einnovator.util.StringUtil;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workspace extends Mount {

	private String subPath;
	
	/**
	 * Create instance of {@code Workspace}.
	 *
	 */
	public Workspace() {
	}

	/**
	 * Get the value of property {@code subPath}.
	 *
	 * @return the value of {@code subPath}
	 */
	public String getSubPath() {
		return subPath;
	}

	/**
	 * Set the value of property {@code subPath}.
	 *
	 * @param subPath the value of {@code subPath}
	 */
	public void setSubPath(String subPath) {
		this.subPath = subPath;
	}
	
	/**
	 * Get the value of property {@code subPath}.
	 *
	 * @param defaultName fallback path value
	 * @return the value of {@code subPath}
	 */
	public String getRequiredSubPath(String defaultName) {
		return StringUtil.hasText(subPath) ? subPath : defaultName;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("subPath", subPath)
				;
	}

}
