import java.util.Arrays;

/**
 * Class to test the BaseAccount class and subclasses
 */
public class TestAccountsInterfaces {
    public static void main(String[] args) {
        BaseAccount[] list = new BaseAccount[5];

        list[0] = new SavingsAccount("Fred");
        list[1] = new ChequeAccount("Jim");
        list[2] = new ChequeAccount("Sue");
        list[3] = new SavingsAccount("Jim");
        list[4] = new SavingsAccount("Jill");

        int i;
		
		//print the account owners and balances
		for (i = 0; i < 5; i++) {
            System.out.println(list[i].owner + " " + list[i]);
		}

        // In the following loops do NOT use your knowledge
        // of which member of list[] is of which type
		
        for (i = 0; i < 5; i++) {
            /* Insert code setting 50.0 credit limits */		
			
			//check if the account implements CreditLimit
			if (list[i] instanceof CreditLimit) {
				//cast to CreditLimit
				((CreditLimit) list[i]).setCreditLimit(50.0);
			}
		}

        for (i = 0; i < 5; i++) {
            /* Insert code depositing 20.0 in each account */
			//all subclasses of BaseAccount must implement deposit
            list[i].deposit(20.0);
        }

        for (i = 0; i < 5; i++) {
            /* Insert code withdrawing 25.0 from each account */
			if (list[i] instanceof Withdrawable) {
				((Withdrawable) list[i]).withdraw(25.0);
			}
        }

        for (i = 0; i < 5; i++) {
            /* Insert code adding 8.0% interest as applicable */
			if (list[i] instanceof Interest) {
				((Interest) list[i]).addInterest(8.0);
			}
        }

		System.out.println("\nSorted:"); 
        /* Insert code to sort the accounts by owner's name */
		
		//Arrays.sort uses the natural order of the array, as defined by compareTo
		Arrays.sort(list);
        for (i = 0; i < 5; i++) {
            System.out.println(list[i].owner + " " + list[i]);
		}
	}
}
