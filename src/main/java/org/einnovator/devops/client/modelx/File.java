/**
 * 
 */
package org.einnovator.devops.client.modelx;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

/**
 * @author support@einnovator.org
 *
 */
public class File extends ObjectBase {
	
	private String name;

	private String path;

	private String perms;
	
	private boolean dir;
	
	private Integer sub;
	
	private String owner;
	
	private String group;
	
	private Integer size;
	
	private String month;
	
	private String day;
	
	private String hhmm;
	
	private String lastModifiedFormatted;

	/**
	 * Create instance of {@code File}.
	 *
	 */
	public File() {
	}
	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param path the path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Get the value of property {@code perms}.
	 *
	 * @return the perms
	 */
	public String getPerms() {
		return perms;
	}

	/**
	 * Set the value of property {@code perms}.
	 *
	 * @param perms the perms
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}

	/**
	 * Get the value of property {@code dir}.
	 *
	 * @return the dir
	 */
	public boolean isDir() {
		return dir;
	}

	/**
	 * Set the value of property {@code dir}.
	 *
	 * @param dir the dir
	 */
	public void setDir(boolean dir) {
		this.dir = dir;
	}

	/**
	 * Get the value of property {@code sub}.
	 *
	 * @return the sub
	 */
	public Integer getSub() {
		return sub;
	}

	/**
	 * Set the value of property {@code sub}.
	 *
	 * @param sub the sub
	 */
	public void setSub(Integer sub) {
		this.sub = sub;
	}

	/**
	 * Get the value of property {@code owner}.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Get the value of property {@code size}.
	 *
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the size
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * Get the value of property {@code month}.
	 *
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Set the value of property {@code month}.
	 *
	 * @param month the month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * Get the value of property {@code day}.
	 *
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Set the value of property {@code day}.
	 *
	 * @param day the day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * Get the value of property {@code hhmm}.
	 *
	 * @return the hhmm
	 */
	public String getHhmm() {
		return hhmm;
	}

	/**
	 * Set the value of property {@code hhmm}.
	 *
	 * @param hhmm the hhmm
	 */
	public void setHhmm(String hhmm) {
		this.hhmm = hhmm;
	}

	/**
	 * Get the value of property {@code lastModifiedFormatted}.
	 *
	 * @return the lastModifiedFormatted
	 */
	public String getLastModifiedFormatted() {
		return lastModifiedFormatted;
	}

	/**
	 * Set the value of property {@code lastModifiedFormatted}.
	 *
	 * @param lastModifiedFormatted the lastModifiedFormatted
	 */
	public void setLastModifiedFormatted(String lastModifiedFormatted) {
		this.lastModifiedFormatted = lastModifiedFormatted;
	}
	
	//
	
	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to with
	 * @return this {@code File}
	 */
	public File withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code path}.
	 *
	 * @param path the path to with
	 * @return this {@code File}
	 */
	public File withPath(String path) {
		this.path = path;
		return this;
	}

	/**
	 * Set the value of property {@code perms}.
	 *
	 * @param perms the perms to with
	 * @return this {@code File}
	 */
	public File withPerms(String perms) {
		this.perms = perms;
		return this;
	}

	/**
	 * Set the value of property {@code dir}.
	 *
	 * @param dir the dir to with
	 * @return this {@code File}
	 */
	public File withDir(boolean dir) {
		this.dir = dir;
		return this;
	}

	/**
	 * Set the value of property {@code sub}.
	 *
	 * @param sub the sub to with
	 * @return this {@code File}
	 */
	public File withSub(Integer sub) {
		this.sub = sub;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the owner to with
	 * @return this {@code File}
	 */
	public File withOwner(String owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group to with
	 * @return this {@code File}
	 */
	public File withGroup(String group) {
		this.group = group;
		return this;
	}


	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the size to with
	 * @return this {@code File}
	 */
	public File withSize(Integer size) {
		this.size = size;
		return this;
	}

	/**
	 * Set the value of property {@code month}.
	 *
	 * @param month the month to with
	 * @return this {@code File}
	 */
	public File withMonth(String month) {
		this.month = month;
		return this;
	}

	/**
	 * Set the value of property {@code day}.
	 *
	 * @param day the day to with
	 * @return this {@code File}
	 */
	public File withDay(String day) {
		this.day = day;
		return this;
	}

	/**
	 * Set the value of property {@code hhmm}.
	 *
	 * @param hhmm the hhmm to with
	 * @return this {@code File}
	 */
	public File withHhmm(String hhmm) {
		this.hhmm = hhmm;
		return this;
	}

	/**
	 * Set the value of property {@code lastModifiedFormatted}.
	 *
	 * @param lastModifiedFormatted the lastModifiedFormatted to with
	 * @return this {@code File}
	 */
	public File withLastModifiedFormatted(String lastModifiedFormatted) {
		this.lastModifiedFormatted = lastModifiedFormatted;
		return this;
	}

	
	//drwxr-xr-x   2 root root 4096 Jun 10 00:00 lib64

	public String ls() {
		StringBuilder sb = new StringBuilder();
		sb.append(perms);
		sb.append(" ");
		sb.append(sub);
		sb.append(" ");
		sb.append(owner);
		sb.append(" ");
		sb.append(group);
		sb.append(" ");
		sb.append(size);
		sb.append(" ");
		sb.append(month);
		sb.append(" ");
		sb.append(day);
		sb.append(" ");
		sb.append(hhmm);
		sb.append(" ");
		sb.append(name);
		return sb.toString();
	}
	
	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
			.append("name", name)
			.append("path", path)
			.append("perms", perms)
			.append("dir", dir)
			.append("sub", sub)
			.append("owner", owner)
			.append("group", group)
			.append("size", size)
			.append("month", month)
			.append("day", day)
			.append("hhmm", hhmm)
			.append("lastModifiedFormatted", lastModifiedFormatted)
			;
	}
	
}

