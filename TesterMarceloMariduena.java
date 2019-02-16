import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesterMarceloMariduena {
  public static void main(String[] args){
	  
	  Scanner input = new Scanner(System.in);
	 
	  
	  // Prompt user for input
	  System.out.println("Enter bank name: ");
	  String bankName_ = input.nextLine();
	  
	  System.out.println("Enter account number, account name (no spaces), initial balance, annual interest rate (in decimals) and overdraft limit. ");
	  String accountNumber_ = input.next();
	  String accountName_ = input.next();
	  double initialBalance_ = input.nextDouble();
	  double annualInterestRate_ = input.nextDouble();
	  double overdraftLimit_ = input.nextDouble();
	  
	  CheckingAccount GrizzlyCheckings = new CheckingAccount(bankName_, accountNumber_, accountName_, initialBalance_, annualInterestRate_, overdraftLimit_);
	  
	  System.out.println(); // spacing
	  
	  // Time to deposit some checks :)
	  System.out.println("====== Checks To Deposit ======");
	  System.out.println("Enter check number, routing number, amount, date (mm/dd/yyy) and bank name.");
	  System.out.println("Enter 0 (zero) to finish");
	  
	  while (true) {
		  int num = input.nextInt(); //number
		  if (num == 0) {
			  break;
		  }
		  int routingNumber = input.nextInt(); //routing number
		  double amount = input.nextDouble(); //amount
		  String dateString = input.next(); //date: covert this
		  String bankName = input.nextLine(); //bank name
		  
		  Date tempDate = new Date(); //date object in case invalid date is the input
		  try {
			  //Convert the input date string to a Date object
			  tempDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
		  } catch (ParseException e) {
			  e.printStackTrace();
		  }
		  
		  Check tempCheck = new Check(num, routingNumber, tempDate, amount, bankName);
		  GrizzlyCheckings.depositCheck(tempCheck);
	  }
	  
	  System.out.println(); // spacing
	  
	  // Clearing checks
	  System.out.println("====== Checks To Clear ======");
	  System.out.println("Enter check number, amount, date (mm/dd/yyy).");
	  System.out.println("Enter 0 (zero) to finish");
		  
	  while (true) {
		  int num = input.nextInt(); //number
		  if (num == 0) {
			  break;
		  }
		  double amount = input.nextDouble(); //amount
		  String dateString = input.next(); //date: covert this
		  
		  Date tempDate = new Date(); //date object in case invalid date is the input
		  try {
			  //Convert the input date string to a Date object
			  tempDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
		  } catch (ParseException e) {
			  e.printStackTrace();
		  }
		  
		  Check tempCheck = new Check(num, amount, tempDate);
		  GrizzlyCheckings.clearCheck(tempCheck);
	  }
	  System.out.println(); // spacing
	  
	  GrizzlyCheckings.displayAllChecks();
	  

	  System.out.printf("Current balance: $%.02f", GrizzlyCheckings.getBalance());
	  
	  input.close();
  }
}
