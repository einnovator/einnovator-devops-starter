/**
 * 
 */
package org.einnovator.devops.client.config;

import org.einnovator.util.web.ClientContext;

/**
 *
 */
public class DevopsClientContext extends ClientContext {
	
	private DevopsClientConfiguration config;
	
	/**
	 * Create instance of {@code DevopsClientContext}.
	 *
	 */
	public DevopsClientContext() {
	}

	/**
	 * Get the value of property {@code config}.
	 *
	 * @return the config
	 */
	public DevopsClientConfiguration getConfig() {
		return config;
	}

	/**
	 * Set the value of property {@code config}.
	 *
	 * @param config the value of property config
	 */
	public void setConfig(DevopsClientConfiguration config) {
		this.config = config;
	}
	
}
