/**
 * Subclasses of BaseAccount implementing this interface are able to be withdrawn from.
 */
public interface Withdrawable {
	public boolean withdraw(double amount);
}
