/**
 * the model of a customer to be saved in database
 */
package com.stevenlesoft.webstore.domain;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Customer {

	private long customerId;
	@NotEmpty
	private String customerPassword;
	@NotEmpty
	@Length(max=50)
	private String customerName;
	@NotEmpty
	@Length(max=50)
	private String customerAddress;
	@NotEmpty
	@Length(max=50)
	private String customerEmail;
	@Digits(integer=10,fraction=0)
	private long numberOfOrdersMade;
	
	public Customer()
	{
		super();
	}
	
	public Customer(long customerId, String customerPassword, String customerName, String customerAddress,
			String customerEmail, long numberOfOrdersMade) {
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.numberOfOrdersMade = numberOfOrdersMade;
	}

	// getter and setter methods
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmail=" + customerEmail + ", numberOfOrdersMade=" + numberOfOrdersMade
				+ "]";
	}
	
}
