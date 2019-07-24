package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ToStringCreator;

public class ImageFilter extends ImageOptions {
	
	private String q;
	
	private Boolean strict;
	
	public ImageFilter() {
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
	 * Get the value of property {@code strict}.
	 *
	 * @return the strict
	 */
	public Boolean getStrict() {
		return strict;
	}


	/**
	 * Set the value of property {@code strict}.
	 *
	 * @param strict the strict to set
	 */
	public void setStrict(Boolean strict) {
		this.strict = strict;
	}



	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q);
	}
	
}
