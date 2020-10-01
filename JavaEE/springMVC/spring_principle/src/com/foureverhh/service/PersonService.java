package com.foureverhh.service;

import com.foureverhh.pojo.one_to_one.Person;

import java.util.List;

public interface PersonService {
    List<Person> selectPersons();
    List<Person> selectAll();
}
