package com.capgemini.view;
import java.util.Scanner;

import com.cagemini.exceptions.InsufficientBalanceException;
import com.cagemini.exceptions.InsufficientOpeningAccountException;
import com.cagemini.exceptions.InvalidAccountNumberException;
import com.cagemini.services.ICICIBank;

public class Client {
	public static void main(String args[]) throws InsufficientOpeningAccountException, InvalidAccountNumberException, InsufficientBalanceException {
		ICICIBank bank=new ICICIBank();
		Scanner sc=new Scanner(System.in);
		System.out.println("How many accounts you want to enter");
		int count=sc.nextInt();
		int accNumb,amount=0;

		for(int i=1;i<=count;i++) {
			System.out.println("Enter your account number");
			accNumb=sc.nextInt();
			System.out.println("Enter your amount");
			amount=sc.nextInt();
			try {
				bank.createAccount(accNumb, amount);
			}catch(InsufficientOpeningAccountException ioe) {
				System.out.println("Insufficient opening amount");
			}
		}

		System.out.println("Enter your account number to withdraw");
		accNumb=sc.nextInt();
		System.out.println("Enter your amount to withdraw");
		amount=sc.nextInt();
		try {
			System.out.println("Balance="+bank.withdrawAmount(accNumb, amount));
		}catch(InvalidAccountNumberException i1) {
			System.out.println("Invalid account number");
		}catch(InsufficientBalanceException ibe) {
			System.out.println("Insufficient Balance");
		}

		System.out.println("Enter your account number to deposit amount");
		accNumb=sc.nextInt();
		System.out.println("Enter your amount");
		amount=sc.nextInt();
		try {
			System.out.println("Amount deposited successfully "+bank.depositAmount(accNumb,amount));
		}catch(InvalidAccountNumberException i1) {
			System.out.println("Invalid account number");
		}

		System.out.println("Enter the Sender account number ");
		int senderAcc=sc.nextInt();
		System.out.println("Enter your Reciever account number");
		int recieverAcc=sc.nextInt();
		System.out.println("Enter the amount to transfer");
		int amt=sc.nextInt();
		try {
			int[] amounts=bank.fundTransfer(senderAcc, recieverAcc, amt);
			System.out.println("Successfully transfered!! New account Balance is  "+amounts[0]+amounts[1]);

		}catch(InvalidAccountNumberException i1) {
			System.out.println("Invalid account number");
		}catch(InsufficientBalanceException ibe) {
			System.out.println("Insufficient Balance");
		}
		sc.close();
	}
}

