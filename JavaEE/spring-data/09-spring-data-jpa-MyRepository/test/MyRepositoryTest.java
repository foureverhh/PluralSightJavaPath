import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/*
*
* JpaSpecificationExecutor接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaSpecificationExecutorTest {

    @Autowired
    private UserDao userDao;

    /*
    * 单条件查询
    * 需求：根据用户姓名查询数据
    * */
    @Test
    public void testQueryByName(){
        //使用lambda创建Specification接口实例
        Specification<User> specification = (root,criteriaQuery,criteriaBuilder)->{
            /*
            * @Predicate 定义了查询条件
            * @Root<User> root：根对象，封装了查询条件从数据库返回的对象
            * @CriteriaQuery<User> criteriaQuery:定义一个基本的查询。一般不使用
            * @CriteriaBuilder :用于创建CriteriaQuery
            * */
            //criteriaQuery = criteriaBuilder.createQuery(User.class);
            //root = criteriaQuery.from(User.class);
            Predicate predicate = criteriaBuilder.like(root.get("name"),"二%");

            return predicate;
        };
        List<User> users = userDao.findAll(specification);
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }


    /*
    * 多条件查询  通过CriteriaBuild.and(Predicates[])的方式实现多条件查询
    * 需求：根据用户姓名和年龄查询数据
    * */
    @Test
    public void testMulti1(){
        Specification<User> specification = (root,query,queryBuild)->{
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(queryBuild.equal(root.get("name"),"二丫"));
            predicates.add(queryBuild.equal(root.get("age"),24));
            //通过CriteriaBuild.and(Predicates[])的方式实现多条件查询
            Predicate[] predicatesArray = new Predicate[predicates.size()];
            return queryBuild.and(predicates.toArray(predicatesArray));
        };
        List<User> users = userDao.findAll(specification);
            for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }

    /*
     * 多条件查询  通过CriteriaBuild.and(predicate1,predicate2,)可变参数的方式实现多条件查询
     * 需求：根据用户姓名和年龄查询数据
     * */
    @Test
    public void testMulti2(){
        Specification<User> specification = (root,query,queryBuild)->{

            //queryBuild.and(queryBuild.equal(root.get("name"),"二丫"),queryBuild.equal(root.get("age"),24),queryBuild.and(predicate1,predicate2)));
            return queryBuild.and(queryBuild.equal(root.get("name"),"二丫"),queryBuild.equal(root.get("age"),24));
        };
        List<User> users = userDao.findAll(specification);
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }

    /*
    *查询二%并分页
    * */
    @Test
    public void testMultiAndPaging(){
        Specification<User> specification = (root,query,queryBuild)-> queryBuild.like(root.get("name"),"二%");
        Pageable pageable = PageRequest.of(0,1);
        Page<User> usersPage = userDao.findAll(specification,pageable);
        List<User> users = usersPage.getContent();
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }

    /*
     *查询二%并排序
     * */
    @Test
    public void testMultiAndSorting(){
        Specification<User> specification = (root,query,queryBuild)-> queryBuild.like(root.get("name"),"二%");
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        List<User> users= userDao.findAll(specification,sort);
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }

    /*
     *查询二%， 分页并排序
     * */
    @Test
    public void testMultiSortingAndPaging(){
        //排序定义
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        //分页定义
        Pageable pageable = PageRequest.of(0,1,sort);
        Pageable pageableNext = pageable.next();


        Specification<User> specification = (root,query,queryBuild)-> queryBuild.like(root.get("name"),"二%");
        Page<User> usersPage= userDao.findAll(specification,pageable);
        Page<User> usersPageNext= userDao.findAll(specification,pageableNext);
        List<User> users = usersPage.getContent();
        List<User> usersNext = usersPageNext.getContent();
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
        for(User user : usersNext){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }
}
