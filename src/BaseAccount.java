/**
 * An abstract class to represent a basic Bank Account
 * 
 * @author Ken Lodge, modified by Ben Formosa
 * @version 3.0 21/11/05
 */
public abstract class BaseAccount implements Comparable<BaseAccount> {
	private static int nextAcctNumber = 1;
	protected String owner;
	protected int acctNumber;
	protected double balance;

	/**
	 * Constructor, used only by subclasses, sets owner, generates unique
	 * account number and zeroes balance.
	 * 
	 * @param name
	 *            This account owner's name
	 */
	protected BaseAccount(String name) {
		owner = name;
		acctNumber = nextAcctNumber++;
		balance = 0.0;
	}

	/**
	 * Implements the Comparable interface, making accounts comparable through
	 * alphabetical ordering by owner's name.
	 */
	@Override
	public int compareTo(BaseAccount rhs) {
		// use String's compareTo if the owners are not the same
		if (!rhs.owner.equals(this.owner)) {
			return this.owner.compareTo(rhs.owner);
		}
		return Integer.compare(this.acctNumber, rhs.acctNumber);
	}

	/**
	 * Makes a deposit. Implementations will at least verify the amount is
	 * positive before making the deposit.
	 * 
	 * @param amount
	 *            the amount to deposit
	 * @return true if amount is positive otherwise false
	 */
	public abstract boolean deposit(double amount);

	/**
	 * Returns true if the given object is the same as this object Based on
	 * Eclipse automatically generated code.
	 */
	@Override
	public boolean equals(Object rhs) {
		if (this == rhs) {
			return true;
		}
		if (rhs == null) {
			return false;
		}
		if (!(rhs instanceof BaseAccount)) {
			return false;
		}
		BaseAccount other = (BaseAccount) rhs;
		if (acctNumber != other.acctNumber) {
			return false;
		}
		if (Double.compare(this.balance, other.balance) != 0) {
			return false;
		}
		if (owner == null) {
			if (other.owner != null) {
				return false;
			}
		} else if (!owner.equals(other.owner)) {
			return false;
		}
		return true;
	}

	/**
	 * String representation of this object
	 * 
	 * @return String representation of this object
	 */
	@Override
	public String toString() {
		return Double.toString(this.balance);
	}
}