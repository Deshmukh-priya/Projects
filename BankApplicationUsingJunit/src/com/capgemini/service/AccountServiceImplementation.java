package com.capgemini.service;


import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImplementation implements AccountService {
	
	AccountRepository accountRepository;
	Account account;

	public AccountServiceImplementation(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	public Account createAccount(int accountNumber,int amount) throws InsufficientOpeningAmountException {

		if(amount<500)
		{
			throw new InsufficientOpeningAmountException();
		}
		 account = new Account(accountNumber,amount);
		account.setAccountNumber(accountNumber);

		account.setAmount(amount);

		if(accountRepository.save(account))
		{
			return account;
		}
		return null;

		
	}
	public int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException   {

		Account account=new Account(accountNumber,amount);
		if(accountRepository.searchAccount(accountNumber)==null){
			throw new InvalidAccountNumberException();
		}
		account.setAmount(account.getAmount()+amount);
		return account.getAccountNumber();
			
		
		}
	public int withDrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
        Account account=new Account(accountNumber,amount);
		if(accountRepository.searchAccount(accountNumber)==null){
			throw new InvalidAccountNumberException();
		}
		if((account.getAmount()-amount>=0))
		{
			throw new InsufficientBalanceException();

			
		}
		account.setAmount(account.getAmount()-amount);
		return amount;
		

	}
	


}







