package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class AccountConfigurations {
	
	public static ArrayList<Account> createAccount(ArrayList<Product> bankProductList) {

		ArrayList<Account> accountList=new ArrayList<Account>();
		String accountLooper="";
		do {
			
			System.out.println("------Account Creation-----");
			Product accountProduct=null;
			System.out.println("Enter the Account number");
			Scanner scanner=new Scanner(System.in);
			String accountNumber=scanner.nextLine();
			
			System.out.println("Select the account product you prefer");
			int i=1;
			for(Product product:bankProductList) {
				System.out.println(i+"."+product.getProductName());
				i++;
			}
			scanner=new Scanner(System.in);
			int productChoice=scanner.nextInt();
			accountProduct=bankProductList.get(productChoice-1);
			scanner=new Scanner(System.in);
			double accountBalance;
			if(accountProduct instanceof SavingsMaxAccount) {
				
				SavingsMaxAccount currentSavingsMaxAccount=(SavingsMaxAccount)accountProduct;
				System.out.println("Enter the Account balance,a minimum of RS.1000 need for savings account");
				accountBalance=scanner.nextDouble();
				while(accountBalance<currentSavingsMaxAccount.getMinBal()) {
					System.out.println("Error:a minimum of RS.1000 need for savings account.Please add another "+(currentSavingsMaxAccount.getMinBal()-accountBalance));
					accountBalance+=scanner.nextDouble();
				}
				Account account=new Account(accountNumber,accountBalance,currentSavingsMaxAccount);
				accountList.add(account);
			}
			else {
				System.out.println("Enter the Account balance");
				accountBalance=scanner.nextDouble();
				Account account=new Account(accountNumber,accountBalance,accountProduct);
				accountList.add(account);
			}
	
			System.out.println("Do you want add another account?(y/n)");
			scanner=new Scanner(System.in);
			accountLooper=scanner.nextLine();

			
		}while(accountLooper.equalsIgnoreCase("y"));
		
		return accountList;
	}

	public static Customer createCustomer(ArrayList<Account> accountList) {
		ArrayList<Account> customerAccountList=new ArrayList<Account>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Customer ID");
		String customerId=scanner.nextLine();
		System.out.println("Enter the Customer Name");
		String customerName=scanner.nextLine();
		customerAccountList=accountList;
		return new Customer(customerId,customerName,customerAccountList);
		
	}

	public static void displayCustomer(Customer customer) {
		System.out.println("-----Customer Details-----");
		System.out.println("Customer Code    "+"Customer Name   "+"Account No    "+"Product Name    "+"Account balance  ");
		for(Account account:customer.getAccountList()) {
			Product product=account.getProduct();
			
			System.out.println(customer.getCustomerNo()+"   "+customer.getCustomerName()+"    "+account.getAccountNo()+"   "+product.getProductName()+"   "+account.getAccountBal());
		}
		
	}

	public static void getTransactionCost(Customer customer) {
		Scanner scanner=new Scanner(System.in);
		int userChoice;
		Product userProductChoice;
		double userServiceChoice;
		double transactionCost;
		int transactionNo;
		ArrayList<Product> productList=new ArrayList<Product>();
		ArrayList<Service> serviceList=new ArrayList<Service>();
		System.out.println("---Transaction Rate Calculater----");
		int j=1;
		for(Account account:customer.getAccountList()) {
			Product product=account.getProduct();
			System.out.println(j+"."+product.getProductName());
			productList.add(product);
			j++;
		}
		
		System.out.println("Choose the Product Account for which trasaction is to be calculated");
		userChoice=scanner.nextInt();
		userProductChoice=productList.get(userChoice-1);
		j=1;
		for(Service service:userProductChoice.getServiceList()) {
			System.out.println(j+"."+service.getServiceName());
			serviceList.add(service);
			j++;
		}
		
		System.out.println("Choose the Service for which trasaction is to be calculated");
		userChoice=scanner.nextInt();
		userServiceChoice=(serviceList.get(userChoice-1)).getServiceRate();
		
		
		System.out.println("Enter the transaction number");
		scanner=new Scanner(System.in);
		transactionNo=scanner.nextInt();
		transactionCost=transactionNo*userServiceChoice;
		System.out.println("your transaction bill for "+transactionNo+" transactions are:"+transactionCost);
		

		
		
	}

	public static Customer accountTransactions(Customer customer) {
		Customer customerpointer=null;
		Scanner scanner=new Scanner(System.in);
		String transactionLooper="";
		do {
			
			int i=1;
			System.out.println("-----Account Select------\n Choose your account");
			for(Account account:customer.getAccountList())
			{
				Product accountProduct=account.getProduct();
				System.out.println(i+"."+accountProduct.getProductName());
				i++;
			}
			scanner=new Scanner(System.in);
			int accountChoice=scanner.nextInt();
		
			customerpointer=accountTransactionType(accountChoice,customer);

			System.out.println("Do you want to do another transaction?(y/n)");
			scanner=new Scanner(System.in);
			transactionLooper=scanner.nextLine();
		}while(transactionLooper.equalsIgnoreCase("y"));
		return customerpointer;
	}

	private static Customer accountTransactionType(int accountChoice, Customer customer) {
		Customer customerpointer=null;
		System.out.println(((customer.getAccountList()).get(accountChoice-1)).getProduct().getProductName()+" seletced");
		System.out.println("Choose the type of transaction\n1.Deposit 2.Withdraw 3.Account Balance");
		Scanner scanner=new Scanner(System.in);
		int transactionChoice=scanner.nextInt();
		
		if(transactionChoice==1) {
			customerpointer=transactionDeposit(customer,accountChoice);
		}
		else if(transactionChoice==2){
			customerpointer=transactionWithdraw(customer,accountChoice);
		}
		else if(transactionChoice==3) {
			System.out.println("---Balance for "+customer.getAccountList().get(accountChoice-1).getProduct().getProductName()+" : "+customer.getAccountList().get(accountChoice-1).getAccountBal());
		}
		return customerpointer;
	}

	private static Customer transactionWithdraw(Customer customer, int accountChoice) {
		Account account=customer.getAccountList().get(accountChoice-1);
		double accountBal=customer.getAccountList().get(accountChoice-1).getAccountBal();
		Product accountProduct=(customer.getAccountList()).get(accountChoice-1).getProduct();
		
		Scanner scanner=new Scanner(System.in);
		double withdrawCash;
		if(accountProduct instanceof SavingsMaxAccount) {
			SavingsMaxAccount savingsMaxAccount=(SavingsMaxAccount)accountProduct;
			System.out.println("Enter the amount to withdraw");
			withdrawCash=scanner.nextDouble();
			while(accountBal-withdrawCash<savingsMaxAccount.getMinBal()) {
				System.out.println("Insufficient Amount,Minimum Balance of 1000 need to be maintained please retry");
				withdrawCash=scanner.nextDouble();
			}
		}
		else {
			System.out.println("Enter the amount to withdraw");
			withdrawCash=scanner.nextDouble();
		}
		while(accountBal-withdrawCash<0) {
			System.out.println("Insufficient balance:"+accountBal+"\n try again");
			System.out.println("Enter the amount to withdraw");
			withdrawCash=scanner.nextDouble();
		}
		account.setAccountBal(accountBal-withdrawCash);
		
		return customer;
	}

	private static Customer transactionDeposit(Customer customer, int accountChoice) {
		Account account=customer.getAccountList().get(accountChoice-1);
		double accountBal=customer.getAccountList().get(accountChoice-1).getAccountBal();
		
		Product accountProduct=(customer.getAccountList()).get(accountChoice-1).getProduct();
		Scanner scanner=new Scanner(System.in);
		double depositCash;
		if(accountProduct instanceof LoanAccount) {
			LoanAccount loanAccount=(LoanAccount)accountProduct;
			System.out.println("Choose the service type of deposit");
			int i=1;
			for(Service service:accountProduct.getServiceList()) {
				System.out.println(i+"."+service.getServiceName());
				i++;
			}
			
			int typeOfService=scanner.nextInt();
			Service service=accountProduct.getServiceList().get(typeOfService-1);
			if(service.getServiceName().equalsIgnoreCase("Cheque Deposit")) {
				System.out.println("Enter the deposit amount,a charge of 0.03% from the deposit amount will be deducted");
				depositCash=scanner.nextDouble();
				depositCash-=(depositCash*loanAccount.getChequeDepositRate());
				System.out.println("Deposit amount after service charge deduction:"+depositCash);
			}
			else {
				System.out.println("Enter the deposit amount");
				depositCash=scanner.nextDouble();
				
			}
		}else {
			
			System.out.println("Enter the deposit amount");
			depositCash=scanner.nextDouble();
		}
		account.setAccountBal(accountBal+depositCash);
		return customer;
	}

	public static Customer addExistingCustomerAccounts(Customer customer, ArrayList<Product> bankProductList) {
		if(customer==null) {
			System.out.println("No such existing customer,Go back to main menu and create Customer");
		}
		else{
			System.out.println("Enter the customer id");
			Scanner scanner=new Scanner(System.in);
			String customerId=scanner.nextLine();
			
			if(customer.getCustomerNo().equalsIgnoreCase(customerId)) {
				System.out.println("-------Customer Account products-------");
				for(Account account:customer.getAccountList()) {
					Product product=account.getProduct();
					int i=1;
					System.out.println(i+"."+product.getProductName());
				}
				
				System.out.println("Add another Account products");
				ArrayList<Account> customerAccountList=createAccount(bankProductList);
				for(Account account:customerAccountList) {
					customer.getAccountList().add(account);
				}

				
			}
			else {
				System.out.println("Customer ID wrong");
			}
			
			return customer;
		}
		return null;
	}


}


