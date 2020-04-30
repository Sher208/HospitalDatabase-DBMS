import java.sql.*;


public class sqlConnection {
	Connection con = null;

	public static Connection sqlPlusData() 
	{
		try {
					
	        Class.forName("oracle.jdbc.driver.OracleDriver");						
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");			
	        return con;
	    } catch (Exception ex) {

	        System.out.println(ex);
	        return null;

	    }
		

	}

}