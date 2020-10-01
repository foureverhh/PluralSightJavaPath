import demo23.pojo.Clz;
import demo23.pojo.Student;
import demo23.pojo.User;
import demo23.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;

import java.util.List;


public class Test {
    Session session = null;
    @Before
    public void setup(){
        session = HibernateUtil.getSession();
    }

    @After
    public void teardown(){
        HibernateUtil.closeSession();
    }

    @org.junit.Test
    public void initDB(){
        Transaction tx = session.beginTransaction();
        try{
            User u1 = new User();
            User u2 = new User();
            User u3 = new User();
            User u4 = new User();
            u1.setName("张三");
            u2.setName("李四");
            u3.setName("王五");
            u4.setName("赵六");
            u1.setAge(12);
            u2.setAge(23);
            u3.setAge(33);
            u4.setAge(45);
            session.save(u1);
            session.save(u2);
            session.save(u3);
            session.save(u4);
            Clz c1 = new Clz();
            c1.setName("208");
            c1.setAddress("B-2");
            Clz c2 = new Clz();
            c2.setName("301");
            c2.setAddress("B-3");
            session.save(c1);
            session.save(c2);
            Student s1 = new Student();
            s1.setName("张三");
            s1.setAge(23);
            s1.setSex("男");
            //设置学生的外键，如果不设置则没有外键值
            s1.setClz(c1);
            Student s2 = new Student();
            s2.setName("李四");
            s2.setAge(22);
            s2.setSex("男");
            s2.setClz(c2);
            Student s3 = new Student();
            s3.setName("王小蒙");
            s3.setAge(20);
            s3.setSex("女");
            s3.setClz(c1);
            session.save(s1);
            session.save(s2);
            session.save(s3);
           tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    @org.junit.Test
    public void testFindAll(){
        Transaction tx = session.beginTransaction();
        try{
            List<User> users = session.createCriteria(User.class).list();
            System.out.println(users.size());
            for (User u: users) {
                System.out.println(u.getName() + ", " + u.getAge());
            }
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    @org.junit.Test
    public void queryCondition(){
        List<User> users = session.createCriteria(User.class).add(Restrictions.gt("age",30)).list();
        for (User u: users) {
            System.out.println(u.getName() + ", " + u.getAge());
        }
    }

    @org.junit.Test
    public void testAnd(){
        List<User> users = session.createCriteria(User.class)
                .add(Restrictions
                        .and(Restrictions
                                .like("name","王%"),
                                Restrictions
                                        .ge("age",30)))
                .list();
        for (User u: users) {
            System.out.println(u.getName() + ", " + u.getAge());
        }
    }
    //带参数的条件查询
    @org.junit.Test
    public void testCondition2() {
        String hql = "from User where age > :queryAge";
        List<User> users = session.createQuery(hql).setParameter("queryAge",25).list();
        for (User u: users) {
            System.out.println(u.getName() + ", " + u.getAge());
        }
    }

    //查询指定列
    @org.junit.Test
    public void testColumn(){
        String hql = "select u.name, u.age from User u";
        List<Object[]> users = session.createQuery(hql).list();
        for(Object[] u : users){
            System.out.println(u[0] + " " + u[1]);
        }
    }

    //查询指定列
    @org.junit.Test
    public void testColumn2Object(){
        String hql = "select new User(u.name, u.age) from User u where u.age > :age";
        List<User> users = session.createQuery(hql).setParameter("age",25).list();
        for(User u : users){
            System.out.println(u.getName() + " " + u.getAge());
        }
    }

    //模糊查询
    @org.junit.Test
    public void testLike(){
        String hql = "from User u where u.name like :name";
        List<User> users = session.createQuery(hql).setParameter("name",'%'+"三"+'%').list();
        for(User u : users){
            System.out.println(u.getName() + " " + u.getAge());
        }
    }

    //unique result,结果只有一个或者为null，才可以使用
    @org.junit.Test
    public void testUnique(){
        String hql = "from User u where u.name like :name";
        User u = (User) session.createQuery(hql).setParameter("name","张三%").uniqueResult();
        System.out.println(u.getName() + " " + u.getAge());
    }

    //聚合函数查询,返回的count为long，使用uniqueResult（）
    @org.junit.Test
    public void testCount(){
        String hql = "select count(u.id) from User u";
        Long size =(Long) session.createQuery(hql).uniqueResult();
        System.out.println(size);
    }

    //分页操作
    @org.junit.Test
    public void testPage(){
        String hql = "from User";

        List<User> users = session.createQuery(hql)
                //(currentPage -1) * pageSize
                .setFirstResult(2)
                //pageSize
                .setMaxResults(2)
                .list();
        for(User u : users){
            System.out.println(u.getName() + " " + u.getAge());
        }
    }

    //排序 order by
    @org.junit.Test
    public void testOrder(){
        String hql  = "from User u order by u.age asc";
        List<User> users = session.createQuery(hql).list();
        for(User u : users){
            System.out.println(u.getName() + " " + u.getAge());
        }
    }

    //in
    @org.junit.Test
    public void testIn(){
        String hql = "from User u where u.id in (:myIds)";
        Integer[] ids = new Integer[]{2,3,5};
        List<User> users = session.createQuery(hql)
                           .setParameterList("myIds", ids)
                           .list();
        for(User u : users){
            System.out.println(u.getName() + " " + u.getAge());
        }
    }

    //可以直接使用类信息
    @org.junit.Test
    public void testJoin(){
        String hql = "from Student s where s.clz.name = :clzName";
        List<Student> students = session.createQuery(hql).setParameter("clzName","208").list();
        for (Student s: students) {
            System.out.println(s.getAge() + ",clz name " + s.getClz().getName() + ",name: " + s.getName() );
        }
    }

    //left join
    @org.junit.Test
    public void leftJoin(){
        String hql = "select count(s.id) from Student s left join Clz c on c.name = s.clz.name where c.name = :clzName";
        Long size = (Long)session.createQuery(hql).setParameter("clzName","208").uniqueResult();
        System.out.println(size);
    }
}
