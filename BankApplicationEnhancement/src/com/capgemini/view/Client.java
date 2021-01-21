package com.capgemini.view;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.services.BankRunner;
import com.capgemini.services.ICICIBank;

public class Client  {
	public static void main(String[] args) throws Throwable {

		ICICIBank bank=new ICICIBank();
		BankRunner bankrunner=new BankRunner(bank);
		try {
			System.out.println("Account creation started");
			System.out.println(bank.createAccount(101, 10000));
			System.out.println(bank.createAccount(102, 20000));

			Thread firstThread=new Thread(bankrunner,"first");
			firstThread.start();

			Thread secondThread=new Thread(bankrunner,"second");
			secondThread.start();

			// System.out.println("Amount after withdrawing from 101 "+bank.withdrawamount(101, 1000));
			System.out.println("After depositing amount in Acoount 101: "+bank.depositAmount(101, 1000));
			int[] balance=bank.fundTransfer(101, 102, 100);
			System.out.println("After transfering amount from 101 to 102. account 101= "+balance[0]+" account 102= "+balance[1]);
		}catch(InsufficientOpeningAmountException ins) {
			System.out.println("Insufficient amount for account opening....minimum balance must be 500");
		}	catch(InsufficientBalanceException inb) {
			System.out.println("insufficient balance");
		}catch(InvalidAccountNumberException ina) {
			System.out.println("invalid account number");
		}
	}
}
