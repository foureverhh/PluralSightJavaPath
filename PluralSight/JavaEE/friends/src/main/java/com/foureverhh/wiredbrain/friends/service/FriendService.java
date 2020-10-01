package com.foureverhh.wiredbrain.friends.service;

import com.foureverhh.wiredbrain.friends.domain.Friend;
import com.foureverhh.wiredbrain.friends.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class FriendService {
    private FriendRepository friendRepository;
    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Transactional
    public Friend save(Friend friend) {
        friendRepository.save(friend);
        return friend;
    }

    public List<Friend>findAll() {
        Iterable<Friend> friends = friendRepository.findAll();
        List<Friend> target = new ArrayList<>();
        friends.forEach(target::add);
        return target;
    }

    public void deleteById(int id) {
        friendRepository.deleteById(id);
    }

    public Iterable<Friend> findByFirstNameAndLastName(String firstName,String lastName){
        return friendRepository.findByFirstNameAndLastName(firstName,lastName);
    }

  /*  public Friend findById(int id) throws Exception {
        return friendRepository.findById(id).orElseThrow(()->new Exception("user not found"));
    }*/
      public Optional<Friend> findById(int id) {
          return friendRepository.findById(id);
      }

    public Iterable<Friend> findByFistName(String firstName) {
          return friendRepository.findByFirstName(firstName);
    }

    public Iterable<Friend> findByLastName(String lastName) {
          return friendRepository.findByLastName(lastName);
    }
}
