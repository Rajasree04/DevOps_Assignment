package com.rest;

import java.util.Scanner;

public class Menu {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println("******MENU**********");
		System.out.println("********************");	
		System.out.println("1.Creating Order ");
		System.out.println("2.Order History ");
		System.out.println("3.Cancel Order ");
		System.out.println("4.Generate Bill ");
		System.out.println("********************");
		System.out.println("********************");	
		System.out.println("Please Select the option : ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		CreateOrder createorder = new CreateOrder();
		OrderHistory orderhistory = new OrderHistory();
		CancelOrder cancelorder = new CancelOrder();
		GenerateBill generatebill = new GenerateBill();
		switch (option) 
        {
            case 1:	System.out.println("Creating Order");
            		createorder.showMenu();
                     break;
            case 2: orderhistory.showHistory();
                     break;
            case 3: cancelorder.cancelOrder();
                     break;
            case 4: System.out.println("Generating the bill");
            		generatebill.generateBill();
                     break;
            default:System.out.println("*** Invalid Option ***");
                     break;
        }
		
	}

}
