/**
 * A class representing a Savings account
 * @author Ben Formosa
 */
public class SavingsAccount extends BaseAccount implements Withdrawable, Interest {
	
	public SavingsAccount(String owner) {
		super(owner);
	}

	/**
	 * Add to the balance
	 * @param amount Amount to add
	 * @return true if the operation was successful
	 */
	public boolean deposit(double amount) {
		//check for negative amount
		if(amount < 0) {
			return false;
		}
		
		this.balance += amount;
		return true;
	}

	/**
	 * Subtract from the balance
	 * @param amount Amount to subtract
	 * @return true if the operation was successful 
	 */
	public boolean withdraw(double amount) {
		//check for negative amount, amount greater than balance
		if(amount < 0 || amount > this.balance) {
			return false;
		}
		
		this.balance -= amount; 
		return true;
	}
	
	/**
	 * Add interest to the balance
	 * @param rate The interest rate to use
	 * @return true if the operation was successful
	 */
	public boolean addInterest(double rate) {
		//check for negative interest rate
		if(rate < 0) {
			return false;
		}
		
		this.balance = (this.balance * rate) / 100;
		return true;
	}
}