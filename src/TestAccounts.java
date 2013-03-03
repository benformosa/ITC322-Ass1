import java.util.Arrays;

/**
 * Class to test the BaseAccount class and subclasses
 */
public class TestAccounts {
	public static void main(String[] args) {
		BaseAccount[] list = new BaseAccount[5];

		list[0] = new SavingsAccount("Fred");
		list[1] = new ChequeAccount("Jim");
		list[2] = new ChequeAccount("Sue");
		list[3] = new SavingsAccount("Jim");
		list[4] = new SavingsAccount("Jill");

		int i;

		// print the account owners and balances
		System.out.println("Owner\tAcctnum\tBalance\tClass");
		for (i = 0; i < 5; i++) {
			System.out.println(list[i].owner + "\t" + list[i].acctNumber + "\t" + list[i] + "\t" + list[i].getClass().getName());
		}
		System.out.println();

		// In the following loops do NOT use your knowledge
		// of which member of list[] is of which type

		for (i = 0; i < 5; i++) {
			// check if the account implements CreditLimit
			if (list[i] instanceof CreditLimit) {
				// cast to CreditLimit
				((CreditLimit) list[i]).setCreditLimit(50.0);
//				System.out.println("set credit limit of 50.0 on acctnumber " + list[i].acctNumber);
			}
		}

		for (i = 0; i < 5; i++) {
			/* Insert code depositing 20.0 in each account */
			// all subclasses of BaseAccount must implement deposit
			System.out.println();
			System.out.println(list[i]);
			System.out.println("deposit 20.0 to acctnumber " + list[i].acctNumber);
			System.out.println(list[i].deposit(20.0));
			System.out.println(list[i]);
		}

		for (i = 0; i < 5; i++) {
			/* Insert code withdrawing 25.0 from each account */
			if (list[i] instanceof Withdrawable) {
				System.out.println();
				System.out.println(list[i]);
				System.out.println("withdraw 25.0 from acctnumber " + list[i].acctNumber);
				System.out.println(((Withdrawable) list[i]).withdraw(25.0));
				System.out.println(list[i]);
			}
		}

		for (i = 0; i < 5; i++) {
			/* Insert code adding 8.0% interest as applicable */
			if (list[i] instanceof Interest) {
				System.out.println();
				System.out.println(list[i]);
				System.out.println("add 8% interest to acctnumber " + list[i].acctNumber);
				((Interest) list[i]).addInterest(8.0);
				System.out.println(list[i]);
			}
		}

		System.out.println("\nSorted:");
		// Arrays.sort uses the natural order of the array, as defined by
		// compareTo
		Arrays.sort(list);
		for (i = 0; i < 5; i++) {
			System.out.println(list[i].owner + "\t" + list[i].acctNumber + "\t" + list[i] + "\t" + list[i].getClass().getName());
		}
		
		System.out.println("###");
		ChequeAccount sue = new ChequeAccount("Sue");
		sue.deposit(20.0);
		sue.acctNumber = 3;
		System.out.println(sue.owner + "\t" + sue.acctNumber + "\t" + sue + "\t" + sue.getClass().getName());
		System.out.println(list[2].equals(sue));
		sue.withdraw(10.0);
		System.out.println(list[2].equals(sue));
	}
}
