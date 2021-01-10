package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.ReplicaSet;
import org.einnovator.util.model.EntityOptions;
import org.einnovator.util.model.ToStringCreator;

public class ReplicaSetOptions extends EntityOptions<ReplicaSet> {

	private Boolean pods;

	
	//
	// Constructors
	//

	/**
	 * Create instance of {@code ReplicaSetOptions}.
	 *
	 */
	public ReplicaSetOptions() {
	}
	
	/**
	 * Create instance of {@code ReplicaSetOptions}.
	 *
	 * @param obj a prototype
	 */
	public ReplicaSetOptions(Object obj) {
		super(obj);
	}
	
	//
	// Getter/Setter
	//
	
	/**
	 * Get the value of property {@code pods}.
	 *
	 * @return the value pods
	 */
	public Boolean getPods() {
		return pods;
	}

	/**
	 * Set the value of property {@code pods}.
	 *
	 * @param pods the value pods
	 */
	public void setPods(Boolean pods) {
		this.pods = pods;
	}


	//
	// With
	//


	/**
	 * Set the value of property {@code pods}.
	 *
	 * @param pods the value pods
	 * @return this {@code ReplicaSetOptions}
	 */
	public ReplicaSetOptions withPods(Boolean pods) {
		this.pods = pods;
		return this;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("pods", pods)
				;
	}
}
