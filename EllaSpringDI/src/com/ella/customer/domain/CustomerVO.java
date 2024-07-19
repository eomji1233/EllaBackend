package com.ella.customer.domain;

public class CustomerVO {
	private String customerId;
	private String custmoerName;
	private String email;
	private String address;
	
	public CustomerVO() {}
	
	public CustomerVO(String customerId, String custmoerName, String email, String address) {
		super();
		this.customerId = customerId;
		this.custmoerName = custmoerName;
		this.email = email;
		this.address = address;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustmoerName() {
		return custmoerName;
	}
	public void setCustmoerName(String custmoerName) {
		this.custmoerName = custmoerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerVO [customerId=" + customerId + ", custmoerName=" + custmoerName + ", email=" + email
				+ ", address=" + address + "]";
	}
}
