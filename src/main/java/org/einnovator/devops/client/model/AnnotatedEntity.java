package org.einnovator.devops.client.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnnotatedEntity extends NamedEntity {

	
	protected String xkind;
	
	protected Map<String, String> labels;

	protected Map<String, String> annotations;

	protected boolean uninstall;

	protected String release;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code AnnotatedEntity}.
	 *
	 */
	public AnnotatedEntity() {
	}
	
	public AnnotatedEntity(Object prototype) {
		super(prototype);
	}
	
	public AnnotatedEntity(String name) {
		super(name);
	}
	
	//
	// Getters/Setters
	//
	

	/**
	 * Get the value of property {@code xkind}.
	 *
	 * @return the xkind
	 */
	public String getXkind() {
		return xkind;
	}

	/**
	 * Set the value of property {@code xkind}.
	 *
	 * @param xkind the value of property xkind
	 */
	public void setXkind(String xkind) {
		this.xkind = xkind;
	}

	/**
	 * Get the value of property {@code labels}.
	 *
	 * @return the labels
	 */
	public Map<String, String> getLabels() {
		return labels;
	}

	/**
	 * Set the value of property {@code labels}.
	 *
	 * @param labels the value of property labels
	 */
	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	/**
	 * Get the value of property {@code annotations}.
	 *
	 * @return the annotations
	 */
	public Map<String, String> getAnnotations() {
		return annotations;
	}

	/**
	 * Set the value of property {@code annotations}.
	 *
	 * @param annotations the value of property annotations
	 */
	public void setAnnotations(Map<String, String> annotations) {
		this.annotations = annotations;
	}
	
	@JsonIgnore
	public String getAnnotation(String name) {
		if (annotations==null) {
			return null;
		}
		return annotations.get(name);
	}


	@JsonIgnore
	public String getLabel(String name) {
		if (labels==null) {
			return null;
		}
		return labels.get(name);
	}
	
	/**
	 * Get the value of property {@code uninstall}.
	 *
	 * @return the uninstall
	 */
	public boolean isUninstall() {
		return uninstall;
	}

	/**
	 * Set the value of property {@code uninstall}.
	 *
	 * @param uninstall the value of property uninstall
	 */
	public void setUninstall(boolean uninstall) {
		this.uninstall = uninstall;
	}

	/**
	 * Get the value of property {@code release}.
	 *
	 * @return the release
	 */
	public String getRelease() {
		return release;
	}

	/**
	 * Set the value of property {@code release}.
	 *
	 * @param release the value of property release
	 */
	public void setRelease(String release) {
		this.release = release;
	}
	
	
	public void addLabels(Map<String, String> labels) {
		if (labels!=null) {
			if (this.labels==null) {
				this.labels = labels;
			} else {
				this.labels.putAll(labels);
			}			
		}
	}
	public void addAnnotations(Map<String, String> annotations) {
		if (annotations!=null) {
			if (this.annotations==null) {
				this.annotations = annotations;
			} else {
				this.annotations.putAll(annotations);
			}			
		}
	}

	//
	//
	//
	
	/**
	 * Add annotation.
	 * 
	 * @param name the name
	 * @param value the value
	 * @return this {@code AnnotatedEntity}
	 */
	public AnnotatedEntity addAnnotation(String name, String value) {
		if (this.annotations==null) {
			this.annotations = new LinkedHashMap<String, String>();
		}
		this.annotations.put(name, value);
		return this;
	}

	/**
	 * Add label.
	 * 
	 * @param name the name
	 * @param value the value
	 * @return this {@code AnnotatedEntity}
	 */
	public AnnotatedEntity addLabel(String name, String value) {
		if (this.labels==null) {
			this.labels = new LinkedHashMap<String, String>();
		}
		this.labels.put(name, value);
		return this;
	}

	//
	// With
	//

	
	/**
	 * Set the value of property {@code xkind}.
	 *
	 * @param xkind the xkind
	 * @return this {@code AnnotatedEntity}
	 */
	public AnnotatedEntity withXkind(String xkind) {
		this.xkind = xkind;
		return this;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("xkind", xkind)
				.append("release", release)
				;
	}
	
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(creator
				.append("annotations", annotations)
				.append("labels", labels)
				);
	}
}
