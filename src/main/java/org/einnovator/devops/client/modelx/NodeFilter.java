package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Node;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Node}s.
 *
 * @see Node
 * @author support@einnovator.org
 *
 */
public class NodeFilter extends NodeOptions {
	
	private String q;
	
	
	/**
	 * Create instance of {@code NodeFilter}.
	 *
	 */
	public NodeFilter() {
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


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return creator
				.append("q", q)
				;
	}
	
	
}
