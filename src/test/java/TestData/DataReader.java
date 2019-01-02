package TestData;

//Import JDBC package
import java.sql.*;
// Import Java package for File I/O
import java.io.*;

public class DataReader {

        public static void main (String[] args) throws SQLException, IOException
        {
            //Load and register Oracle driver
       //     DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            //Establish a connection
            Connection conn =  DriverManager.getConnection("jdbc:oraclracle", "", "");
            //Create a Statement object
            Statement sql_stmt = conn.createStatement();
            //Create a ResultSet object, execute the query and return a
            // resultset
            ResultSet rset = sql_stmt.executeQuery("SELECT empno, ename, sal, deptno FROM emp ORDER BY ename");
                    //Process the resultset, retrieve data in each row, column by column
                    //and write to an operating system file
                    String str = "";
            while (rset.next())
            {
                str += rset.getInt(1)+" "+ rset.getString(2)+" "+rset.getFloat(3)+" "+rset.getInt(4)+"\n";
                System.out.println(str);
            }

//Close the ResultSet and Statement
            rset.close();
            sql_stmt.close();
            //Close the database connection
            conn.close();
        }
    }

