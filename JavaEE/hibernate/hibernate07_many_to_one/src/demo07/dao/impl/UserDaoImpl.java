package demo07.dao.impl;

import demo07.dao.UserDao;
import demo07.pojo.User;
import demo07.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> list() {

        List<User> users = null;
        try {
            Session session = HibernateUtil.getSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> rootEntry = query.from(User.class);
            CriteriaQuery<User> all = query.select(rootEntry);
            TypedQuery<User> allUsers = session.createQuery(all);
            users = allUsers.getResultList();
            System.out.println(users);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtil.closeSession();
        }
        return users;
    }
}
