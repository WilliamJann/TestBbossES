package com.example.testbbosselasticsearchboot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.testbbosselasticsearchboot.service.IOnlinecarService;
import com.example.testbbosselasticsearchboot.service.OnlinecarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSave {

    public static void main(String[] args) {
        //测试1
        IOnlinecarService iOnlinecarService = new OnlinecarServiceImpl();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;
        String[] strings = {"carNo","lon","lat","speed","angle","time","source","soc","socStatus","ip","iccId","mileage","carState","alarmState","certificateId"};
        for (String str : strings){
            jsonObject = new JSONObject();
            jsonObject.put(str,"1");
            jsonArray.add(jsonObject);
        }
        //iOnlinecarService.saveOnlinecarLog
    }
}
