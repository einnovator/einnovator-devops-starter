/**
 * 
 */
package org.einnovator.devops.client.model;

import org.einnovator.util.StringUtil;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Repository extends NamedEntity {

	
	private RepositoryType type;

	private String url;

	private Vcs vcs;
		
	private Boolean publik;

	/**
	 * Create instance of {@code Repository}.
	 *
	 */
	public Repository() {
	}	
	

	/**
	 * Create instance of {@code Repository}.
	 *
	 * @param obj a prototype
	 */
	public Repository(Object obj) {
		super(obj);
	}

	//
	// Getters and setters
	//

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the {@code type}
	 */
	public RepositoryType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the {@code type} to set
	 */
	public void setType(RepositoryType type) {
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
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	

	/**
	 * Get the value of property {@code vcs}.
	 *
	 * @return the vcs
	 */
	public Vcs getVcs() {
		return vcs;
	}

	/**
	 * Set the value of property {@code vcs}.
	 *
	 * @param vcs the vcs to set
	 */
	public void setVcs(Vcs vcs) {
		this.vcs = vcs;
	}

	/**
	 * Get the value of property {@code publik}.
	 *
	 * @return the publik
	 */
	public Boolean getPublic() {
		return publik;
	}



	/**
	 * Set the value of property {@code publik}.
	 *
	 * @param publik the publik to set
	 */
	public void setPublic(Boolean publik) {
		this.publik = publik;
	}

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("url", url)
				.append("public", publik)
				.append("vcs", vcs)
				;
	}

	public String getNormalizedName() {
		return StringUtil.normalizeCommonIdentifier(name);
	}
	

	
}
