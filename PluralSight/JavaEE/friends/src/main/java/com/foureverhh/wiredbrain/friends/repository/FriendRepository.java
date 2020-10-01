package com.foureverhh.wiredbrain.friends.repository;

import com.foureverhh.wiredbrain.friends.domain.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Integer> {
    Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);
    Iterable<Friend>findByFirstName(String firstName);
    Iterable<Friend> findByLastName(String lastName);
}
