package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.einnovator.util.MappingUtils;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
abstract public class Deployable extends AnnotatedEntity {

	public static final String SEPARATOR = " ";

	private DeploymentKind kind;

	private Stack stack;

	private SolutionType type;
	
	private String solutionRepoId;

	private String solutionId;

	protected String plan;

	protected String subplan;

	protected Manager manager;

	protected Image image;

	//
	// CICD
	//
	
	protected Image buildImage;
		
	protected String builder;

	protected String builderKind;

	protected Workspace workspace;

	protected List<Repository> repositories;

	protected Webhook webhook;

	//
	
	protected List<Instance> instances;

	protected Boolean autoBindings;

	protected Boolean skipUnbound;

	protected Boolean autoEnv;

	protected Boolean spaceEnv;

	protected Boolean clusterEnv;

	protected Boolean vcap;

	protected Boolean start;

	protected Resources resources;

	protected Bill bill;

	//Simple
	
	protected String serviceAccountName;

	protected ImagePullPolicy imagePullPolicy;
	
	protected RestartPolicy restartPolicy;
	
	protected Long activeDeadline;
	
	protected Probe livenessProbe;

	protected Probe readinessProbe;

	protected List<Variable> env;

	protected List<Binding> bindings;

	protected List<String> command;
	
	protected List<String> args;

	protected List<Mount> mounts;


	//Manifest
	
	protected String manifest;

	//External

	protected String url;

	//
	// Constructor
	//

	/**
	 * Create instance of {@code Deployable}.
	 *
	 */
	public Deployable() {
	}
	
	/**
	 * Create instance of {@code Deployable}.
	 *
	 * @param obj a prototype
	 */
	public Deployable(Object obj) {
		super(obj);
	}
	
	//
	// Getter/Setter
	//
	
	/**
	 * Get the value of property {@code kind}.
	 *
	 * @return the kind
	 */
	public DeploymentKind getKind() {
		return kind;
	}

	/**
	 * Set the value of property {@code kind}.
	 *
	 * @param kind the value of property kind
	 */
	public void setKind(DeploymentKind kind) {
		this.kind = kind;
	}
	
	@JsonIgnore
	public DeploymentKind getRequiredKind() {
		return kind!=null ? kind : DeploymentKind.DEPLOYMENT;
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
	 * @param type the value of property type
	 */
	public void setType(SolutionType type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code url}.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the value of property {@code url}.
	 *
	 * @param url the value of property url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Get the value of property {@code image}.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Get the value of property {@code buildImage}.
	 *
	 * @return the buildImage
	 */
	public Image getBuildImage() {
		return buildImage;
	}

	/**
	 * Set the value of property {@code buildImage}.
	 *
	 * @param buildImage the value of property buildImage
	 */
	public void setBuildImage(Image buildImage) {
		this.buildImage = buildImage;
	}

	/**
	 * Get the value of property {@code command}.
	 *
	 * @return the command
	 */
	public List<String> getCommand() {
		return command;
	}

	/**
	 * Set the value of property {@code command}.
	 *
	 * @param command the command to set
	 */
	public void setCommand(List<String> command) {
		this.command = command;
	}

	/**
	 * Get the value of property {@code args}.
	 *
	 * @return the args
	 */
	public List<String> getArgs() {
		return args;
	}

	/**
	 * Set the value of property {@code args}.
	 *
	 * @param args the args to set
	 */
	public void setArgs(List<String> args) {
		this.args = args;
	}

	/**
	 * Get the value of property {@code solutionRepoId}.
	 *
	 * @return the solutionRepoId
	 */
	public String getSolutionRepoId() {
		return solutionRepoId;
	}

	/**
	 * Set the value of property {@code solutionRepoId}.
	 *
	 * @param solutionRepoId the value of property solutionRepoId
	 */
	public void setSolutionRepoId(String solutionRepoId) {
		this.solutionRepoId = solutionRepoId;
	}

	/**
	 * Get the value of property {@code solutionId}.
	 *
	 * @return the solutionId
	 */
	public String getSolutionId() {
		return solutionId;
	}

	/**
	 * Set the value of property {@code solutionId}.
	 *
	 * @param solutionId the value of property solutionId
	 */
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}

	/**
	 * Get the value of property {@code plan}.
	 *
	 * @return the plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * Set the value of property {@code plan}.
	 *
	 * @param plan the plan to set
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	/**
	 * Get the value of property {@code resources}.
	 *
	 * @return the resources
	 */
	public Resources getResources() {
		return resources;
	}


	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the resources to set
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
	}
	
	/**
	 * Get the value of property {@code instances}.
	 *
	 * @return the instances
	 */
	public List<Instance> getInstances() {
		return instances;
	}

	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances to set
	 */
	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	/**
	 * Get the value of property {@code bill}.
	 *
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * Set the value of property {@code bill}.
	 *
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
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
	 * Get the value of property {@code imagePullPolicy}.
	 *
	 * @return the imagePullPolicy
	 */
	public ImagePullPolicy getImagePullPolicy() {
		return imagePullPolicy;
	}

	/**
	 * Set the value of property {@code imagePullPolicy}.
	 *
	 * @param imagePullPolicy the value of property imagePullPolicy
	 */
	public void setImagePullPolicy(ImagePullPolicy imagePullPolicy) {
		this.imagePullPolicy = imagePullPolicy;
	}

	public ImagePullPolicy getRequiredImagePullPolicy() {
		return imagePullPolicy!=null ? imagePullPolicy : ImagePullPolicy.ALWAYS;
	}

	/**
	 * Get the value of property {@code livenessProbe}.
	 *
	 * @return the livenessProbe
	 */
	public Probe getLivenessProbe() {
		return livenessProbe;
	}

	/**
	 * Set the value of property {@code livenessProbe}.
	 *
	 * @param livenessProbe the livenessProbe to set
	 */
	public void setLivenessProbe(Probe livenessProbe) {
		this.livenessProbe = livenessProbe;
	}

	/**
	 * Get the value of property {@code readinessProbe}.
	 *
	 * @return the readinessProbe
	 */
	public Probe getReadinessProbe() {
		return readinessProbe;
	}

	/**
	 * Set the value of property {@code readinessProbe}.
	 *
	 * @param readinessProbe the readinessProbe to set
	 */
	public void setReadinessProbe(Probe readinessProbe) {
		this.readinessProbe = readinessProbe;
	}


	/**
	 * Get the value of property {@code subplan}.
	 *
	 * @return the subplan
	 */
	public String getSubplan() {
		return subplan;
	}

	/**
	 * Set the value of property {@code subplan}.
	 *
	 * @param subplan the subplan to set
	 */
	public void setSubplan(String subplan) {
		this.subplan = subplan;
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
	 * Get the value of property {@code repositories}.
	 *
	 * @return the repositories
	 */
	public List<Repository> getRepositories() {
		return repositories;
	}

	/**
	 * Set the value of property {@code repositories}.
	 *
	 * @param repositories the repositories to set
	 */
	public void setRepositories(List<Repository> repositories) {
		this.repositories = repositories;
	}


	/**
	 * Get the value of property {@code serviceAccountName}.
	 *
	 * @return the serviceAccountName
	 */
	public String getServiceAccountName() {
		return serviceAccountName;
	}

	/**
	 * Set the value of property {@code serviceAccountName}.
	 *
	 * @param serviceAccountName the serviceAccountName to set
	 */
	public void setServiceAccountName(String serviceAccountName) {
		this.serviceAccountName = serviceAccountName;
	}
	
	/**
	 * Get the value of property {@code autoBindings}.
	 *
	 * @return the autoBindings
	 */
	public Boolean getAutoBindings() {
		return autoBindings;
	}

	/**
	 * Set the value of property {@code autoBindings}.
	 *
	 * @param autoBindings the autoBindings to set
	 */
	public void setAutoBindings(Boolean autoBindings) {
		this.autoBindings = autoBindings;
	}

	/**
	 * Get the value of property {@code skipUnbound}.
	 *
	 * @return the skipUnbound
	 */
	public Boolean getSkipUnbound() {
		return skipUnbound;
	}

	/**
	 * Set the value of property {@code skipUnbound}.
	 *
	 * @param skipUnbound the skipUnbound to set
	 */
	public void setSkipUnbound(Boolean skipUnbound) {
		this.skipUnbound = skipUnbound;
	}


	/**
	 * Get the value of property {@code autoEnv}.
	 *
	 * @return the autoEnv
	 */
	public Boolean getAutoEnv() {
		return autoEnv;
	}

	/**
	 * Set the value of property {@code autoEnv}.
	 *
	 * @param autoEnv the autoEnv to set
	 */
	public void setAutoEnv(Boolean autoEnv) {
		this.autoEnv = autoEnv;
	}

	/**
	 * Get the value of property {@code spaceEnv}.
	 *
	 * @return the spaceEnv
	 */
	public Boolean getSpaceEnv() {
		return spaceEnv;
	}

	/**
	 * Set the value of property {@code spaceEnv}.
	 *
	 * @param spaceEnv the value of property spaceEnv
	 */
	public void setSpaceEnv(Boolean spaceEnv) {
		this.spaceEnv = spaceEnv;
	}

	/**
	 * Get the value of property {@code clusterEnv}.
	 *
	 * @return the clusterEnv
	 */
	public Boolean getClusterEnv() {
		return clusterEnv;
	}

	/**
	 * Set the value of property {@code clusterEnv}.
	 *
	 * @param clusterEnv the value of property clusterEnv
	 */
	public void setClusterEnv(Boolean clusterEnv) {
		this.clusterEnv = clusterEnv;
	}

	/**
	 * Get the value of property {@code vcap}.
	 *
	 * @return the vcap
	 */
	public Boolean getVcap() {
		return vcap;
	}

	/**
	 * Set the value of property {@code vcap}.
	 *
	 * @param vcap the vcap to set
	 */
	public void setVcap(Boolean vcap) {
		this.vcap = vcap;
	}

	/**
	 * Get the value of property {@code restartPolicy}.
	 *
	 * @return the restartPolicy
	 */
	public RestartPolicy getRestartPolicy() {
		return restartPolicy;
	}

	/**
	 * Set the value of property {@code restartPolicy}.
	 *
	 * @param restartPolicy the restartPolicy to set
	 */
	public void setRestartPolicy(RestartPolicy restartPolicy) {
		this.restartPolicy = restartPolicy;
	}

	/**
	 * Get the value of property {@code activeDeadline}.
	 *
	 * @return the activeDeadline
	 */
	public Long getActiveDeadline() {
		return activeDeadline;
	}

	/**
	 * Set the value of property {@code activeDeadline}.
	 *
	 * @param activeDeadline the activeDeadline to set
	 */
	public void setActiveDeadline(Long activeDeadline) {
		this.activeDeadline = activeDeadline;
	}
	
	
	/**
	 * Get the value of property {@code mounts}.
	 *
	 * @return the mounts
	 */
	public List<Mount> getMounts() {
		return mounts;
	}

	/**
	 * Set the value of property {@code mounts}.
	 *
	 * @param mounts the mounts to set
	 */
	public void setMounts(List<Mount> mounts) {
		this.mounts = mounts;
	}	

	/**
	 * Get the value of property {@code builder}.
	 *
	 * @return the builder
	 */
	public String getBuilder() {
		return builder;
	}

	/**
	 * Set the value of property {@code builder}.
	 *
	 * @param builder the value of property builder
	 */
	public void setBuilder(String builder) {
		this.builder = builder;
	}

	/**
	 * Get the value of property {@code builderKind}.
	 *
	 * @return the builderKind
	 */
	public String getBuilderKind() {
		return builderKind;
	}

	/**
	 * Set the value of property {@code builderKind}.
	 *
	 * @param builderKind the value of property builderKind
	 */
	public void setBuilderKind(String builderKind) {
		this.builderKind = builderKind;
	}
	
	/**
	 * Get the value of property {@code start}.
	 *
	 * @return the start
	 */
	public Boolean getStart() {
		return start;
	}

	/**
	 * Set the value of property {@code start}.
	 *
	 * @param start the start to set
	 */
	public void setStart(Boolean start) {
		this.start = start;
	}

	//
	// With
	//

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 * @return this {@code Deployable}
	 */
	public Deployable withType(SolutionType type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code url}.
	 *
	 * @param url the value of property url
	 * @return this {@code Deployable}
	 */
	public Deployable withUrl(String url) {
		this.url = url;
		return this;
	}

	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the image to with
	 * @return this {@code Deployable}
	 */
	public Deployable withImage(Image image) {
		this.image = image;
		return this;
	}

	/**
	 * Set the value of property {@code buildImage}.
	 *
	 * @param buildImage the value of property buildImage
	 * @return this {@code Deployable}
	 */
	public Deployable withBuildImage(Image buildImage) {
		this.buildImage = buildImage;
		return this;
	}

	/**
	 * Set the value of property {@code command}.
	 *
	 * @param command the command to with
	 * @return this {@code Deployable}
	 */
	public Deployable withCommand(List<String> command) {
		this.command = command;
		return this;
	}


	/**
	 * Set the value of property {@code args}.
	 *
	 * @param args the args to with
	 * @return this {@code Deployable}
	 */
	public Deployable withArgs(List<String> args) {
		this.args = args;
		return this;
	}


	/**
	 * Set the value of property {@code solutionRepoId}.
	 *
	 * @param solutionRepoId the value of property solutionRepoId
	 * @return this {@code Deployable}
	 */
	public Deployable withSolutionRepoId(String solutionRepoId) {
		this.solutionRepoId = solutionRepoId;
		return this;
	}


	/**
	 * Set the value of property {@code solutionId}.
	 *
	 * @param solutionId the value of property solutionId
	 * @return this {@code Deployable}
	 */
	public Deployable withSolutionId(String solutionId) {
		this.solutionId = solutionId;
		return this;
	}

	/**
	 * Set the value of property {@code plan}.
	 *
	 * @param plan the plan to with
	 * @return this {@code Deployable}
	 */
	public Deployable withPlan(String plan) {
		this.plan = plan;
		return this;
	}


	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the resources to with
	 * @return this {@code Deployable}
	 */
	public Deployable withResources(Resources resources) {
		this.resources = resources;
		return this;
	}

	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances to with
	 * @return this {@code Deployable}
	 */
	public Deployable withInstances(List<Instance> instances) {
		this.instances = instances;
		return this;
	}

	/**
	 * Set the value of property {@code bill}.
	 *
	 * @param bill the bill to with
	 * @return this {@code Deployable}
	 */
	public Deployable withBill(Bill bill) {
		this.bill = bill;
		return this;
	}

	/**
	 * Set the value of property {@code manager}.
	 *
	 * @param manager the manager to with
	 * @return this {@code Deployable}
	 */
	public Deployable withManager(Manager manager) {
		this.manager = manager;
		return this;
	}

	/**
	 * Set the value of property {@code stack}.
	 *
	 * @param stack the stack to with
	 * @return this {@code Deployable}
	 */
	public Deployable withStack(Stack stack) {
		this.stack = stack;
		return this;
	}

	/**
	 * Set the value of property {@code imagePullPolicy}.
	 *
	 * @param imagePullPolicy the value of property imagePullPolicy
	 * @return this {@code Deployable}
	 */
	public Deployable withImagePullPolicy(ImagePullPolicy imagePullPolicy) {
		this.imagePullPolicy = imagePullPolicy;
		return this;
	}


	/**
	 * Set the value of property {@code livenessProbe}.
	 *
	 * @param livenessProbe the livenessProbe to with
	 * @return this {@code Deployable}
	 */
	public Deployable withLivenessProbe(Probe livenessProbe) {
		this.livenessProbe = livenessProbe;
		return this;
	}


	/**
	 * Set the value of property {@code readinessProbe}.
	 *
	 * @param readinessProbe the readinessProbe to with
	 * @return this {@code Deployable}
	 */
	public Deployable withReadinessProbe(Probe readinessProbe) {
		this.readinessProbe = readinessProbe;
		return this;
	}

	/**
	 * Set the value of property {@code subplan}.
	 *
	 * @param subplan the subplan to with
	 * @return this {@code Deployable}
	 */
	public Deployable withSubplan(String subplan) {
		this.subplan = subplan;
		return this;
	}


	/**
	 * Set the value of property {@code manifest}.
	 *
	 * @param manifest the manifest to with
	 * @return this {@code Deployable}
	 */
	public Deployable withManifest(String manifest) {
		this.manifest = manifest;
		return this;
	}


	/**
	 * Set the value of property {@code repositories}.
	 *
	 * @param repositories the repositories to with
	 * @return this {@code Deployable}
	 */
	public Deployable withRepositories(List<Repository> repositories) {
		this.repositories = repositories;
		return this;
	}

	/**
	 * Set the value of property {@code serviceAccountName}.
	 *
	 * @param serviceAccountName the serviceAccountName to with
	 * @return this {@code Deployable}
	 */
	public Deployable withServiceAccountName(String serviceAccountName) {
		this.serviceAccountName = serviceAccountName;
		return this;
	}

	/**
	 * Set the value of property {@code autoBindings}.
	 *
	 * @param autoBindings the autoBindings to with
	 * @return this {@code Deployable}
	 */
	public Deployable withAutoBindings(Boolean autoBindings) {
		this.autoBindings = autoBindings;
		return this;
	}

	/**
	 * Set the value of property {@code skipUnbound}.
	 *
	 * @param skipUnbound the skipUnbound to with
	 * @return this {@code Deployable}
	 */
	public Deployable withSkipUnbound(Boolean skipUnbound) {
		this.skipUnbound = skipUnbound;
		return this;
	}

	/**
	 * Set the value of property {@code autoEnv}.
	 *
	 * @param autoEnv the autoEnv to with
	 * @return this {@code Deployable}
	 */
	public Deployable withAutoEnv(Boolean autoEnv) {
		this.autoEnv = autoEnv;
		return this;
	}


	/**
	 * Set the value of property {@code spaceEnv}.
	 *
	 * @param spaceEnv the value of property spaceEnv
	 * @return this {@code Deployable}
	 */
	public Deployable withSpaceEnv(Boolean spaceEnv) {
		this.spaceEnv = spaceEnv;
		return this;
	}

	/**
	 * Set the value of property {@code clusterEnv}.
	 *
	 * @param clusterEnv the value of property clusterEnv
	 * @return this {@code Deployable}
	 */
	public Deployable withClusterEnv(Boolean clusterEnv) {
		this.clusterEnv = clusterEnv;
		return this;
	}

	/**
	 * Set the value of property {@code vcap}.
	 *
	 * @param vcap the vcap to with
	 * @return this {@code Deployable}
	 */
	public Deployable withVcap(Boolean vcap) {
		this.vcap = vcap;
		return this;
	}

	/**
	 * Set the value of property {@code restartPolicy}.
	 *
	 * @param restartPolicy the restartPolicy to with
	 * @return this {@code Deployable}
	 */
	public Deployable withRestartPolicy(RestartPolicy restartPolicy) {
		this.restartPolicy = restartPolicy;
		return this;
	}

	/**
	 * Set the value of property {@code activeDeadline}.
	 *
	 * @param activeDeadline the activeDeadline to with
	 * @return this {@code Deployable}
	 */
	public Deployable withActiveDeadline(Long activeDeadline) {
		this.activeDeadline = activeDeadline;
		return this;
	}


	/**
	 * Set the value of property {@code mounts}.
	 *
	 * @param mounts the mounts to with
	 * @return this {@code Deployable}
	 */
	public Deployable withMounts(List<Mount> mounts) {
		this.mounts = mounts;
		return this;
	}	

	/**
	 * Set the value of property {@code builder}.
	 *
	 * @param builder the value of property builder
	 * @return this {@code Deployable}
	 */
	public Deployable withBuilder(String builder) {
		this.builder = builder;
		return this;
	}

	/**
	 * Set the value of property {@code builderKind}.
	 *
	 * @param builderKind the value of property builderKind
	 * @return this {@code Deployable}
	 */
	public Deployable withBuilderKind(String builderKind) {
		this.builderKind = builderKind;
		return this;
	}

	/**
	 * Set the value of property {@code start}.
	 *
	 * @param start the start to with
	 * @return this {@code Deployable}
	 */
	public Deployable withStart(Boolean start) {
		this.start = start;
		return this;
	}

	//
	// Mount
	//
	
	public void addMount(Mount mount) {
		if (mounts==null) {
			mounts = new ArrayList<Mount>();
		}
		mounts.add(mount);
	}

	public void addMounts(Iterable<Mount> mounts) {
		if (mounts!=null) {
			for (Mount mount: mounts) {
				addMount(mount);
			}
		}
	}

	public Mount removeMount(int index) {
		if (mounts==null || index <0 || index>= mounts.size()) {
			return null;
		}
		return mounts.remove(index);
	}

	public Mount getMount(int index) {
		if (mounts==null || index <0 || index>= mounts.size()) {
			return null;
		}
		return mounts.get(index);
	}

	public Mount findMount(Mount mount) {
		if (mount!=null && mounts!=null) {
			for (Mount mount2: mounts) {
				if ((mount2.getId()!=null && mount2.getId().equals(mount.getId())) 
						|| (mount2.getUuid()!=null && mount2.getUuid().equals(mount.getUuid()))) {
					return mount2;
				}
			}
		}
		return null;
	}

	public Mount findMount(String id) {
		if (id!=null && mounts!=null) {
			for (Mount mount: mounts) {
				if (id.equals(mount.getUuid()) || id.equals(mount.getName())) {
					return mount;
				}
			}
		}
		return null;
	}

	public Mount removeMount(Mount mount) {
		if (mount!=null && mounts!=null) {
			for (int i=0; i<mounts.size(); i++) {
				Mount mount2 = mounts.get(i);
				if ((mount2.getId()!=null && mount2.getId().equals(mount.getId())) || (mount2.getUuid()!=null && mount2.getUuid().equals(mount.getUuid()))) {
					return mounts.remove(i);
				}
			}
		}
		return null;
	}
	
	
	
	//
	// Repository
	//
	
	
	public Repository getActiveRepository() {
		return getRepository(0);
	}

	
	public void addRepository(Repository repo) {
		if (repositories==null) {
			repositories = new ArrayList<Repository>();
		}
		repositories.add(repo);				
	}


	public void addRepositories(Iterable<Repository> repos) {
		if (repositories!=null) {
			for (Repository repo: repositories) {
				addRepository(repo);
			}
		}
	}

	public Repository removeRepository(int index) {
		if (repositories==null || index <0 || index>= repositories.size()) {
			return null;
		}
		return repositories.remove(index);
	}

	public Repository getRepository(int index) {
		if (repositories==null || index <0 || index>= repositories.size()) {
			return null;
		}
		return repositories.get(index);
	}

	public Repository findRepository(Repository repo) {
		if (repo!=null && repositories!=null) {
			for (Repository repo2: repositories) {
				if ((repo2.getId()!=null && repo2.getId().equals(repo.getId())) ||
						(repo2.getUuid()!=null && repo2.getUuid().equals(repo.getUuid()))
					|| (repo2.getUrl()!=null && repo2.getUuid().equals(repo.getUrl()))) {
					return repo2;
				}
			}
		}
		return null;
	}

	public Repository findRepository(String id) {
		if (id!=null && repositories!=null) {
			try {
				return getRepository(Integer.parseInt(id));				
			} catch (NumberFormatException e) {
			}
			
			for (Repository repo: repositories) {
				if (id.equals(repo.getUuid()) || id.equals(repo.getName()) || id.equals(repo.getUrl())) {
					return repo;
				}
			}
		}
		return null;
	}

	public Repository removeRepository(Repository repo) {
		if (repo!=null && repositories!=null) {
			for (int i=0; i<repositories.size(); i++) {
				Repository repo2 = repositories.get(i);
				if ((repo2.getId()!=null && repo2.getId().equals(repo.getId())) || (repo2.getUuid()!=null && repo2.getUuid().equals(repo.getUuid()))
						|| (repo2.getUrl()!=null && repo2.getUrl().equals(repo.getUrl())))  {
					return repositories.remove(i);
				}
			}
		}
		return null;
	}
	
	public Repository removeRepository(String id) {
		if (id!=null && repositories!=null) {
			try {
				return removeRepository(Integer.parseInt(id));				
			} catch (NumberFormatException e) {
			}
			for (int i=0; i<repositories.size(); i++) {
				Repository repo = repositories.get(i);
				if (id.equals(repo.getUuid()) || id.equals(repo.getName()) || id.equals(repo.getUrl())) {
					return repositories.remove(i);
				}
			}
		}
		return null;
	}
	
	//
	// Env
	//
	

	public void addVariable(Variable var) {
		if (env==null) {
			env = new ArrayList<Variable>();
		}
		env.add(var);
	}
	
	public void addOrUpdateVariable(Variable var) {
		Variable var0 = findVariable(var.getName());
		if (var0==null) {
			addVariable(new Variable(var));
		} else {
			MappingUtils.updateObjectFromNonNull(var0, var);
		}
	}

	public void addOrUpdateVariables(Collection<Variable> vars) {
		if (vars!=null) {
			for (Variable var: vars) {
				addOrUpdateVariable(var);
			}
		}
	}
	public Variable removeVariable(int index) {
		if (env==null || index <0 || index>= env.size()) {
			return null;
		}
		return env.remove(index);
	}

	public Variable getVariable(int index) {
		if (env==null || index <0 || index>= env.size()) {
			return null;
		}
		return env.get(index);
	}

	public Variable findVariable(Variable var) {
		if (var!=null && env!=null) {
			for (Variable var2: env) {
				if (var2.getName()!=null && var2.getName().equalsIgnoreCase(var.getName())) {
					return var2;
				}
			}
		}
		return null;
	}

	public Variable findVariable(String name) {
		if (name!=null && env!=null) {
			for (Variable var: env) {
				if (name.equalsIgnoreCase(var.getName())) {
					return var;
				}
			}
		}
		return null;
	}

	public Variable removeVariable(Variable var) {
		if (var!=null && env!=null) {
			for (int i=0; i<env.size(); i++) {
				Variable var2 = env.get(i);
				if (var2.getName()!=null && var2.getName().equalsIgnoreCase(var.getName())) {
					return env.remove(i);
				}
			}
		}
		return null;
	}

	public Variable removeVariable(String name) {
		if (name!=null && env!=null) {
			for (int i=0; i<env.size(); i++) {
				Variable var = env.get(i);
				if (name.equalsIgnoreCase(var.getName())) {
					return env.remove(i);
				}
			}
		}
		return null;
	}


	public Variable updateVariable(String name, Variable var) {
		if (env==null) {
			return null;
		}
		Variable var0 = findVariable(var);
		if (var0==null) {
			return null;
		}
		MappingUtils.updateObjectFromNonNull(var0, var);
		return var0;
	}

	
	public String getValue(String name) {
		Variable var = findVariable(name);
		return var!=null ? var.getValue() : null;
	}

	public void setValue(String name, String value) {
		Variable var = findVariable(name);
		if (var==null) {
			addVariable(new Variable(name, value));
		} else {
			var.setValue(value);
		}
	}

	public String updateValue(String name, String value) {
		Variable var = findVariable(name);
		if (var==null) {
			return null;
		}
		var.setValue(value);
		return value;
	}

	public String getVarType(String name) {
		Variable var = findVariable(name);
		return var!=null ? var.getType() : null;
	}

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("stack", stack)
				.append("image", image)
				.append("manager", manager)
				.append("command", command)
				.append("args", args)
				.append("resources", resources)
				.append("serviceAccountName", serviceAccountName)
				.append("imagePullPolicy", imagePullPolicy)
				.append("restartPolicy", restartPolicy)
				.append("activeDeadline", activeDeadline)
				.append("#manifest", manifest!=null ? manifest.length() : null)
				.append("url", url)
				.append("livenessProbe", livenessProbe)
				.append("readinessProbe", readinessProbe)
				.append("buildImage", buildImage)
				.append("builder", builder)
				.append("builderKind", builderKind)
				;
	}

	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(creator
				.append("kind", kind)
				.append("solutionId", solutionId)
				.append("solutionRepoId", solutionRepoId)
				.append("bindings", bindings)
				.append("mounts", mounts)
				.append("env", env)
				.append("repositories", repositories)
				.append("bill", bill)
				);
	}


	
}
