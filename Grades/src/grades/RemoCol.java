package grades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RemoCol {
    
    private static final String USERNAME="Prachita";
    private static final String PASSWORD="Prachita";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    static final String DB_URL = "jdbc:mysql://localhost:3306/grades";
    Scanner sc = new Scanner(System.in);
    String a,table;
    
    RemoCol()
    {
        Connection conn= null;
        Statement stmt = null;
        
        
        
        System.out.println("ENTER THE COURSE NAME");
        table = sc.nextLine();
        System.out.println("ENTER THE COLUMN NAME YOU WISH TO BE DELETED");
        a = sc.nextLine();
        
            
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Execute a query
            stmt = conn.createStatement();
            
            // Removing column
           int n = stmt.executeUpdate("ALTER TABLE "+table+" DROP COLUMN "+a);
            //ALTER TABLE [table] ADD COLUMN [column] VARCHAR(120);

            System.out.println("Column removed");
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
    }
    
    
    public static void main(String[] args)
    {
        RemoCol re = new RemoCol();
        System.out.println("EXITED REMOCOL");
    }
}
