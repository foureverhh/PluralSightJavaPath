package demo06_again.dao.impl;

import demo06_again.dao.UserDao;
import demo06_again.pojo.User;
import demo06_again.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> list() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> rootEntry = query.from(User.class);
        CriteriaQuery<User> all = query.select(rootEntry);
        TypedQuery<User> allUsers = session.createQuery(all);
        List<User> users = allUsers.getResultList();
        System.out.println(users);
        return users;
    }
}
