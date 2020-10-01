package test;

import mapper.StudentMapper;
import mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;
import pojo.Teacher;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        System.out.println();

        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selAll();
        for (Student s: students) {
            System.out.println(s);
        }
        System.out.println("------------------------------");
        List<Teacher> teachers = teacherMapper.selAll();
        for (Teacher t: teachers) {
            System.out.println(t);
        }
        System.out.println();
        session.commit();
        session.close();

    }
}
