package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cluster extends BilledEntity {

	private String region;
	
	private List<Node> nodes;

	private Boolean sandbox;

	private Boolean shared;

	private Boolean fallback;

	private String img;
	
	private Boolean enabled;
	
	private String master;

	private String caCertData;

	private String caCertUri;

	private String clientCertData;

	private String clientCertUri;

	private String clientKeyData;

	private String clientKeyUri;

	private String clientKeyAlgo;

	/**
	 * Create instance of {@code Cluster}.
	 *
	 */
	public Cluster() {
	}

	
	/**
	 * Get the value of property {@code region}.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}


	/**
	 * Set the value of property {@code region}.
	 *
	 * @param region the region to set
	 */
	public void setRegion(String region) {
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
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		if (this.nodes==null) {
			this.nodes = new ArrayList<>();
		}
		this.nodes.add(node);
	}

	public Node removeNode(int index) {
		if (nodes==null || index <0 || index>= nodes.size()) {
			return null;
		}
		return nodes.remove(index);
	}

	public Node getNode(int index) {
		if (nodes==null || index <0 || index>= nodes.size()) {
			return null;
		}
		return nodes.get(index);
	}

	public Node findNode(Node node) {
		if (node!=null && nodes!=null) {
			for (Node node2: nodes) {
				if ((node2.getId()!=null && node2.getId().equals(node.getId())) || (node2.getUuid()!=null && node2.getUuid().equals(node.getUuid()))) {
					return node;
				}
			}
		}
		return null;
	}

	public Node findNode(String id) {
		if (id!=null && nodes!=null) {
			for (Node node: nodes) {
				if (id.equals(node.getUuid())) {
					return node;
				}
			}
		}
		return null;
	}

	public Node removeNode(Node node) {
		if (node!=null && nodes!=null) {
			for (int i=0; i<nodes.size(); i++) {
				Node node2 = nodes.get(i);
				if ((node2.getId()!=null && node2.getId().equals(node.getId())) || (node2.getUuid()!=null && node2.getUuid().equals(node.getUuid()))) {
					return nodes.remove(i);
				}
			}
		}
		return null;
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
	 * @param shared the shared to set
	 */
	public void setShared(Boolean shared) {
		this.shared = shared;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
	 * @param enabled the enabled to set
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
	 * @param fallback the fallback to set
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
	 * @param master the master to set
	 */
	public void setMaster(String master) {
		this.master = master;
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
	 * @param caCertData the caCertData to set
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
	 * @param caCertUri the caCertUri to set
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
	 * @param clientCertData the clientCertData to set
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
	 * @param clientCertUri the clientCertUri to set
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
	 * @param clientKeyData the clientKeyData to set
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
	 * @param clientKeyUri the clientKeyUri to set
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
	 * @param clientKeyAlgo the clientKeyAlgo to set
	 */
	public void setClientKeyAlgo(String clientKeyAlgo) {
		this.clientKeyAlgo = clientKeyAlgo;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("sandbox", sandbox)
				.append("shared", shared)
				.append("fallback", fallback)
				.append("region", region)
				.append("nodes", nodes)
				.append("enabled", enabled)
				.append("img", img)
				.append("#caCertData", caCertData!=null ? caCertData.length() : null)
				.append("caCertUri", caCertUri)
				.append("#clientCertData", clientCertData!=null ? clientCertData.length() : null)
				.append("clientCertUri", clientCertUri)
				.append("clientKeyAlgo", clientKeyAlgo)
				.append("#clientKeyData", clientKeyData!=null ? clientKeyData.length() : null)
				.append("clientKeyUri", clientKeyUri)
				;
	}

}
