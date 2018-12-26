package grades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Upda {


        static int choice;
        private static final String USERNAME="Prachita";
        private static final String PASSWORD="Prachita";
        private static final String CONN_STRING="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
        static final String DB_URL = "jdbc:mysql://localhost:3306/grades";

    
        
        private Connection conn;
        private Statement stmt;
        String course,idst;
        
        Upda()
        {  
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Update Marks for a Student ");
            System.out.println("2. Update specific Marks for all Students");
            choice = sc.nextInt();
            
        }


        void UpdateRow() throws ClassNotFoundException 
        {
            int i;
            conn=null;
            stmt=null;
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER THE COURSE NAME WHICH IS TO BE UPDATED");
            course = sc.nextLine();
            System.out.println("ENTER THE ID WHOSE DATA IS TO BE UPDATED");
            idst = sc.nextLine();
            boolean done=false;
            
            while(!done)
            {
                try
                {   
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                    // Execute a query
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM "+course);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int count = rsmd.getColumnCount(); //number of column

                    for ( i = 4; i <= count; i++)
                    {
                       String name = rsmd.getColumnName(i);
                       System.out.println("DO YOU WANT TO UPDATE "+name+" FOR "+idst);
                       System.out.println("TYPE Y FOR YES AND N FOR NO");
                       String x = sc.nextLine();
                       if(x.equals("y"))
                       {
                            try
                            {
                                Class.forName("com.mysql.jdbc.Driver");

                                // Open a connection
                                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                                // Execute a query
                                stmt = conn.createStatement();
                                String s;
                                System.out.println("ENTER THE VALUE TO BE UPDATED ");
                                s = sc.nextLine();
                                
                                String query = "UPDATE grades."+course+" SET "+name+" = ? WHERE ID = ?";
                                PreparedStatement preparedStmt = conn.prepareStatement(query);
                                preparedStmt.setString(1,s);
                                preparedStmt.setString(2,idst);
                                preparedStmt.executeUpdate();

                                /*String sql = "UPDATE grades."+course+" SET "+name+"="+name+" WHERE 1";
                                stmt.executeUpdate(sql);*/
                                System.out.println("UPDATION PERFORMED FOR "+name);
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
                       }
                    }
                    if(i>count)
                    {
                        done= true;
                    }
                }
                catch(SQLException re)
                {
                    re.printStackTrace();
                }
                
                System.out.println("Ending Del");
                
            }
            
        }



        void UpdateCol()
        {
            Scanner sc = new Scanner(System.in);
            boolean done=false;
            while(!done)
            {
                
                
            }
            
        }


        public static void main (String[] args) throws ClassNotFoundException 
        {
             
            Upda uppp = new Upda();
            if( uppp.choice == 1)
            {
                uppp.UpdateRow();
            }
            else if( uppp.choice == 2)
            {
                uppp.UpdateCol();
            }
        }
}
