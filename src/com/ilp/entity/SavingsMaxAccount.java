package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	
	private double minBal=1000.00;

	public SavingsMaxAccount(String productNo, String productName, ArrayList<Service> serviceList) {
		super(productNo, productName, serviceList);
		
	}
	
	public SavingsMaxAccount( ) {
		
	}

	public double getMinBal() {
		return minBal;
	}

	public void setMinBal(double minBal) {
		this.minBal = minBal;
	}

	

}
