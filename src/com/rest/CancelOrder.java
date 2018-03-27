package com.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CancelOrder {
	
	private static Statement stmt = null;
	private static Connection conn = null;
	

	public void cancelOrder() {
		
		try
        {
			CreateConnection con =new CreateConnection();
			conn = con.establishConnection();
            stmt = conn.createStatement();
            @SuppressWarnings("resource")
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Select Order id : ");
    		int order_id = sc.nextInt();
    		ResultSet results = stmt.executeQuery("select * from orders where ORDER_ID = "+order_id);
    		while(results.next())
            {
    		if (results.getInt(1) == order_id && results.getString(2).equals("P"))
    		{
    			stmt.execute("UPDATE ORDERS SET ORDER_STATUS='C' WHERE ORDER_ID=" +order_id);
    			System.out.println("Order Successfully Cancelled");
    			break;
    		}
    		else if (results.getInt(1) == order_id && results.getString(2).equals("C"))
    		{
    			System.out.println("ORDER IS ALREADY CANCELLED " + order_id);
    			break;
    		}
    		else
    		{
    			System.out.println("We couldn't found ORDER NUMBER " + order_id + " ,Please check again..");
    			break;
    		}
            }
			
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        } 
	}
}
