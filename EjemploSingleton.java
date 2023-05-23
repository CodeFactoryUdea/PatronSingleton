package Singleton;

import java.sql.*;

public class EjemploSingleton 
{
	
	private String url;
	private String driver;
	private String user;
	private String password;
	private static Connection conn=null;
	
	//Constructor
	public EjemploSingleton()
	{
		String url = "jdbc:mysql://localhost:3306/udea";
 		String driver = "com.mysql.jdbc.Driver";
 		String user = "root";
 		String password = "";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if(conn != null){
                            System.out.println("Conexión establecida...");
                        }
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error al conectar..." + e);
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
	
	//con este método nos desconectamos de la bd
        public void desconectar(){
        conn = null;
        if(conn == null){
            System.out.println("Conexión terminada...");
        }
    }
}
