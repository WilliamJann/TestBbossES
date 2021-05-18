package com.example.testbbosselasticsearchboot.service;

import com.example.testbbosselasticsearchboot.domain.UnitOnlinecarCarlog;
import com.example.testbbosselasticsearchboot.domain.User;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TestService {

    /**
     * 创建加载配置文件的客户端工具，用来检索文档，单实例多线程安全
     */
    ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/dsl.xml");
    ClientInterface clientUtil2 = ElasticSearchHelper.getConfigRestClientUtil("esmapper/online_car.xml");
    public ESDatas<User> dslOne(Map<String, Object> params) {

        /**
         *执行查询，demo为索引表，_search为检索操作action
         * ESDatas包含当前检索的记录集合，最多10条记录，由dsl中的size属性指定
         * demo为索引表，_search为检索操作action
         * @param searchDatas esmapper/demo.xml中定义的dsl语句
         * @param params 变量参数
         * @param Demo.class  返回的文档封装对象类型
         */
        boolean flag = clientUtil.existIndice("user");
        if (flag){
            System.out.println("user exist");
        }else {
            System.out.println("user not exist");
        }
        boolean flag1 = clientUtil.existIndice("jjjj");
        if (flag1){
            System.out.println("jjjj exist");
        }else {
            System.out.println("jjjj not exist");
        }
        ESDatas<User> esDatas = clientUtil.searchList("user/_search", "scriptDsl", params, User.class);

        return esDatas;
    }
    public String insertInfo(Map<String, Object> params) {


        String  esDatas = clientUtil.addDocument("user/_doc", "insertInfo", params);

        return esDatas;
    }
    public String insertInfo2(User user) {


        String  esDatas = clientUtil.addDocument("user/_doc", "insertInfo", user);

        return esDatas;
    }

    public String createIndex(String indexName){
        String str = clientUtil2.createIndiceMapping(indexName,"createNbmdUnitOnlinecarCarlogIndex");
        return str;
    }
    public String insertInfoCar(List<UnitOnlinecarCarlog> unitOnlinecarCarlog, String indexName) {

        ClientInterface clientInterface = ElasticSearchHelper.getRestClientUtil();
        String  esDatas = clientInterface.addDocuments(indexName ,  unitOnlinecarCarlog);
        return esDatas;
    }





}