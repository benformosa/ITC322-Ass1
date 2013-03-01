/**
 * An abstract class to represent a basic Bank Account
 * @author Ken Lodge, modified by Ben Formosa
 * @version 3.0 21/11/05
 */
public abstract class BaseAccount implements Comparable<BaseAccount> {
    private static int nextAcctNumber = 1;
    protected String owner;
    protected int acctNumber;
    protected double balance;

    /**
     * Constructor, used only by subclasses, sets owner,
     * generates unique account number and zeroes balance.
     * @param name owner's name
     */
    protected BaseAccount(String name) {
        owner = name;
        acctNumber = nextAcctNumber++;
        balance = 0.0;
    }

    /**
     * Makes a deposit. Implementations will at least verify
     * the amount is positive before making the deposit.
	 *
     * @param amount the amount to deposit
     * @return true if amount is positive otherwise false
     */
    public abstract boolean deposit(double amount);

    /**
     * Implements the Comparable interface, making accounts
     * comparable through alphabetical ordering by owner's name.
     */
    public int compareTo(BaseAccount rhs) {
    	//use String's compareTos
    	return this.owner.compareTo(rhs.owner); 
    }

    /**
     * Override equals to be consistent with compareTo
     */
    public boolean equals(Object rhs) {
    	//equal if it is the same reference
    	if(this == rhs) {
    		return true;
    	}
    	
    	//not equal if it is not a BaseAccount
    	if(!(rhs instanceof BaseAccount)) {
    		return false;
    	}
    	
    	//we can now safely cast to BaseAccount
    	BaseAccount BArhs = (BaseAccount)rhs;
    	
    	//compare all attributes
    	return BArhs.owner.equals(this.owner) &&
    		BArhs.balance == this.balance &&
    		BArhs.acctNumber == this.acctNumber;
    }

    /**
	 * String representation of this object
     * @return String representation of this object
     */
    public String toString() {
    	return Double.toString(this.balance);
    } 
}