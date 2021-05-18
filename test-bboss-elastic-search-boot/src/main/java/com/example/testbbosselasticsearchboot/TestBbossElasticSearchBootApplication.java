package com.example.testbbosselasticsearchboot;

import com.example.testbbosselasticsearchboot.dao.OnlineCarIndexNameDao;
import com.example.testbbosselasticsearchboot.domain.UnitOnlinecarCarlog;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.frameworkset.elasticsearch.entity.MapSearchHit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@SpringBootApplication
public class TestBbossElasticSearchBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBbossElasticSearchBootApplication.class, args);
//        System.out.println(OnlineCarIndexName.ONLINE_CAR_COMPANY_INDEX);
//        System.out.println(OnlineCarIndexName.ONLINE_CAR_LOG_INDEX);
  //      ClientInterface clientInterface = ElasticSearchHelper.getConfigRestClientUtil("esmapper/dsl.xml");
//        System.out.println("count ------------"+clientInterface.countAll("user"));
//        if (clientInterface.countAll("user") != 0 ){
//            clientInterface.deleteByPath("user");
//
//            System.out.println("删除成功" );
//        }
//
//        System.out.println("count ------------"+clientInterface.countAll("user"));
//        List<UnitOnlinecarCarlog> carlogList = new ArrayList<>();
//        for (int i = 0 ; i < 5 ; i ++ ){
//            UnitOnlinecarCarlog unitOnlinecarCarlog = new UnitOnlinecarCarlog("test" + i ,null,null,null
//            ,i,"2021-05-17 09:31:57",i,i,i,"i = " + i ,"xxx",null,1L,1L,"xxx");
//            carlogList.add(unitOnlinecarCarlog);
//        }
//        String  s = clientInterface.addDocuments("nbmd_unit_onlinecar_carlog",carlogList);
//        System.out.println("插入成功！----------" + s);
//        Map<String ,Object> map = new HashMap();
//        map.put("time","2021-05-17 09:31:57");
//        ESDatas<UnitOnlinecarCarlog> carlogList1 = clientInterface.searchList("nbmd_unit_onlinecar_carlog/_search","selectTime" , map , UnitOnlinecarCarlog.class);
//        //System.out.println(clientInterface.deleteByQuery("nbmd_unit_onlinecar_carlog/_delete_by_query", "selectTime", map));
//        List<UnitOnlinecarCarlog> carlogList2 = carlogList1.getDatas();
//        for (UnitOnlinecarCarlog u:carlogList2){
//            System.out.println(u.toString());
//        }
//        System.out.println(OnlineCarIndexNameDao.ONLINE_CAR_MDT_INDEX);
//        System.out.println(clientInterface.count("nbmd_unit_onlinecar_carlog","selectTime" , map));
//        System.out.println(clientInterface.countAll("nbmd_unit_onlinecar_carlog"));
//        List<MapSearchHit> mapSearchHits =  clientInterface.search("nbmd_unit_onlinecar_carlog/_search", "selectTime", map).getSearchHits().getHits();
//        mapSearchHits.forEach(mapSearchHit -> System.out.println(mapSearchHit.getId()));
//        System.out.println();
//        Set<String> strings = new HashSet<>();
//        strings.add("1");
//        strings.add("1");
//        strings.add("1");
//        strings.add("2");
//        System.out.println(strings);
//        for (String s :strings){
//            System.out.println(s);
//        }
//        Map<String ,Object> map1 = new HashMap<>();
//        map1.put("1","1");
//        System.out.println(map1);
//        map1.clear();
//        System.out.println(map1);
//
   }

}
