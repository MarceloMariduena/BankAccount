import java.util.*;

public class CheckingAccount extends Account{
	
	// Variables
	private double overdraftLimit;
	final double DEFAULT_OVERDRAFT_LIMIT = 100;
	
	ArrayList<Check> checksDeposited = new ArrayList<Check>();
	ArrayList<Check> checksCleared = new ArrayList<Check>();
  
	// Default constructor 
	public CheckingAccount(){
		super();
		overdraftLimit = DEFAULT_OVERDRAFT_LIMIT;
	}
	
	// Constructor with arguments
	public CheckingAccount(String bankName_, String actNumber_, String actName_, double blanace_, double annualInterestRate_, double overdraftLimit_){
		super(bankName_, actNumber_, actName_, blanace_, annualInterestRate_);
		
		if (overdraftLimit_ > 0) {
			overdraftLimit = overdraftLimit_;
		}
		else {
			overdraftLimit = DEFAULT_OVERDRAFT_LIMIT;
		}
	}


	@Override
	public void withdraw(double amt){
		if (amt <= balance + overdraftLimit){
			balance -= amt;
		}
		else {
			System.out.println("Insufficient funds!");
		}
	}
  
	public void withdraw(double amt, SavingsAccount s){
		// If the funds are available in the checking account ...
		if (amt <= balance){
			balance -= amt;
			System.out.println("Wtihdrew only from checkings.");
		}
		// If the funds are available in the checking with the savings ...
		else if ((amt > balance) && !(amt > balance + s.getBalance())){
			double tempVar = amt - balance;
			balance = 0;
			s.withdraw(tempVar); //Withdraws from savings
			System.out.println("Withdraw from savings was necessary.");
		}
		// If the funds are available in the checking with the savings + 100 ...
		else if ((amt < balance + s.balance + overdraftLimit)) {
			double tempVar = amt - s.getBalance();
			s.withdraw(s.getBalance()); // withdraw all money from savings
			balance -= tempVar;
			System.out.println("All was withdrawn from savings and checkings. Approaching overdraft limit.");
		}
		else {
			System.out.println("Overdraft proection. Cannot withdraw this amount.");
		}
	}
  
	public void depositCheck(Check newCheck){
		balance += newCheck.getAmount();
		checksDeposited.add(newCheck);	
	}
  
	public void clearCheck(Check newCheck){
		withdraw(newCheck.getAmount());
		checksCleared.add(newCheck);
	}
  
	public void displayAllChecks(){
		System.out.println("======== Transaction History ========");
		System.out.println("----------- Summar for " + this.getAccountName() + " -----------");
		System.out.println("======= Checks Deposited ======= ");
		System.out.println("Number \tDate \t\tAmount \t\t Bank Name \tBank Routing Number");
		double sumOfChecksDeposited = 0;
		for (int i = 0; i < checksDeposited.size(); i++) {
			System.out.println(checksDeposited.get(i).getNumber() + "\t" + checksDeposited.get(i).getDate() + "\t" + checksDeposited.get(i).getAmount() + "\t\t" + checksDeposited.get(i).getBankName() + "\t" + checksDeposited.get(i).getRoutingNumber());
			sumOfChecksDeposited += checksDeposited.get(i).getAmount();
		}
		System.out.println("Total deposited: $" + sumOfChecksDeposited);
		
		System.out.println(); // spacing
		
		System.out.println("======= Checks cleared ======= ");
		System.out.println("Number \tDate \tAmount");
		double sumOfChecksCleared = 0;
		for (int i = 0; i < checksCleared.size(); i++) {
			System.out.println(checksCleared.get(i).getNumber() + "\t" + checksCleared.get(i).getDate() + "\t" + checksCleared.get(i).getAmount());
			sumOfChecksCleared += checksCleared.get(i).getAmount();
		}
		System.out.println("Total cleared: $" + sumOfChecksCleared);
		
		System.out.println(); // spacing
	}
	
}
