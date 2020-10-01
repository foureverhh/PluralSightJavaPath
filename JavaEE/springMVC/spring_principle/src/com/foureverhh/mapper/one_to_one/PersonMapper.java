package com.foureverhh.mapper.one_to_one;

import com.foureverhh.pojo.one_to_one.Person;

import java.util.List;

public interface PersonMapper {
    List<Person> selectPersons();
    List<Person> selectAll();
}
