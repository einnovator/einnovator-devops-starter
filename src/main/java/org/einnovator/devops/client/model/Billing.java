package org.einnovator.devops.client.model;

import java.math.BigDecimal;
import java.util.Date;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Billing extends ProtectedEntity {

	private Boolean upgraded;
	
	private Date upgradeDate;

	private String accountId;

	private Object account;

	private BigDecimal currentBalance;

	private BigDecimal pendingBalance;

	private BigDecimal totalBalance;

	private Object currency;

	private BigDecimal refund;

	private BigDecimal credit;

	private Date creditExpires;

	private String upgradePaymentId;
	
	private String paymentId;

	private Object payment;
	
	private Object paymentStatus;
	
	private Date lastUpdate;

	private Date paymentIssuedDate;

	private Date paymentCompletedDate;

	private Date paymentDeadline;


	private BigDecimal priceHour;

	private BigDecimal priceMonth;
		
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code TitleEntity}.
	 *
	 */
	public Billing() {
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
	 * @param currentBalance the currentBalance
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
	 * @param pendingBalance the pendingBalance
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
	 * @param totalBalance the totalBalance
	 */
	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}


	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the currency
	 */
	public Object getCurrency() {
		return currency;
	}


	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the currency
	 */
	public void setCurrency(Object currency) {
		this.currency = currency;
	}


	/**
	 * Get the value of property {@code refund}.
	 *
	 * @return the refund
	 */
	public BigDecimal getRefund() {
		return refund;
	}


	/**
	 * Set the value of property {@code refund}.
	 *
	 * @param refund the refund
	 */
	public void setRefund(BigDecimal refund) {
		this.refund = refund;
	}


	/**
	 * Get the value of property {@code credit}.
	 *
	 * @return the credit
	 */
	public BigDecimal getCredit() {
		return credit;
	}


	/**
	 * Set the value of property {@code credit}.
	 *
	 * @param credit the credit
	 */
	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}


	/**
	 * Get the value of property {@code creditExpires}.
	 *
	 * @return the creditExpires
	 */
	public Date getCreditExpires() {
		return creditExpires;
	}


	/**
	 * Set the value of property {@code creditExpires}.
	 *
	 * @param creditExpires the creditExpires
	 */
	public void setCreditExpires(Date creditExpires) {
		this.creditExpires = creditExpires;
	}

	/**
	 * Get the value of property {@code upgraded}.
	 *
	 * @return the upgraded
	 */
	public Boolean getUpgraded() {
		return upgraded;
	}


	/**
	 * Set the value of property {@code upgraded}.
	 *
	 * @param upgraded the upgraded
	 */
	public void setUpgraded(Boolean upgraded) {
		this.upgraded = upgraded;
	}

	/**
	 * Get the value of property {@code upgradeDate}.
	 *
	 * @return the upgradeDate
	 */
	public Date getUpgradeDate() {
		return upgradeDate;
	}

	/**
	 * Set the value of property {@code upgradeDate}.
	 *
	 * @param upgradeDate the upgradeDate
	 */
	public void setUpgradeDate(Date upgradeDate) {
		this.upgradeDate = upgradeDate;
	}

	/**
	 * Get the value of property {@code accountId}.
	 *
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * Set the value of property {@code accountId}.
	 *
	 * @param accountId the accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * Get the value of property {@code account}.
	 *
	 * @return the account
	 */
	public Object getAccount() {
		return account;
	}

	/**
	 * Set the value of property {@code account}.
	 *
	 * @param account the account
	 */
	public void setAccount(Object account) {
		this.account = account;
	}

	/**
	 * Get the value of property {@code upgradePaymentId}.
	 *
	 * @return the upgradePaymentId
	 */
	public String getUpgradePaymentId() {
		return upgradePaymentId;
	}


	/**
	 * Set the value of property {@code upgradePaymentId}.
	 *
	 * @param upgradePaymentId the upgradePaymentId
	 */
	public void setUpgradePaymentId(String upgradePaymentId) {
		this.upgradePaymentId = upgradePaymentId;
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
	 * @param paymentId the paymentId
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * Get the value of property {@code payment}.
	 *
	 * @return the payment
	 */
	public Object getPayment() {
		return payment;
	}


	/**
	 * Set the value of property {@code payment}.
	 *
	 * @param payment the payment
	 */
	public void setPayment(Object payment) {
		this.payment = payment;
	}

	/**
	 * Get the value of property {@code paymentStatus}.
	 *
	 * @return the paymentStatus
	 */
	public Object getPaymentStatus() {
		return paymentStatus;
	}


	/**
	 * Set the value of property {@code paymentStatus}.
	 *
	 * @param paymentStatus the paymentStatus
	 */
	public void setPaymentStatus(Object paymentStatus) {
		this.paymentStatus = paymentStatus;
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
	 * @param lastUpdate the lastUpdate
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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
	 * @param paymentIssuedDate the paymentIssuedDate
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
	 * @param paymentCompletedDate the paymentCompletedDate
	 */
	public void setPaymentCompletedDate(Date paymentCompletedDate) {
		this.paymentCompletedDate = paymentCompletedDate;
	}

	/**
	 * Get the value of property {@code paymentDeadline}.
	 *
	 * @return the paymentDeadline
	 */
	public Date getPaymentDeadline() {
		return paymentDeadline;
	}


	/**
	 * Set the value of property {@code paymentDeadline}.
	 *
	 * @param paymentDeadline the paymentDeadline
	 */
	public void setPaymentDeadline(Date paymentDeadline) {
		this.paymentDeadline = paymentDeadline;
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
	 * @param priceHour the priceHour
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
	 * @param priceMonth the priceMonth
	 */
	public void setPriceMonth(BigDecimal priceMonth) {
		this.priceMonth = priceMonth;
	}
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("accountId", accountId)
				.append("upgraded", upgraded)
				.append("upgradeDate", upgradeDate)
				.append("currentBalance", currentBalance)
				.append("pendingBalance", pendingBalance)
				.append("totalBalance", totalBalance)
				.append("currency", currency)
				.append("refund", refund)
				.append("credit", credit)
				.append("creditExpires", creditExpires)
				.append("payment", payment)
				.append("paymentStatus", paymentStatus)
				.append("paymentIssuedDate", paymentIssuedDate)
				.append("paymentCompletedDate", paymentCompletedDate)
				.append("paymentDeadline", paymentDeadline)
				);
	}



}
