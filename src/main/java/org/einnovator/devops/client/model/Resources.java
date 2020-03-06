package org.einnovator.devops.client.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resources extends ObjectBase {

	private static final String DEFAULT_MEMORY_UNIT = "Gi";

	private static final String DEFAULT_DISK_UNIT = "Gi";

	private static final String DEFAULT_CPU_UNIT = "";

	private Integer instances;
	
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
	 * @param memory the memory to set
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
	 * @param cpu the cpu to set
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
	 * @param disk the disk to set
	 */
	public void setDisk(String disk) {
		this.disk = disk;
	}

	

	/**
	 * Get the value of property {@code instances}.
	 *
	 * @return the instances
	 */
	public Integer getInstances() {
		return instances;
	}

	/**
	 * Set the value of property {@code instances}.
	 *
	 * @param instances the instances to set
	 */
	public void setInstances(Integer instances) {
		this.instances = instances;
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
	 * @param memoryValue the memoryValue to set
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
	 * @param memoryUnit the memoryUnit to set
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
	 * @param cpuValue the cpuValue to set
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
	 * @param cpuUnit the cpuUnit to set
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
	 * @param diskValue the diskValue to set
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
	 * @param diskUnit the diskUnit to set
	 */
	public void setDiskUnit(String diskUnit) {
		this.diskUnit = diskUnit;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("instances", instances)
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


	public void normalize() {
		Object[] a1 = normalizeUnits(memory, memoryValue, memoryUnit!=null ? memoryUnit : DEFAULT_MEMORY_UNIT);
		memory = (String)a1[0]; memoryValue = (Integer)a1[1]; memoryUnit = (String)a1[2];
		Object[] a2 = normalizeUnits(disk, diskValue, diskUnit!=null ? diskUnit : DEFAULT_DISK_UNIT);
		disk = (String)a2[0]; diskValue = (Integer)a2[1]; diskUnit = (String)a2[2];
		Object[] a3 = normalizeUnits(cpu, cpuValue, cpuUnit!=null ? cpuUnit : DEFAULT_CPU_UNIT);
		cpu = (String)a3[0]; cpuValue = (Integer)a3[1]; cpuUnit = (String)a3[2];
	}

	public static Object[] normalizeUnits(String s, Integer value, String unit) {
		Object[] a = new Object[3];
		if (StringUtils.hasText(s)) {
			s = s.trim();
			int i = -1;
			if (s.length()>=1 && Character.isAlphabetic(s.charAt(s.length()-1))) {
				i = s.length()-1;
				if (s.length()>=2 && Character.isAlphabetic(s.charAt(s.length()-2))) {
					i = s.length()-2;
				}

			}
			if (i>0) {
				try {
					value = Integer.parseInt(s.substring(0, i));					
				} catch (NumberFormatException e) {
					value = 1;
				}
				unit = s.substring(i);
			} else if (i==0) {
				value = 1;
				unit = s;
			} else {
				try {
					value = Integer.parseInt(s);					
				} catch (NumberFormatException e) {
					value = 1;
				}
				unit = null;
			}
		} else {
			s = value!=null && unit!=null ? value + unit : unit!=null ? 1 + unit: value!=null ? value.toString() : "1";
		}
		a[0] = s;
		a[1] = value;
		a[2] = unit;
		return a;
	}
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(creator
				);
	}





}
