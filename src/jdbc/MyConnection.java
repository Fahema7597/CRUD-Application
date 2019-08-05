package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MyConnection {
public static Connection prepareConnection() throws ClassNotFoundException,SQLException{
	//database URL
	String connectionURL = "jdbc:mysql://localhost:3306/clt6"; //core is database name
	
	//database credentials
	String uname = "root";
	String pwd ="root";
	
	//register JDBC driver
	Class.forName("com.mysql.jdbc.Driver");
	
	//open a connection
	Connection ref = DriverManager.getConnection(connectionURL,uname,pwd);
	return ref;
	
}
}


