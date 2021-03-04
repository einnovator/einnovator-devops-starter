package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OSImage extends AnnotatedEntity {
	
	private String vendor;

	private String icon;

	private Integer size;
	
	//
	// Contructors
	//
	
	public OSImage() {
	}
	
	public OSImage(String name, String displayName, String vendor, String icon, Integer size) {
		this.name = name;
		this.displayName = displayName;
		this.vendor = vendor;
		this.size = size;
		this.icon = icon;
	}
	
	
	//
	// Getter/Setter
	//

	/**
	 * Get the value of property {@code vendor}.
	 *
	 * @return the value of {@code vendor}
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * Set the value of property {@code vendor}.
	 *
	 * @param vendor the value of {@code vendor}
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * Get the value of property {@code icon}.
	 *
	 * @return the value of {@code icon}
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * Set the value of property {@code icon}.
	 *
	 * @param icon the value of {@code icon}
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * Get the value of property {@code size}.
	 *
	 * @return the value of {@code size}
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the value of {@code size}
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("vendor", vendor)
				.append("icon", icon)
				.append("size", size)
				;
	}
	


}
