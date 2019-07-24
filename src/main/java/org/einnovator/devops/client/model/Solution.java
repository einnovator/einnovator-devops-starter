package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Solution extends ProtectedEntity {

	private SolutionType type;

	private List<Plan> plans;
	
	private List<Image> images;

	private List<Solution> solutions;

	private List<Label> labels;

	private List<Annotation> annotations;

	private List<Binding> bindings;

	private Stack stack;
	
	private Boolean featured;

	private Boolean popular;

	private Integer ndeploy;
	
	private Boolean stateful;

	private Environment env;

	private Manager manager;
	
	private String host;
	
	private Ports ports;
	
	private Boolean ignore;

	private String uri;

	private String manifest;
	
	private Boolean license;

	public Solution() {
	}


	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public SolutionType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(SolutionType type) {
		this.type = type;
	}


	/**
	 * Get the value of property {@code plans}.
	 *
	 * @return the plans
	 */
	public List<Plan> getPlans() {
		return plans;
	}


	/**
	 * Set the value of property {@code plans}.
	 *
	 * @param plans the plans to set
	 */
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public void addPlan(Plan plan) {
		if (plans==null) {
			plans = new ArrayList<Plan>();
		}
		plans.add(plan);
	}

	public Plan removePlan(int index) {
		if (plans==null || index <0 || index>= plans.size()) {
			return null;
		}
		return plans.remove(index);
	}

	public Plan getPlan(int index) {
		if (plans==null || index <0 || index>= plans.size()) {
			return null;
		}
		return plans.get(index);
	}

	public Plan findPlan(Plan plan) {
		if (plan!=null && plans!=null) {
			for (Plan plan2: plans) {
				if ((plan2.getId()!=null && plan2.getId().equals(plan.getId())) || (plan2.getUuid()!=null && plan2.getUuid().equals(plan.getUuid()))) {
					return plan;
				}
			}
		}
		return null;
	}

	public Plan findPlan(String id) {
		if (id!=null && plans!=null) {
			for (Plan plan: plans) {
				if (id.equals(plan.getUuid()) || id.equals(plan.getKey())) {
					return plan;
				}
			}
		}
		return null;
	}
	
	public Plan findPlanByKey(String key) {
		if (key!=null && plans!=null) {
			for (Plan plan: plans) {
				if (key.equals(plan.getKey())) {
					return plan;
				}
			}
		}
		return null;		
	}

	public Plan removePlan(Plan plan) {
		if (plan!=null && plans!=null) {
			for (int i=0; i<plans.size(); i++) {
				Plan plan2 = plans.get(i);
				if ((plan2.getId()!=null && plan2.getId().equals(plan.getId())) || (plan2.getUuid()!=null && plan2.getUuid().equals(plan.getUuid()))) {
					return plans.remove(i);
				}
			}
		}
		return null;
	}


	/**
	 * Get the value of property {@code images}.
	 *
	 * @return the images
	 */
	public List<Image> getImages() {
		return images;
	}


	/**
	 * Set the value of property {@code images}.
	 *
	 * @param images the images to set
	 */
	public void setImages(List<Image> images) {
		this.images = images;
	}


	public void addImage(Image image) {
		if (images==null) {
			images = new ArrayList<Image>();
		}
		images.add(image);
	}

	public Image removeImage(int index) {
		if (images==null || index <0 || index>= images.size()) {
			return null;
		}
		return images.remove(index);
	}

	public Image getImage(int index) {
		if (images==null || index <0 || index>= images.size()) {
			return null;
		}
		return images.get(index);
	}

	public Image findImage(Image image) {
		if (image!=null && images!=null) {
			for (Image image2: images) {
				if ((image2.getId()!=null && image2.getId().equals(image.getId())) || (image2.getUuid()!=null && image2.getUuid().equals(image.getUuid()))) {
					return image;
				}
			}
		}
		return null;
	}

	public Image findImage(String id) {
		if (id!=null && images!=null) {
			for (Image image: images) {
				if (id.equals(image.getUuid())) {
					return image;
				}
			}
		}
		return null;
	}

	public Image removeImage(Image image) {
		if (image!=null && images!=null) {
			for (int i=0; i<images.size(); i++) {
				Image image2 = images.get(i);
				if ((image2.getId()!=null && image2.getId().equals(image.getId())) || (image2.getUuid()!=null && image2.getUuid().equals(image.getUuid()))) {
					return images.remove(i);
				}
			}
		}
		return null;
	}


	/**
	 * Get the value of property {@code solutions}.
	 *
	 * @return the solutions
	 */
	public List<Solution> getSolutions() {
		return solutions;
	}


	/**
	 * Set the value of property {@code solutions}.
	 *
	 * @param solutions the solutions to set
	 */
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	

	/**
	 * Get the value of property {@code labels}.
	 *
	 * @return the labels
	 */
	public List<Label> getLabels() {
		return labels;
	}

	/**
	 * Set the value of property {@code labels}.
	 *
	 * @param labels the labels to set
	 */
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	/**
	 * Get the value of property {@code annotations}.
	 *
	 * @return the annotations
	 */
	public List<Annotation> getAnnotations() {
		return annotations;
	}

	/**
	 * Set the value of property {@code annotations}.
	 *
	 * @param annotations the annotations to set
	 */
	public void setAnnotations(List<Annotation> annotations) {
		this.annotations = annotations;
	}

	/**
	 * Get the value of property {@code bindings}.
	 *
	 * @return the bindings
	 */
	public List<Binding> getBindings() {
		return bindings;
	}

	/**
	 * Set the value of property {@code bindings}.
	 *
	 * @param bindings the bindings to set
	 */
	public void setBindings(List<Binding> bindings) {
		this.bindings = bindings;
	}
	
	/**
	 * Get the value of property {@code featured}.
	 *
	 * @return the featured
	 */
	public Boolean getFeatured() {
		return featured;
	}

	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param featured the featured to set
	 */
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}


	/**
	 * Get the value of property {@code popular}.
	 *
	 * @return the popular
	 */
	public Boolean getPopular() {
		return popular;
	}

	/**
	 * Set the value of property {@code popular}.
	 *
	 * @param popular the popular to set
	 */
	public void setPopular(Boolean popular) {
		this.popular = popular;
	}

	/**
	 * Get the value of property {@code ndeploy}.
	 *
	 * @return the ndeploy
	 */
	public Integer getNdeploy() {
		return ndeploy;
	}

	/**
	 * Set the value of property {@code ndeploy}.
	 *
	 * @param ndeploy the ndeploy to set
	 */
	public void setNdeploy(Integer ndeploy) {
		this.ndeploy = ndeploy;
	}

	/**
	 * Get the value of property {@code env}.
	 *
	 * @return the env
	 */
	public Environment getEnv() {
		return env;
	}


	/**
	 * Set the value of property {@code env}.
	 *
	 * @param env the env to set
	 */
	public void setEnv(Environment env) {
		this.env = env;
	}

	/**
	 * Get the value of property {@code stateful}.
	 *
	 * @return the stateful
	 */
	public Boolean getStateful() {
		return stateful;
	}


	/**
	 * Set the value of property {@code stateful}.
	 *
	 * @param stateful the stateful to set
	 */
	public void setStateful(Boolean stateful) {
		this.stateful = stateful;
	}

	
	
	/**
	 * Get the value of property {@code stack}.
	 *
	 * @return the stack
	 */
	public Stack getStack() {
		return stack;
	}


	/**
	 * Set the value of property {@code stack}.
	 *
	 * @param stack the stack to set
	 */
	public void setStack(Stack stack) {
		this.stack = stack;
	}


	/**
	 * Get the value of property {@code manager}.
	 *
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}


	/**
	 * Set the value of property {@code manager}.
	 *
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}


	/**
	 * Get the value of property {@code host}.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}


	/**
	 * Set the value of property {@code host}.
	 *
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}


	/**
	 * Get the value of property {@code ports}.
	 *
	 * @return the ports
	 */
	public Ports getPorts() {
		return ports;
	}


	/**
	 * Set the value of property {@code ports}.
	 *
	 * @param ports the ports to set
	 */
	public void setPorts(Ports ports) {
		this.ports = ports;
	}


	/**
	 * Get the value of property {@code uri}.
	 *
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}


	/**
	 * Set the value of property {@code uri}.
	 *
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}


	/**
	 * Get the value of property {@code manifest}.
	 *
	 * @return the manifest
	 */
	public String getManifest() {
		return manifest;
	}


	/**
	 * Set the value of property {@code manifest}.
	 *
	 * @param manifest the manifest to set
	 */
	public void setManifest(String manifest) {
		this.manifest = manifest;
	}



	/**
	 * Get the value of property {@code ignore}.
	 *
	 * @return the ignore
	 */
	public Boolean getIgnore() {
		return ignore;
	}


	/**
	 * Set the value of property {@code ignore}.
	 *
	 * @param ignore the ignore to set
	 */
	public void setIgnore(Boolean ignore) {
		this.ignore = ignore;
	}


	/**
	 * Get the value of property {@code license}.
	 *
	 * @return the license
	 */
	public Boolean getLicense() {
		return license;
	}


	/**
	 * Set the value of property {@code license}.
	 *
	 * @param license the license to set
	 */
	public void setLicense(Boolean license) {
		this.license = license;
	}
	
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("stateful", stateful)
				.append("stack", stack)
				.append("manager", manager)
				.append("plans", plans)
				.append("images", images)
				.append("labels", labels)
				.append("annotations", annotations)
				.append("solutions", solutions)
				.append("bindings", bindings)
				.append("stateful", stateful)
				.append("featured", featured)
				.append("popular", popular)
				.append("ndeploy", ndeploy)
				.append("env", env)
				.append("uri", uri)
				.append("manifest", manifest)
				.append("license", license)
				;
	}
	

	public Image getLatestImage() {
		if (images==null || images.isEmpty()) {
			return null;
		}
		for (Image image: images) {
			if (image.getKey()!=null) {
				if (image.getKey().contains(":latest")) {
					return image;
				}				
			}
		}
		return images.get(0);
	}




}
