/*
	AccountTester.java
*/

/**
	Provides tests for the classes in Assignment 2.
	
	@author Alan Fowler (acfowler@u.washington.edu)
	@version autumn 2009
*/
public class AccountTester {

	/**
		Starts the tests.
	*/
	public static void main(String[] args) {
	
		boolean allNumericalTestsPassed = true;
	
		/* 
			Add additional tests if you wish; however, there is no requirement for
		   this unless you are doing the extra credit.
		   Be careful what you change here since later tests depend on earlier results.
		*/ 
		
		System.out.println("Testing methods of class BankAccount");
		
		//construct a BankAccount object
		System.out.println("Creating a bank account for John Doe at 5.00%");
		BankAccount testAcct1 = new BankAccount("John Doe", 0.05);
		System.out.println(testAcct1);
		
		//construct a BankAccount object using a negative interest rate
		System.out.println("Creating a bank account for Sam Smith at -5.00%");
		BankAccount testAcct2 = new BankAccount("Sam Smith", -0.05);
		System.out.println(testAcct2);
		
		//test getAccountHolderName() and setAccountHolderName()
		System.out.println("testAcct1 owner: " + testAcct1.getAccountHolderName());
		System.out.println("Changing the owner name to Jane Doe:");
		testAcct1.setAccountHolderName("Jane Doe");
		System.out.println(testAcct1);
		System.out.println();
		
		//test getBalance() and processDeposit()
		if (Math.abs(testAcct1.getBalance()) >= .005) {
			System.out.println("getBalance() failed!");
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;
		}
		testAcct1.processDeposit(123.45);
		if (Math.abs(testAcct1.getBalance() - 123.45) >= .005) {
			System.out.println("processDeposit() failed on a valid test!");
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;
		}
		testAcct1.processDeposit(-123.45); //try a negative value
		if (Math.abs(testAcct1.getBalance() - 123.45) >= .005) {
			System.out.println("processDeposit() failed on a negative value!");
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;
		}
		
		//test processWithdrawl()
		testAcct1.processWithdrawal(100.00);
		if (Math.abs(testAcct1.getBalance() - 23.45) >= .005
				|| testAcct1.myMonthlyWithdrawCount != 1) {
				
			System.out.println("processWithdrawl() failed on a valid test!");
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;
		}
		testAcct1.processWithdrawal(-10.00); // try a negative value
		if (Math.abs(testAcct1.getBalance() - 23.45) >= .005
				|| testAcct1.myMonthlyWithdrawCount != 1) {
				
			System.out.println("processWithdrawl() failed on a negative value!");
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;
		}
		testAcct1.processWithdrawal(100.00); // try a value that is larger than the balance
		if (Math.abs(testAcct1.getBalance() - 23.45) >= .005
				|| testAcct1.myMonthlyWithdrawCount != 1) {
				
			System.out.println("processWithdrawl() failed on a value larger than the balance!");
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;
		}
		
		//test calculateInterest()
		if (Math.abs(testAcct1.calculateInterest() - .1) >= .005) {
			System.out.println("calculateInterest() failed!");
			System.out.println("Interest calculated: " + testAcct1.calculateInterest());
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;
		}
		
		//test performMonthlyProcess()
		testAcct1.performMonthlyProcess();
		if (Math.abs(testAcct1.getBalance() - 23.55) >= .005
				|| testAcct1.myMonthlyWithdrawCount != 0
				|| testAcct1.myMonthlyServiceCharges >= .005) {

			System.out.println("performMonthlyProcess() failed!");
			System.out.println(testAcct1);
			allNumericalTestsPassed = false;		
		}
		
		
		if (allNumericalTestsPassed) {
			System.out.println("All numerical tests passed!\n");
		}
		
		
		System.out.println("Testing methods of class SavingsAccount\n");
		
		//construct a SavingsAccount object
		System.out.println("Creating a savings account for Dan Doe at 5.00%");
		SavingsAccount testAcct3 = new SavingsAccount("Dan Doe", 0.05);
		System.out.println(testAcct3);
		
		//test processDeposit()
		System.out.println("Depositing 100.00 . . .");
		System.out.println("Now status should be active.");
		testAcct3.processDeposit(100.00);
		System.out.println(testAcct3);
		
		//test processWithdrawl()
		System.out.println("Withdrawinging 15.00 . . .");
		System.out.println("Status should be active.");
		System.out.println("Number of withdrawls should be 1");
		testAcct3.processWithdrawal(15.00);
		System.out.println(testAcct3);
		System.out.println("Withdrawing 15.00 6 more times . . . ");
		System.out.println("Balance should be 10.00");
		System.out.println("Status should not be active.");
		System.out.println("Number of withdrawls should be 6");
		System.out.println("Service charge should be 2.00");
		for (int i = 1; i <= 6; i++) {
			testAcct3.processWithdrawal(15.00);
		}
		System.out.println(testAcct3);
		
		//test performMonthlyProcess
		System.out.println("performing monthly process  . . .");
		testAcct3.performMonthlyProcess();
		System.out.println("Balance should be 8.03");
		System.out.println("Status should not be active.");
		System.out.println("Number of withdrawls should be 0");
		System.out.println("Service charge should be 0.00");
		System.out.println(testAcct3);
		

		System.out.println("\nTesting methods of class BankAccount");
		
		//construct a SafeDepositBoxAccount object
		System.out.println("\nCreating a safe seposit box account for John Doe");
		SafeDepositBoxAccount testAcct4 = new SafeDepositBoxAccount("John Doe");
		System.out.println(testAcct4);
		
		//test setAccountHolderName()
		System.out.println("Changing the owner name to Jane Doe:");
		testAcct4.setAccountHolderName("Jane Doe");
		System.out.println(testAcct4);
		
	}

} // end class AccountTester

/*
	Your output from the tests above should be very similar to:
	
	Testing methods of class BankAccount
	Creating a bank account for John Doe at 5.00%
	BankAccount[owner: John Doe, balance: 0.00, interest rate: 0.05,
		number of withdrawls this month: 0, service charges for this month: 0.0]
	Creating a bank account for Sam Smith at -5.00%
	BankAccount[owner: Sam Smith, balance: 0.00, interest rate: 0.00,
		number of withdrawls this month: 0, service charges for this month: 0.0]
	testAcct1 owner: John Doe
	Changing the owner name to Jane Doe:
	BankAccount[owner: Jane Doe, balance: 0.00, interest rate: 0.05,
		number of withdrawls this month: 0, service charges for this month: 0.0]

	All numerical tests passed!

	Testing methods of class SavingsAccount

	Creating a savings account for Dan Doe at 5.00%
	SavingsAccount[owner: Dan Doe, balance: 0.00, interest rate: 0.05,
		number of withdrawls this month: 0, service charges for this month: 0.0, myStatusIsActive: false]
	Depositing 100.00 . . .
	Now status should be active.
	SavingsAccount[owner: Dan Doe, balance: 100.00, interest rate: 0.05,
		number of withdrawls this month: 0, service charges for this month: 0.0, myStatusIsActive: true]
	Withdrawinging 15.00 . . .
	Status should be active.
	Number of withdrawls should be 1
	SavingsAccount[owner: Dan Doe, balance: 85.00, interest rate: 0.05,
		number of withdrawls this month: 1, service charges for this month: 0.0, myStatusIsActive: true]
	Withdrawing 15.00 6 more times . . . 
	Balance should be 10.00
	Status should not be active.
	Number of withdrawls should be 6
	Service charge should be 2.00
	SavingsAccount[owner: Dan Doe, balance: 10.00, interest rate: 0.05,
		number of withdrawls this month: 6, service charges for this month: 2.0, myStatusIsActive: false]
	performing monthly process  . . .
	Balance should be 8.03
	Status should not be active.
	Number of withdrawls should be 0
	Service charge should be 0.00
	SavingsAccount[owner: Dan Doe, balance: 8.03, interest rate: 0.05,
		number of withdrawls this month: 0, service charges for this month: 0.0, myStatusIsActive: false]

	Testing methods of class BankAccount

	Creating a safe seposit box account for John Doe
	SafeDepositBoxAccount[owner: John Doe]
	Changing the owner name to Jane Doe:
	SafeDepositBoxAccount[owner: Jane Doe]
*/