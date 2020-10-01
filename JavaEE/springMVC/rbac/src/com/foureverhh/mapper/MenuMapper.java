package com.foureverhh.mapper;

import com.foureverhh.pojo.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
  /*  @Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "children",many = @Many(select = "selMenuByPid"),column="{u_id=uid,p_id=id}")
    })
    //#{u_id} uid 常量列
    @Select("select *,#{u_id} as uid from menu where id in (select mid from role_menu where rid in (select id from role where id = #{u_id})) and pid=#{p_id}")
    List<Menu> selMenuByPid(Map<String, Object> param);*/

   /* @Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "children",many = @Many(select = "selMenuPid"),column="{id}")
    })
    @Select("select * from menu where pid = {param1}")
    List<Menu> selMenuPid(int pid);
*/


/*
    @Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "children",many = @Many(select = "selMenuByRid"),column="{rid=r_id,pid=id}")
    })
   @Select("select *,#{param1} as r_id from menu where id in (select mid from role_menu where rid = #{param1}) and pid = #{param2}")
   //@Select(" select * from menu where pid in (select id from menu where id in (select mid from role_menu where rid = #{param1}))")
    List<Menu> selMenuByRid(int rid,int pid);*/
    List<Menu> selMenuByRid(@Param("rid") int rid,@Param("pid") int pid);

}
