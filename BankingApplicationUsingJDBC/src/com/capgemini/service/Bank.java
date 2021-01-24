package com.capgemini.service;



import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface Bank {
	
	int depositAmount(int accNo, int amt) throws InvalidAccountNumberException;

	boolean validateAccount(int AccNo) throws  InvalidAccountNumberException;

	int withdrawAmount(int accNo, int amt) throws InsufficientBalanceException;

	int[] fundTransfer(int sourceAccNo, int recieverAccNo, int amt) throws InsufficientBalanceException;

	boolean createAccount(int accNo, int Deposit) throws InsufficientOpeningBalanceException;
	
}
