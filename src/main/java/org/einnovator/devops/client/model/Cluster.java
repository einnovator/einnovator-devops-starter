package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cluster extends BilledEntity {

	private Region region;

	private ProviderType provider;

	private List<Node> nodes;

	private Boolean sandbox;

	private Boolean shared;

	private Boolean fallback;

	private Boolean enabled;
	
	private String master;

	private CredentialsType credentialsType;
	
	private String caCertData;

	private String caCertUri;

	private String clientCertData;

	private String clientCertUri;

	private String clientKeyData;

	private String clientKeyUri;

	private String clientKeyAlgo;
	
	private String username;

	private String key;
	
	private String secret;

	private String svcacc;
	
	private String token;
	
	private String kubeconfig;

	private IngressRuntime ingress;

	private CicdRuntime cicd;
	
	private Tools tools;
	
	//
	// Constructor
	//

	/**
	 * Create instance of {@code Cluster}.
	 *
	 */
	public Cluster() {
	}


	//
	// Gettes/Setter
	//
	
	/**
	 * Get the value of property {@code provider}.
	 *
	 * @return the value of {@code provider}
	 */
	public ProviderType getProvider() {
		return provider;
	}


	/**
	 * Set the value of property {@code provider}.
	 *
	 * @param provider the value of {@code provider}
	 */
	public void setProvider(ProviderType provider) {
		this.provider = provider;
	}


	/**
	 * Get the value of property {@code region}.
	 *
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}


	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the region
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Get the value of property {@code nodes}.
	 *
	 * @return the nodes
	 */
	public List<Node> getNodes() {
		return nodes;
	}


	/**
	 * Set the value of property {@code nodes}.
	 *
	 * @param nodes the nodes
	 */
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
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
	 * @param sandbox the sandbox
	 */
	public void setSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
	}
	
	

	//yml config hack
	
	/**
	 * Get the value of property {@code shared}.
	 *
	 * @return the shared
	 */
	public Boolean getShared() {
		return shared;
	}


	/**
	 * Set the value of property {@code shared}.
	 *
	 * @param shared the shared
	 */
	public void setShared(Boolean shared) {
		this.shared = shared;
	}



	/**
	 * Get the value of property {@code enabled}.
	 *
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}


	/**
	 * Set the value of property {@code enabled}.
	 *
	 * @param enabled the enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Get the value of property {@code fallback}.
	 *
	 * @return the fallback
	 */
	public Boolean getFallback() {
		return fallback;
	}


	/**
	 * Set the value of property {@code fallback}.
	 *
	 * @param fallback the fallback
	 */
	public void setFallback(Boolean fallback) {
		this.fallback = fallback;
	}

	/**
	 * Get the value of property {@code master}.
	 *
	 * @return the master
	 */
	public String getMaster() {
		return master;
	}

	/**
	 * Set the value of property {@code master}.
	 *
	 * @param master the master
	 */
	public void setMaster(String master) {
		this.master = master;
	}
	
	/**
	 * Get the value of property {@code credentialsType}.
	 *
	 * @return the credentialsType
	 */
	public CredentialsType getCredentialsType() {
		return credentialsType;
	}


	/**
	 * Set the value of property {@code credentialsType}.
	 *
	 * @param credentialsType the value of property credentialsType
	 */
	public void setCredentialsType(CredentialsType credentialsType) {
		this.credentialsType = credentialsType;
	}
	/**
	 * Get the value of property {@code caCertData}.
	 *
	 * @return the caCertData
	 */
	public String getCaCertData() {
		return caCertData;
	}

	/**
	 * Set the value of property {@code caCertData}.
	 *
	 * @param caCertData the caCertData
	 */
	public void setCaCertData(String caCertData) {
		this.caCertData = caCertData;
	}

	/**
	 * Get the value of property {@code caCertUri}.
	 *
	 * @return the caCertUri
	 */
	public String getCaCertUri() {
		return caCertUri;
	}

	/**
	 * Set the value of property {@code caCertUri}.
	 *
	 * @param caCertUri the caCertUri
	 */
	public void setCaCertUri(String caCertUri) {
		this.caCertUri = caCertUri;
	}

	/**
	 * Get the value of property {@code clientCertData}.
	 *
	 * @return the clientCertData
	 */
	public String getClientCertData() {
		return clientCertData;
	}

	/**
	 * Set the value of property {@code clientCertData}.
	 *
	 * @param clientCertData the clientCertData
	 */
	public void setClientCertData(String clientCertData) {
		this.clientCertData = clientCertData;
	}

	/**
	 * Get the value of property {@code clientCertUri}.
	 *
	 * @return the clientCertUri
	 */
	public String getClientCertUri() {
		return clientCertUri;
	}

	/**
	 * Set the value of property {@code clientCertUri}.
	 *
	 * @param clientCertUri the clientCertUri
	 */
	public void setClientCertUri(String clientCertUri) {
		this.clientCertUri = clientCertUri;
	}

	/**
	 * Get the value of property {@code clientKeyData}.
	 *
	 * @return the clientKeyData
	 */
	public String getClientKeyData() {
		return clientKeyData;
	}

	/**
	 * Set the value of property {@code clientKeyData}.
	 *
	 * @param clientKeyData the clientKeyData
	 */
	public void setClientKeyData(String clientKeyData) {
		this.clientKeyData = clientKeyData;
	}

	/**
	 * Get the value of property {@code clientKeyUri}.
	 *
	 * @return the clientKeyUri
	 */
	public String getClientKeyUri() {
		return clientKeyUri;
	}

	/**
	 * Set the value of property {@code clientKeyUri}.
	 *
	 * @param clientKeyUri the clientKeyUri
	 */
	public void setClientKeyUri(String clientKeyUri) {
		this.clientKeyUri = clientKeyUri;
	}

	/**
	 * Get the value of property {@code clientKeyAlgo}.
	 *
	 * @return the clientKeyAlgo
	 */
	public String getClientKeyAlgo() {
		return clientKeyAlgo;
	}

	/**
	 * Set the value of property {@code clientKeyAlgo}.
	 *
	 * @param clientKeyAlgo the clientKeyAlgo
	 */
	public void setClientKeyAlgo(String clientKeyAlgo) {
		this.clientKeyAlgo = clientKeyAlgo;
	}

	/**
	 * Get the value of property {@code key}.
	 *
	 * @return the value of {@code key}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Get the value of property {@code username}.
	 *
	 * @return the value of {@code username}
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the value of property {@code username}.
	 *
	 * @param username the value of {@code username}
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the value of {@code key}
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the value of property {@code secret}.
	 *
	 * @return the value of {@code secret}
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * Set the value of property {@code secret}.
	 *
	 * @param secret the value of {@code secret}
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * Get the value of property {@code svcacc}.
	 *
	 * @return the value of {@code svcacc}
	 */
	public String getSvcacc() {
		return svcacc;
	}

	/**
	 * Set the value of property {@code svcacc}.
	 *
	 * @param svcacc the value of {@code svcacc}
	 */
	public void setSvcacc(String svcacc) {
		this.svcacc = svcacc;
	}

	/**
	 * Get the value of property {@code token}.
	 *
	 * @return the value of {@code token}
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Set the value of property {@code token}.
	 *
	 * @param token the value of {@code token}
	 */
	public void setToken(String token) {
		this.token = token;
	}


	/**
	 * Get the value of property {@code kubeconfig}.
	 *
	 * @return the value of {@code kubeconfig}
	 */
	public String getKubeconfig() {
		return kubeconfig;
	}


	/**
	 * Set the value of property {@code kubeconfig}.
	 *
	 * @param kubeconfig the value of {@code kubeconfig}
	 */
	public void setKubeconfig(String kubeconfig) {
		this.kubeconfig = kubeconfig;
	}


	/**
	 * Get the value of property {@code ingress}.
	 *
	 * @return the value of {@code ingress}
	 */
	public IngressRuntime getIngress() {
		return ingress;
	}


	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the value of {@code ingress}
	 */
	public void setIngress(IngressRuntime ingress) {
		this.ingress = ingress;
	}


	/**
	 * Get the value of property {@code cicd}.
	 *
	 * @return the value of {@code cicd}
	 */
	public CicdRuntime getCicd() {
		return cicd;
	}


	/**
	 * Set the value of property {@code cicd}.
	 *
	 * @param cicd the value of {@code cicd}
	 */
	public void setCicd(CicdRuntime cicd) {
		this.cicd = cicd;
	}


	/**
	 * Get the value of property {@code tools}.
	 *
	 * @return the value of {@code tools}
	 */
	public Tools getTools() {
		return tools;
	}


	/**
	 * Set the value of property {@code tools}.
	 *
	 * @param tools the value of {@code tools}
	 */
	public void setTools(Tools tools) {
		this.tools = tools;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("provider", provider)
				.append("region", region)
				.append("sandbox", sandbox)
				.append("shared", shared)
				.append("fallback", fallback)
				.append("nodes", nodes)
				.append("enabled", enabled)
				.append("username", username)
				.append("key", key)
				.append("secret", secret!=null ? "****" : null)
				.append("svcacc", svcacc!=null ? "****" : null)
				.append("token", token!=null ? "****" : null)
				.append("#caCertData", caCertData!=null ? caCertData.length() : null)
				.append("caCertUri", caCertUri)
				.append("#clientCertData", clientCertData!=null ? clientCertData.length() : null)
				.append("clientCertUri", clientCertUri)
				.append("clientKeyAlgo", clientKeyAlgo)
				.append("#clientKeyData", clientKeyData!=null ? clientKeyData.length() : null)
				.append("clientKeyUri", clientKeyUri)

				.append("ingress", ingress)
				.append("cicd", cicd)
				.append("tools", tools)
				;
	}

}
