import java.util.Date;

public class TesterMarceloMariduena {
  public static void main(String[] args){
	  
	  // Grizzly checking account created for testing
	  CheckingAccount grizzlyCheckings = new CheckingAccount("Grizly Bank", "83-BC8273-1934", "Grizzly Checking", 10000.5, 0.05, 1000);
	  
	  // Grizzly savings account created for testing
	  SavingsAccount grizzlySavings = new SavingsAccount("Grizly Bank", "83-BC8273-1935", "Grizzly Savings", 10000.5, 0.05);
	  
	  // Get Grizzly Bank details
	  grizzlyCheckings.displayDetails();
	  
	  // Checks to deposit
	  Check check1 = new Check(100, 262141335, new java.util.Date(System.currentTimeMillis()), 2000.2, "Atlanta Georgia Bank");
	  Check check2 = new Check(230, 265441395, new java.util.Date(System.currentTimeMillis()), 2000.2, "Fidelity Bank");
	  Check check3 = new Check(1090, 282111394, new java.util.Date(System.currentTimeMillis()), 2000.2, "American National Bank");
	  
	  // Checks to clear
	  Check check4 = new Check(64.14, new java.util.Date(System.currentTimeMillis()));
	  Check check5 = new Check(82.17, new java.util.Date(System.currentTimeMillis()));
	  Check check6 = new Check(43.79, new java.util.Date(System.currentTimeMillis()));
	  Check check7 = new Check(91.36, new java.util.Date(System.currentTimeMillis()));
	  
	  // Check deposits
	  grizzlyCheckings.depositCheck(check1);
	  grizzlyCheckings.depositCheck(check2);
	  grizzlyCheckings.depositCheck(check3);
	  
	  // Checks cleared
	  grizzlyCheckings.clearCheck(check4);
	  grizzlyCheckings.clearCheck(check5);
	  grizzlyCheckings.clearCheck(check6);
	  grizzlyCheckings.clearCheck(check7);
	  
	  grizzlyCheckings.displayAllChecks();
	  
	  grizzlyCheckings.withdraw(100, grizzlySavings);
	  System.out.printf("Current balance: %.2f \n" , grizzlyCheckings.getBalance());
	  grizzlyCheckings.withdraw(2500, grizzlySavings);
	  System.out.printf("Current balance: %.2f \n" , grizzlyCheckings.getBalance());
	  grizzlyCheckings.withdraw(1000000, grizzlySavings);
  }
}
