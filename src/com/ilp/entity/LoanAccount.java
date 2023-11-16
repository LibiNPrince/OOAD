package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	private double chequeDepositRate=0.3;

	public LoanAccount(String productNo, String productName, ArrayList<Service> serviceList) {
		super(productNo, productName, serviceList);
	
	}

	public double getChequeDepositRate() {
		return chequeDepositRate;
	}

	public void setChequeDepositRate(double chequeDepositRate) {
		this.chequeDepositRate = chequeDepositRate;
	}


}