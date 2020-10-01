package com.foureverhh.mapper;

import com.foureverhh.pojo.Files;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FilesMapper {
    @Select("select * from files")
    List<Files> selAllFiles();
/*    @Update("update files set count=count+1 where id=#{id}")
    int updCountById(Files files);*/
    @Update("update files set count=count+1 where id=#{param1}")
    int updCountById(int id);
}
