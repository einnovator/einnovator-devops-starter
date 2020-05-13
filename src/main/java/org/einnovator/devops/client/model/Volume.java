package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Volume extends OwnedEntity {
	
	public static final String ACCESS_MODE_RWO = "ReadWriteOnce";
	public static final String ACCESS_MODE_ROM = "ReadOnlyMany";
	public static final String ACCESS_MODE_RWM = "ReadWriteMany";
		
	public static final String STORAGE_CLASS_LOCAL = "local-storage";
	public static final String STORAGE_CLASS_DO = "do-block-storage";
	public static final String STORAGE_CLASS_AWSEBS = "AWSElasticBlockStore";
	public static final String STORAGE_CLASS_AZUREDISK = "AzureDisk";
	public static final String STORAGE_CLASS_AZUREFILE = "AzureFile";
	public static final String STORAGE_CLASS_CEPHFS = "CephFS";
	public static final String STORAGE_CLASS_CINDER = "Cinder (OpenStack block storage)";
	public static final String STORAGE_CLASS_GCE = "GCEPersistentDisk";
	public static final String STORAGE_CLASS_Glusterfs = "Glusterfs";
	public static final String STORAGE_CLASS_NFS = "NFS";
	public static final String STORAGE_CLASS_QUOBYTE = "Quobyte Volumes";
	public static final String STORAGE_CLASS_RBD = "RBD (Ceph Block Device)";
	public static final String STORAGE_CLASS_STORAGEOS = "StorageOS";
	public static final String STORAGE_CLASS_VSPHERE = "VsphereVolume";
	public static final String STORAGE_CLASS_ISCSI = "iSCSI";    
    
	private String size;

	private String mode;

	private String storageClass;

	private String fs;

	private String path;
	
	private ReclaimType reclaimType;

	private String node;

	private String namespace;
		
	public Volume() {
	}

	/**
	 * Get the value of property {@code size}.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the value of property size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Get the value of property {@code mode}.
	 *
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * Set the value of property {@code mode}.
	 *
	 * @param mode the value of property mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * Get the value of property {@code storageClass}.
	 *
	 * @return the storageClass
	 */
	public String getStorageClass() {
		return storageClass;
	}

	/**
	 * Set the value of property {@code storageClass}.
	 *
	 * @param storageClass the value of property storageClass
	 */
	public void setStorageClass(String storageClass) {
		this.storageClass = storageClass;
	}

	/**
	 * Get the value of property {@code fs}.
	 *
	 * @return the fs
	 */
	public String getFs() {
		return fs;
	}

	/**
	 * Set the value of property {@code fs}.
	 *
	 * @param fs the value of property fs
	 */
	public void setFs(String fs) {
		this.fs = fs;
	}

	/**
	 * Get the value of property {@code path}.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Set the value of property {@code path}.
	 *
	 * @param path the value of property path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Get the value of property {@code reclaimType}.
	 *
	 * @return the reclaimType
	 */
	public ReclaimType getReclaimType() {
		return reclaimType;
	}

	/**
	 * Set the value of property {@code reclaimType}.
	 *
	 * @param reclaimType the value of property reclaimType
	 */
	public void setReclaimType(ReclaimType reclaimType) {
		this.reclaimType = reclaimType;
	}

	/**
	 * Get the value of property {@code node}.
	 *
	 * @return the node
	 */
	public String getNode() {
		return node;
	}

	/**
	 * Set the value of property {@code node}.
	 *
	 * @param node the value of property node
	 */
	public void setNode(String node) {
		this.node = node;
	}

	/**
	 * Get the value of property {@code namespace}.
	 *
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * Set the value of property {@code namespace}.
	 *
	 * @param namespace the value of property namespace
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("size", size)
				.append("mode", mode)
				.append("storageClass", storageClass)
				.append("fs", fs)
				.append("reclaimType", reclaimType)
				.append("path", path)
				.append("node", node)
				.append("namespace", namespace)
				;
	}
	
	
}
