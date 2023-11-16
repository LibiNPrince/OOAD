package com.ilp.entity;

import java.util.ArrayList;

public class Customer {
	private String customerNo;
	private String customerName;
	private ArrayList<Account> accountList;
	
	public Customer(String customerNo, String customerName, ArrayList<Account> accountList) {
		super();
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.accountList = accountList;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	
	

}
