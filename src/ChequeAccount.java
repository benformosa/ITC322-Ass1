/**
 * A class representing a Chequeing account
 * 
 * @author Ben Formosa
 */
public class ChequeAccount extends BaseAccount implements Withdrawable,
		CreditLimit {

	double creditLimit;
	static double TRANSACTION_CHARGE = 0.30;

	/**
	 * @param The
	 *            account owner's name
	 */
	public ChequeAccount(String owner) {
		super(owner);
		this.creditLimit = 0.0;
	}

	/**
	 * Add to the balance
	 * 
	 * @param amount
	 *            Amount to add
	 * @return true if the operation was successful
	 */
	public boolean deposit(double amount) {
		// check for negative amount
		if (amount < 0) {
			return false;
		}

		this.balance += amount - TRANSACTION_CHARGE;
		return true;
	}

	/**
	 * Set the credit limit on this account
	 * 
	 * @param credit
	 *            limit to set
	 * @return false if the given credit limit cannot be set
	 */
	public boolean setCreditLimit(double limit) {
		// check new credit limit is not negative
		if (limit < 0) {
			return false;
		}

		this.creditLimit = limit;
		return true;
	}

	/**
	 * Subtract from the balance
	 * 
	 * @param amount
	 *            Amount to subtract
	 * @return true if the operation was successful
	 */
	public boolean withdraw(double amount) {
		// check for negative amount, available balance for charges
		if (amount < 0 || this.balance - amount < TRANSACTION_CHARGE) {
			return false;
		}

		this.balance -= amount + TRANSACTION_CHARGE;
		return true;
	}
}
