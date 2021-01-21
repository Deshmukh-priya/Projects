package com.cagemini.services;

import com.cagemini.exceptions.InsufficientBalanceException;
import com.cagemini.exceptions.InsufficientOpeningAccountException;
import com.cagemini.exceptions.InvalidAccountNumberException;

public interface Bank {
	 String createAccount(int accountNumber,int amount) throws InsufficientOpeningAccountException;
	 int withdrawAmount(int accountNumber,int amount) throws InsufficientBalanceException, InvalidAccountNumberException;
	 int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException;
	 int[] fundTransfer(int senderAccount,int recieverAccount,int amount) throws InvalidAccountNumberException, InsufficientOpeningAccountException, InsufficientBalanceException;

}
