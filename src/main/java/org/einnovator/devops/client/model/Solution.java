package org.einnovator.devops.client.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Solution extends AnnotatedEntity {

	private SolutionType type;
	
	private SolutionCategory category;

	private DeploymentKind kind;

	private SolutionPackaging packaging;

	private Stack stack;
	
	private List<Solution> plans;

	private String subtitle;
	
	private Boolean enabled;
	
	private Boolean featured;

	private Boolean deprecated;

	private Boolean unstable;

	private Boolean license;

	private Boolean popular;

	private Integer ndeploy;

	private Manager manager;
	
	private List<String> alias;

	private List<String> keywords;

	private String home;

	private String source;

	private List<SolutionVersion> versions;

	private Boolean multiversion;

	private Boolean common;

	private String host;

	private Boolean service;

	private Boolean route;
	
	//Simple

	private String registryId;
	
	private Registry registry;
	
	private List<Mount> mounts;
	
	private List<Variable> env;

	private List<ConfigMap> configmaps;

	private List<Secret> secrets;

	private List<Port> ports;

	private Map<String, String> properties;

	private String propertiesJson;
	
	private List<Binding> bindings;
	
	private Boolean nobinds;

	private List<Connector> connectors;

	//External
	
	private String url;
	
	private List<String> urls;
	
	//Manifest

	private String manifest;

	// Deployment

	private Deployment deployment;
	
	//Helm Charts
	
	private Map<String, Map<String, Object>> config;

	private Resources resources;

	private Boolean free;

	private Boolean sandbox;

	private BigDecimal priceHour;

	private BigDecimal priceMonth;

	private String currency;

	private Probe livenessProbe;

	private Probe readinessProbe;

	private Probe startupProbe;

	//
	// Constructor
	//

	public Solution() {
	}

	//
	// Getter/Setter
	//
	
	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the value of {@code type}
	 */
	public SolutionType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of {@code type}
	 */
	public void setType(SolutionType type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code category}.
	 *
	 * @return the value of {@code category}
	 */
	public SolutionCategory getCategory() {
		return category;
	}

	/**
	 * Set the value of property {@code category}.
	 *
	 * @param category the value of {@code category}
	 */
	public void setCategory(SolutionCategory category) {
		this.category = category;
	}

	/**
	 * Get the value of property {@code kind}.
	 *
	 * @return the value of {@code kind}
	 */
	public DeploymentKind getKind() {
		return kind;
	}

	/**
	 * Set the value of property {@code kind}.
	 *
	 * @param kind the value of {@code kind}
	 */
	public void setKind(DeploymentKind kind) {
		this.kind = kind;
	}

	/**
	 * Get the value of property {@code packaging}.
	 *
	 * @return the value of {@code packaging}
	 */
	public SolutionPackaging getPackaging() {
		return packaging;
	}

	/**
	 * Set the value of property {@code packaging}.
	 *
	 * @param packaging the value of {@code packaging}
	 */
	public void setPackaging(SolutionPackaging packaging) {
		this.packaging = packaging;
	}

	/**
	 * Get the value of property {@code stack}.
	 *
	 * @return the value of {@code stack}
	 */
	public Stack getStack() {
		return stack;
	}

	/**
	 * Set the value of property {@code stack}.
	 *
	 * @param stack the value of {@code stack}
	 */
	public void setStack(Stack stack) {
		this.stack = stack;
	}

	/**
	 * Get the value of property {@code plans}.
	 *
	 * @return the value of {@code plans}
	 */
	public List<Solution> getPlans() {
		return plans;
	}

	/**
	 * Set the value of property {@code plans}.
	 *
	 * @param plans the value of {@code plans}
	 */
	public void setPlans(List<Solution> plans) {
		this.plans = plans;
	}

	/**
	 * Get the value of property {@code subtitle}.
	 *
	 * @return the value of {@code subtitle}
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Set the value of property {@code subtitle}.
	 *
	 * @param subtitle the value of {@code subtitle}
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * Get the value of property {@code enabled}.
	 *
	 * @return the value of {@code enabled}
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the value of {@code enabled}
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Get the value of property {@code featured}.
	 *
	 * @return the value of {@code featured}
	 */
	public Boolean getFeatured() {
		return featured;
	}

	/**
	 * Set the value of property {@code featured}.
	 *
	 * @param featured the value of {@code featured}
	 */
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	/**
	 * Get the value of property {@code deprecated}.
	 *
	 * @return the value of {@code deprecated}
	 */
	public Boolean getDeprecated() {
		return deprecated;
	}

	/**
	 * Set the value of property {@code deprecated}.
	 *
	 * @param deprecated the value of {@code deprecated}
	 */
	public void setDeprecated(Boolean deprecated) {
		this.deprecated = deprecated;
	}

	/**
	 * Get the value of property {@code unstable}.
	 *
	 * @return the value of {@code unstable}
	 */
	public Boolean getUnstable() {
		return unstable;
	}

	/**
	 * Set the value of property {@code unstable}.
	 *
	 * @param unstable the value of {@code unstable}
	 */
	public void setUnstable(Boolean unstable) {
		this.unstable = unstable;
	}

	/**
	 * Get the value of property {@code license}.
	 *
	 * @return the value of {@code license}
	 */
	public Boolean getLicense() {
		return license;
	}

	/**
	 * Set the value of property {@code license}.
	 *
	 * @param license the value of {@code license}
	 */
	public void setLicense(Boolean license) {
		this.license = license;
	}

	/**
	 * Get the value of property {@code popular}.
	 *
	 * @return the value of {@code popular}
	 */
	public Boolean getPopular() {
		return popular;
	}

	/**
	 * Set the value of property {@code popular}.
	 *
	 * @param popular the value of {@code popular}
	 */
	public void setPopular(Boolean popular) {
		this.popular = popular;
	}

	/**
	 * Get the value of property {@code ndeploy}.
	 *
	 * @return the value of {@code ndeploy}
	 */
	public Integer getNdeploy() {
		return ndeploy;
	}

	/**
	 * Set the value of property {@code ndeploy}.
	 *
	 * @param ndeploy the value of {@code ndeploy}
	 */
	public void setNdeploy(Integer ndeploy) {
		this.ndeploy = ndeploy;
	}

	/**
	 * Get the value of property {@code manager}.
	 *
	 * @return the value of {@code manager}
	 */
	public Manager getManager() {
		return manager;
	}

	/**
	 * Set the value of property {@code manager}.
	 *
	 * @param manager the value of {@code manager}
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	/**
	 * Get the value of property {@code alias}.
	 *
	 * @return the value of {@code alias}
	 */
	public List<String> getAlias() {
		return alias;
	}

	/**
	 * Set the value of property {@code alias}.
	 *
	 * @param alias the value of {@code alias}
	 */
	public void setAlias(List<String> alias) {
		this.alias = alias;
	}

	/**
	 * Get the value of property {@code keywords}.
	 *
	 * @return the value of {@code keywords}
	 */
	public List<String> getKeywords() {
		return keywords;
	}

	/**
	 * Set the value of property {@code keywords}.
	 *
	 * @param keywords the value of {@code keywords}
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	/**
	 * Get the value of property {@code home}.
	 *
	 * @return the value of {@code home}
	 */
	public String getHome() {
		return home;
	}

	/**
	 * Set the value of property {@code home}.
	 *
	 * @param home the value of {@code home}
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * Get the value of property {@code source}.
	 *
	 * @return the value of {@code source}
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Set the value of property {@code source}.
	 *
	 * @param source the value of {@code source}
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Get the value of property {@code versions}.
	 *
	 * @return the value of {@code versions}
	 */
	public List<SolutionVersion> getVersions() {
		return versions;
	}

	/**
	 * Set the value of property {@code versions}.
	 *
	 * @param versions the value of {@code versions}
	 */
	public void setVersions(List<SolutionVersion> versions) {
		this.versions = versions;
	}

	/**
	 * Get the value of property {@code multiversion}.
	 *
	 * @return the value of {@code multiversion}
	 */
	public Boolean getMultiversion() {
		return multiversion;
	}

	/**
	 * Set the value of property {@code multiversion}.
	 *
	 * @param multiversion the value of {@code multiversion}
	 */
	public void setMultiversion(Boolean multiversion) {
		this.multiversion = multiversion;
	}

	/**
	 * Get the value of property {@code common}.
	 *
	 * @return the value of {@code common}
	 */
	public Boolean getCommon() {
		return common;
	}

	/**
	 * Set the value of property {@code common}.
	 *
	 * @param common the value of {@code common}
	 */
	public void setCommon(Boolean common) {
		this.common = common;
	}

	/**
	 * Get the value of property {@code host}.
	 *
	 * @return the value of {@code host}
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Set the value of property {@code host}.
	 *
	 * @param host the value of {@code host}
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Get the value of property {@code service}.
	 *
	 * @return the value of {@code service}
	 */
	public Boolean getService() {
		return service;
	}

	/**
	 * Set the value of property {@code service}.
	 *
	 * @param service the value of {@code service}
	 */
	public void setService(Boolean service) {
		this.service = service;
	}

	/**
	 * Get the value of property {@code route}.
	 *
	 * @return the value of {@code route}
	 */
	public Boolean getRoute() {
		return route;
	}

	/**
	 * Set the value of property {@code route}.
	 *
	 * @param route the value of {@code route}
	 */
	public void setRoute(Boolean route) {
		this.route = route;
	}

	/**
	 * Get the value of property {@code registryId}.
	 *
	 * @return the value of {@code registryId}
	 */
	public String getRegistryId() {
		return registryId;
	}

	/**
	 * Set the value of property {@code registryId}.
	 *
	 * @param registryId the value of {@code registryId}
	 */
	public void setRegistryId(String registryId) {
		this.registryId = registryId;
	}

	/**
	 * Get the value of property {@code registry}.
	 *
	 * @return the value of {@code registry}
	 */
	public Registry getRegistry() {
		return registry;
	}

	/**
	 * Set the value of property {@code registry}.
	 *
	 * @param registry the value of {@code registry}
	 */
	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	/**
	 * Get the value of property {@code mounts}.
	 *
	 * @return the value of {@code mounts}
	 */
	public List<Mount> getMounts() {
		return mounts;
	}

	/**
	 * Set the value of property {@code mounts}.
	 *
	 * @param mounts the value of {@code mounts}
	 */
	public void setMounts(List<Mount> mounts) {
		this.mounts = mounts;
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
	 * Get the value of property {@code configmaps}.
	 *
	 * @return the value of {@code configmaps}
	 */
	public List<ConfigMap> getConfigmaps() {
		return configmaps;
	}

	/**
	 * Set the value of property {@code configmaps}.
	 *
	 * @param configmaps the value of {@code configmaps}
	 */
	public void setConfigmaps(List<ConfigMap> configmaps) {
		this.configmaps = configmaps;
	}

	/**
	 * Get the value of property {@code secrets}.
	 *
	 * @return the value of {@code secrets}
	 */
	public List<Secret> getSecrets() {
		return secrets;
	}

	/**
	 * Set the value of property {@code secrets}.
	 *
	 * @param secrets the value of {@code secrets}
	 */
	public void setSecrets(List<Secret> secrets) {
		this.secrets = secrets;
	}

	/**
	 * Get the value of property {@code ports}.
	 *
	 * @return the value of {@code ports}
	 */
	public List<Port> getPorts() {
		return ports;
	}

	/**
	 * Set the value of property {@code ports}.
	 *
	 * @param ports the value of {@code ports}
	 */
	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	/**
	 * Get the value of property {@code properties}.
	 *
	 * @return the value of {@code properties}
	 */
	public Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * Set the value of property {@code properties}.
	 *
	 * @param properties the value of {@code properties}
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	/**
	 * Get the value of property {@code propertiesJson}.
	 *
	 * @return the value of {@code propertiesJson}
	 */
	public String getPropertiesJson() {
		return propertiesJson;
	}

	/**
	 * Set the value of property {@code propertiesJson}.
	 *
	 * @param propertiesJson the value of {@code propertiesJson}
	 */
	public void setPropertiesJson(String propertiesJson) {
		this.propertiesJson = propertiesJson;
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
	 * Get the value of property {@code nobinds}.
	 *
	 * @return the value of {@code nobinds}
	 */
	public Boolean getNobinds() {
		return nobinds;
	}

	/**
	 * Set the value of property {@code nobinds}.
	 *
	 * @param nobinds the value of {@code nobinds}
	 */
	public void setNobinds(Boolean nobinds) {
		this.nobinds = nobinds;
	}

	/**
	 * Get the value of property {@code connectors}.
	 *
	 * @return the value of {@code connectors}
	 */
	public List<Connector> getConnectors() {
		return connectors;
	}

	/**
	 * Set the value of property {@code connectors}.
	 *
	 * @param connectors the value of {@code connectors}
	 */
	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
	}

	/**
	 * Get the value of property {@code url}.
	 *
	 * @return the value of {@code url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the value of property {@code url}.
	 *
	 * @param url the value of {@code url}
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get the value of property {@code urls}.
	 *
	 * @return the value of {@code urls}
	 */
	public List<String> getUrls() {
		return urls;
	}

	/**
	 * Set the value of property {@code urls}.
	 *
	 * @param urls the value of {@code urls}
	 */
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	/**
	 * Get the value of property {@code manifest}.
	 *
	 * @return the value of {@code manifest}
	 */
	public String getManifest() {
		return manifest;
	}

	/**
	 * Set the value of property {@code manifest}.
	 *
	 * @param manifest the value of {@code manifest}
	 */
	public void setManifest(String manifest) {
		this.manifest = manifest;
	}

	/**
	 * Get the value of property {@code deployment}.
	 *
	 * @return the value of {@code deployment}
	 */
	public Deployment getDeployment() {
		return deployment;
	}

	/**
	 * Set the value of property {@code deployment}.
	 *
	 * @param deployment the value of {@code deployment}
	 */
	public void setDeployment(Deployment deployment) {
		this.deployment = deployment;
	}

	/**
	 * Get the value of property {@code config}.
	 *
	 * @return the value of {@code config}
	 */
	public Map<String, Map<String, Object>> getConfig() {
		return config;
	}

	/**
	 * Set the value of property {@code config}.
	 *
	 * @param config the value of {@code config}
	 */
	public void setConfig(Map<String, Map<String, Object>> config) {
		this.config = config;
	}

	/**
	 * Get the value of property {@code resources}.
	 *
	 * @return the value of {@code resources}
	 */
	public Resources getResources() {
		return resources;
	}

	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the value of {@code resources}
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
	}

	/**
	 * Get the value of property {@code free}.
	 *
	 * @return the value of {@code free}
	 */
	public Boolean getFree() {
		return free;
	}

	/**
	 * Set the value of property {@code free}.
	 *
	 * @param free the value of {@code free}
	 */
	public void setFree(Boolean free) {
		this.free = free;
	}

	/**
	 * Get the value of property {@code sandbox}.
	 *
	 * @return the value of {@code sandbox}
	 */
	public Boolean getSandbox() {
		return sandbox;
	}

	/**
	 * Set the value of property {@code sandbox}.
	 *
	 * @param sandbox the value of {@code sandbox}
	 */
	public void setSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
	}

	/**
	 * Get the value of property {@code priceHour}.
	 *
	 * @return the value of {@code priceHour}
	 */
	public BigDecimal getPriceHour() {
		return priceHour;
	}

	/**
	 * Set the value of property {@code priceHour}.
	 *
	 * @param priceHour the value of {@code priceHour}
	 */
	public void setPriceHour(BigDecimal priceHour) {
		this.priceHour = priceHour;
	}

	/**
	 * Get the value of property {@code priceMonth}.
	 *
	 * @return the value of {@code priceMonth}
	 */
	public BigDecimal getPriceMonth() {
		return priceMonth;
	}

	/**
	 * Set the value of property {@code priceMonth}.
	 *
	 * @param priceMonth the value of {@code priceMonth}
	 */
	public void setPriceMonth(BigDecimal priceMonth) {
		this.priceMonth = priceMonth;
	}

	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the value of {@code currency}
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the value of {@code currency}
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the value of property {@code livenessProbe}.
	 *
	 * @return the value of {@code livenessProbe}
	 */
	public Probe getLivenessProbe() {
		return livenessProbe;
	}

	/**
	 * Set the value of property {@code livenessProbe}.
	 *
	 * @param livenessProbe the value of {@code livenessProbe}
	 */
	public void setLivenessProbe(Probe livenessProbe) {
		this.livenessProbe = livenessProbe;
	}

	/**
	 * Get the value of property {@code readinessProbe}.
	 *
	 * @return the value of {@code readinessProbe}
	 */
	public Probe getReadinessProbe() {
		return readinessProbe;
	}

	/**
	 * Set the value of property {@code readinessProbe}.
	 *
	 * @param readinessProbe the value of {@code readinessProbe}
	 */
	public void setReadinessProbe(Probe readinessProbe) {
		this.readinessProbe = readinessProbe;
	}

	/**
	 * Get the value of property {@code startupProbe}.
	 *
	 * @return the value of {@code startupProbe}
	 */
	public Probe getStartupProbe() {
		return startupProbe;
	}

	/**
	 * Set the value of property {@code startupProbe}.
	 *
	 * @param startupProbe the value of {@code startupProbe}
	 */
	public void setStartupProbe(Probe startupProbe) {
		this.startupProbe = startupProbe;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("kind", kind)
				.append("category", category)
				.append("packaging", packaging)
				.append("stack", stack)
				.append("nobinds", nobinds)
				.append("manager", manager)
				.append("plans", plans)
				.append("labels", labels)
				.append("annotations", annotations)
				.append("ndeploy", ndeploy)
				.append("url", url)
				.append("urls", urls)
				.append("manifest", manifest)
				.append("license", license)
				.append("versions", versions)
				.append("mounts", mounts)
				.append("service", service)
				.append("route", route)
				.append("env", env)				
				.append("configmaps", configmaps)				
				.append("secrets", secrets)				
				.append("ports", ports)
				.append("properties", properties)
				.append("enabled", enabled)
				.append("deprecated", deprecated)
				.append("featured", featured)
				.append("popular", popular)
				.append("home", home)
				.append("source", source)
				.append("bindings", bindings)
				.append("connectors", connectors)
				.append("resources", resources)
				.append("sandbox", sandbox)
				.append("free", free)
				.append("priceHour", priceHour)
				.append("priceMonth", priceMonth)
				.append("currency", currency)
				.append("plans", plans)
				;
	}
	
}
