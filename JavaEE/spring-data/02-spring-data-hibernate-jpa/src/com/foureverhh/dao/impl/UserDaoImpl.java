package com.foureverhh.dao.impl;

import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.List;
//spring会实例化
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insertUser(User user) {
        hibernateTemplate.save(user);
    }

    @Override
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    public void deleteUser(User user) {
         hibernateTemplate.delete(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return hibernateTemplate.get(User.class,id);
    }

    @Override
    public List<User> selectUserByName(String name) {
        //getCurrentSession():当前session必须有事务边界，且只能处理唯一的一个事务。当事务提交或者回滚后session自动失效
        //getSession()：每次都会打开一个新的session，假如每次使用多次。则会获得不同的session对象，每次使用完毕必须手动调用close（）方法关闭
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from User where name = :queryName");
        query.setParameter("queryName",name);
        List<User> users = query.list();
        return users;
    }

    @Override
    public List<User> selectUserByNameInSql(String name) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query<User> query = session.createSQLQuery("select * from t_user where user_name = :queryName")
                                    .setParameter("queryName",name)
                                    .addEntity(User.class);
        return query.list();
    }

    @Override
    public List<User> selectUserByNameInByCriteria(String name) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        //等同于sql select * from t_user
        Criteria criteria = session.createCriteria(User.class);
        //等同于 where user_name = name
        criteria.add(Restrictions.eq("name",name));

        return criteria.list();
    }
}
