package grades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Table {
    private static final String USERNAME="Prachita";
    private static final String PASSWORD="Prachita";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    static final String DB_URL = "jdbc:mysql://localhost:3306/grades";
    
    Table()
    {
        Connection conn= null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        String a;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Execute a query
            stmt = conn.createStatement();
            System.out.println("ENTER THE COURSE NAME WITH CURRENT YEAR WITHOUT SPACES");
            a = sc.nextLine();
            
            // Creating table
            String sql = "CREATE TABLE " +  a  +
                         "(ID VARCHAR(20), " +
                         " name VARCHAR(40), " + 
                         " last VARCHAR(40)) " ; 

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
            //finally block used to close resources
            try
            {
                if(stmt!=null)
                conn.close();
            }
            catch(SQLException se)
            {
            }
            // do nothing
            try
            {
                if(conn!=null)
                conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
        }//end finally try
   }//end try
    }

    public static void main(String [] args)
    {
        Table t = new Table();
        System.out.println("Goodbye!");
    }
}