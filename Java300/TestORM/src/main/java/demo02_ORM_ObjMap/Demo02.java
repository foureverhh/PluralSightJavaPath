package demo02_ORM_ObjMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //Map<String,Object> row = new HashMap<String, Object>();//capsule one record
        List<Map<String,Object>> rows = new ArrayList<Map<String, Object>>();
        try {
            conn = JDBCUtils.getMysqlConnection();
            ps = conn.prepareStatement("SELECT empname,salary,age FROM emp WHERE id>=? ");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while (rs.next()){
                Map<String,Object> row = new HashMap<String, Object>();//capsule one record
                row.put("empname",rs.getObject(1));
                row.put("salary",rs.getObject(2));
                row.put("age",rs.getObject(3));
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,ps,rs);
        }
        for(Map<String,Object> row:rows){
            for(String key : row.keySet()){
                System.out.print(key+": "+row.get(key)+"\n");
            }
            System.out.println();
        }


    }
}
