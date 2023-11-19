package com.ilp.entity;

import java.util.ArrayList;

public  abstract class Product {
	private String productNo;
	private String productName;
	private ArrayList<Service> serviceList;
	
	
	public Product(String productNo, String productName, ArrayList<Service> serviceList) {

		this.productNo = productNo;
		this.productName = productName;
		this.serviceList = serviceList;
	}
	
	
	public Product( ) {

	}
	
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Service> getServiceList() {
		return serviceList;
	}
	public void setServiceList(ArrayList<Service> serviceList) {
		this.serviceList = serviceList;
	}
	
}
