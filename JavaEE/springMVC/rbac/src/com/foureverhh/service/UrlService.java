package com.foureverhh.service;

import com.foureverhh.pojo.Url;

import java.util.List;

public interface UrlService {
    List<Url> selbyRid(int rid);
    List<Url> showAll();
}
