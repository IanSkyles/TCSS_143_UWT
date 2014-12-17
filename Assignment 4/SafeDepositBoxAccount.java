/*
* 
* SafeDepositBoxAccount.java
* TCSS 143 – Autumn 2014
* Assignment 4
* Class that implements named account
*
*/


/**
* Please see BankAccount.java by ian skyles for more info
* @author Ian Skyles iskyles@uw.edu
* @version 10/21/2014
*/
public class SafeDepositBoxAccount implements NamedAccount {

   /*
    * @field a private string field
    */ 
   private String safe_deposit_name;
   
          /**
          * Constructor
          *   
          * @param nameOfHolder used as input to change field        
          * no return
          */

   public SafeDepositBoxAccount(final String nameOfHolder) {
      this.safe_deposit_name = nameOfHolder;
   }
   
          /**
          * gets account holder name
          *   
          *         
          * @return String - safe deposit name
          */   
   public String getAccountHolderName() {
      return safe_deposit_name;
   }
          /**
          * Sets account holder name
          *   
          * @param String newName new name of account holder        
          * return void
          */
   public void setAccountHolderName(final String newName) {
      this.safe_deposit_name = newName;
   }
       /**
       * returns a string formatting box owner
       *                      
       * @return String - returns a string with owners name
       */
   public String toString() {
      return "SafeDepositBoxAccount[owner: " + safe_deposit_name + "]";
   }
}