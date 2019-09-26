package demo02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
* Test sql execute() and sql injection
* */
public class Demo02 {
    public static void main(String[] args)  {
        Connection connection = null;
        Statement statement = null;
        try {
            //Set up connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees"
                    ,"root"
                    ,"!!8603122692167");

            //instantiate statement
            statement = connection.createStatement();
            String sql = "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES ('9998','1986-03-12','元亨','李','M','2019-01-31')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null!= statement){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!= connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
