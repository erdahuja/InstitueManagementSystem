package com.bmpl.ims.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommonDAO {
	private CommonDAO(){}
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		//String url2 = "jdbc:mysql://localhost:3306/admin?user=root&password=sunil2345";
		ResourceBundle rb=ResourceBundle.getBundle("db");
		Class.forName(rb.getString("drivername"));
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(rb.getString("dburl"),rb.getString("userid"),rb.getString("password"));
		//Connection con=DriverManager.getConnection(url2);
		return con;
	}
	
}
