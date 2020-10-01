package com.foureverhh.mapper.one_to_many;

import com.foureverhh.pojo.one_to_many.Students;

import java.util.List;

public interface StudentsMapper {
    List<Students> selectAllStudents();
    List<Students> selectStudentsByClass(int clsId);
}
