package org.einnovator.devops.client.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * EInnovator Cloud Devops client configuration properties.
 * 
 */
@ConfigurationProperties("devops")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevopsClientConfiguration {

	public static String DEFAULT_SERVER = "http://localhost:2500";

	private String server = DEFAULT_SERVER;
	
	@NestedConfigurationProperty
	private ConnectionConfiguration connection = new ConnectionConfiguration();

	public DevopsClientConfiguration() {
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public ConnectionConfiguration getConnection() {
		return connection;
	}

	public void setConnection(ConnectionConfiguration connection) {
		this.connection = connection;
	}

		
}
