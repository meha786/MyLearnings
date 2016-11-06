
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author www.luv2code.com
 *
 */
public class JavaPreparedStatment {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			 myConn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			 System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
		    //myStmt  = myConn.createStatement();
			 
			 myStmt  = myConn.prepareStatement("select * from employees where salary > ? and department=?");
			 // PreparedStatement.setDouble(1,80000)
			 myStmt.setDouble(1,80000); 
			 myStmt.setString(2,"legal"); 
			 
			 myRs = myStmt.executeQuery();
			 
			 System.out.println(myRs);
		
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}


}
