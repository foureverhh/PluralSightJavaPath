package com.foureverhh.service.impl;

import com.foureverhh.mapper.one_to_one.PersonMapper;
import com.foureverhh.pojo.one_to_one.Person;
import com.foureverhh.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonMapper personMapper;

    public PersonMapper getPersonMapper() {
        return personMapper;
    }

    public void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Override
    public List<Person> selectPersons() {
        return personMapper.selectPersons();
    }

    @Override
    public List<Person> selectAll() {
        return personMapper.selectAll();
    }
}
