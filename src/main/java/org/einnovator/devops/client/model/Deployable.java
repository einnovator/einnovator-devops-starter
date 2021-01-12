package org.einnovator.devops.client.model;

import java.util.List;

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

	protected Repository repository;
	
	protected Webhook webhook;

	//
	
	protected List<Pod> instances;

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
	 * @param image the image
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
	 * @param command the command
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
	 * @param args the args
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
	 * @param plan the plan
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
	 * @param resources the resources
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
	}
	
	/**
	 * Get the value of property {@code instances}.
	 *
	 * @return the instances
	 */
	public List<Pod> getPods() {
		return instances;
	}

	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances
	 */
	public void setPods(List<Pod> instances) {
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
	 * @param bill the bill
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
	 * @param manager the manager
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
	 * @param stack the stack
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
	 * @param livenessProbe the livenessProbe
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
	 * @param readinessProbe the readinessProbe
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
	 * @param subplan the subplan
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
	 * @param manifest the manifest
	 */
	public void setManifest(String manifest) {
		this.manifest = manifest;
	}

	/**
	 * Get the value of property {@code repository}.
	 *
	 * @return the value of {@code repository}
	 */
	public Repository getRepository() {
		return repository;
	}

	/**
	 * Set the value of property {@code repository}.
	 *
	 * @param repository the value of {@code repository}
	 */
	public void setRepository(Repository repository) {
		this.repository = repository;
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
	 * @param serviceAccountName the serviceAccountName
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
	 * @param autoBindings the autoBindings
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
	 * @param skipUnbound the skipUnbound
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
	 * @param autoEnv the autoEnv
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
	 * @param vcap the vcap
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
	 * @param restartPolicy the restartPolicy
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
	 * @param activeDeadline the activeDeadline
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
	 * @param mounts the mounts
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
	 * @param start the start
	 */
	public void setStart(Boolean start) {
		this.start = start;
	}

	/**
	 * Get the value of property {@code workspace}.
	 *
	 * @return the value of {@code workspace}
	 */
	public Workspace getWorkspace() {
		return workspace;
	}

	/**
	 * Set the value of property {@code workspace}.
	 *
	 * @param workspace the value of {@code workspace}
	 */
	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	/**
	 * Get the value of property {@code webhook}.
	 *
	 * @return the value of {@code webhook}
	 */
	public Webhook getWebhook() {
		return webhook;
	}

	/**
	 * Set the value of property {@code webhook}.
	 *
	 * @param webhook the value of {@code webhook}
	 */
	public void setWebhook(Webhook webhook) {
		this.webhook = webhook;
	}

	/**
	 * Get the value of property {@code env}.
	 *
	 * @return the value of {@code env}
	 */
	public List<Variable> getEnv() {
		return env;
	}

	/**
	 * Set the value of property {@code env}.
	 *
	 * @param env the value of {@code env}
	 */
	public void setEnv(List<Variable> env) {
		this.env = env;
	}

	/**
	 * Get the value of property {@code bindings}.
	 *
	 * @return the value of {@code bindings}
	 */
	public List<Binding> getBindings() {
		return bindings;
	}

	/**
	 * Set the value of property {@code bindings}.
	 *
	 * @param bindings the value of {@code bindings}
	 */
	public void setBindings(List<Binding> bindings) {
		this.bindings = bindings;
	}
	
	/**
	 * Get the value of property {@code instances}.
	 *
	 * @return the value of {@code instances}
	 */
	public List<Pod> getInstances() {
		return instances;
	}

	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the value of {@code instances}
	 */
	public void setInstances(List<Pod> instances) {
		this.instances = instances;
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
	public Deployable withPods(List<Pod> instances) {
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

	/**
	 * Set the value of property {@code workspace}.
	 *
	 * @param workspace the value of {@code workspace}
	 * @return this {@code Deployable}
	 */
	public Deployable withWorkspace(Workspace workspace) {
		this.workspace = workspace;
		return this;
	}

	/**
	 * Set the value of property {@code webhook}.
	 *
	 * @param webhook the value of {@code webhook}
	 * @return this {@code Deployable}
	 */
	public Deployable withWebhook(Webhook webhook) {
		this.webhook = webhook;
		return this;
	}

	/**
	 * Set the value of property {@code env}.
	 *
	 * @param env the value of {@code env}
	 * @return this {@code Deployable}
	 */
	public Deployable withEnv(List<Variable> env) {
		this.env = env;
		return this;
	}

	/**
	 * Set the value of property {@code bindings}.
	 *
	 * @param bindings the value of {@code bindings}
	 * @return this {@code Deployable}
	 */
	public Deployable withBindings(List<Binding> bindings) {
		this.bindings = bindings;
		return this;
	}
	
	/**
	 * Set the value of property {@code repository}.
	 *
	 * @param repository the value of {@code repository}
	 * @return this {@code Deployable}
	 */
	public Deployable withRepository(Repository repository) {
		this.repository = repository;
		return this;
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
				.append("repository", repository)
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
				.append("bill", bill)
				);
	}


	
}
