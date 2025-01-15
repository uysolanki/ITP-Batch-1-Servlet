

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;

public class MySQLConnection1 {
		public static Connection con;
		public static Connection getConnection(ServletContext context) throws ClassNotFoundException, SQLException
		{
			String driverName=(String)context.getInitParameter("driverName");
			String dbName=(String)context.getInitParameter("dbName");
			String userName=(String)context.getInitParameter("userName");
			String password=(String)context.getInitParameter("password");
			
			Class.forName(driverName);  
			con=DriverManager.getConnection(dbName,userName,password); 
			return con;
		}
}
