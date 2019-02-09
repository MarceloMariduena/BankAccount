public class SavingsAccount extends Account{
  
	// Default constructor inherits parent's constructor
	public SavingsAccount() {
		super();
	}
  
	// Constructor with arguments inheriting parent's constructor with its arguments
	public SavingsAccount(String bankName_, String actNumber_, String actName_, double balance_, double annualInterestRate_){
		super(bankName_, actNumber_, actName_, balance_, annualInterestRate_);
	}
  
	// Any amount can be withdrawn from Account but Saving balance must remain at least 0
	@Override
	public void withdraw(double amt){
		if (this.balance - amt >= 0){
			this.balance -= amt;
		}
		else {
			System.out.println("Overdraft protection from savings.");
		}
	}
}