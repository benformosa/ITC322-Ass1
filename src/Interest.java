/**
 * Subclasses of BaseAccount implementing this interface are able to add
 * interest at a calculated rate.
 */
public interface Interest {
	public boolean addInterest(double rate);
}
