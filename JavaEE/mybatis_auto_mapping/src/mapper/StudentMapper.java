package mapper;

import org.apache.ibatis.annotations.Select;
import pojo.Student;

import java.util.List;

public interface StudentMapper {
    @Select("select s.id,s.name,age,tid,t.id `teacher.id`,t.name `teacher.name` from student s left join teacher t on s.tid = t.id ")
    List<Student> selAll();
    @Select("select * from student where tid=#{arg0}")
    List<Student> selStudentsByTid(int id);


}
