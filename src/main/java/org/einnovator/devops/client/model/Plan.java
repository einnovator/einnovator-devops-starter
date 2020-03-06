package org.einnovator.devops.client.model;

import java.math.BigDecimal;
import java.util.List;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Plan extends NamedEntity {

	private Resources resources;

	private Resources minResources;

	private Resources maxResources;
	
	private Boolean free;

	private Boolean sandbox;

	private BigDecimal priceHour;

	private BigDecimal priceMonth;

	@JsonIgnore
	private BigDecimal instancePriceMonth;
	
	@JsonIgnore
	private BigDecimal memoryPriceMonth;

	@JsonIgnore
	private BigDecimal cpuPriceMonth;

	@JsonIgnore
	private BigDecimal diskPriceMonth;

	private Object currency;

	private List<Solution> solutions;

	private List<Plan> plans;
	
	private Integer order;

	//
	// Constructors
	//
	
	/**
	 * Create memory of {@code TitleEntity}.
	 *
	 */
	public Plan() {
	}
	
	//
	// Getters/Setters
	//


	/**
	 * Get the value of property {@code resources}.
	 *
	 * @return the resources
	 */
	public Resources getResources() {
		return resources;
	}

	/**
	 * Set the value of property {@code resources}.
	 *
	 * @param resources the resources to set
	 */
	public void setResources(Resources resources) {
		this.resources = resources;
	}

	/**
	 * Get the value of property {@code free}.
	 *
	 * @return the free
	 */
	public Boolean getFree() {
		return free;
	}
	
	/**
	 * Set the value of property {@code free}.
	 *
	 * @param free the free to set
	 */
	public void setFree(Boolean free) {
		this.free = free;
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

	
	
	/**
	 * Get the value of property {@code priceHour}.
	 *
	 * @return the priceHour
	 */
	public BigDecimal getPriceHour() {
		return priceHour;
	}

	/**
	 * Get the value of property {@code priceMonth}.
	 *
	 * @return the priceMonth
	 */
	public BigDecimal getPriceMonth() {
		return priceMonth;
	}

	/**
	 * Get the value of property {@code order}.
	 *
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * Set the value of property {@code order}.
	 *
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	
	/**
	 * Get the value of property {@code solutions}.
	 *
	 * @return the solutions
	 */
	public List<Solution> getSolutions() {
		return solutions;
	}

	/**
	 * Set the value of property {@code solutions}.
	 *
	 * @param solutions the solutions to set
	 */
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	
	/**
	 * Get the value of property {@code minResources}.
	 *
	 * @return the minResources
	 */
	public Resources getMinResources() {
		return minResources;
	}


	/**
	 * Set the value of property {@code minResources}.
	 *
	 * @param minResources the minResources to set
	 */
	public void setMinResources(Resources minResources) {
		this.minResources = minResources;
	}


	/**
	 * Get the value of property {@code maxResources}.
	 *
	 * @return the maxResources
	 */
	public Resources getMaxResources() {
		return maxResources;
	}


	/**
	 * Set the value of property {@code maxResources}.
	 *
	 * @param maxResources the maxResources to set
	 */
	public void setMaxResources(Resources maxResources) {
		this.maxResources = maxResources;
	}
	
	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the currency
	 */
	public Object getObject() {
		return currency;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the currency to set
	 */
	public void setObject(Object currency) {
		this.currency = currency;
	}

	/**
	 * Set the value of property {@code priceHour}.
	 *
	 * @param priceHour the priceHour to set
	 */
	public void setPriceHour(BigDecimal priceHour) {
		this.priceHour = priceHour;
	}

	/**
	 * Set the value of property {@code priceMonth}.
	 *
	 * @param priceMonth the priceMonth to set
	 */
	public void setPriceMonth(BigDecimal priceMonth) {
		this.priceMonth = priceMonth;
	}

	/**
	 * Get the value of property {@code memoryPriceMonth}.
	 *
	 * @return the memoryPriceMonth
	 */
	public BigDecimal getInstancePriceMonth() {
		return memoryPriceMonth;
	}

	/**
	 * Set the value of property {@code memoryPriceMonth}.
	 *
	 * @param memoryPriceMonth the memoryPriceMonth to set
	 */
	public void setInstancePriceMonth(BigDecimal memoryPriceMonth) {
		this.memoryPriceMonth = memoryPriceMonth;
	}

	/**
	 * Get the value of property {@code cpuPriceMonth}.
	 *
	 * @return the cpuPriceMonth
	 */
	public BigDecimal getCpuPriceMonth() {
		return cpuPriceMonth;
	}

	/**
	 * Set the value of property {@code cpuPriceMonth}.
	 *
	 * @param cpuPriceMonth the cpuPriceMonth to set
	 */
	public void setCpuPriceMonth(BigDecimal cpuPriceMonth) {
		this.cpuPriceMonth = cpuPriceMonth;
	}

	/**
	 * Get the value of property {@code diskPriceMonth}.
	 *
	 * @return the diskPriceMonth
	 */
	public BigDecimal getDiskPriceMonth() {
		return diskPriceMonth;
	}

	/**
	 * Set the value of property {@code diskPriceMonth}.
	 *
	 * @param diskPriceMonth the diskPriceMonth to set
	 */
	public void setDiskPriceMonth(BigDecimal diskPriceMonth) {
		this.diskPriceMonth = diskPriceMonth;
	}

	/**
	 * Get the value of property {@code memoryPriceMonth}.
	 *
	 * @return the memoryPriceMonth
	 */
	public BigDecimal getMemoryPriceMonth() {
		return memoryPriceMonth;
	}

	/**
	 * Set the value of property {@code memoryPriceMonth}.
	 *
	 * @param memoryPriceMonth the memoryPriceMonth to set
	 */
	public void setMemoryPriceMonth(BigDecimal memoryPriceMonth) {
		this.memoryPriceMonth = memoryPriceMonth;
	}
	
	/**
	 * Get the value of property {@code plans}.
	 *
	 * @return the plans
	 */
	public List<Plan> getPlans() {
		return plans;
	}

	/**
	 * Set the value of property {@code plans}.
	 *
	 * @param plans the plans to set
	 */
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("resources", resources)
				.append("free", free)
				.append("priceHour", priceHour)
				.append("priceMonth", priceMonth)
				.append("memoryPriceMonth", memoryPriceMonth)
				.append("cpuPriceMonth", cpuPriceMonth)
				.append("diskPriceMonth", diskPriceMonth)
				.append("memoryPriceMonth", memoryPriceMonth)
				.append("currency", currency)
				.append("order", order)
				.append("plans", plans)
				);
	}
	
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(creator
				);
	}



	
	

	public Plan findPlan(String id) {
		if (id!=null && plans!=null) {
			for (Plan plan: plans) {
				if (id.equals(plan.getUuid()) || id.equals(plan.getKey())) {
					return plan;
				}
			}
		}
		return null;
	}
	
	public Plan findPlanByKey(String key) {
		if (key!=null && plans!=null) {
			for (Plan plan: plans) {
				if (key.equals(plan.getKey())) {
					return plan;
				}
			}
		}
		return null;		
	}
}
