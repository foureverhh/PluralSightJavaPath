package com.foureverhh.mapper;

import com.foureverhh.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Results(value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            //@Many等同于<collection>
            @Result(property = "menus",many = @Many(select = "com.foureverhh.mapper.MenuMapper.selMenuByPid"),column = "{u_id=id,p_id=pid}")
    })
    //如果需要传递多个参数column={prop1=col1,prop2=col2}，他们会被mybatis存在一个map中
    //这样另一个查询中会获取传递过来的参数#{prop1} #{prop2}
    //而且方法中public void selxxxxx(Map<String,Object> map){};
    @Select("select *, 0 as pid from user where username = #{username} and password = #{password}")
    User selByUser(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    User selUser(User user);
}
