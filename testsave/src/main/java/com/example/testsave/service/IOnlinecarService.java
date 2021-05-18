package com.example.testsave.service;

import com.alibaba.fastjson.JSONArray;

/**
 * @Description:
 * @author: fengyufeng
 * @since: 2020/9/9
 */
public interface IOnlinecarService {

    /**
     * 处理网约车数据
     * @return
     */
    void processBaseData(String flag, JSONArray jsonArray);

}
