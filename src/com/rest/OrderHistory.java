package com.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OrderHistory {
	
	private static Statement stmt = null;
	private static Connection conn = null;
	
	public void showHistory() 
	{
		try
        {
			int order_id = 0;
			String order_status = null;
			int customer_id = 0;
			double amount = 0;
			CreateConnection con =new CreateConnection();
			conn = con.establishConnection();
            stmt = conn.createStatement();
            @SuppressWarnings("resource")
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Select Customer id : ");
    		int cid = sc.nextInt();
    		ResultSet results = stmt.executeQuery("select * from orders where customer_id = "+cid);
    		System.out.println("ORDER ID \t CUSTOMER ID \t ORDER STATUS \t AMOUNT");
            System.out.println("\n--------------------------------------------------------------");
            while(results.next())
            {
                order_id = results.getInt(1);
                order_status = results.getString(2);
                customer_id = results.getInt(4);
                amount = results.getDouble(5);
                
            }
            if (order_status.equals("P"))
            {
            	order_status = "Placed";
            }
            else if (order_status.equals("C"))
            {
            	order_status = "Cancelled";
            }
            else
            {
            	order_status = "Pending";
            }
            System.out.println(order_id + " \t\t" + customer_id + " \t\t" + order_status + " \t\t" + amount);
            System.out.println("\n--------------------------------------------------------------");
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        } 
	}

}
