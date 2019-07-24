package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Domain extends BilledEntity {
	
	private String dns;

	private Boolean sandbox;

	private Boolean verified;

	private String parent;

	private Boolean root;

	private Boolean enabled;

	private Boolean tls;
	
	private Certificate certificate;
	
	/**
	 * Create instance of {@code Cluster}.
	 *
	 */
	public Domain() {
	}

	
	
	/**
	 * Get the value of property {@code dns}.
	 *
	 * @return the dns
	 */
	public String getDns() {
		return dns;
	}


	/**
	 * Set the value of property {@code dns}.
	 *
	 * @param dns the dns to set
	 */
	public void setDns(String dns) {
		this.dns = dns;
	}



	/**
	 * Get the value of property {@code sandbox}.
	 *
	 * @return the sandbox
	 */
	public Boolean getSandbox() {
		return sandbox;
	}

	/**
	 * Set the value of property {@code sandbox}.
	 *
	 * @param sandbox the sandbox to set
	 */
	public void setSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
	}

	/**
	 * Get the value of property {@code verified}.
	 *
	 * @return the verified
	 */
	public Boolean getVerified() {
		return verified;
	}


	/**
	 * Set the value of property {@code verified}.
	 *
	 * @param verified the verified to set
	 */
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}


	/**
	 * Get the value of property {@code parent}.
	 *
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}


	/**
	 * Set the value of property {@code parent}.
	 *
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * Get the value of property {@code root}.
	 *
	 * @return the root
	 */
	public Boolean getRoot() {
		return root;
	}

	/**
	 * Set the value of property {@code root}.
	 *
	 * @param root the root to set
	 */
	public void setRoot(Boolean root) {
		this.root = root;
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
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Get the value of property {@code tls}.
	 *
	 * @return the tls
	 */
	public Boolean getTls() {
		return tls;
	}


	/**
	 * Set the value of property {@code tls}.
	 *
	 * @param tls the tls to set
	 */
	public void setTls(Boolean tls) {
		this.tls = tls;
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
	 * @param certificate the certificate to set
	 */
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}



	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("dns", dns)
				.append("sandbox", sandbox)
				.append("verified", verified)
				.append("parent", parent)
				.append("root", root)
				.append("enabled", enabled)
				.append("tls", tls)
				.append("certificate", certificate)	
				;
	}



	/**
	 * 
	 */
	public void normalize() {
		if (!Boolean.TRUE.equals(root)) {
			if (StringUtils.hasText(parent)) {
				if (StringUtils.hasText(name)) {
					dns = name + "." + parent;				
				}
			} else {
				if (!StringUtils.hasText(dns)) {
					dns = name;
				}
			}
		} else {
			if (!StringUtils.hasText(name)) {
				name = dns;
			}
			if (StringUtils.hasText(dns)) {
				dns = name;
			}
		}
	}
	

	
}
