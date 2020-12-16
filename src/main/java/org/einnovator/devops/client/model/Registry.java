package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Registry extends ProtectedEntity {
	
	private RegistryType type;
	
	private String server;

	private CredentialsType credentialsType;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String token;
	
	private String key;
	
	private String jsonKey;
	
	private String keyRaw;
	
	private String secret;
	
	private Boolean global;
	
	
	/**
	 * Create instance of {@code Registry}.
	 *
	 */
	public Registry() {
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public RegistryType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 */
	public void setType(RegistryType type) {
		this.type = type;
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
	 * @param username the value of property username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the value of property {@code email}.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the value of property {@code email}.
	 *
	 * @param email the value of property email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @param password the value of property password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

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
	 * @param credentialsType the value of property credentialsType
	 */
	public void setCredentialsType(CredentialsType credentialsType) {
		this.credentialsType = credentialsType;
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
	 * @param token the value of property token
	 */
	public void setToken(String token) {
		this.token = token;
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
	 * @param jsonKey the value of property jsonKey
	 */
	public void setJsonKey(String jsonKey) {
		this.jsonKey = jsonKey;
	}

	/**
	 * Get the value of property {@code keyRaw}.
	 *
	 * @return the keyRaw
	 */
	public String getKeyRaw() {
		return keyRaw;
	}

	/**
	 * Set the value of property {@code keyRaw}.
	 *
	 * @param keyRaw the value of property keyRaw
	 */
	public void setKeyRaw(String keyRaw) {
		this.keyRaw = keyRaw;
	}

	/**
	 * Get the value of property {@code server}.
	 *
	 * @return the server
	 */
	public String getServer() {
		return server;
	}

	/**
	 * Set the value of property {@code server}.
	 *
	 * @param server the value of property server
	 */
	public void setServer(String server) {
		this.server = server;
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
	 * Get the value of property {@code global}.
	 *
	 * @return the global
	 */
	public Boolean getGlobal() {
		return global;
	}

	/**
	 * Set the value of property {@code global}.
	 *
	 * @param global the value of property global
	 */
	public void setGlobal(Boolean global) {
		this.global = global;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("server", server)
				.append("global", global)
				.append("credentialsType", credentialsType)
				.append("username", username)
				.append("email", email)
				.append("password", StringUtils.hasText(password) ? "******" : null)
				.append("token", StringUtils.hasText(token) ? "******" : null)
				.append("key", StringUtils.hasText(key) ? "******" : null)
				.append("jsonKey", StringUtils.hasText(jsonKey) ? "******" : null)
				.append("secret", StringUtils.hasText(secret) ? "******" : null)
				;
	}
	
}
