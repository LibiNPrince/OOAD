package com.ilp.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.AccountConfigurations;
import com.ilp.service.ProductConfigurations;

public class utitlies {

	public static void main(String[] args) {
		ArrayList<Account> accountList=new ArrayList<Account>();
		ArrayList<Product> bankProductList=new ArrayList<Product>();
		ArrayList<Service> bankServiceList=new ArrayList<Service>();
		Product bankProduct=null;
		
		Scanner scanner=new Scanner(System.in);
		String userUtilityLooper="";
		do {
			
			System.out.println("----Menu Creation-----");
			System.out.println("1.Create Service\n2.Display Services\n3.Create Product\n4.Display Product");
			int utilityChoice=scanner.nextInt();
			switch(utilityChoice){
			case 1:
				Service service=null;
				service=ProductConfigurations.createService();
				bankServiceList.add(service);
				break;
			case 2:
				ProductConfigurations.displayServices(bankServiceList);
				break;
			case 3:
				
				bankProduct=ProductConfigurations.createProduct(bankServiceList);
				bankProductList.add(bankProduct);
				break;
			case 4:
				ProductConfigurations.displayProduct(bankProductList);
				break;
			default:
				System.out.println("Invalid");
			}
			System.out.println("Do you want to continue to Menu Creation(y/n)");
			userUtilityLooper=scanner.next();
			
			if((userUtilityLooper.equalsIgnoreCase("n")) &&(bankProductList.size()<1)) {
				System.out.println("You cannot procced without Products,Try creating Product/s");
				userUtilityLooper="y";
			}
			
		}while(userUtilityLooper.equalsIgnoreCase("y"));
		
		
		
		Customer customer=null;
		System.out.println("----Welcome to Bank-----\n");
		System.out.println("1.Create Customer\n2.Display Customer\n3.Customer Add account \n4.Transaction Bill\n5.Manage accounts\n6.Exit");
		Scanner scanner1=new Scanner(System.in);
		int userChoice=scanner1.nextInt();
		while(userChoice!=6) {
			switch(userChoice) {
			case 1:
				accountList=AccountConfigurations.createAccount(bankProductList);
				customer=AccountConfigurations.createCustomer(accountList);
				break;
			case 2:
				AccountConfigurations.displayCustomer(customer);
				break;
			case 3:
				customer=AccountConfigurations.addExistingCustomerAccounts(customer,bankProductList);
				break;
			case 4:
				AccountConfigurations.getTransactionCost(customer);
				break;
			case 5:
				customer=AccountConfigurations.accountTransactions(customer);
				break;
			default:
				System.out.println("Invalid");
				break;
			}
			System.out.println("----Welcome to Bank-----\n");
			System.out.println("1.Create Customer\n2.Display Customer\n3.Customer Add account \n4.Transaction Bill\n5.Manage accounts\n6.Exit");
			userChoice=scanner1.nextInt();
		}	
	}

}
