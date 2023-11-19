package com.ilp.entity;

public class Service {
	private String serviceNo;
	public Service(String serviceNo, String serviceName, double serviceRate) {
		super();
		this.serviceNo = serviceNo;
		this.serviceName = serviceName;
		this.serviceRate = serviceRate;
	}
	private String serviceName;
	private double serviceRate;
	
	public String getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getServiceRate() {
		return serviceRate;
	}
	public void setServiceRate(double serviceRate) {
		this.serviceRate = serviceRate;
	}
	

}
