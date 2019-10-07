package demo01_ORM_ObjArray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
* Use Object[] to store a record
* */
public class Demo01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> objs = new ArrayList<Object[]>();


        try {
            conn = JDBCUtils.getMysqlConnection();
            ps = conn.prepareStatement("SELECT empname,salary,age FROM emp WHERE id>=? ");
            ps.setObject(1,1);
            //ps.setObject(2,4);
            rs =ps.executeQuery();
            //Object[] obj = new Object[3];
            while (rs.next()){
                Object[] obj = new Object[3];
                //System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                obj[0] = rs.getString(1);
                obj[1] = rs.getObject(2);
                obj[2] = rs.getObject(3);
                objs.add(obj);
                //System.out.println(obj.length);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        //System.out.println(""+obj[0]+obj[1]+obj[2]);
        System.out.println(""+objs.get(0)[0]+objs.get(0)[1]+objs.get(0)[2]);
        System.out.println(""+objs.get(1)[0]+objs.get(1)[1]+objs.get(1)[2]);

    }
}
