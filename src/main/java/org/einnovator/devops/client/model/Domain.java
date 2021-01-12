package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

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

	private Boolean cert;

	private Boolean auto;

	private Boolean global;	
	
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
	 * @param dns the dns
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
	 * @param sandbox the sandbox
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
	 * @param verified the verified
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
	 * @param parent the parent
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
	 * @param root the root
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
	 * @param enabled the enabled
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
	 * @param tls the tls
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
	 * @param certificate the certificate
	 */
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	/**
	 * Get the value of property {@code cert}.
	 *
	 * @return the value of {@code cert}
	 */
	public Boolean getCert() {
		return cert;
	}

	/**
	 * Set the value of property {@code cert}.
	 *
	 * @param cert the value of {@code cert}
	 */
	public void setCert(Boolean cert) {
		this.cert = cert;
	}

	/**
	 * Get the value of property {@code auto}.
	 *
	 * @return the value of {@code auto}
	 */
	public Boolean getAuto() {
		return auto;
	}

	/**
	 * Set the value of property {@code auto}.
	 *
	 * @param auto the value of {@code auto}
	 */
	public void setAuto(Boolean auto) {
		this.auto = auto;
	}

	/**
	 * Get the value of property {@code global}.
	 *
	 * @return the value of {@code global}
	 */
	public Boolean getGlobal() {
		return global;
	}

	/**
	 * Set the value of property {@code global}.
	 *
	 * @param global the value of {@code global}
	 */
	public void setGlobal(Boolean global) {
		this.global = global;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("dns", dns)
				.append("sandbox", sandbox)
				.append("verified", verified)
				.append("parent", parent)
				.append("root", root)
				.append("enabled", enabled)
				.append("tls", tls)
				.append("enabled", enabled)
				.append("cert", cert)
				.append("auto", auto)
				.append("global", global)
				.append("certificate", certificate)	
				;
	}


	
}
