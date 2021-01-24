package com.capgemini.service;


import com.capgemini.repository.DataBaseHelper;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.*;

public class ICICIBank implements Bank {
	
	DataBaseHelper db=null;
	
	
	public boolean createAccount(int accNo, int Deposit) throws InsufficientOpeningBalanceException {
		Account a = new Account();
	/*	if(new DataBaseHelper().searchRecord(accNo))
		{
			
			return false;			
		}
		else 
		{*/
			a.setAccountNum(accNo);
			if(Deposit>=500)
			{
				a.setBalance(Deposit);
				return new DataBaseHelper().insertRecord(a);
			}
			else
				throw new InsufficientOpeningBalanceException();
		}
	

	public boolean validateAccount(int AccNo) throws InvalidAccountNumberException
	{	
		if(new DataBaseHelper().fetchRecord(AccNo) != null)
			return true;
		else	
			throw new InvalidAccountNumberException();

	}


	public int depositAmount(int accNo, int amount) throws InvalidAccountNumberException {
		Account a = new DataBaseHelper().fetchRecord(accNo);
		a.setBalance(a.getBalance()+amount);
		if(new DataBaseHelper().updateRecord(a))
			return a.getBalance();
		else
			throw new InvalidAccountNumberException();
	}


	public int withdrawAmount(int accNo, int amount) throws InsufficientBalanceException {
		Account a = new DataBaseHelper().fetchRecord(accNo);
		if(a.getBalance()-amount>=500)
		{
			a.setBalance(a.getBalance()-amount);
			if(new DataBaseHelper().updateRecord(a))
				return a.getBalance();
			else
				return 0;
		}

		throw new InsufficientBalanceException();
	}


	public int[] fundTransfer(int sourceAccNo,int recieverAccNo, int amount) throws InsufficientBalanceException {
		int[] balance =null;
		Account sourceAcc = new DataBaseHelper().fetchRecord(sourceAccNo);
		Account recieverAcc = new DataBaseHelper().fetchRecord(recieverAccNo);
		if(sourceAcc.getBalance()-amount>=500)
		{
			sourceAcc.setBalance(sourceAcc.getBalance()-amount);
			recieverAcc.setBalance(recieverAcc.getBalance()+amount);
			if(new DataBaseHelper().updateRecord(sourceAcc) && new DataBaseHelper().updateRecord(recieverAcc))
			{
				balance =new int[] {sourceAcc.getBalance(),recieverAcc.getBalance()};
				return balance;
			}				
			else
				return null;
		}
		else
			throw new InsufficientBalanceException();
	}

	
	
	
}