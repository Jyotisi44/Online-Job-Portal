package com.DB;

import java.sql.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {

private static Connection con;
	
	public static Connection getCon()
	{
		try
		{
			MysqlDataSource ds = new MysqlDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/jobportal");
			ds.setUser("root");
			ds.setPassword("");
			
			con=ds.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			return con;
		}
	} 

}
