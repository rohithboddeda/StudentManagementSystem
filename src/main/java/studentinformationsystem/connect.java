package studentinformationsystem;
import java.sql.*;

public class connect {
	public static Connection getConnection() throws Exception{
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","ROHITH","ROHITH");
		
		return con;
	}
	

}
