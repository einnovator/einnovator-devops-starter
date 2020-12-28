package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Domain;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Domain}s.
 *
 * @see Domain
 * @author support@einnovator.org
 *
 */
public class DomainFilter extends DomainOptions {
	
	private String q;
	
	private String owner;

	private Boolean root;

	private Boolean enabled;

	private Boolean tls;

	private Boolean cert;
	
	private Boolean auto;

	private Boolean global;
	
	private String parent;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code DomainFilter}.
	 *
	 */
	public DomainFilter() {
	}

	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the value of q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code owner}.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
	 * @return the value of {@code tls}
	 */
	public Boolean getTls() {
		return tls;
	}

	/**
	 * Set the value of property {@code tls}.
	 *
	 * @param tls the value of {@code tls}
	 */
	public void setTls(Boolean tls) {
		this.tls = tls;
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

	/**
	 * Get the value of property {@code parent}.
	 *
	 * @return the value of {@code parent}
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * Set the value of property {@code parent}.
	 *
	 * @param parent the value of {@code parent}
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withOwner(String owner) {
		this.owner = owner;
		return this;		
	}
	
	/**
	 * Set the value of property {@code root}.
	 *
	 * @param root the root
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withRoot(Boolean root) {
		this.root = root;
		return this;
	}

	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the enabled
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}
	

	/**
	 * Set the value of property {@code tls}.
	 *
	 * @param tls the value of {@code tls}
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withTls(Boolean tls) {
		this.tls = tls;
		return this;
	}

	/**
	 * Set the value of property {@code cert}.
	 *
	 * @param cert the value of {@code cert}
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withCert(Boolean cert) {
		this.cert = cert;
		return this;
	}

	/**
	 * Set the value of property {@code auto}.
	 *
	 * @param auto the value of {@code auto}
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withAuto(Boolean auto) {
		this.auto = auto;
		return this;
	}

	/**
	 * Set the value of property {@code global}.
	 *
	 * @param global the value of {@code global}
	 * @return this {@code DomainFilter}
	 */
	public DomainFilter withGlobal(Boolean global) {
		this.global = global;
		return this;
	}
	
	/**
	 * Set the value of property {@code parent}.
	 *
	 * @param parent the value of {@code parent}
	 */
	public DomainFilter withParent(String parent) {
		this.parent = parent;
		return this;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("root", root)
				.append("enabled", enabled)
				.append("root", root)
				.append("global", global)
				.append("auto", auto)
				.append("tls", tls)
				.append("cert", cert)
				.append("auto", auto)
				.append("parent", parent)
				.append("owner", owner)
				;
	}
	
}
