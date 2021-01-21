package com.capgemini.services;

import java.util.LinkedList;

import com.capgemini.beans.Accounts;
import com.capgemini.exceptions.InsufficientBalnceException;
import com.capgemini.exceptions.InsuffiecientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;


public class ICICIBank  {
	private LinkedList <Accounts> accounts=new LinkedList<>();

	public String createAccount(int accountNumber,int amount)throws InsuffiecientOpeningAmountException {
		Accounts account=new Accounts();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		if(account.getAmount()>=500) {
			accounts.add(account);  //added in LinkedList.
			return"Account created successfully";
		}
		else {
			throw new InsuffiecientOpeningAmountException();
		}
	}
	private Accounts searchAccount(int accountNumber)throws InvalidAccountNumberException{
		for(Accounts account:accounts) {
			if(account.getAccountNumber()==accountNumber) {
				return account;
			}
		}
		throw new InvalidAccountNumberException();

	}
	public int withdrawamount(int accountNumber,int amount)throws InsufficientBalnceException,InvalidAccountNumberException{
		Accounts account=searchAccount(accountNumber);
		synchronized(account) {
			if(account.getAmount()-amount>=500) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				account.setAmount(account.getAmount()-amount);
				return account.getAmount();
			}
		}
		throw new InsufficientBalnceException();
	}
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException{
		Accounts account=searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}
	public int[] fundTransfer(int senderAccount,int receiverAccount,int amount) throws Throwable {
		Accounts sender=searchAccount(senderAccount);
		Accounts receiver=searchAccount(receiverAccount);
		if(sender.getAmount()>=500) {
			sender.setAmount(sender.getAmount()-amount);
			receiver.setAmount(receiver.getAmount()+amount);
			int[] balance= {sender.getAmount(),receiver.getAmount()};
			return balance;
		}
		throw new InvalidAccountNumberException();
		
	}
}
