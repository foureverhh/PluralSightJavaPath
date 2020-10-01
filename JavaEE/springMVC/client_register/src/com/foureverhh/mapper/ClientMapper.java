package com.foureverhh.mapper;

import com.foureverhh.pojo.Client;
import org.apache.ibatis.annotations.Insert;

public interface ClientMapper {
    @Insert("insert into client values (default, #{username},#{password},#{photo})")
    int insertClient(Client client);


}
