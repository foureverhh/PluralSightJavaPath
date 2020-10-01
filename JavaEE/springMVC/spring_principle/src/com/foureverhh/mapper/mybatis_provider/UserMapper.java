package com.foureverhh.mapper.mybatis_provider;

import com.foureverhh.pojo.mybatis_provide.User;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import javax.xml.rpc.holders.ObjectHolder;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    /*
    * Provider系列注解：
    * method属性 - 当前方法执行的时候，用于构建SQL的方法是什么
    * type属性 - 当前方法执行的时候，用于构建SQL的类是什么
    * */
    @InsertProvider(method="createInsertSQL",type = UserMapperProvider.class)
    int insertUser(User user);
    @InsertProvider(method="createBatchInsertSQL",type = UserMapperProvider.class)
    int insertBatchUser(Map<String,Object> params); //key=users，value = List<User>

  /*  @UpdateProvider(method = "createUpdateSQL", type = UserMapperProvider.class)
    int updateUser(User user);

    @DeleteProvider(method = "createDeleteSQL", type = UserMapperProvider.class)
    void deleteUser(User user);

    @SelectProvider(method = "createSelectSQL",type = UserMapperProvider.class)
    List<User> selectUser();*/

    static class UserMapperProvider{
        /*
        * user 就是 insertUser(User user)中的参数
        * 返回值为要执行的SQL语句
        * */
        public String createInsertSQL(User user){
            System.out.println("in provider createInsertSQL : " + user);
            //创建SQL构建工具 import org.apache.ibatis.jdbc.SQL;
            SQL sql = new SQL();
            //开始构建SQL语句，方法名代表SQL语法中的子句，参数代表要执行的逻辑
            //如： INSERT_INTO()对应insert into子句。参数对应表名
            sql.INSERT_INTO("user");
            //批量定义插入数据的字段名
            sql.INTO_COLUMNS("username","password");
            //批量定义插入的数据占位符
            sql.INTO_VALUES("#{username}","#{password}");

            String rtnValue = sql.toString();
            System.out.println("in provider createInsertSQL build sql : \n" + rtnValue);
            return rtnValue;
        }

        public String createBatchInsertSQL(Map<String,Object> params){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into user (username,password) values ");
            List<User> users = (List<User>) params.get("users");
            for (int i = 0; i < users.size(); i++) {
                if(i != 0){
                    stringBuilder.append(",");
                }
                /*stringBuilder.append("(#{user[").append(i).append("].username},#{user[").append(i).append("].password})");*/
                stringBuilder.append("(\'").append(users.get(i).getUsername()).append("\',\'").append(users.get(i).getPassword()).append("\')");
            }
            stringBuilder.append(";");
            return stringBuilder.toString();
        }
    }
}
