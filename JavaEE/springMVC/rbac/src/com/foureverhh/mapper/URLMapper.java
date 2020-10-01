package com.foureverhh.mapper;

import com.foureverhh.pojo.Url;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface URLMapper {
    @Select("select * from url u left join role_url ru on u.id = ru.uid where ru.rid = #{param1} ")
    List<Url> selByRid(int rid);
    //查询全部
    @Select("select * from url")
    List<Url> selAll();
}
