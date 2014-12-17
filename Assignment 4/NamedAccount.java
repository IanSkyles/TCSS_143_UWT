/*
* 
* NamedAccount.java
* TCSS 143 – Autumn 2014
* Assignment 4
* Interface
*
*/

/**
* Please see BankAccount.java by ian skyles for more info
* @author Ian Skyles iskyles@uw.edu
* @version 10/21/2014
*/
public interface NamedAccount{

   /*
    *defines the methods required by anything within interface
    */  
   
    String getAccountHolderName();
    void setAccountHolderName(final String newName);
 }