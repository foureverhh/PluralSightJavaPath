package service;

import model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


public class DBBaseService {


    public List<User> retrieveAllUser(EntityManager manager){
        TypedQuery<User> usersQuery = manager.createQuery("select u from User u ",User.class);
        return usersQuery.getResultList();
    }
}
