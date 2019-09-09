package org.einnovator.devops.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeploymentBuilder extends Deployment {

	public DeploymentBuilder() {
	}
	
	public DeploymentBuilder(DeploymentBuilder deploy) {
		super(deploy);
	}
	
	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the key to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withKey(String key) {
		this.key = key;
		return this;
	}


	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code img}.
	 *
	 * @param img the img to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withImg(String img) {
		this.img = img;
		return this;
	}

	
	/**
	 * Set the value of property {@code thumbnail}.
	 *
	 * @param thumbnail the thumbnail to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}


	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withDescription(String description) {
		this.description = description;
		return this;
	}


	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withType(SolutionType type) {
		this.type = type;
		return this;
	}


	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the image to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withImage(Image image) {
		this.image = image;
		return this;
	}


	/**
	 * Set the value of property {@code solution}.
	 *
	 * @param solution the solution to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withSolution(Solution solution) {
		this.solution = solution;
		return this;
	}

	/**
	 * Set the value of property {@code plan}.
	 *
	 * @param plan the plan to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withPlan(Plan plan) {
		this.plan = plan;
		return this;
	}


	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the resources to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withResources(Resources resources) {
		this.resources = resources;
		return this;
	}

	/**
	 * Set the value of property {@code ports}.
	 *
	 * @param ports the ports to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withPorts(Ports ports) {
		this.ports = ports;
		return this;
	}

	/**
	 * Set the value of property {@code replicas}.
	 *
	 * @param replicas the replicas to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withReplicas(Integer replicas) {
		this.replicas = replicas;
		return this;
	}


	/**
	 * Set the value of property {@code desiredReplicas}.
	 *
	 * @param desiredReplicas the desiredReplicas to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withDesiredReplicas(Integer desiredReplicas) {
		this.desiredReplicas = desiredReplicas;
		return this;
	}


	/**
	 * Set the value of property {@code readyReplicas}.
	 *
	 * @param readyReplicas the readyReplicas to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withReadyReplicas(Integer readyReplicas) {
		this.readyReplicas = readyReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code availableReplicas}.
	 *
	 * @param availableReplicas the availableReplicas to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withAvailableReplicas(Integer availableReplicas) {
		this.availableReplicas = availableReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code unavailableReplicas}.
	 *
	 * @param unavailableReplicas the unavailableReplicas to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withUnavailableReplicas(Integer unavailableReplicas) {
		this.unavailableReplicas = unavailableReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code updatedReplicas}.
	 *
	 * @param updatedReplicas the updatedReplicas to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withUpdatedReplicas(Integer updatedReplicas) {
		this.updatedReplicas = updatedReplicas;
		return this;
	}

	/**
	 * Set the value of property {@code routes}.
	 *
	 * @param routes the routes to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withRoutes(List<Route> routes) {
		this.routes = routes;
		return this;
	}

	/**
	 * Set the value of property {@code bindings}.
	 *
	 * @param bindings the bindings to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withBindings(List<Binding> bindings) {
		this.bindings = bindings;
		return this;
	}


	/**
	 * Set the value of property {@code connectors}.
	 *
	 * @param connectors the connectors to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withConnectors(List<Connector> connectors) {
		this.connectors = connectors;
		return this;
	}

	/**
	 * Set the value of property {@code env}.
	 *
	 * @param env the env to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withEnv(Environment env) {
		this.env = env;
		return this;
	}

	/**
	 * Set the value of property {@code stateful}.
	 *
	 * @param stateful the stateful to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withStateful(Boolean stateful) {
		this.stateful = stateful;
		return this;
	}

	/**
	 * Set the value of property {@code stack}.
	 *
	 * @param stack the stack to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withStack(Stack stack) {
		this.stack = stack;
		return this;
	}

	/**
	 * Set the value of property {@code livenessProbe}.
	 *
	 * @param livenessProbe the livenessProbe to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withLivenessProbe(String livenessProbe) {
		this.livenessProbe = livenessProbe;
		return this;
	}

	/**
	 * Set the value of property {@code readinessProbe}.
	 *
	 * @param readinessProbe the readinessProbe to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withReadinessProbe(String readinessProbe) {
		this.readinessProbe = readinessProbe;
		return this;
	}

	/**
	 * Set the value of property {@code subplan}.
	 *
	 * @param subplan the subplan to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withSubplan(Plan subplan) {
		this.subplan = subplan;
		return this;
	}

	/**
	 * Set the value of property {@code labels}.
	 *
	 * @param labels the labels to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withLabels(List<Label> labels) {
		this.labels = labels;
		return this;
	}


	/**
	 * Set the value of property {@code manifest}.
	 *
	 * @param manifest the manifest to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withManifest(String manifest) {
		this.manifest = manifest;
		return this;
	}


	/**
	 * Set the value of property {@code serviceKey}.
	 *
	 * @param serviceKey the serviceKey to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}


	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the ingress to with
	 * @return this {@code DeploymentBuilder}
	 */
	public DeploymentBuilder withIngress(String ingress) {
		this.ingress = ingress;
		return this;
	}

	public Deployment build() {
		Deployment deploy = new Deployment(this);
		return deploy;
	}

}
