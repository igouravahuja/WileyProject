package com.shop.helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection
{

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "9407154504");
		
		return connection;
	}

}

