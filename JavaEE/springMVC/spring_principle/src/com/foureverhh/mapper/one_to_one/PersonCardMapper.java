package com.foureverhh.mapper.one_to_one;

import com.foureverhh.pojo.one_to_one.PersonCard;

import java.util.List;

public interface PersonCardMapper {
    List<PersonCard> selectPersonCardByPerson(int personId);
}
