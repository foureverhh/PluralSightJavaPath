package view;

import model.User;
import service.DBBaseService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
public class UserBean {
    private String firstName;
    private String lastName;
    private String password;
    private List<User> users;
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jsfJpa");
 /*   @PersistenceContext(unitName = "jsf_jpa")*/
    private EntityManager manager = factory.createEntityManager();
    private DBBaseService DBBaseService = new DBBaseService();

    public UserBean() {
       // users = retrieveAllUsers(manager);
    }

    private List<User> retrieveAllUsers(EntityManager manager) {
        return DBBaseService.retrieveAllUser(manager);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
