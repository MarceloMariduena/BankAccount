import java.util.*;

public class Account {
	
	// Variables
	protected String actNumber, actName, bankName;
	protected double balance, annualInterestRate;
	Date creationDate = new Date();
  
	// Default constructor
	public Account(){
		bankName = "";
	    actNumber = "";
	    actName = "";
	    balance = 0;
	    annualInterestRate = 1;
	}
  
	// Constructor with arguments 
	public Account(String bankName_, String actNumber_, String actName_, double balance_, double annualInterestRate_){
	    bankName = bankName_;
	    actNumber = actNumber_;
	    actName = actName_;
	    balance = balance_;
	    annualInterestRate = annualInterestRate_;
	}
  
	/****** GETTERS ******/
	// Returns bank anme
	public String getBankName() {return bankName;}
	
	// Returns creation date
	public Date getCreationDate(){return creationDate;}
	
	// Returns balance
	public double getBalance() {return balance;}
	
	// Returns annual interest rate
	public double getInterestRate() {return annualInterestRate;}
	
	// Returns account name
	public String getAccountName() {return actName;}
	
	// Displays account details
	public void displayDetails() {
		System.out.println("Bank name: " + bankName);
		System.out.println("Account number: " + actNumber);
		System.out.println("Account name: " + actName);
		System.out.println("Balance: " + balance);
		System.out.println("Annual interest rate: " + annualInterestRate);
		System.out.println();
	}
	
	/****** SETTERS ******/
	// Sets bank name
	public void setBankName(String name) {
		bankName = name;
	}
	
	// Sets the interest rate
	public void setInterest(double rate){
	    annualInterestRate = rate;
	}
	
	// Deposits amount
	public void deposit(double amt){
	    balance += amt;
	}
  
	// Withdraws amount
	public void withdraw(double amt){
	    balance -= amt;
	}
	
	// Applies interest rate
	public void applyInterest(){
		balance *= annualInterestRate;
	}
  
}
