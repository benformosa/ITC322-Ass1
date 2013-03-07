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
	 * Construct a ChequeAccount
	 * 
	 * @param name
	 *            The account owner's name
	 */
	public ChequeAccount(String name) {
		super(name);
		this.creditLimit = 0.0;
	}

	/**
	 * Add to the balance
	 * 
	 * @param amount
	 *            Amount to add
	 * @return true if the operation was successful
	 */
	@Override
	public boolean deposit(double amount) {
		// check for negative amount
		if (amount < 0) {
			return false;
		}

		this.balance += amount - TRANSACTION_CHARGE;
		return true;
	}

	/**
	 * Returns true if the given object is the same as this object Based on
	 * Eclipse automatically generated code.
	 */
	@Override
	public boolean equals(Object rhs) {
		if (this == rhs) {
			return true;
		}
		if (!super.equals(rhs)) {
			return false;
		}
		if (!(rhs instanceof ChequeAccount)) {
			return false;
		}
		ChequeAccount other = (ChequeAccount) rhs;
		if (Double.compare(this.balance, other.balance) != 0) {
			return false;
		}
		return true;
	}

	/**
	 * Set the credit limit on this account
	 * 
	 * @param limit
	 *            credit limit to set
	 * @return false if the given credit limit cannot be set
	 */
	@Override
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
	@Override
	public boolean withdraw(double amount) {
		// check for negative amount, available balance for charges
		if (amount < 0 || this.balance - amount < TRANSACTION_CHARGE) {
			return false;
		}

		this.balance -= amount + TRANSACTION_CHARGE;
		return true;
	}
}