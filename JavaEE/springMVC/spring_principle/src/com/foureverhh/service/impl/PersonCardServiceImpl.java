package com.foureverhh.service.impl;

import com.foureverhh.mapper.one_to_one.PersonCardMapper;
import com.foureverhh.pojo.one_to_one.PersonCard;
import com.foureverhh.service.PersonCardService;

import java.util.List;

public class PersonCardServiceImpl implements PersonCardService {
    private PersonCardMapper personCardMapper;

    public PersonCardMapper getPersonCardMapper() {
        return personCardMapper;
    }

    public void setPersonCardMapper(PersonCardMapper personCardMapper) {
        this.personCardMapper = personCardMapper;
    }

    @Override
    public List<PersonCard> selectPersonCardByPerson(int personId) {
        return personCardMapper.selectPersonCardByPerson(personId);
    }
}
