package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> selAll();
    @Insert("insert into teacher values (default,#{name})")
    int insertTeacher(Teacher t);
    @Update("update teacher set name=#{name} where id=#{id}")
    int updateTeacher(Teacher t);
    @Delete("delete from teacher where id=#{arg0}")
    int deleteById(int id);
    @Results(value = {
            @Result(column = "id",id = true,property = "id"),
            @Result(column = "name",property = "name"),
            @Result(property = "students", column = "id",many = @Many(select = "mapper.StudentMapper.selStudentsByTid"))})
    @Select("select * from teacher ")
    List<Teacher> selTeacher();
    List<Teacher> selAll2();
}
