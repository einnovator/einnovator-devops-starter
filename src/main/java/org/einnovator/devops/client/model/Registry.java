package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Registry extends OwnedEntity {

	private RegistryType type;

	private String username;

	private String email;

	private String password;

	private String server;
	
	private String secret;
	
	@JsonProperty("private")
	private Boolean private_;
	
	private Boolean builtin;
	
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
	 * @param type the type to set
	 */
	public void setType(RegistryType type) {
		this.type = type;
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
	 * @param server the server to set
	 */
	public void setServer(String server) {
		this.server = server;
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
	 * @param email the email to set
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
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

	//yml config hack
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Get the value of property {@code priv}.
	 *
	 * @return the priv
	 */
	public Boolean getPrivate() {
		return private_;
	}


	/**
	 * Set the value of property {@code priv}.
	 *
	 * @param priv the priv to set
	 */
	public void setPrivate(Boolean private_) {
		this.private_ = private_;
	}
	
	


	/**
	 * Get the value of property {@code builtin}.
	 *
	 * @return the builtin
	 */
	public Boolean getBuiltin() {
		return builtin;
	}


	/**
	 * Set the value of property {@code builtin}.
	 *
	 * @param builtin the builtin to set
	 */
	public void setBuiltin(Boolean builtin) {
		this.builtin = builtin;
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


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("server", server)
				.append("username", username)
				.append("email", email)
				.append("password", password)
				.append("private", private_)
				.append("builtin", builtin)
				.append("secret", secret)
				;
	}
	
	
}
