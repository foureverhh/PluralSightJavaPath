package demo03_javaBean;

import demo02_ORM_ObjMap.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo03 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Emp> emps = new ArrayList<Emp>();
        try {
            conn = demo02_ORM_ObjMap.JDBCUtils.getMysqlConnection();
            ps = conn.prepareStatement("SELECT empname,salary,age FROM emp WHERE id>=? ");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while (rs.next()){
                Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
                emps.add(emp);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        for(Emp emp : emps){
            System.out.println(emp.getEmpname()+emp.getSalary()+emp.getAge());
        }
    }

}
