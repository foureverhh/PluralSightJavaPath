package com.foureverhh.service;

import com.foureverhh.pojo.one_to_one.PersonCard;

import java.util.List;

public interface PersonCardService {
    List<PersonCard> selectPersonCardByPerson(int personId);
}
