/**
 * 
 */
package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A {@code Repository}
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Repository extends NamedEntity {
	
	private RepositoryType type;

	private String url;

	private String branch;

	private String rootdir;

	private String vcsId;
	
	private Vcs vcs;
		
	/**
	 * Create instance of {@code Repository}.
	 *
	 */
	public Repository() {
	}	

	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the value of {@code type}
	 */
	public RepositoryType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of {@code type}
	 */
	public void setType(RepositoryType type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code url}.
	 *
	 * @return the value of {@code url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the value of property {@code url}.
	 *
	 * @param url the value of {@code url}
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get the value of property {@code branch}.
	 *
	 * @return the value of {@code branch}
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * Set the value of property {@code branch}.
	 *
	 * @param branch the value of {@code branch}
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * Get the value of property {@code rootdir}.
	 *
	 * @return the value of {@code rootdir}
	 */
	public String getRootdir() {
		return rootdir;
	}

	/**
	 * Set the value of property {@code rootdir}.
	 *
	 * @param rootdir the value of {@code rootdir}
	 */
	public void setRootdir(String rootdir) {
		this.rootdir = rootdir;
	}

	/**
	 * Get the value of property {@code vcsId}.
	 *
	 * @return the value of {@code vcsId}
	 */
	public String getVcsId() {
		return vcsId;
	}

	/**
	 * Set the value of property {@code vcsId}.
	 *
	 * @param vcsId the value of {@code vcsId}
	 */
	public void setVcsId(String vcsId) {
		this.vcsId = vcsId;
	}

	/**
	 * Get the value of property {@code vcs}.
	 *
	 * @return the value of {@code vcs}
	 */
	public Vcs getVcs() {
		return vcs;
	}

	/**
	 * Set the value of property {@code vcs}.
	 *
	 * @param vcs the value of {@code vcs}
	 */
	public void setVcs(Vcs vcs) {
		this.vcs = vcs;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("type", type)
			.append("url", url)
			.append("branch", branch)
			.append("rootdir", rootdir)
			.append("vcsId", vcsId)
			.append("vcs", vcs)
			;
	}
	
}
