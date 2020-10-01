package com.foureverhh.mapper.one_to_many;

import com.foureverhh.pojo.one_to_many.Classes;

import java.util.List;

public interface ClassesMapper {
    List<Classes> selectAll();
    List<Classes> selectAllClasses();
}
