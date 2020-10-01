package com.foureverhh.mapper;

import com.foureverhh.pojo.Menu;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    @Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "children",many = @Many(select = "selMenuByPid"),column="{u_id=uid,p_id=id}")
    })
    //#{u_id} uid 常量列
    @Select("select *,#{u_id} as uid from menu where id in (select mid from user_menu where uid = #{u_id}) and pid=#{p_id}")
    List<Menu> selMenuByPid(Map<String,Object> param);

}
