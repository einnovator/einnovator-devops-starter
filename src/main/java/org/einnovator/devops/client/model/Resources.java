package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resources extends ObjectBase {

	private String memory;

	private Integer memoryValue;

	private String memoryUnit;

	private String cpu;

	private Integer cpuValue;

	private String cpuUnit;

	private String disk;

	private Integer diskValue;

	private String diskUnit;


	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code TitleEntity}.
	 *
	 */
	public Resources() {
	}

	public Resources(Object obj) {
		super(obj);
	}

	//
	// Getters/Setters
	//

	
	/**
	 * Get the value of property {@code memory}.
	 *
	 * @return the memory
	 */
	public String getMemory() {
		return memory;
	}

	/**
	 * Set the value of property {@code memory}.
	 *
	 * @param memory the memory
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	/**
	 * Get the value of property {@code cpu}.
	 *
	 * @return the cpu
	 */
	public String getCpu() {
		return cpu;
	}

	/**
	 * Set the value of property {@code cpu}.
	 *
	 * @param cpu the cpu
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	/**
	 * Get the value of property {@code disk}.
	 *
	 * @return the disk
	 */
	public String getDisk() {
		return disk;
	}

	/**
	 * Set the value of property {@code disk}.
	 *
	 * @param disk the disk
	 */
	public void setDisk(String disk) {
		this.disk = disk;
	}


	/**
	 * Get the value of property {@code memoryValue}.
	 *
	 * @return the memoryValue
	 */
	public Integer getMemoryValue() {
		return memoryValue;
	}

	/**
	 * Set the value of property {@code memoryValue}.
	 *
	 * @param memoryValue the memoryValue
	 */
	public void setMemoryValue(Integer memoryValue) {
		this.memoryValue = memoryValue;
	}

	/**
	 * Get the value of property {@code memoryUnit}.
	 *
	 * @return the memoryUnit
	 */
	public String getMemoryUnit() {
		return memoryUnit;
	}

	/**
	 * Set the value of property {@code memoryUnit}.
	 *
	 * @param memoryUnit the memoryUnit
	 */
	public void setMemoryUnit(String memoryUnit) {
		this.memoryUnit = memoryUnit;
	}
	
	/**
	 * Get the value of property {@code cpuValue}.
	 *
	 * @return the cpuValue
	 */
	public Integer getCpuValue() {
		return cpuValue;
	}

	/**
	 * Set the value of property {@code cpuValue}.
	 *
	 * @param cpuValue the cpuValue
	 */
	public void setCpuValue(Integer cpuValue) {
		this.cpuValue = cpuValue;
	}

	/**
	 * Get the value of property {@code cpuUnit}.
	 *
	 * @return the cpuUnit
	 */
	public String getCpuUnit() {
		return cpuUnit;
	}

	/**
	 * Set the value of property {@code cpuUnit}.
	 *
	 * @param cpuUnit the cpuUnit
	 */
	public void setCpuUnit(String cpuUnit) {
		this.cpuUnit = cpuUnit;
	}

	/**
	 * Get the value of property {@code diskValue}.
	 *
	 * @return the diskValue
	 */
	public Integer getDiskValue() {
		return diskValue;
	}

	/**
	 * Set the value of property {@code diskValue}.
	 *
	 * @param diskValue the diskValue
	 */
	public void setDiskValue(Integer diskValue) {
		this.diskValue = diskValue;
	}

	/**
	 * Get the value of property {@code diskUnit}.
	 *
	 * @return the diskUnit
	 */
	public String getDiskUnit() {
		return diskUnit;
	}

	/**
	 * Set the value of property {@code diskUnit}.
	 *
	 * @param diskUnit the diskUnit
	 */
	public void setDiskUnit(String diskUnit) {
		this.diskUnit = diskUnit;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("memory", memory)
				.append("memoryValue", memoryValue)
				.append("memoryUnit", memoryUnit)
				.append("cpu", cpu)
				.append("cpuValue", cpuValue)
				.append("cpuUnit", cpuUnit)
				.append("disk", disk)
				.append("diskValue", diskValue)
				.append("diskUnit", diskUnit)
				);
	}





}
