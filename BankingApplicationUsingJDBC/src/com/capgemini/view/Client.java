package com.capgemini.view;

import java.util.Scanner;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.service.Bank;
import com.capgemini.service.ICICIBank;

public class Client {
	public static void main(String[] args) throws  InvalidAccountNumberException, InsufficientBalanceException {
		Bank bank = new ICICIBank();
		Scanner sc = new Scanner(System.in);
		int accNo;
		int amount = 0;
		int senderAcc = 0,receiverAcc = 0;
		while(true)
		{
			System.out.println("MENU:");
			System.out.println("1.Create New Account\n2.Existing Account\n3.Deposit amount\n 4.Transfer amount\n 5.WithDraw amount \nENTER YOUR CHOICE");
			int choice= sc.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter Account Number:");
				accNo = sc.nextInt();
				System.out.println("Enter the Amount:");
				amount= sc.nextInt();
				break;
			case 2:
				System.out.println("Enter Account Number:");
				accNo = sc.nextInt();
				try {
					bank.validateAccount(accNo);
				} catch (InvalidAccountNumberException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter Account Number:");
				accNo = sc.nextInt();
				System.out.println("Enter the Amount:");
				amount= sc.nextInt();
				bank.depositAmount(accNo, amount);
				break;
			case 4:
				int[] arr=bank.fundTransfer(senderAcc,receiverAcc,amount);
				System.out.println("Enter Sender Account Number:");
				senderAcc=sc.nextInt();
				System.out.println("Enter Reciever Account Number:");
				receiverAcc=sc.nextInt();
				System.out.println("Enter the Amount:");
				amount= sc.nextInt();
				bank.fundTransfer(senderAcc,receiverAcc , amount);
				System.out.println("Amount Trasferred Successfully!");
				System.out.println("Sender's Current Balance:"+arr[0]);
				System.out.println("Reciever's Current Balance:"+arr[1]);
				break;
			case 5:
				System.out.println("Enter Account Number:");
				accNo = sc.nextInt();
				System.out.println("Enter the Amount:");
				amount= sc.nextInt();
				bank.withdrawAmount(accNo, amount);
				break;

			}
			
		}
		
	}
	
}
