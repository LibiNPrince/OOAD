package com.ilp.entity;

public class Account {
	private String accountNo;
	private double accountBal;
	private Product product;
	
	public Account(String accountNo, double accountBal, Product product) {
		super();
		this.accountNo = accountNo;
		this.accountBal = accountBal;
		this.product = product;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
