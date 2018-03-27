package com.rest;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	
	private static String dbURL = "jdbc:derby://localhost:1527/RestDb;create=true;";
	private static Connection conn = null;
    
    @SuppressWarnings({ "deprecation" })
	public Connection establishConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
            //return true;
            //System.out.println("Connection Successfully established");
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
		return conn;
    }

}
