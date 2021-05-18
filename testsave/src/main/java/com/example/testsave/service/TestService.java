package com.example.testsave.service;

import com.example.testsave.dao.OnlineCarIndexNameDao;
import com.example.testsave.domain.OnlineCarLogModel;
import com.example.testsave.domain.OnlinecarLogReq;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TestService {
    private static String QUERY_SEARCH = "esmapper/onlineCarQuery.xml";
    //private static ClientInterface clientInterface = ElasticSearchHelper.getConfigRestClientUtil(QUERY_SEARCH);
    public List<OnlineCarLogModel> getOnlineCarLogModels(OnlinecarLogReq onlinecarLogReq){
        return ElasticSearchHelper.getConfigRestClientUtil(QUERY_SEARCH)
                .searchList(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX + "/_search" , "getOnlineCarLog",onlinecarLogReq,OnlineCarLogModel.class)
                .getDatas();
    }
    public List<Map<String,Object>> getMaxTimeGroupByCarNo(List<String> carNos){
        ClientInterface clientInterface = ElasticSearchHelper.getConfigRestClientUtil(QUERY_SEARCH);
        Map<String,Object> map = new HashMap<>();
        map.put("carNos",carNos);
        ESDatas<Map> esDatas = clientInterface.searchList(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX + "/_search" , "getMaxTimeGroupByCarNo",map,Map.class);
        List<Map> map1= esDatas.getDatas();
        return esDatas.getAggregationBuckets("terms");
    }

    public List<OnlineCarLogModel> getInfoByMaxTimeAndCarNo(List<Map<String,Object>> mapList){
        Map<String,Object> map = new HashMap<>();
        map.put("maps",mapList);
        ClientInterface clientInterface = ElasticSearchHelper.getConfigRestClientUtil(QUERY_SEARCH);
        ESDatas<OnlineCarLogModel> esDatas = clientInterface.searchList(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX + "/_search" , "getInfoByMaxTimeAndCarNo",map,OnlineCarLogModel.class);
        return esDatas.getDatas();
    }
    public List<OnlineCarLogModel> getCarLastResponse(List<String> carNos){
        Map<String,Object> carNosmap = new HashMap<>();
        carNosmap.put("carNos",carNos);
        Map<String,Object> map = new HashMap<>();
        map.put("maps",ElasticSearchHelper.getConfigRestClientUtil(QUERY_SEARCH).searchList(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX + "/_search" , "getMaxTimeGroupByCarNo",carNosmap,Map.class).getAggregationBuckets("terms"));
        return ElasticSearchHelper.getConfigRestClientUtil(QUERY_SEARCH).searchList(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX + "/_search" , "getInfoByMaxTimeAndCarNo",map,OnlineCarLogModel.class).getDatas();
    }
}
