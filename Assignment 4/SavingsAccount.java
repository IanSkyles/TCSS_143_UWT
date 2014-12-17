/*
* 
* SavingsAccount.java
* TCSS 143 – Autumn 2014
* Assignment 4
* SubClass for bankaccount.java
*/

/**
* Please see BankAccount.java by ian skyles for more info
* @author Ian Skyles iskyles@uw.edu
* @version 10/21/2014
*/

public class SavingsAccount extends BankAccount {
   
     
   //private static final int SMALLEST_SAVINGS_ACCOUNT = 25;
   /*
    * @field myStatusIsActive - is it valid savings acccnt
    */
   private boolean myStatusIsActive;
   
       /**
       * CONSTRUCTOR savingsaccount constructs the object (and calls super)
       * @param final double intrest rate
       * @param final String name of owner                    
       * 
       */   
   public SavingsAccount(final String nameOfOwner, final double IntrestRate) {
      super(nameOfOwner, IntrestRate);
      if(super.getBalance() < 25) {
         this.myStatusIsActive = false;
      } else {
         this.myStatusIsActive = true;
      }
   }
       /**
       * processDeposit deposits funds and updates if the account is valid savings
       * @param final double amount                     
       * @return boolean true or false depending on qualifying depost(0 or more)
       */
   public boolean processDeposit(final double amount) {
      boolean flag = super.processDeposit(amount);
      if(getBalance() >= 25) {
         this.myStatusIsActive = true;
      }
      return flag;
   }
   
       /**
       * processwithdrawls request and determines if its valid
       * @param final double amount                     
       * @return boolean true or false depending on qualifying withdrawl
       */
   public boolean processWithdrawal(final double amount) {
      boolean flag = false;
      if(this.myStatusIsActive == true) {
         flag = super.processWithdrawal(amount);
         myMonthlyWithdrawCount++;
         if(myMonthlyWithdrawCount >= 5) {
            myMonthlyServiceCharges += 1;
         }
         if(super.getBalance() < 25) {
            this.myStatusIsActive = false;
         }                 
      } 
      return flag;      
   }
      /**
       * performs monthly process from bankaccount.java (super) and checks status
       *                      
       * @return void 
       */
   public void performMonthlyProcess() {
         super.performMonthlyProcess();
         if(getBalance() >= 25) {
            this.myStatusIsActive = true;
         } else {
            this.myStatusIsActive = false;
         }
   }
      /**
       * returns a string formatting savings account holder
       *                      
       * @return String - formatting savings account holder
       */
   public String toString() {      
      return "Savings Account["+super.toString() + ", myStatusIsActive: " + myStatusIsActive +"]";
   }

}