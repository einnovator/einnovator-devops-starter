package org.einnovator.devops.client.model;

import java.util.Date;


import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Webhook extends ObjectBase {

	private Boolean enabled;

	private Boolean tagged;

	private Boolean adhoc;

	private String image;
	
	private String secret;

	private Long lastBuild;

	private Date lastBuildDate;

	private String commitId;

	private String commitUrl;

	private String ref;

	private String tag;

	private Boolean deploy;

	private Boolean deployTagged;

	public Webhook() {
	}

	/**
	 * Get the value of property {@code enabled}.
	 *
	 * @return the value of {@code enabled}
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the value of {@code enabled}
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	

	/**
	 * Get the value of property {@code tagged}.
	 *
	 * @return the value of {@code tagged}
	 */
	public Boolean getTagged() {
		return tagged;
	}

	/**
	 * Set the value of property {@code tagged}.
	 *
	 * @param tagged the value of {@code tagged}
	 */
	public void setTagged(Boolean tagged) {
		this.tagged = tagged;
	}

	/**
	 * Get the value of property {@code adhoc}.
	 *
	 * @return the value of {@code adhoc}
	 */
	public Boolean getAdhoc() {
		return adhoc;
	}

	/**
	 * Set the value of property {@code adhoc}.
	 *
	 * @param adhoc the value of {@code adhoc}
	 */
	public void setAdhoc(Boolean adhoc) {
		this.adhoc = adhoc;
	}

	/**
	 * Get the value of property {@code image}.
	 *
	 * @return the value of {@code image}
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the value of {@code image}
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Get the value of property {@code secret}.
	 *
	 * @return the value of {@code secret}
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * Set the value of property {@code secret}.
	 *
	 * @param secret the value of {@code secret}
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * Get the value of property {@code lastBuild}.
	 *
	 * @return the value of {@code lastBuild}
	 */
	public Long getLastBuild() {
		return lastBuild;
	}

	/**
	 * Set the value of property {@code lastBuild}.
	 *
	 * @param lastBuild the value of {@code lastBuild}
	 */
	public void setLastBuild(Long lastBuild) {
		this.lastBuild = lastBuild;
	}

	/**
	 * Get the value of property {@code lastBuildDate}.
	 *
	 * @return the value of {@code lastBuildDate}
	 */
	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	/**
	 * Set the value of property {@code lastBuildDate}.
	 *
	 * @param lastBuildDate the value of {@code lastBuildDate}
	 */
	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	/**
	 * Get the value of property {@code ref}.
	 *
	 * @return the value of {@code ref}
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Set the value of property {@code ref}.
	 *
	 * @param ref the value of {@code ref}
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * Get the value of property {@code commitId}.
	 *
	 * @return the value of {@code commitId}
	 */
	public String getCommitId() {
		return commitId;
	}

	/**
	 * Set the value of property {@code commitId}.
	 *
	 * @param commitId the value of {@code commitId}
	 */
	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}

	/**
	 * Get the value of property {@code commitUrl}.
	 *
	 * @return the value of {@code commitUrl}
	 */
	public String getCommitUrl() {
		return commitUrl;
	}

	/**
	 * Set the value of property {@code commitUrl}.
	 *
	 * @param commitUrl the value of {@code commitUrl}
	 */
	public void setCommitUrl(String commitUrl) {
		this.commitUrl = commitUrl;
	}

	/**
	 * Get the value of property {@code tag}.
	 *
	 * @return the value of {@code tag}
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Set the value of property {@code tag}.
	 *
	 * @param tag the value of {@code tag}
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/**
	 * Get the value of property {@code deploy}.
	 *
	 * @return the value of {@code deploy}
	 */
	public Boolean getDeploy() {
		return deploy;
	}

	/**
	 * Set the value of property {@code deploy}.
	 *
	 * @param deploy the value of {@code deploy}
	 */
	public void setDeploy(Boolean deploy) {
		this.deploy = deploy;
	}

	
	/**
	 * Get the value of property {@code deployTagged}.
	 *
	 * @return the value of {@code deployTagged}
	 */
	public Boolean getDeployTagged() {
		return deployTagged;
	}

	/**
	 * Set the value of property {@code deployTagged}.
	 *
	 * @param deployTagged the value of {@code deployTagged}
	 */
	public void setDeployTagged(Boolean deployTagged) {
		this.deployTagged = deployTagged;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("enabled", enabled)
				.append("tagged", tagged)
				.append("adhoc", adhoc)
				.append("secret", secret)
				.append("lastBuild", lastBuild)
				.append("lastBuildDate", lastBuildDate)
				.append("ref", ref)
				.append("commitId", commitId)
				.append("commitUrl", commitUrl)
				.append("tag", tag)
				.append("deploy", deploy)
				.append("deployTagged", deployTagged)
				;
	}
}
