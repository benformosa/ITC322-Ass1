/**
 * Subclasses of BaseAccount implementing this interface have a credit limit.
 */
public interface CreditLimit {
	public double creditLimit = 0.0;
	public boolean setCreditLimit(double limit);
}
