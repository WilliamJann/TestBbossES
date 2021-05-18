package com.example.testsave.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.testsave.domain.OnlinecarLogReq;
import com.example.testsave.service.OnlinecarServiceImpl;

import com.example.testsave.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/test")
@Controller
public class TestController {



    @Autowired
    private OnlinecarServiceImpl onlinecarService;

    @Autowired
    private TestService testService;


    @RequestMapping("/testsavelog")
    @ResponseBody
    public String testlog() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        String[] strings = {"carNo","lon","lat","speed","angle","time","source","soc","socStatus","ip","iccId","mileage","carState","alarmState","certificateId"};
        for (String str : strings){

            if (str.equals("time")){
                jsonObject.put(str,"2021-05-17 09:31:59");
            }else {
                jsonObject.put(str,"9");
            }


        }
        jsonArray.add(jsonObject);
        System.out.println("-----------------------");
        System.out.println(jsonArray);
        System.out.println("-----------------------");
        onlinecarService.processBaseData("carlog",jsonArray);
        return "ok";
    }

    @RequestMapping("/testquerylog")
    @ResponseBody
    public String testquerylog() {
        OnlinecarLogReq onlinecarLogReq = new OnlinecarLogReq();
        onlinecarLogReq.setCarNo("2");
        onlinecarLogReq.setStartTime("2021-05-17 09:31:56");
        onlinecarLogReq.setEndTime("2021-05-17 09:31:57");
        return testService.getOnlineCarLogModels(onlinecarLogReq) == null ? "null": testService.getOnlineCarLogModels(onlinecarLogReq).toString();
    }

    @RequestMapping("/testaggs")
    @ResponseBody
    public String testaggs() {
        List<String> strings = new ArrayList<>();
        strings.add("4");
        strings.add("9");
        strings.add("1");
        return testService.getCarLastResponse(strings) == null ? "null": testService.getCarLastResponse(strings).toString();
    }

}