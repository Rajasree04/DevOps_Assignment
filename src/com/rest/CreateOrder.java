package com.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CreateOrder {
	
	private static Statement stmt = null;
	private static Connection conn = null;

	public void showMenu()
	{
		try
        {
			CreateConnection con =new CreateConnection();
			conn = con.establishConnection();
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from ITEMS");
            System.out.println("------------------------------");
            System.out.println("ITEM ID" + "\t\t" + "ITEM NAME");
            while(results.next())
            {
                int item_id = results.getInt(1);
                String item_name = results.getString(2);
                System.out.println(item_id + "\t\t" + item_name);     
            }
            selectItem();
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        } 
		
	}
	
	public static void selectItem() throws SQLException
	{
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Customer id : ");
		int cid = sc.nextInt();
		System.out.println("Please Enter the number of items : ");
		int count = sc.nextInt();
		System.out.println("Please Select the Item/Items : ");
		ArrayList<Integer> listItems=new ArrayList<Integer>();
		for (int i =0 ;i < count ;i++) {
			
			Integer item = sc.nextInt();
			listItems.add(item);
			
		}
		placeOrder(listItems,cid);
		
	}
	public static void placeOrder(ArrayList<Integer> list,int cid) throws SQLException {
		
		
		  	String Order_status = "P";
			double amount = list.size() * 100.00 ;
			Random rand = new Random();
			int number1 = rand.nextInt(100);
			int number2 = rand.nextInt(100);
			int number3 = rand.nextInt(100);
			int order_id = (number1 * number2) + number3 ;
			stmt = conn.createStatement();
			stmt.execute("insert into orders (ORDER_ID,ORDER_STATUS,CUSTOMER_ID,AMOUNT) values (" + order_id + ",'" + Order_status + "'," + cid + "," + amount + ")");
			for (Integer item_id : list) { 		      
		           System.out.println(item_id);
		           stmt.execute("insert into items_ordered values ("+ order_id + ","+ item_id +")");
		    }
			
			System.out.println("Successfully Order is creared : " + order_id + " for the user : " + cid);
	}
	
}
