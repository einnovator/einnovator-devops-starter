/**
 * 
 */
package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.devops.client.modelx.RemoteManager;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Catalog extends NamedEntity {

	private SolutionRepoType type;

	private String url;

	private String path;

	private Boolean enabled;

	private Boolean remote;

	private Boolean license;

	private List<String> exclude;

	private List<String> featured;
	
	private Boolean checkFeatured;

	private String featuredRaw;

	private CredentialsType credentialsType;

	private String username;

	private String password;
	
	private Certificate certificate;

	private RemoteManager manager;

	/**
	 * Create instance of {@code SolutionRepo}.
	 *
	 */
	public Catalog() {	
	}

	//
	// Getters/Setters
	//


	/**
	 * Create instance of {@code SolutionRepo}.
	 *
	 * @param type the type
	 * @param name the name
	 * @param url the url
	 */
	public Catalog(SolutionRepoType type, String name, String url) {
		this.name = name;
		this.type = type;
		this.url = url;
	}


	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public SolutionRepoType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 */
	public void setType(SolutionRepoType type) {
		this.type = type;
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
	 * @param url the value of property url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get the value of property {@code path}.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Set the value of property {@code path}.
	 *
	 * @param path the value of property path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Get the value of property {@code enabled}.
	 *
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the value of property enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Get the value of property {@code license}.
	 *
	 * @return the license
	 */
	public Boolean getLicense() {
		return license;
	}



	/**
	 * Set the value of property {@code license}.
	 *
	 * @param license the value of property license
	 */
	public void setLicense(Boolean license) {
		this.license = license;
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
	 * Get the value of property {@code certificate}.
	 *
	 * @return the certificate
	 */
	public Certificate getCertificate() {
		return certificate;
	}

	/**
	 * Set the value of property {@code certificate}.
	 *
	 * @param certificate the value of property certificate
	 */
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	/**
	 * Get the value of property {@code remote}.
	 *
	 * @return the remote
	 */
	public Boolean getRemote() {
		return remote;
	}

	/**
	 * Set the value of property {@code remote}.
	 *
	 * @param remote the value of property remote
	 */
	public void setRemote(Boolean remote) {
		this.remote = remote;
	}



	/**
	 * Get the value of property {@code exclude}.
	 *
	 * @return the exclude
	 */
	public List<String> getExclude() {
		return exclude;
	}

	/**
	 * Set the value of property {@code exclude}.
	 *
	 * @param exclude the value of property exclude
	 */
	public void setExclude(List<String> exclude) {
		this.exclude = exclude;
	}

	/**
	 * Get the value of property {@code manager}.
	 *
	 * @return the manager
	 */
	public RemoteManager getManager() {
		return manager;
	}

	/**
	 * Set the value of property {@code manager}.
	 *
	 * @param manager the value of property manager
	 */
	public void setManager(RemoteManager manager) {
		this.manager = manager;
	}

	/**
	 * Get the value of property {@code featured}.
	 *
	 * @return the featured
	 */
	public List<String> getFeatured() {
		return featured;
	}

	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param featured the value of property featured
	 */
	public void setFeatured(List<String> featured) {
		this.featured = featured;
	}

	/**
	 * Get the value of property {@code featuredRaw}.
	 *
	 * @return the featuredRaw
	 */
	public String getFeaturedRaw() {
		return featuredRaw;
	}

	/**
	 * Set the value of property {@code featuredRaw}.
	 *
	 * @param featuredRaw the value of property featuredRaw
	 */
	public void setFeaturedRaw(String featuredRaw) {
		this.featuredRaw = featuredRaw;
	}

	/**
	 * Get the value of property {@code checkFeatured}.
	 *
	 * @return the checkFeatured
	 */
	public Boolean getCheckFeatured() {
		return checkFeatured;
	}

	/**
	 * Set the value of property {@code checkFeatured}.
	 *
	 * @param checkFeatured the value of property checkFeatured
	 */
	public void setCheckFeatured(Boolean checkFeatured) {
		this.checkFeatured = checkFeatured;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("url", url)
				.append("path", path)
				.append("enabled", enabled)
				.append("remote", remote)
				.append("exclude", exclude)
				.append("featured", featured)
				.append("checkFeatured", checkFeatured)
				.append("credentialsType", credentialsType)
				.append("username", username)
				.append("password", password)
				.append("certificate", certificate)
				.append("manager", manager)
				;
	}


}
