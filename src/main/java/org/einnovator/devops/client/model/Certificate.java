/**
 * 
 */
package org.einnovator.devops.client.model;

import java.util.Date;
import java.util.Map;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Certificate extends ObjectBase {

	private String name;

	private String secret;
	
	private String ca;

	private String crt;
	
	private String key;

	private Date expires;
	
	private Map<String, Object> meta;

	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param secret the secret
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * Get the value of property {@code ca}.
	 *
	 * @return the value of {@code ca}
	 */
	public String getCa() {
		return ca;
	}

	/**
	 * Set the value of property {@code ca}.
	 *
	 * @param ca the value of {@code ca}
	 */
	public void setCa(String ca) {
		this.ca = ca;
	}

	/**
	 * Get the value of property {@code crt}.
	 *
	 * @return the crt
	 */
	public String getCrt() {
		return crt;
	}

	/**
	 * Set the value of property {@code crt}.
	 *
	 * @param crt the crt
	 */
	public void setCrt(String crt) {
		this.crt = crt;
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
	 * @param key the key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the value of property {@code expires}.
	 *
	 * @return the expires
	 */
	public Date getExpires() {
		return expires;
	}

	/**
	 * Set the value of property {@code expires}.
	 *
	 * @param expires the expires
	 */
	public void setExpires(Date expires) {
		this.expires = expires;
	}

	/**
	 * Get the value of property {@code meta}.
	 *
	 * @return the meta
	 */
	public Map<String, Object> getMeta() {
		return meta;
	}

	/**
	 * Set the value of property {@code meta}.
	 *
	 * @param meta the meta
	 */
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("#ca", ca!=null ? ca.length() : null)
				.append("#crt", crt!=null ? crt.length() : null)
				.append("key", key!=null ? "******" : null)
				.append("expires", expires)
				.append("meta", meta)
				;
	}
	

}
