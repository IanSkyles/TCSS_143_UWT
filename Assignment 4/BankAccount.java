/*
* 
* BankAccount.java
* TCSS 143 – Autumn 2014
* Assignment 4
* Super class that implements named account and supers savingsaccount
*/

/**
* This class in combination with driver program: AccountTester.java
*               and sub class SavingsAccount.java
*              and interface NamedAccount.java
*               and SafeDepositBox (which implements the interface)
*               will keep track of bank/savings/deposit box account information
* @author Ian Skyles iskyles@uw.edu
* @version 10/21/2014
*/

public class BankAccount implements NamedAccount {
   
   /*
    * @field String customers_name - stores it
    */
   private String customers_name;
   /*
    * @field double account_balance - stores accnt funds
    */
   private double account_balance;
   /*
    * @field double intrestRate - stores intrest rate
    */
   private double intrestRate;
   
   /*
    * @protected int myMonthlyWithdrawCount - makes avaliable to subclasses
    */
   protected int myMonthlyWithdrawCount;
   /*
    * @protected int myMonthlyServiceCharges - makes avaliable to subclasses
    */
   protected double myMonthlyServiceCharges;
   
    /**
       * CONSTRUCTOR BankAccount constructs the object
       * @param final double intrest rate
       * @param final String name of owner                    
       * 
       */   
   public BankAccount(final String nameOfOwner, final double IntrestRate) {
      this.customers_name = nameOfOwner;
      if(IntrestRate >= 0) {
         this.intrestRate = IntrestRate;
      } else {
         this.intrestRate = 0.00;
      }
      this.account_balance = 0;
      this.myMonthlyWithdrawCount = 0;
      this.myMonthlyServiceCharges = 0;
   }
      /**
       * getBalance returns account balance
       *                 
       * @return double getBalance returns balance of account
       */  
   public double getBalance() {
      return this.account_balance;
   }
       /**
       * processDeposit if deposit is valid
       * @param final double amount - amount to be depositied                
       * @return boolean flag if valid deposit
       */  
   public boolean processDeposit(final double amount) {
      boolean flag = false;
      if(amount > 0) {
         flag = true;
         this.account_balance += amount;
      }
      return flag;
   }
      /**
       * processWithdrawal if withdrawl is valid
       * @param final double amount - amount to be withdrawled                
       * @return boolean flag if valid withdrawl
       */ 
   public boolean processWithdrawal(final double amount) {
      boolean flag = false;
      if((amount < 0) || (amount > account_balance)) {
         flag = false;
      }
      else {
         flag = true;
         this.account_balance -= amount;
         myMonthlyWithdrawCount++;
      }
      return flag;
   }
   
      /**
       * calculateInterest - determines intrest rate per month
       *                 
       * @return double - intrest rate / 12 (12 months)
       */ 
   public double calculateInterest() {
      return this.intrestRate / 12.0;
   }
     /**
       * performMonthlyProcess - checks service count/charges updates account 
       *                         basedd on intrest/service charges
       *                 
       * @return void 
       */ 
   public void performMonthlyProcess() {
      this.account_balance -= this.myMonthlyServiceCharges;
      this.account_balance += calculateInterest();
      this.myMonthlyWithdrawCount = 0;
      this.myMonthlyServiceCharges = 0;
      //monthly balance should not be less then 
   }
      /**
       * getAccountHolderName - gets account holders name (getter)
       *                 
       * @return String --- customers name 
       */ 
   public String getAccountHolderName() {
      return customers_name;
   }
   
      /**
       * setAccountHolderName - assigns new name to account
       *                 
       * @return void 
       */ 
   public void setAccountHolderName(final String newName){
      this.customers_name = newName;
   }
      /**
       * returns a string formatting bank account holder and info
       *                      
       * @return String - formatting bank account holder and info
       */
   public String toString() {
      return "Bank Account[owner: " + customers_name + ", balance: "
                       + account_balance + ", intrest rate: " + intrestRate
                       + ", number of withdrawls this month: " + myMonthlyWithdrawCount
                       + ", service charges for this month: " + myMonthlyServiceCharges
                       + "]";
   }
}
