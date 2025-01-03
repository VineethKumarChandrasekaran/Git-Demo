package com.vt.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con;
	
	
public void getDatabaseConnection() throws SQLException
{
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	}
	catch(Exception e)
	{
		
	}
	
}

public ResultSet executeSelectQuery(String query) throws SQLException
{
	Statement statement = con.createStatement();
	ResultSet result = statement.executeQuery(query);
	return result;
}

public int executeNonSelectQuery(String query) throws SQLException
{
	Statement statement=con.createStatement();
	int result = statement.executeUpdate(query);
	return result;
	
}


public void closeConnection() throws SQLException
{
	con.close();
}
}
