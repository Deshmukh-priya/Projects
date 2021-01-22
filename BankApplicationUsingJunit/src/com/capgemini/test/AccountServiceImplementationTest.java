package com.capgemini.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImplementation;


public class AccountServiceImplementationTest {
	
	@Mock
	AccountRepository accountRepository;
	AccountService accountService;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImplementation(accountRepository);
		
	}

	@Test(expected=InsufficientOpeningAmountException.class)//1. Amount is not Enough to open account
	public void whenAmountIsInsufficient() throws InsufficientOpeningAmountException  {
		accountService.createAccount(101, 300);
	}
	@Test
	public void whenAmountandAccountNumberisValidCreateTheAccount() throws InsufficientOpeningAmountException {
		accountService.createAccount(101, 5000);
		Account account =new Account(101,5000);
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(101, 5000));

	}// When valid information is passed account must be created.
	
	@Test(expected=InvalidAccountNumberException.class)
	public void whenAccountIsInvalidThrowException() throws InvalidAccountNumberException, InsufficientOpeningAmountException {
		Account account =new Account(101,1000);
		when(accountRepository.searchAccount(101)).thenReturn(account);	
		accountService.depositAmount(100, 300);
		
		
	}
	@Test
	public void whenValidAccountNumberDepositTheAmount() throws InvalidAccountNumberException, InsufficientOpeningAmountException {
		
		Account account=new Account(101,1000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.depositAmount(101, 300);
		
		
	}
	
	
	@Test(expected=InvalidAccountNumberException.class)
	public void whenInvalidAccountShouldThrowException() throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningAmountException {
		Account account=new Account(101,5000);
		//when(accountRepository.save(account)).thenReturn(true);
		when(accountRepository.searchAccount(101)).thenReturn(account);	
		accountService.withDrawAmount(102, 100);
		
		
	}
	@Test
	public void whenInsufficientBalanceThrowException() throws  InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningAmountException {
		
		Account account=new Account(101,5000);
		when(accountRepository.searchAccount(101)).thenReturn(account);	
		
		accountService.withDrawAmount(101, 50000);
		
		}
	
	@Test
	public void whenInformationIsValidWithdrawTheAmount() throws InvalidAccountNumberException, InsufficientBalanceException{
		
		Account account=new Account(101,1000);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		
		accountService.withDrawAmount(101, 100);
	}
	
	}
	
	
	


