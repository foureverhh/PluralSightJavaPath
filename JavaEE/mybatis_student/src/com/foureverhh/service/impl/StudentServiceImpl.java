package com.foureverhh.service.impl;

import com.foureverhh.mapper.StudentMapper;
import com.foureverhh.mapper.TeacherMapper;
import com.foureverhh.mybatisUtil.MybatisUtil;
import com.foureverhh.pojo.PageInfo;
import com.foureverhh.pojo.Student;
import com.foureverhh.pojo.Teacher;
import com.foureverhh.service.StudentService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public PageInfo showPage(String sName, String tName, String pageSizeStr, String pageNumberStr) {
        int pageNumber,pageSize;
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        if(pageNumberStr != null && !pageNumberStr.equals("")) {
            pageNumber = Integer.parseInt(pageNumberStr.trim());
        }else {
            pageNumber = 1;
        }
        if(pageSizeStr != null && !pageSizeStr.equals("")) {
            pageSize = Integer.parseInt(pageSizeStr.trim());
        }else {
            pageSize = 2;
        }
        //System.out.println("service pageSize -> " + pageSize + ",pageNumber ->" + pageNumber + ",pageStart -> " + (pageNumber-1)*pageSize);
        PageInfo pageInfo = new PageInfo();
        //int pageStart = (pageNumber-1)*pageSize;
        //System.out.println("pageStart-> " + pageStart);
        pageInfo.setPageStart((pageNumber-1)*pageSize);
        //System.out.println("pageInfo.getPageStart()->" + pageInfo.getPageStart() );
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setsName(sName);
        pageInfo.settName(tName);
        System.out.println("service pageInfo -> " + pageInfo );
        List<Student> currentInfo = studentMapper.selByPage(pageInfo);
        //查出每个学生对应的老师
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        for(Student student :currentInfo){
            Teacher teacher = teacherMapper.selById(student.getTid());
            student.setTeacher(teacher);
        }
        pageInfo.setCurrentInfo(currentInfo);
        long allPages = studentMapper.selCountByPageInfo(pageInfo);
        pageInfo.setTotal((long)Math.ceil(allPages/pageSize));
        return pageInfo;
    }
}
