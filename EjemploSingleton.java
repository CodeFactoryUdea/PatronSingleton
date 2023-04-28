package Singleton;

import java.sql.*;

public class EjemploSingleton implements DataBase
{
	
	private String url;
	private String driver;
	private String user;
	private String password;
	private static Connection conn=null;
	
	//Constructor
	public EjemploSingleton()
	{
		String url = "jdbc:mysql://localhost:3306/test";
 		String driver = "com.mysql.jdbc.Driver";
 		String user = "usuario";
 		String password = "password";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//Fin constructor
	
	//Métodos
	public static Connection getConnection()
	{
		if (conn == null)
			{new EjemploSingleton();}
		return conn;
	}
	//Fin getConnection
}
