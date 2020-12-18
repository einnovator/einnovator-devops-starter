package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;

/**
 * {@code Deployment} manifest generation options.
 *
 * @author support@einnovator.org
 */
public class ManifestOptions extends DeploymentOptions {

	private String format;

	private Boolean local;

	//
	// Constructors
	//

	/**
	 * Create instance of {@code ManifestOptions}.
	 *
	 */
	public ManifestOptions() {
	}
	
	//
	// Getter/Setter
	//

	/**
	 * Get the value of property {@code format}.
	 *
	 * @return the value of {@code format}
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Set the value of property {@code format}.
	 *
	 * @param format the value of {@code format}
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Get the value of property {@code local}.
	 *
	 * @return the value of {@code local}
	 */
	public Boolean getLocal() {
		return local;
	}

	/**
	 * Set the value of property {@code local}.
	 *
	 * @param local the value of {@code local}
	 */
	public void setLocal(Boolean local) {
		this.local = local;
	}


	//
	// With
	//

	/**
	 * Set the value of property {@code format}.
	 *
	 * @param format the value of {@code format}
	 * @return this {@code ManifestOptions}
	 */
	public ManifestOptions withFormat(String format) {
		this.format = format;
		return this;

	}
	
	/**
	 * Set the value of property {@code local}.
	 *
	 * @param local the value of {@code local}
	 * @return this {@code ManifestOptions}
	 */
	public ManifestOptions withLocal(Boolean local) {
		this.local = local;
		return this;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("format", format)
				.append("local", local)
				;
	}
}
