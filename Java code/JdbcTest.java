import java.sql.*;

/**
 * 
 * @author www.luv2code.com
 *
 */
public class JdbcTest {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			 myConn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			 System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			 myStmt  = myConn.createStatement();
			 
			
			
			 System.out.println("Adding a new employee into the database");
			/* int rowsAffected = myStmt.executeUpdate(
					 "insert into employees " +
					  "(last_name, first_name,email,department,salary)" +
					  "values " +
					  "('bhatt','aliya','a.bhatt@gmail.com','HR',33000.00)");*/
			 
			 int rowsAffected = myStmt.executeUpdate(
					 "update employees " + 
					  "set email = 'aliya.bhatt@yahoo.in' "+
					  "where last_name = 'bhatt' and first_name = 'aliya'");
			 
			 System.out.println("rows affected " + rowsAffected); 
			 
			// 3. Execute SQL query
			 myRs = myStmt.executeQuery("select * from employees");
			 
			
			
			// 4. Process the result set
			// moves forward one row i.e read data from each row
			while (myRs.next()) { 
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
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
