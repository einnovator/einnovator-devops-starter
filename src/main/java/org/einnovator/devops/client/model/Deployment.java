package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deployment extends NamedEntity {

	protected SolutionType type;

	protected DeploymentStatus status;

	protected Boolean stateful;

	protected Stack stack;
	
	protected Integer replicas;

	protected Integer desiredReplicas;

	protected Integer readyReplicas;

	protected Integer availableReplicas;

	protected Integer unavailableReplicas;

	protected Integer updatedReplicas;

	protected Endpoint endpoints;

	protected Resources resources;

	protected Plan plan;

	protected Plan subplan;

	protected Solution solution;

	protected Manager manager;

	protected List<Route> routes;

	protected List<Binding> bindings;

	protected List<Connector> connectors;
	
	private List<Mount> mounts;
	
	private List<Repository> repositories;

	protected Boolean binds;
		
	protected Image image;

	protected List<Event> events;

	protected String serviceKey;

	protected String ingress;

	protected Boolean sandbox;

	protected Ports ports;
	
	protected String clusterIp;
	
	protected List<Instance> instances;
	
	protected Environment env;
	
	protected Map<String, String> envVars;
	
	
	protected Map<String, Object> meta;

	protected Map<String, Object> svcmeta;

	protected Bill bill;

	protected String livenessProbe;

	protected String readinessProbe;

	protected List<Label> labels;
	
	protected String manifest;
	
	public Deployment() {
	}
	
	public Deployment(Deployment deploy) {
		super(deploy);
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
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public DeploymentStatus getStatus() {
		return status;
	}


	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status to set
	 */
	public void setStatus(DeploymentStatus status) {
		this.status = status;
	}
	
	
	/**
	 * Get the value of property {@code clusterIp}.
	 *
	 * @return the clusterIp
	 */
	public String getClusterIp() {
		return clusterIp;
	}


	/**
	 * Set the value of property {@code clusterIp}.
	 *
	 * @param clusterIp the clusterIp to set
	 */
	public void setClusterIp(String clusterIp) {
		this.clusterIp = clusterIp;
	}


	/**
	 * Get the value of property {@code endpoints}.
	 *
	 * @return the endpoints
	 */
	public Endpoint getEndpoints() {
		return endpoints;
	}


	/**
	 * Set the value of property {@code endpoints}.
	 *
	 * @param endpoints the endpoints to set
	 */
	public void setEndpoints(Endpoint endpoints) {
		this.endpoints = endpoints;
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
	 * Get the value of property {@code events}.
	 *
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}


	/**
	 * Set the value of property {@code events}.
	 *
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void addEvent(Event event) {
		if (this.events==null) {
			this.events = new ArrayList<>();
		}
		this.events.add(event);
	}

	/**
	 * Get the value of property {@code solution}.
	 *
	 * @return the solution
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * Set the value of property {@code solution}.
	 *
	 * @param solution the solution to set
	 */
	public void setSolution(Solution solution) {
		this.solution = solution;
	}


	/**
	 * Get the value of property {@code plan}.
	 *
	 * @return the plan
	 */
	public Plan getPlan() {
		return plan;
	}

	/**
	 * Set the value of property {@code plan}.
	 *
	 * @param plan the plan to set
	 */
	public void setPlan(Plan plan) {
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
	 * Get the value of property {@code sandbox}.
	 *
	 * @return the sandbox
	 */
	public Boolean getSandbox() {
		return sandbox;
	}


	/**
	 * Set the value of property {@code sandbox}.
	 *
	 * @param sandbox the sandbox to set
	 */
	public void setSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
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
	 * Get the value of property {@code replicas}.
	 *
	 * @return the replicas
	 */
	public Integer getReplicas() {
		return replicas;
	}

	/**
	 * Set the value of property {@code replicas}.
	 *
	 * @param replicas the replicas to set
	 */
	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}


	/**
	 * Get the value of property {@code desiredReplicas}.
	 *
	 * @return the desiredReplicas
	 */
	public Integer getDesiredReplicas() {
		return desiredReplicas;
	}

	/**
	 * Set the value of property {@code desiredReplicas}.
	 *
	 * @param desiredReplicas the desiredReplicas to set
	 */
	public void setDesiredReplicas(Integer desiredReplicas) {
		this.desiredReplicas = desiredReplicas;
	}


	/**
	 * Get the value of property {@code readyReplicas}.
	 *
	 * @return the readyReplicas
	 */
	public Integer getReadyReplicas() {
		return readyReplicas;
	}

	/**
	 * Set the value of property {@code readyReplicas}.
	 *
	 * @param readyReplicas the readyReplicas to set
	 */
	public void setReadyReplicas(Integer readyReplicas) {
		this.readyReplicas = readyReplicas;
	}

	/**
	 * Get the value of property {@code availableReplicas}.
	 *
	 * @return the availableReplicas
	 */
	public Integer getAvailableReplicas() {
		return availableReplicas;
	}

	/**
	 * Set the value of property {@code availableReplicas}.
	 *
	 * @param availableReplicas the availableReplicas to set
	 */
	public void setAvailableReplicas(Integer availableReplicas) {
		this.availableReplicas = availableReplicas;
	}

	/**
	 * Get the value of property {@code unavailableReplicas}.
	 *
	 * @return the unavailableReplicas
	 */
	public Integer getUnavailableReplicas() {
		return unavailableReplicas;
	}

	/**
	 * Set the value of property {@code unavailableReplicas}.
	 *
	 * @param unavailableReplicas the unavailableReplicas to set
	 */
	public void setUnavailableReplicas(Integer unavailableReplicas) {
		this.unavailableReplicas = unavailableReplicas;
	}

	/**
	 * Get the value of property {@code updatedReplicas}.
	 *
	 * @return the updatedReplicas
	 */
	public Integer getUpdatedReplicas() {
		return updatedReplicas;
	}

	/**
	 * Set the value of property {@code updatedReplicas}.
	 *
	 * @param updatedReplicas the updatedReplicas to set
	 */
	public void setUpdatedReplicas(Integer updatedReplicas) {
		this.updatedReplicas = updatedReplicas;
	}
	
	/**
	 * Get the value of property {@code routes}.
	 *
	 * @return the routes
	 */
	public List<Route> getRoutes() {
		return routes;
	}

	/**
	 * Set the value of property {@code routes}.
	 *
	 * @param routes the routes to set
	 */
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
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
	 * Get the value of property {@code connectors}.
	 *
	 * @return the connectors
	 */
	public List<Connector> getConnectors() {
		return connectors;
	}


	/**
	 * Set the value of property {@code connectors}.
	 *
	 * @param connectors the connectors to set
	 */
	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
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
	 * Get the value of property {@code meta}.
	 *
	 * @return the meta
	 */
	public Map<String, Object> getMeta() {
		return meta;
	}


	/**
	 * Set the value of property {@code meta}.
	 *
	 * @param meta the meta to set
	 */
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	/**
	 * Get the value of property {@code svcmeta}.
	 *
	 * @return the svcmeta
	 */
	public Map<String, Object> getSvcmeta() {
		return svcmeta;
	}


	/**
	 * Set the value of property {@code svcmeta}.
	 *
	 * @param svcmeta the svcmeta to set
	 */
	public void setSvcmeta(Map<String, Object> svcmeta) {
		this.svcmeta = svcmeta;
	}


	/**
	 * Get the value of property {@code binds}.
	 *
	 * @return the binds
	 */
	public Boolean getBinds() {
		return binds;
	}


	/**
	 * Set the value of property {@code binds}.
	 *
	 * @param binds the binds to set
	 */
	public void setBinds(Boolean binds) {
		this.binds = binds;
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
	 * Get the value of property {@code livenessProbe}.
	 *
	 * @return the livenessProbe
	 */
	public String getLivenessProbe() {
		return livenessProbe;
	}


	/**
	 * Set the value of property {@code livenessProbe}.
	 *
	 * @param livenessProbe the livenessProbe to set
	 */
	public void setLivenessProbe(String livenessProbe) {
		this.livenessProbe = livenessProbe;
	}


	/**
	 * Get the value of property {@code readinessProbe}.
	 *
	 * @return the readinessProbe
	 */
	public String getReadinessProbe() {
		return readinessProbe;
	}


	/**
	 * Set the value of property {@code readinessProbe}.
	 *
	 * @param readinessProbe the readinessProbe to set
	 */
	public void setReadinessProbe(String readinessProbe) {
		this.readinessProbe = readinessProbe;
	}


	//
	public void addRoute(Route route) {
		if (routes==null) {
			routes = new ArrayList<Route>();
		}
		routes.add(route);
	}

	public Route removeRoute(int index) {
		if (routes==null || index <0 || index>= routes.size()) {
			return null;
		}
		return routes.remove(index);
	}

	public Route getRoute(int index) {
		if (routes==null || index <0 || index>= routes.size()) {
			return null;
		}
		return routes.get(index);
	}

	public Route findRoute(Route route) {
		if (route!=null && routes!=null) {
			for (Route route2: routes) {
				if ((route2.getId()!=null && route2.getId().equals(route.getId())) || (route2.getUuid()!=null && route2.getUuid().equals(route.getUuid()))) {
					return route;
				}
			}
		}
		return null;
	}

	public Route findRoute(String id) {
		if (id!=null && routes!=null) {
			for (Route route: routes) {
				if (id.equals(route.getUuid())) {
					return route;
				}
			}
		}
		return null;
	}


	//
	
	public void addBinding(Binding binding) {
		if (bindings==null) {
			bindings = new ArrayList<Binding>();
		}
		bindings.add(binding);
	}

	public Binding removeBinding(int index) {
		if (bindings==null || index <0 || index>= bindings.size()) {
			return null;
		}
		return bindings.remove(index);
	}

	public Binding getBinding(int index) {
		if (bindings==null || index <0 || index>= bindings.size()) {
			return null;
		}
		return bindings.get(index);
	}

	public Binding findBinding(Binding binding) {
		if (binding!=null && bindings!=null) {
			for (Binding binding2: bindings) {
				if ((binding2.getId()!=null && binding2.getId().equals(binding.getId())) || (binding2.getUuid()!=null && binding2.getUuid().equals(binding.getUuid()))) {
					return binding;
				}
			}
		}
		return null;
	}

	public Binding findBinding(String id) {
		if (id!=null && bindings!=null) {
			for (Binding binding: bindings) {
				if (id.equals(binding.getUuid())) {
					return binding;
				}
			}
		}
		return null;
	}

	public Binding removeBinding(Binding binding) {
		if (binding!=null && bindings!=null) {
			for (int i=0; i<bindings.size(); i++) {
				Binding binding2 = bindings.get(i);
				if ((binding2.getId()!=null && binding2.getId().equals(binding.getId())) || (binding2.getUuid()!=null && binding2.getUuid().equals(binding.getUuid()))) {
					return bindings.remove(i);
				}
			}
		}
		return null;
	}

	//
	
	public void addConnector(Connector connector) {
		if (connectors==null) {
			connectors = new ArrayList<Connector>();
		}
		connectors.add(connector);
	}

	public Connector removeConnector(int index) {
		if (connectors==null || index <0 || index>= connectors.size()) {
			return null;
		}
		return connectors.remove(index);
	}

	public Connector getConnector(int index) {
		if (connectors==null || index <0 || index>= connectors.size()) {
			return null;
		}
		return connectors.get(index);
	}

	public Connector findConnector(Connector connector) {
		if (connector!=null && connectors!=null) {
			for (Connector connector2: connectors) {
				if ((connector2.getId()!=null && connector2.getId().equals(connector.getId())) || (connector2.getUuid()!=null && connector2.getUuid().equals(connector.getUuid()))) {
					return connector;
				}
			}
		}
		return null;
	}

	public Connector findConnector(String id) {
		if (id!=null && connectors!=null) {
			for (Connector connector: connectors) {
				if (id.equals(connector.getUuid())) {
					return connector;
				}
			}
		}
		return null;
	}

	public Connector removeConnector(Connector connector) {
		if (connector!=null && connectors!=null) {
			for (int i=0; i<connectors.size(); i++) {
				Connector connector2 = connectors.get(i);
				if ((connector2.getId()!=null && connector2.getId().equals(connector.getId())) || (connector2.getUuid()!=null && connector2.getUuid().equals(connector.getUuid()))) {
					return connectors.remove(i);
				}
			}
		}
		return null;
	}

	/**
	 * Get the value of property {@code subplan}.
	 *
	 * @return the subplan
	 */
	public Plan getSubplan() {
		return subplan;
	}

	/**
	 * Set the value of property {@code subplan}.
	 *
	 * @param subplan the subplan to set
	 */
	public void setSubplan(Plan subplan) {
		this.subplan = subplan;
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
	 * Get the value of property {@code envVars}.
	 *
	 * @return the envVars
	 */
	public Map<String, String> getEnvVars() {
		return envVars;
	}

	/**
	 * Set the value of property {@code envVars}.
	 *
	 * @param envVars the envVars to set
	 */
	public void setEnvVars(Map<String, String> envVars) {
		this.envVars = envVars;
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
	 * Get the value of property {@code serviceKey}.
	 *
	 * @return the serviceKey
	 */
	public String getServiceKey() {
		return serviceKey;
	}

	/**
	 * Set the value of property {@code serviceKey}.
	 *
	 * @param serviceKey the serviceKey to set
	 */
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}

	/**
	 * Get the value of property {@code ingress}.
	 *
	 * @return the ingress
	 */
	public String getIngress() {
		return ingress;
	}

	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the ingress to set
	 */
	public void setIngress(String ingress) {
		this.ingress = ingress;
	}
	
	//
	// Repository
	//
	
	public void addRepository(Repository mount) {
		if (getRepositories()==null) {
			setRepositories(new ArrayList<Repository>());
		}
		getRepositories().add(mount);
	}

	public void addRepositories(Iterable<Repository> mounts) {
		if (getRepositories()!=null) {
			for (Repository mount: getRepositories()) {
				addRepository(mount);
			}
		}
	}

	public Repository removeRepository(int index) {
		if (getRepositories()==null || index <0 || index>= getRepositories().size()) {
			return null;
		}
		return getRepositories().remove(index);
	}

	public Repository getRepository(int index) {
		if (getRepositories()==null || index <0 || index>= getRepositories().size()) {
			return null;
		}
		return getRepositories().get(index);
	}

	public Repository findRepository(Repository mount) {
		if (mount!=null && getRepositories()!=null) {
			for (Repository mount2: getRepositories()) {
				if ((mount2.getId()!=null && mount2.getId().equals(mount.getId())) || (mount2.getUuid()!=null && mount2.getUuid().equals(mount.getUuid()))) {
					return mount2;
				}
			}
		}
		return null;
	}

	public Repository findRepository(String id) {
		if (id!=null && getRepositories()!=null) {
			for (Repository mount: getRepositories()) {
				if (id.equals(mount.getUuid()) || id.equals(mount.getName())) {
					return mount;
				}
			}
		}
		return null;
	}

	public Repository removeRepository(Repository mount) {
		if (mount!=null && getRepositories()!=null) {
			for (int i=0; i<getRepositories().size(); i++) {
				Repository mount2 = getRepositories().get(i);
				if ((mount2.getId()!=null && mount2.getId().equals(mount.getId())) || (mount2.getUuid()!=null && mount2.getUuid().equals(mount.getUuid()))) {
					return getRepositories().remove(i);
				}
			}
		}
		return null;
	}
	

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("status", status)
				.append("stack", stack)
				.append("stateful", stateful)
				.append("replicas", replicas)
				.append("readyReplicas", readyReplicas)
				.append("availableReplicas", availableReplicas)
				.append("unavailableReplicas", unavailableReplicas)
				.append("updatedReplicas", updatedReplicas)
				.append("manager", manager)
				.append("endpoints", endpoints)
				.append("ports", ports)
				.append("resources", resources)
				.append("routes", routes)
				.append("binds", binds)
				.append("bindings", bindings)
				.append("connectors", connectors)
				.append("repositories", repositories)
				.append("env", env)
				.append("bill", bill)
				.append("manifest", manifest)
				.append("serviceKey", serviceKey)
				.append("ingress", ingress)
				;
	}

	void printMeta() {
		System.out.println(meta.get("metadata"));
		System.out.println(meta.get("spec"));
		System.out.println(meta.get("status"));
		System.out.println(meta.get("properties"));
	}

	void printSvcMeta() {
		System.out.println(meta.get("metadata"));
		System.out.println(meta.get("spec"));
		System.out.println(meta.get("status"));
		System.out.println(meta.get("properties"));
	}
	

}
