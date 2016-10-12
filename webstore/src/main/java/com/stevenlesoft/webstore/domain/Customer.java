/**
 * the model of a customer to be saved in database
 */
package com.stevenlesoft.webstore.domain;

public class Customer {

	private String customerId;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private long numberOfOrdersMade;
	
	public Customer(String customerId, String customerName, String customerAddress) 
	{
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerId;
		this.numberOfOrdersMade = 0;
	}

	
	// getter and setter methods
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getNumberOfOrdersMade() {
		return numberOfOrdersMade;
	}

	public void setNumberOfOrdersMade(long numberOfOrdersMade) {
		this.numberOfOrdersMade = numberOfOrdersMade;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmail=" + customerEmail + ", numberOfOrdersMade=" + numberOfOrdersMade
				+ "]";
	}
	
}
