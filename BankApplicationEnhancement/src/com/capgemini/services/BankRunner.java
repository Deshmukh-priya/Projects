package com.capgemini.services;

import com.capgemini.exceptions.InsufficientBalnceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public class BankRunner implements Runnable {
	ICICIBank bank;
	public BankRunner(ICICIBank bank) {
		this.bank=bank;
	}


	@Override
	public void run() {
		try {
			if(Thread.currentThread().getName().equals("first")) {
				System.out.println("balance "+bank.withdrawamount(101, 1000));
			}
			else {
				System.out.println("balance "+bank.withdrawamount(101,1000));
			}
		}catch(InvalidAccountNumberException ian)
		{
			System.out.println("invalid account number");
		}catch (InsufficientBalnceException e) {

			e.printStackTrace();
		}

	}

}
