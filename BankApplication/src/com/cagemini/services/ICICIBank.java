package com.cagemini.services;

import java.util.LinkedList;

import com.cagemini.beans.Account;
import com.cagemini.exceptions.InsufficientBalanceException;
import com.cagemini.exceptions.InsufficientOpeningAccountException;
import com.cagemini.exceptions.InvalidAccountNumberException;

public class ICICIBank implements Bank{
	private LinkedList<Account> accounts=new LinkedList<>();
	public String createAccount(int accountNumber,int amount)throws InsufficientOpeningAccountException {
		if(amount>=500)  {
			Account account=new Account(accountNumber,amount);
			accounts.add(account);
			return "Account created";
		}
		else throw new InsufficientOpeningAccountException();

	}
	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException{
		for(Account account: accounts) {
			if(account.getAccountNumber()==accountNumber) {
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}
	public int withdrawAmount(int accountNumber,int amount)throws InsufficientBalanceException, InvalidAccountNumberException {
		Account account=searchAccount(accountNumber);

		if(account.getAmount()-amount>=0) {
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();

		}
		throw new InsufficientBalanceException();

	}
	public int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException {
		Account account=searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}
	public int[] fundTransfer(int senderAccount,int recieverAccount,int amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		Account account=searchAccount(senderAccount);
		Account acc=searchAccount(recieverAccount);
		if(account.getAmount()>=0) {

			account.setAmount(account.getAmount()-amount);
			acc.setAmount(acc.getAmount()+amount);
			int[] balanceAmount= {account.getAmount(),acc.getAmount()};
			return balanceAmount;
		}throw new InsufficientBalanceException();
	}
}

