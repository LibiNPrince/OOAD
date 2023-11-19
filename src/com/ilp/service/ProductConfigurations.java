package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ProductConfigurations {

	public static Service createService() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the service ID");
		String serviceId = scanner.nextLine();
		System.out.println("Enter the service Name");
		String serviceName = scanner.nextLine();
		System.out.println("Enter the service Rate");
		scanner = new Scanner(System.in);
		double serviceRate = scanner.nextDouble();
		return new Service(serviceId, serviceName, serviceRate);
	}

	public static void displayServices(ArrayList<Service> serviceList) {
		if(serviceList.size()<1) {
			System.out.println("No services created");
			return;
		}
		System.out.println("----Services Available------");
		int i = 1;
		for (Service service : serviceList) {
			System.out.println(i + "." + service.getServiceName());
			i++;
		}

	}

	public static Product createProduct(ArrayList<Service> serviceList) {
		if(serviceList.size()<1) {
			System.out.println("No services created");
			return null;
		}
		ArrayList<Product> productList=new ArrayList<Product>();
		Scanner scanner=new Scanner(System.in);
		Product product=null;
//		String productLooper="";
//		do {
			System.out.println("Which  product you want to create?\n1.Savings Max Account 2.Loan Account 3.Current Account");
			int productChoice=scanner.nextInt();
			
			switch(productChoice) {
				case 1:
					product=createSavingsMaxAccountProduct(serviceList);
					break;
				case 2:
					product=createLoanAccount(serviceList);
					break;
				case 3:
					product=createCurrentAccount(serviceList);
					break;
				default:
					System.out.println("Invalid");
					break;
			}
			return product;
			
//			productList.add(product);
			
//			System.out.println("Do you wish to continue adding another Product?(y/n)");
//			scanner=new Scanner(System.in);
//			productLooper=scanner.nextLine();
//		}while(productLooper.equalsIgnoreCase("y"));
		
//		return productList;
	}
	
	private static SavingsMaxAccount createSavingsMaxAccountProduct(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Service> savingsMaxAccountServiceList=new ArrayList<Service>();
		
		
		System.out.println("Enter the Product ID");
		String productId = scanner.nextLine();
		System.out.println("Enter the Product Name");
		String productName = scanner.nextLine();
		
		Service productService=null;
		String serviceLooper="";
		do {
			System.out.println("Choose the services you want");
			int i=1;
			for(Service service:serviceList) {
				System.out.println(i + "." + service.getServiceName());
				i++;
			}
			int productServiceChoice = scanner.nextInt();
			savingsMaxAccountServiceList.add(serviceList.get(productServiceChoice - 1));

			System.out.println("Do you wish to continue adding another Service?(y/n)");
			scanner=new Scanner(System.in);
			serviceLooper=scanner.nextLine();
		}while(serviceLooper.equalsIgnoreCase("y"));
		
		return new SavingsMaxAccount(productId,productName,savingsMaxAccountServiceList);
	}
	
	private static LoanAccount createLoanAccount(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Service> LoanAccountServiceList=new ArrayList<Service>();
		
		
		System.out.println("Enter the Product ID");
		String productId = scanner.nextLine();
		System.out.println("Enter the Product Name");
		String productName = scanner.nextLine();
		
		Service productService=null;
		String serviceLooper="";
		do {
			System.out.println("Choose the services you want");
			int i=1;
			for(Service service:serviceList) {
				System.out.println(i + "." + service.getServiceName());
				i++;
			}
			int productServiceChoice = scanner.nextInt();
			LoanAccountServiceList.add(serviceList.get(productServiceChoice - 1));

			System.out.println("Do you wish to continue adding another Service?(y/n)");
			scanner=new Scanner(System.in);
			serviceLooper=scanner.nextLine();
		}while(serviceLooper.equalsIgnoreCase("y"));
		
		return new LoanAccount(productId,productName,LoanAccountServiceList);

	}
	
	private static CurrentAccount createCurrentAccount(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Service> currentAccountServiceList=new ArrayList<Service>();
		
		
		System.out.println("Enter the Product ID");
		String productId = scanner.nextLine();
		System.out.println("Enter the Product Name");
		String productName = scanner.nextLine();
		
		Service productService=null;
		String serviceLooper="";
		do {
			System.out.println("Choose the services you want");
			int i=1;
			for(Service service:serviceList) {
				System.out.println(i + "." + service.getServiceName());
				i++;
			}
			int productServiceChoice = scanner.nextInt();
			currentAccountServiceList.add(serviceList.get(productServiceChoice - 1));

			System.out.println("Do you wish to continue adding another Service?(y/n)");
			scanner=new Scanner(System.in);
			serviceLooper=scanner.nextLine();
		}while(serviceLooper.equalsIgnoreCase("y"));
		
		return new CurrentAccount(productId,productName,currentAccountServiceList);

	} 

	public static void displayProduct(ArrayList<Product> productList) {
		if(productList.size()<1) {
			System.out.println("No products created");
			return;
		}
		System.out.println("----Product Available------");
		int i = 1;
		for (Product product : productList) {
			System.out.println(i + "." + product.getProductName());
			
			System.out.println(product.getProductName()+" Services");
			int j=1;
			for (Service service : product.getServiceList()) {
				System.out.println(j + "." + service.getServiceName());
				j++;
			}
			i++;
			System.out.println("");
		}
		
	}

}
