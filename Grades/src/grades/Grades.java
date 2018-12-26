package grades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Grades {

    private static final String USERNAME="Prachita";
    private static final String PASSWORD="Prachita";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    private Connection conn;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        System.out.println("CONNECTED");
        }
        catch (SQLException ex)
        {
            System.err.println(ex);
        }
        System.out.println("-------------GrAdInG-------------");
        int a;
        boolean exit=false;
        while(!exit)
        {
           System.out.println("Enter your choice");
            System.out.println("1.Add a Course Record ");
            System.out.println("2.Add New Column In Already existing Course");
            System.out.println("3.Update Details");
            System.out.println("4.Calculate Total");
            System.out.println("5.Calculate the %");
            System.out.println("6.Display Record");
            System.out.println("7.Delete a Course Record");
            System.out.println("8.Delete a Column");
            System.out.println("9.Go To Main Screen");
            Scanner sc = new Scanner(System.in);
            a= sc.nextInt();
            switch(a)
            {
                case 1 :
                    Table t = new Table();
                     break;
                case 2 :
                    AddCol z = new AddCol();
                     break;
                case 3 :
                    //Call Update
                     break;
                case 4 :
                    //Call Total
                     break;
                case 5 :
                    //Call Percentage
                     break;
                case 6 :
                    //Display Record
                    Display dd = new Display();
                     break;
                case 7 :
                    Del d = new Del();
                     break;
                case 8 :
                    //Del a column or row
                    RemoCol ree = new RemoCol();
                    break;
                    
                case 9 :
                    //Call to The Main Menu
                    //Menu m = new Menu();
                    exit=true;
                     break;
            } 
        }
            
        
    }
    
}
