import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.ArrayList;
import java.util.List;

/*
*
* Repository接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PagingAndSortingRepositoryTest {

    @Autowired
    private UserDao userDao;

    /*
    * 分页处理
    * */
    @Test
    public void testPaging(){
        //page为检索的索引，从0开始
        int page = 0;
        int size = 3;
        Pageable pageable = PageRequest.of(page,size);
        Page<User> pages = userDao.findAll(pageable);
        System.out.println("数据的总条数："+pages.getTotalElements());
        System.out.println("数据的总页数："+pages.getTotalPages());
        System.out.println("当前页面索引:"+pages.getNumber());
        System.out.println("每页的size："+pages.getNumberOfElements());
        List<User> list = pages.getContent();
        for(User user : list){
            System.out.println(user.getId() + ", " + user.getName());
        }
    }

    //单个order
    @Test
    public void testSorting1(){
        //Sort:封装了排序规则以及指定的排序字段（使用对象的属性来表示）
        //new Sort(direction,properties)
        //direction：排序规则
        //properties: 排序的字段（用属性表示）
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        List<User> users = (List<User>)userDao.findAll(sort);
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName());
        }
    }

    //多个order
    @Test
    public void testSorting2(){
        //Sort:封装了排序规则以及指定的排序字段（使用对象的属性来表示）
        //new Sort(direction,properties)
        //direction：排序规则
        //properties: 排序的字段（用属性表示）
        Sort.Order ageOrder = new Sort.Order(Sort.Direction.DESC,"age");
        Sort.Order nameOrder = new Sort.Order(Sort.Direction.ASC,"name");
        Sort sort = Sort.by(ageOrder,nameOrder);
        List<User> users = (List<User>)userDao.findAll(sort);
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }
}
