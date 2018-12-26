package grades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Display {
    
    private static final String USERNAME="Prachita";
    private static final String PASSWORD="Prachita";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    static final String DB_URL = "jdbc:mysql://localhost:3306/grades";
    Scanner sc = new Scanner(System.in);
    String course;
    Display()
    {
        Connection conn= null;
        Statement stmt = null;
        
        
        System.out.println("ENTER THE COURSE NAME WHICH IS TO BE DISPLAYED");
        course = sc.nextLine();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Execute a query
            stmt = conn.createStatement();
            
            String sql = "SELECT ID, name, last FROM "+course;
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                //Retrieve by column name
                String id = rs.getString("ID");
                String first = rs.getString("name");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
            System.out.println("DELETION PERFORMED");
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
            }// do nothing
            try{
                if(conn!=null)
                conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
        System.out.println("Ending Display");
    }
    /**
     *
     * @param args
     */
    public static void main (String [] args)
    {
        Display de = new Display();
        System.out.println("EXITED Display");
    }
}
