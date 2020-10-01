package com.foureverhh.mapper;

import com.foureverhh.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> selByPid(int pid);
}
