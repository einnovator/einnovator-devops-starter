package org.einnovator.devops.client.model;

import java.util.List;
import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolutionVersion extends AnnotatedEntity {

	private String manifest;

	private String spec;

	private String url;

	private String version;

	private String image;
	
	private Stack stack;
	
	private String digest;

	private String apiVersion;

	private String appVersion;

	private String created;

	private String engine;

	private String home;

	private List<Map<String, Object>> maintainers;
    
	private List<String> sources;

	private List<String> urls;

	@JsonIgnore
	protected Map<String, Object> meta;
	
	public SolutionVersion() {
	}

	/**
	 * Get the value of property {@code spec}.
	 *
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * Set the value of property {@code spec}.
	 *
	 * @param spec the value of property spec
	 */
	public void setSpec(String spec) {
		this.spec = spec;
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
	 * @param manifest the value of property manifest
	 */
	public void setManifest(String manifest) {
		this.manifest = manifest;
	}


	/**
	 * Get the value of property {@code image}.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}


	/**
	 * Set the value of property {@code image}.
	 *
	 * @param image the value of property image
	 */
	public void setImage(String image) {
		this.image = image;
	}


	/**
	 * Get the value of property {@code version}.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Set the value of property {@code version}.
	 *
	 * @param version the value of property version
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * @param stack the value of property stack
	 */
	public void setStack(Stack stack) {
		this.stack = stack;
	}

	/**
	 * Get the value of property {@code digest}.
	 *
	 * @return the digest
	 */
	public String getDigest() {
		return digest;
	}

	/**
	 * Set the value of property {@code digest}.
	 *
	 * @param digest the value of property digest
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}

	/**
	 * Get the value of property {@code apiVersion}.
	 *
	 * @return the apiVersion
	 */
	public String getApiVersion() {
		return apiVersion;
	}

	/**
	 * Set the value of property {@code apiVersion}.
	 *
	 * @param apiVersion the value of property apiVersion
	 */
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * Get the value of property {@code appVersion}.
	 *
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * Set the value of property {@code appVersion}.
	 *
	 * @param appVersion the value of property appVersion
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	/**
	 * Get the value of property {@code created}.
	 *
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the value of property {@code created}.
	 *
	 * @param created the value of property created
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the value of property {@code engine}.
	 *
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * Set the value of property {@code engine}.
	 *
	 * @param engine the value of property engine
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * Get the value of property {@code home}.
	 *
	 * @return the home
	 */
	public String getHome() {
		return home;
	}

	/**
	 * Set the value of property {@code home}.
	 *
	 * @param home the value of property home
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * Get the value of property {@code maintainers}.
	 *
	 * @return the maintainers
	 */
	public List<Map<String, Object>> getMaintainers() {
		return maintainers;
	}

	/**
	 * Set the value of property {@code maintainers}.
	 *
	 * @param maintainers the value of property maintainers
	 */
	public void setMaintainers(List<Map<String, Object>> maintainers) {
		this.maintainers = maintainers;
	}

	/**
	 * Get the value of property {@code sources}.
	 *
	 * @return the sources
	 */
	public List<String> getSources() {
		return sources;
	}

	/**
	 * Set the value of property {@code sources}.
	 *
	 * @param sources the value of property sources
	 */
	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	/**
	 * Get the value of property {@code urls}.
	 *
	 * @return the urls
	 */
	public List<String> getUrls() {
		return urls;
	}

	/**
	 * Set the value of property {@code urls}.
	 *
	 * @param urls the value of property urls
	 */
	public void setUrls(List<String> urls) {
		this.urls = urls;
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
	 * @param meta the value of property meta
	 */
	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("version", version)
				.append("urls", urls)
				.append("sources", sources)
				.append("home", home)
				.append("engine", engine)
				.append("created", created)
				.append("apiVersion", apiVersion)
				.append("appVersion", appVersion)
				.append("digest", digest)
				.append("maintainers", maintainers)
				.append("image", image)
				.append("manifest", manifest)
				.append("meta", meta)
				;
	}


}
