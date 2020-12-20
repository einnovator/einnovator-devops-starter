/**
 * 
 */
package org.einnovator.devops.client.model;

import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A {@code KeyPath}.
 *
 * @author support@einnovator.org
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class KeyPath extends ObjectBase {

	private String key;
	
	private String path;

	private String mode;

	/**
	 * Create instance of {@code KeyPath}.
	 *
	 */
	public KeyPath() {
	}

	/**
	 * Create instance of {@code KeyPath}.
	 *
	 * @param key the key
	 * @param path the path
	 * @param mode the mode
	 */
	public KeyPath(String key, String path, String mode) {
		super();
		this.key = key;
		this.path = path;
		this.mode = mode;
	}

	/**
	 * Create instance of {@code KeyPath}.
	 *
	 * @param key the key
	 * @param path the path
	 * @param mode the mode
	 */
	public KeyPath(String key, String path, Integer mode) {
		this(key, path, (String)null);
		this.mode = formatMode(mode);
	}

	/**
	 * Get the value of property {@code key}.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set the value of property {@code key}.
	 *
	 * @param key the value of property key
	 */
	public void setKey(String key) {
		this.key = key;
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

	
	@JsonInclude
	public Integer getModeAsInteger() {
		if (mode==null || mode.isEmpty()) {
			return null;
		}
		return parseMode(mode);
	}

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("key", key)
				.append("path", path)
				;
	}

	private static Integer parseMode(String mode) {
		try {
			int n = Integer.parseInt(mode);			
			mode = formatMode(n);
		} catch (IllegalArgumentException e) {
		}
		
		try {
			Set<PosixFilePermission> perms = PosixFilePermissions.fromString(mode);
			int n = 0;
			for (PosixFilePermission perm: perms) {
				switch (perm) {
				case OWNER_READ: n |= 400; break;
				case OWNER_WRITE: n |= 200; break;
				case OWNER_EXECUTE: n |= 100; break;
				case GROUP_READ: n |= 040; break;
				case GROUP_WRITE: n |= 020; break;
				case GROUP_EXECUTE: n |= 010; break;
				case OTHERS_READ: n |= 004; break;
				case OTHERS_WRITE: n |= 002; break;
				case OTHERS_EXECUTE: n |= 001; break;
				}
			}
			return n;			
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	 public static String formatMode(Integer perms) {
		 if (perms==null) {
			 return null;
		 }
		 final char[] ds = Integer.toString(perms).toCharArray();
		 final char[] ss = {'-','-','-','-','-','-','-','-','-'};
		 for (int i = ds.length-1; i >= 0; i--) {
			 int n = ds[i] - '0';
			 if (i == ds.length-1) {
				 if ((n & 1) != 0) ss[8] = 'x';
				 if ((n & 2) != 0) ss[7] = 'w';
				 if ((n & 4) != 0) ss[6] = 'r';
			 }
			 else if (i == ds.length-2) {
				 if ((n & 1) != 0) ss[5] = 'x';
				 if ((n & 2) != 0) ss[4] = 'w';
				 if ((n & 4) != 0) ss[3] = 'r';
			 }
			 else if (i == ds.length-3) {
				 if ((n & 1) != 0) ss[2] = 'x';
				 if ((n & 2) != 0) ss[1] = 'w';
				 if ((n & 4) != 0) ss[0] = 'r';
			 }
		 }
		 String sperms = new String(ss);
		 return sperms;
	 }

}
