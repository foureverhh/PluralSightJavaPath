package demo06.dao.impl;

import demo06.dao.UserDao;
import demo06.pojo.User;
import demo06.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> list() {
        TypedQuery<User> allUsers = null;
        try {
            Session session = HibernateUtil.getSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> rootEntry = query.from(User.class);
            CriteriaQuery<User> all = query.select(rootEntry);
            allUsers = session.createQuery(all);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtil.closeSession();
        }
        return allUsers.getResultList();
    }
}
