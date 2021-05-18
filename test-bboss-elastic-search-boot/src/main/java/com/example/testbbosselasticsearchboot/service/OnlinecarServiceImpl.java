package com.example.testbbosselasticsearchboot.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.testbbosselasticsearchboot.dao.CreateOnlineCarIndex;
import com.example.testbbosselasticsearchboot.dao.OnlineCarIndexNameDao;
import com.example.testbbosselasticsearchboot.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;


import java.util.*;

/**
 * @Description:
 * @author: fengyufeng
 * @since: 2020/9/9
 */
@Service
@Slf4j
public class OnlinecarServiceImpl implements IOnlinecarService {

    private static final String KEY_ONLINECAR_COMPANY = "company";
    private static final String KEY_ONLINECAR_DRIVER = "driver";
    private static final String KEY_ONLINE_CAR = "car";
    private static final String KEY_ONLINECAR_MDT = "mdt";
    private static final String KEY_ONLINECAR_CARLOG = "carlog";


    @Autowired
    private CreateOnlineCarIndex createOnlineCarIndex;
//    @Autowired
//    private RestTemplate restTemplate;


    @Override
    public void processBaseData(String flag, JSONArray jsonArray) {
        if (jsonArray == null) {
            return;
        }

        try {
            if (KEY_ONLINE_CAR.equals(flag)) {
//                log.error("网约车信息：" + jsonArray.size());
                saveOnlinecarCar(jsonArray);
            } else if (KEY_ONLINECAR_MDT.equals(flag)) {
//                log.error("网约车终端设备信息：" + jsonArray.size());
                saveOnlinecarMdt(jsonArray);
            } else if (KEY_ONLINECAR_COMPANY.equals(flag)) {
//                log.error("网约车公司信息：" + jsonArray.size());
                saveOnlinecarCompany(jsonArray);
            } else if (KEY_ONLINECAR_DRIVER.equals(flag)) {
//                log.error("网约车司机信息：" + jsonArray.size());
                saveOnlinecarDriver(jsonArray);
            } else if (KEY_ONLINECAR_CARLOG.equals(flag)) {
//                log.error("网约车轨迹信息::::::::::::::::::" + jsonArray.size());
                saveOnlinecarLog(jsonArray);
            }
        } catch (Exception e) {
            log.error("网约车信息存储错误", e);
        }
    }

    private void saveOnlinecarLog(JSONArray jsonArray) {
        log.error("接入网约车车辆轨迹信息=======================");
        //创建网约车车辆轨迹信息索引
        createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX);
        //es
        ClientInterface clientInterface = ElasticSearchHelper.getRestClientUtil();

        List<UnitOnlinecarCarlog> unitOnlinecarCarlogList = new ArrayList<>();
        List<UnitOnlinecarCarlog> unitOnlinecarCarlogs = JSONObject.parseArray(jsonArray.toJSONString(), UnitOnlinecarCarlog.class);
        log.error("网约车车辆轨迹数量=======================" + unitOnlinecarCarlogs.size());
        int temp = 0;
        System.out.println("size -------------"  + unitOnlinecarCarlogs.size());
        for (UnitOnlinecarCarlog unitOnlinecarCarlog : unitOnlinecarCarlogs) {
            unitOnlinecarCarlogList.add(unitOnlinecarCarlog);
            temp++;
            if (unitOnlinecarCarlogList.size() == 300 || temp >= unitOnlinecarCarlogs.size()) {
                //unitOnlinecarCarlogMapper.batchInsert(unitOnlinecarCarlogList);

                //存储到es
                clientInterface.addDocuments(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX,unitOnlinecarCarlogList);
                System.out.println(clientInterface.addDocuments(OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX,unitOnlinecarCarlogList));
                unitOnlinecarCarlogList.clear();
            }
        }
        System.out.println("---车辆轨迹数据存储成功----");

    }

    private void saveOnlinecarCar(JSONArray jsonArray) {
        log.error("接入网约车车辆信息=======================");
        //创建网约车车辆信息索引、车辆管理信息索引
        createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_INDEX);
        createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.VEHICLE_MANAGER_INDEX);
        //es
        ClientInterface clientInterface = ElasticSearchHelper.getConfigRestClientUtil(OnlineCarIndexNameDao.ESMAPPER_XML_SEARCH);

        List<UnitOnlinecar> unitOnlinecarList = JSONObject.parseArray(jsonArray.toJSONString(), UnitOnlinecar.class);


        //Integer count = unitOnlinecarMapper.selectCount(null);
        Long count = clientInterface.countAll(OnlineCarIndexNameDao.ONLINE_CAR_INDEX);

        if (count != 0) {
            //unitOnlinecarMapper.delete(null);
            //将所有文档删除，通过删除索引再创建索引的方法实现
            clientInterface.deleteByPath(OnlineCarIndexNameDao.ONLINE_CAR_INDEX);
            createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_INDEX);
        }

        List<UnitVehicleManager> unitVehicleManagerList = new ArrayList<>();

        //封装车辆数据
        transformData(unitOnlinecarList, unitVehicleManagerList);

        //List<UnitVehicleManager> unitVehicleManagers = unitVehicleManagerMapper.selectList(new QueryWrapper<UnitVehicleManager>().eq("unit_type_name", "网约车公司"));
        Map<String,Object> map = new HashMap<>();
        map.put("unitTypeName","网约车公司");
        ESDatas<UnitVehicleManager> unitVehicleManagerlist = clientInterface.searchList(OnlineCarIndexNameDao.VEHICLE_MANAGER_INDEX + "/_search", "selectUnitTypeName",map,UnitVehicleManager.class);
        List<UnitVehicleManager> unitVehicleManagers = unitVehicleManagerlist.getDatas();

        if (CollectionUtils.isNotEmpty(unitVehicleManagers)) {
            //List<String> idList = new ArrayList<>();

            //由于mysql转换成es后，原mysql自动增长的id无法使用，改为根据plateno来删除
            Set<String > idList = new HashSet<>();
            for (UnitVehicleManager vehicleManager : unitVehicleManagerList) {
                for (UnitVehicleManager unitVehicleManager : unitVehicleManagers) {
                    if (unitVehicleManager.getPlateNo().equals(vehicleManager.getPlateNo())) {
                        //idList.add(unitVehicleManager.getId().toString());
                        idList.add(unitVehicleManager.getPlateNo());
                        break;
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(idList)) {
                //unitVehicleManagerMapper.deleteBatchIds(idList);
                map.clear();
                for (String str : idList){
                    map.put("plateNo",str);
                    clientInterface.deleteByQuery(OnlineCarIndexNameDao.VEHICLE_MANAGER_INDEX + "/_delete_by_query" , "deletePlateNo" , map);
                }
            }
        }
        log.error("车辆基础信息==========================================================" + unitVehicleManagerList.get(0).toString());
        //unitVehicleManagerMapper.batchInsert(unitVehicleManagerList);
        clientInterface.addDocuments(OnlineCarIndexNameDao.VEHICLE_MANAGER_INDEX,unitVehicleManagerList);
        //unitOnlinecarMapper.batchInsert(unitOnlinecarList);
        clientInterface.addDocuments(OnlineCarIndexNameDao.ONLINE_CAR_INDEX,unitOnlinecarList);

    }

    private void saveOnlinecarCompany(JSONArray jsonArray) {
        //创建信息索引、车辆公司信息索引
        createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.INFO_INDEX);
        createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_COMPANY_INDEX);
        ClientInterface clientInterface = ElasticSearchHelper.getConfigRestClientUtil(OnlineCarIndexNameDao.ESMAPPER_XML_SEARCH);
        //Integer unitInfoCount = unitInfoMapper.selectCount(new QueryWrapper<UnitInfo>().eq("category_type", "26003"));
        Map<String ,Object> map = new HashMap<>();
        map.put("categoryType","26003");
        Long unitInfoCount = clientInterface.count(OnlineCarIndexNameDao.INFO_INDEX , "selectCategoryType" , map);
        //Integer count = unitOnlinecarCompanyMapper.selectCount(null);
        Long count = clientInterface.countAll(OnlineCarIndexNameDao.ONLINE_CAR_COMPANY_INDEX);
        if (count != 0 ){
            //unitOnlinecarCompanyMapper.delete(null);
            clientInterface.deleteByPath(OnlineCarIndexNameDao.ONLINE_CAR_COMPANY_INDEX);
            createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_COMPANY_INDEX);
        }
        if (unitInfoCount != 0) {
            //unitInfoMapper.delete(new QueryWrapper<UnitInfo>().eq("category_type", "26003"));
            clientInterface.deleteByQuery(OnlineCarIndexNameDao.INFO_INDEX + "/_delete_by_query" , "selectCategoryType" , map);
        }

        List<UnitOnlinecarCompany> unitOnlinecarCompanys = JSONObject.parseArray(jsonArray.toJSONString(), UnitOnlinecarCompany.class);

        if (CollectionUtils.isNotEmpty(unitOnlinecarCompanys)) {
            List<UnitInfo> unitInfoList = new ArrayList<>();
            List<UnitOnlinecarCompany> unitOnlinecarCompanyList = new ArrayList<>();
            //将api返回数据转换成自己的数据

            for (UnitOnlinecarCompany unitOnlinecarCompany : unitOnlinecarCompanys) {
                UnitInfo unitInfo = new UnitInfo();
                //公司的id
//                unitInfo.setId(unitOnlinecarCompany.getId());

                //公司名称
                if (unitOnlinecarCompany.getName() != null && !"".equals(unitOnlinecarCompany.getName())) {
                    unitInfo.setUnitName(unitOnlinecarCompany.getName());
                }
                //类别(统一都是网约车服务商)
                unitInfo.setCategoryType("26003");
                //创建时间
                unitInfo.setCreateTime(Calendar.getInstance().getTime());
                unitInfoList.add(unitInfo);
                unitOnlinecarCompanyList.add(unitOnlinecarCompany);
            }

            //批量保存到公司基础数据表
            //unitInfoMapper.batchInsert(unitInfoList);
            clientInterface.addDocuments(OnlineCarIndexNameDao.INFO_INDEX,unitInfoList);
            //unitOnlinecarCompanyMapper.batchInsert(unitOnlinecarCompanyList);
            clientInterface.addDocuments(OnlineCarIndexNameDao.ONLINE_CAR_COMPANY_INDEX,unitOnlinecarCompanyList);
        }

    }

    private void saveOnlinecarMdt(JSONArray jsonArray) {
        createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_MDT_INDEX);
        //Integer count = unitOnlinecarMdtMapper.selectCount(null);
        ClientInterface clientInterface = ElasticSearchHelper.getRestClientUtil();
        Long count = clientInterface.countAll(OnlineCarIndexNameDao.ONLINE_CAR_MDT_INDEX);
        if (count != 0) {
            //unitOnlinecarMdtMapper.delete(null);
            clientInterface.deleteByPath(OnlineCarIndexNameDao.ONLINE_CAR_MDT_INDEX);
            createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_MDT_INDEX);
        }
        List<UnitOnlinecarMdt> unitOnlinecarMdtList = JSONObject.parseArray(jsonArray.toJSONString(), UnitOnlinecarMdt.class);

        //unitOnlinecarMdtMapper.batchInsert(unitOnlinecarMdtList);
        clientInterface.addDocuments(OnlineCarIndexNameDao.ONLINE_CAR_MDT_INDEX,unitOnlinecarMdtList);

    }

    private void saveOnlinecarDriver(JSONArray jsonArray) {
        log.error("接入网约车车辆司机信息=======================");
        createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_DRIVER_INDEX);
        //查询表中是否有数据,先清空重新添加
        //int count = unitOnlinecarDriverMapper.selectCount(null);
        ClientInterface clientInterface = ElasticSearchHelper.getRestClientUtil();
        Long count = clientInterface.countAll(OnlineCarIndexNameDao.ONLINE_CAR_DRIVER_INDEX);
        if (count != 0) {
            //unitOnlinecarDriverMapper.delete(null);
            clientInterface.deleteByPath(OnlineCarIndexNameDao.ONLINE_CAR_DRIVER_INDEX);
            createOnlineCarIndex.createIndex(OnlineCarIndexNameDao.ONLINE_CAR_DRIVER_INDEX);
        }
        List<UnitOnlinecarDriver> unitOnlinecarDriverList = JSONObject.parseArray(jsonArray.toJSONString(), UnitOnlinecarDriver.class);

        if (CollectionUtils.isNotEmpty(unitOnlinecarDriverList)) {
            //unitOnlinecarDriverMapper.batchInsert(unitOnlinecarDriverList);
            clientInterface.addDocuments(OnlineCarIndexNameDao.ONLINE_CAR_DRIVER_INDEX,unitOnlinecarDriverList);
        }

    }


    /**
     * 将厂家返回的数据转换成自己的数据
     *
     * @param unitOnlinecars
     * @param unitVehicleManagerList
     */
    private void transformData(List<UnitOnlinecar> unitOnlinecars, List<UnitVehicleManager> unitVehicleManagerList) {



    }



    /**
     * 查询字典
     *
     * @param kinds
     * @return
     */


}
