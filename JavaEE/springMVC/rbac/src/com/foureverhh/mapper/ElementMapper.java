package com.foureverhh.mapper;

import com.foureverhh.pojo.Element;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ElementMapper {
    @Select("select * from element where id in (select eid from role_element where rid = #{param1})")
    List<Element> selByRid(int id);
}
