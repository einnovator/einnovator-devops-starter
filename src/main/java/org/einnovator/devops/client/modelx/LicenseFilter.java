package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.License;
import org.einnovator.devops.client.model.LicenseStatus;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code License}s.
 *
 * @see License
 * @author support@einnovator.org
 *
 */
public class LicenseFilter extends LicenseOptions {
	
	private String q;
	
	private LicenseStatus status;
	
	private String owner;
	
	public LicenseFilter() {
	}


	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public LicenseStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 */
	public void setStatus(LicenseStatus status) {
		this.status = status;
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
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	//
	// With
	//

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of q 
	 * @return this {@code ClusterFilter}
	 */
	public LicenseFilter withQ(String q) {
		this.q = q;
		return this;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("status", status)
				.append("owner", owner)
				;
	}
	
}
