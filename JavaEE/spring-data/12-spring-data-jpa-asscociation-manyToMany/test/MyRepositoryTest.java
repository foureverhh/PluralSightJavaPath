import com.foureverhh.dao.CourseDao;
import com.foureverhh.dao.StudentDao;

import com.foureverhh.pojo.Course;
import com.foureverhh.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.relation.Role;


/*
*
* 一对一测试接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyRepositoryTest {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    /*
    * 创建实体
    * */
    @Test
    public void createTest(){
        //创建课程
        Course target = courseDao.findCourseNameIs("C#");
        Course course = new Course();
        if(target == null){
            course.setCourseName("C#");
            courseDao.save(course);
        }else {
            course.setCourseId(target.getCourseId());
            course.setCourseName(target.getCourseName());
            course.setStudents(target.getStudents());
        }
        //System.out.println(course.getCourseId() + ", " + course.getCourseName());
        /*
        Course course = courseDao.findCourseNameIs("java");
        course.getStudents().add(s2);
        int courseId = course.getCourseId();
        System.out.println("java id is: " + courseId);
        Course courseForStudent = new Course();
        courseForStudent.setCourseId(courseId);
        */
        //course.setCourseName("java");

        //创建学生
     /*   Student s1 = new Student();
        s1.setAge(30);
        s1.setName("小王");*/
        Student s2 = new Student();
        s2.setAge(5);
        s2.setName("哮天犬");


        //建立关联
        //s1.setCourse(course);
        //s2.setCourse(courseForStudent);
        //保存
        //studentDao.save(s1);
        course.getStudents().add(s2);
        s2.setCourse(course);
        studentDao.save(s2);
    }

    @Test
    public void findCourseByStudentIdTest2(){
        Student student = studentDao.findById(3).get();
        System.out.println("学生姓名： " + student.getName());
        Course course = student.getCourse();
        System.out.println("学生" + student.getName() + " , enrolled in course " + course.getCourseName());
    }
}
