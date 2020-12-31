package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;

/**
 * A {@code VolumeClaimFilter}.
 *
 * @author support@einnovator.org
 *
 */
public class VolumeClaimFilter extends VolumeClaimOptions {
	
	private String q;
	

	/**
	 * Create instance of {@code VarFilter}.
	 *
	 */
	public VolumeClaimFilter() {
	}

	
	//
	//
	//

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
	 * @param q the value of property q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				;
	}
	
}
