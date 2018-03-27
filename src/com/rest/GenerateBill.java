package com.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GenerateBill {
	
	private static Statement stmt = null;
	private static Connection conn = null;
	
	public void generateBill() {
		
		int item_id;
		String item_name;
		String item_desc;
		String item_cat;
		int item_cost = 100 ;
		int total =100;
		boolean flag = false;
		
		try
        {
			CreateConnection con =new CreateConnection();
			conn = con.establishConnection();
            stmt = conn.createStatement();
            @SuppressWarnings("resource")
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Select Order id : ");
    		int order_id = sc.nextInt();
    		ResultSet orderStatus = stmt.executeQuery("select * from orders where ORDER_ID = "+order_id);
    		while(orderStatus.next())
            {
    			if(orderStatus.getInt(1) == order_id && orderStatus.getString(2).equals("C"))
    			{
    				flag = true;
    				break;
    			}
    			else
    			{
    				flag = false;
    				break;
    			}
            }
    		if(flag == false ) 
    		{
    			ResultSet results = stmt.executeQuery("select * from items where item_id in (select item_id from items_ordered where order_id ="+order_id+")");
    			System.out.println("ITEM ID \t ITEM NAME \t ITEM DESC \t ITEM_CATEGORY \t AMOUNT");
    			System.out.println("\n--------------------------------------------------------------");
    			while(results.next())
    			{
    				item_id = results.getInt(1);
    				item_name = results.getString(2);
    				item_desc = results.getString(3);
    				item_cat = results.getString(4);
    				System.out.println(item_id + " \t" + item_name + " \t" + item_desc + " \t" + item_cat + " \t" + item_cost);
    				total = item_cost + 100 ;
                
    			}
    			System.out.println("\n--------------------------------------------------------------");
    			System.out.println("TOTAL \t\t\t\t\t\t\t\t" + total);
    			System.out.println("--------------------------------------------------------------");
    		}
    		else
    		{
    			System.out.println("YOUR ORDER "+order_id+" IS CANCELLED ,WE CAN NOT GENERATE BILL");
    		}
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        } 
	}
	
}
