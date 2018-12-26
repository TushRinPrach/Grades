package grades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddCol {
    
    private static final String USERNAME="Prachita";
    private static final String PASSWORD="Prachita";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    static final String DB_URL = "jdbc:mysql://localhost:3306/grades";
    
    
    AddCol()
    {
        Connection conn= null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        String a,type,c;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Execute a query
            stmt = conn.createStatement();
            
            System.out.println("ENTER THE COURSE NAME");
            c = sc.nextLine();
            
            System.out.println("ENTER THE COLUMN NAME YOU WANT TO ADD");
            a = sc.nextLine();
            
            // Adding column
            int n = stmt.executeUpdate("ALTER TABLE "+c+" ADD COLUMN "+a+" VARCHAR(40)");
            //ALTER TABLE [table] ADD COLUMN [column] VARCHAR(120);

            System.out.println("Column added");
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
        AddCol add = new AddCol();
        System.out.println("EXITED AddCol");
    }
}
