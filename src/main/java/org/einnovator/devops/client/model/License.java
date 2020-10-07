package org.einnovator.devops.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A {@code License}
 *
 * @author support@einnovator.org
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class License extends ProtectedEntity {

	private LicenseStatus status;
	
	private String catalogId;

	private String solutionId;
	
	private String plan;

	private Date issuedDate;

	private Date startDate;

	private Date expireDate;

	private String key;
	
	private Map<String, String> data;
	
	private Integer months;

	private Double discount;

	private BigDecimal basePrice;

	private BigDecimal priceMonth;

	private BigDecimal total;

	private String currency;

	private String paymentId;

	private String paymentStatus;
	
	private Date paymentIssuedDate;

	private Date paymentCompletedDate;

	private Boolean auto;

	private Date renewDate;

	private Integer paymentCount;
	
	private BigDecimal paymentsTotal;	

	/**
	 * Create instance of {@code License}.
	 *
	 */
	public License() {
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public LicenseStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 */
	public void setStatus(LicenseStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code solutionId}.
	 *
	 * @return the solutionId
	 */
	public String getSolutionId() {
		return solutionId;
	}

	/**
	 * Set the value of property {@code solutionId}.
	 *
	 * @param solutionId the value of property solutionId
	 */
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}

	/**
	 * Get the value of property {@code catalogId}.
	 *
	 * @return the value of {@code catalogId}
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * Set the value of property {@code catalogId}.
	 *
	 * @param catalogId the value of {@code catalogId}
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the value of {@code currency}
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the value of {@code currency}
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * Get the value of property {@code data}.
	 *
	 * @return the data
	 */
	public Map<String, String> getData() {
		return data;
	}

	/**
	 * Set the value of property {@code data}.
	 *
	 * @param data the value of property data
	 */
	public void setData(Map<String, String> data) {
		this.data = data;
	}

	/**
	 * Get the value of property {@code discount}.
	 *
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * Set the value of property {@code discount}.
	 *
	 * @param discount the value of property discount
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * Get the value of property {@code basePrice}.
	 *
	 * @return the basePrice
	 */
	public BigDecimal getBasePrice() {
		return basePrice;
	}

	/**
	 * Set the value of property {@code basePrice}.
	 *
	 * @param basePrice the value of property basePrice
	 */
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
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
	 * @param priceMonth the value of property priceMonth
	 */
	public void setPriceMonth(BigDecimal priceMonth) {
		this.priceMonth = priceMonth;
	}

	/**
	 * Get the value of property {@code total}.
	 *
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * Set the value of property {@code total}.
	 *
	 * @param total the value of property total
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * Get the value of property {@code auto}.
	 *
	 * @return the auto
	 */
	public Boolean getAuto() {
		return auto;
	}

	/**
	 * Set the value of property {@code auto}.
	 *
	 * @param auto the value of property auto
	 */
	public void setAuto(Boolean auto) {
		this.auto = auto;
	}


	/**
	 * Set the value of property {@code months}.
	 *
	 * @param months the value of property months
	 */
	public void setMonths(Integer months) {
		this.months = months;
	}


	/**
	 * Get the value of property {@code plan}.
	 *
	 * @return the plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * Set the value of property {@code plan}.
	 *
	 * @param plan the value of property plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	/**
	 * Get the value of property {@code issueDate}.
	 *
	 * @return the issueDate
	 */
	public Date getIssuedDate() {
		return issuedDate;
	}

	/**
	 * Set the value of property {@code issuedDate}.
	 *
	 * @param issuedDate the value of property issuedDate
	 */
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}


	/**
	 * Get the value of property {@code startDate}.
	 *
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Set the value of property {@code startDate}.
	 *
	 * @param startDate the value of property startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get the value of property {@code expireDate}.
	 *
	 * @return the expireDate
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * Set the value of property {@code expireDate}.
	 *
	 * @param expireDate the value of property expireDate
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * Get the value of property {@code months}.
	 *
	 * @return the months
	 */
	public Integer getMonths() {
		return months;
	}

	@JsonIgnore
	public int getRequiredMonths() {
		return months!=null && months>0 ? months : 1;
	}
	

	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the currency
	 */
	public String getString() {
		return currency;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the value of property currency
	 */
	public void setString(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the value of property {@code paymentId}.
	 *
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * Set the value of property {@code paymentId}.
	 *
	 * @param paymentId the value of property paymentId
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * Get the value of property {@code paymentStatus}.
	 *
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * Set the value of property {@code paymentStatus}.
	 *
	 * @param paymentStatus the value of property paymentStatus
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * Get the value of property {@code paymentIssuedDate}.
	 *
	 * @return the paymentIssuedDate
	 */
	public Date getPaymentIssuedDate() {
		return paymentIssuedDate;
	}

	/**
	 * Set the value of property {@code paymentIssuedDate}.
	 *
	 * @param paymentIssuedDate the value of property paymentIssuedDate
	 */
	public void setPaymentIssuedDate(Date paymentIssuedDate) {
		this.paymentIssuedDate = paymentIssuedDate;
	}

	/**
	 * Get the value of property {@code paymentCompletedDate}.
	 *
	 * @return the paymentCompletedDate
	 */
	public Date getPaymentCompletedDate() {
		return paymentCompletedDate;
	}

	/**
	 * Set the value of property {@code paymentCompletedDate}.
	 *
	 * @param paymentCompletedDate the value of property paymentCompletedDate
	 */
	public void setPaymentCompletedDate(Date paymentCompletedDate) {
		this.paymentCompletedDate = paymentCompletedDate;
	}


	/**
	 * Get the value of property {@code renewDate}.
	 *
	 * @return the renewDate
	 */
	public Date getRenewDate() {
		return renewDate;
	}

	/**
	 * Set the value of property {@code renewDate}.
	 *
	 * @param renewDate the value of property renewDate
	 */
	public void setRenewDate(Date renewDate) {
		this.renewDate = renewDate;
	}

	/**
	 * Get the value of property {@code paymentCount}.
	 *
	 * @return the paymentCount
	 */
	public Integer getPaymentCount() {
		return paymentCount;
	}

	/**
	 * Set the value of property {@code paymentCount}.
	 *
	 * @param paymentCount the value of property paymentCount
	 */
	public void setPaymentCount(Integer paymentCount) {
		this.paymentCount = paymentCount;
	}

	/**
	 * Get the value of property {@code paymentsTotal}.
	 *
	 * @return the paymentsTotal
	 */
	public BigDecimal getPaymentsTotal() {
		return paymentsTotal;
	}

	/**
	 * Set the value of property {@code paymentsTotal}.
	 *
	 * @param paymentsTotal the value of property paymentsTotal
	 */
	public void setPaymentsTotal(BigDecimal paymentsTotal) {
		this.paymentsTotal = paymentsTotal;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("solutionId", solutionId)
				.append("plan", plan)
				.append("issuedDate", issuedDate)
				.append("expireDate", expireDate)
				.append("months", months)
				.append("total", total)
				.append("currency", currency)
				.append("priceMonth", priceMonth)
				.append("basePrice", basePrice)
				.append("paymentId", paymentId)
				.append("paymentStatus", paymentStatus)
				.append("paymentIssuedDate", paymentIssuedDate)
				.append("paymentCompletedDate", paymentCompletedDate)
				.append("key", key!=null ? "****" : null)
				;
	}

}
