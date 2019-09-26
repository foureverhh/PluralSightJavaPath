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
        try {
            //Set up connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees"
                    ,"root"
                    ,"!!8603122692167");

            //instantiate statement
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES ('9999','1986-03-12','元亨','李','M','2019-01-31')";
            statement.execute(sql);



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }


}
