package com.example.testbbosselasticsearchboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.testbbosselasticsearchboot.domain.UnitOnlinecarCarlog;
import com.example.testbbosselasticsearchboot.domain.User;
import com.example.testbbosselasticsearchboot.service.OnlinecarServiceImpl;
import com.example.testbbosselasticsearchboot.service.TestService;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/test")
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private OnlinecarServiceImpl onlinecarService;
    @RequestMapping("/dsl")
    @ResponseBody
    public ESDatas<User> DslTest() {

        Map<String, Object> params = new HashMap<>();
        //设置applicationName1和applicationName2两个变量的值
        params.put("name", "李四");

        ESDatas<User> esDatas = testService.dslOne(params);

        return esDatas;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String InsertTest() {

        Map<String, Object> params = new HashMap<>();
        //设置applicationName1和applicationName2两个变量的值
        params.put("name", "jzp");
        params.put("userId",100);
        params.put("age",22);

        String  esDatas = testService.insertInfo(params);

        return esDatas;
    }
    @RequestMapping("/insert2")
    @ResponseBody
    public String InsertTest2() {

        User user = new User();
        user.setUserId(1001);
        user.setName("pzf");
        user.setAge(99);

        String  esDatas = testService.insertInfo2(user);

        return esDatas;
    }

    @RequestMapping("/insertcar")
    @ResponseBody
    public String InsertTestCar() {
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        if (!clientUtil.existIndice("nbmd_unit_onlinecar_carlog")){
            System.out.println("索引不存在，正在创建");
            testService.createIndex("nbmd_unit_onlinecar_carlog");
            System.out.println("创建成功");
        }else {
            System.out.println("--------索引存在------");
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(date);
        System.out.println("------time str ----" + str);
        Date date1 = null;
        try {
             date1 = dateFormat.parse(str);
            System.out.println("----time date ---" +date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (clientUtil.existIndice("nbmd_unit_onlinecar_carlog")){
            List<UnitOnlinecarCarlog>  list = new ArrayList<>();
            UnitOnlinecarCarlog u = new UnitOnlinecarCarlog("carNo5", null,null,null,
                    1,str,1,1,1,"192.161.1.1","str",null,1L,2L,"ster");
            UnitOnlinecarCarlog u2 = new UnitOnlinecarCarlog("carNo6", null,null,null,
                    1,str,1,1,1,"192.161.1.1","str",null,1L,2L,"ster");
            list.add(u);
            list.add(u2);
            String  st = "";
            System.out.println("-----test1-------");
            st = testService.insertInfoCar(list,"nbmd_unit_onlinecar_carlog");


            return  st;

        }


        return "创建失败！";
    }

    @RequestMapping("/testsavelog")
    @ResponseBody
    public String testlog() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        String[] strings = {"carNo","lon","lat","speed","angle","time","source","soc","socStatus","ip","iccId","mileage","carState","alarmState","certificateId"};
        for (String str : strings){

            if (str.equals("time")){
                jsonObject.put(str,"2021-05-17 09:31:57");
            }else {
                jsonObject.put(str,"1");
            }


        }
        jsonArray.add(jsonObject);
        System.out.println("-----------------------");
        System.out.println(jsonArray);
        System.out.println("-----------------------");
        onlinecarService.processBaseData("carlog",jsonArray);
        return "ok";
    }
}