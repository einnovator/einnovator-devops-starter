package org.einnovator.devops.client.model;

import java.math.BigDecimal;
import java.util.Date;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bill extends ObjectBase {

	private BigDecimal currentBalance;

	private BigDecimal pendingBalance;

	private BigDecimal totalBalance;
	
	private Object currency;

	private Date lastUpdate;

	private BigDecimal priceHour;

	private BigDecimal priceMonth;

	private Boolean free;
	
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code TitleEntity}.
	 *
	 */
	public Bill() {
	}

	
	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code currentBalance}.
	 *
	 * @return the currentBalance
	 */
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}


	/**
	 * Set the value of property {@code currentBalance}.
	 *
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}


	/**
	 * Get the value of property {@code pendingBalance}.
	 *
	 * @return the pendingBalance
	 */
	public BigDecimal getPendingBalance() {
		return pendingBalance;
	}


	/**
	 * Set the value of property {@code pendingBalance}.
	 *
	 * @param pendingBalance the pendingBalance to set
	 */
	public void setPendingBalance(BigDecimal pendingBalance) {
		this.pendingBalance = pendingBalance;
	}


	/**
	 * Get the value of property {@code totalBalance}.
	 *
	 * @return the totalBalance
	 */
	public BigDecimal getTotalBalance() {
		return totalBalance;
	}


	/**
	 * Set the value of property {@code totalBalance}.
	 *
	 * @param totalBalance the totalBalance to set
	 */
	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
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
	 * Get the value of property {@code lastUpdate}.
	 *
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}


	/**
	 * Set the value of property {@code lastUpdate}.
	 *
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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
	 * Set the value of property {@code priceHour}.
	 *
	 * @param priceHour the priceHour to set
	 */
	public void setPriceHour(BigDecimal priceHour) {
		this.priceHour = priceHour;
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
	 * Set the value of property {@code priceMonth}.
	 *
	 * @param priceMonth the priceMonth to set
	 */
	public void setPriceMonth(BigDecimal priceMonth) {
		this.priceMonth = priceMonth;
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

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("currentBalance", currentBalance)
				.append("pendingBalance", pendingBalance)
				.append("totalBalance", totalBalance)
				.append("currency", currency)
				.append("lastUpdate", lastUpdate)
				.append("priceHour", priceHour)
				.append("priceMonth", priceMonth)
				.append("free", free)
				);
	}

}
