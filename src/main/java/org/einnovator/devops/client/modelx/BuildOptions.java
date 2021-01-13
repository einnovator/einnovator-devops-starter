package org.einnovator.devops.client.modelx;

import org.einnovator.devops.client.model.Build;
import org.einnovator.util.model.EntityOptions;
import org.einnovator.util.model.ToStringCreator;

/**
 * CI/CD Build options.
 *
 * @author support@einnovator.org
 */
public class BuildOptions extends EntityOptions<Build> {

	private String image;

	private String tag;

	private Boolean autodeploy;
	
	//
	// Constructors
	//

	/**
	 * Create instance of {@code BuildOptions}.
	 *
	 */
	public BuildOptions() {
	}

	//
	// Getter/Setter
	//

	/**
	 * Get the value of property {@code image}.
	 *
	 * @return the value of {@code image}
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the value of {@code image}
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Get the value of property {@code tag}.
	 *
	 * @return the value of {@code tag}
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Set the value of property {@code tag}.
	 *
	 * @param tag the value of {@code tag}
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Get the value of property {@code autodeploy}.
	 *
	 * @return the value of {@code autodeploy}
	 */
	public Boolean getAutodeploy() {
		return autodeploy;
	}

	/**
	 * Set the value of property {@code autodeploy}.
	 *
	 * @param autodeploy the value of {@code autodeploy}
	 */
	public void setAutodeploy(Boolean autodeploy) {
		this.autodeploy = autodeploy;
	}

	
	//
	// With
	//

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the value of {@code image}
	 * @return this {@code BuildOptions}
	 */
	public BuildOptions withImage(String image) {
		this.image = image;
		return this;
	}

	/**
	 * Set the value of property {@code tag}.
	 *
	 * @param tag the value of {@code tag}
	 * @return this {@code BuildOptions}
	 */
	public BuildOptions withTag(String tag) {
		this.tag = tag;
		return this;
	}

	/**
	 * Set the value of property {@code autodeploy}.
	 *
	 * @param autodeploy the value of {@code autodeploy}
	 * @return this {@code BuildOptions}
	 */
	public BuildOptions withAutodeploy(Boolean autodeploy) {
		this.autodeploy = autodeploy;
		return this;
	}
	
	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
				.append("image", image)
				.append("tag", tag)
				.append("autodeploy", autodeploy)
				;
	}

}
