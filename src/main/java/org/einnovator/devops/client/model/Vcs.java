/**
 * 
 */
package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.util.model.ToStringCreator;
import org.einnovator.util.security.Authority;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vcs extends ProtectedEntity {

	private String url;

	private CredentialsType credentialsType;
	
	private String username;
	
	private String password;
	
	private String token;

	private String key;

	private String jsonKey;
	
	private String secret;

	private List<Authority> authorities;
	
	/**
	 * Create instance of {@code Vcs}.
	 *
	 */
	public Vcs() {
	}	
	
	
	//
	// Getters and setters
	//

	

	/**
	 * Get the value of property {@code credentialsType}.
	 *
	 * @return the credentialsType
	 */
	public CredentialsType getCredentialsType() {
		return credentialsType;
	}

	/**
	 * Set the value of property {@code credentialsType}.
	 *
	 * @param credentialsType the credentialsType to set
	 */
	public void setCredentialsType(CredentialsType credentialsType) {
		this.credentialsType = credentialsType;
	}

	/**
	 * Get the value of property {@code username}.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the value of property {@code username}.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the value of property {@code password}.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the value of property {@code password}.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the value of property {@code token}.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Set the value of property {@code token}.
	 *
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Get the value of property {@code url}.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}



	/**
	 * Set the value of property {@code url}.
	 *
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the value of property {@code jsonKey}.
	 *
	 * @return the jsonKey
	 */
	public String getJsonKey() {
		return jsonKey;
	}

	/**
	 * Set the value of property {@code jsonKey}.
	 *
	 * @param jsonKey the jsonKey to set
	 */
	public void setJsonKey(String jsonKey) {
		this.jsonKey = jsonKey;
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
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * Get the value of property {@code authorities}.
	 *
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * Set the value of property {@code authorities}.
	 *
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("url", url)
				.append("credentialsType", credentialsType)
				.append("username", username)
				.append("credentialsType", credentialsType)
				.append("password", StringUtils.hasText(password) ? "******" : null)
				.append("token", StringUtils.hasText(token) ? "******" : null)
				.append("key", StringUtils.hasText(key) ? "******" : null)
				.append("jsonKey", StringUtils.hasText(jsonKey) ? "******" : null)
				.append("secret", secret)
				.append("authorities", authorities)
				;
	}


}
