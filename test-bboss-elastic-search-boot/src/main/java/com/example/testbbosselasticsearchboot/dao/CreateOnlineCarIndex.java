package com.example.testbbosselasticsearchboot.dao;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.stereotype.Component;

@Component
public class CreateOnlineCarIndex {
    private static final String DAO_XML_PATH = "esmapper/create_online_car_index.xml";

    /**
     * 创建索引
     * @param indexName
     */
    public void createIndex(String indexName){
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil(DAO_XML_PATH);
        boolean exist = clientUtil.existIndice(indexName);
        if(!exist) {
            // 索引不存在，创建

            clientUtil.createIndiceMapping(indexName,indexNameToXmlId(indexName));
            System.out.println("---车辆轨迹索引创建成功----");
        }else {
            System.out.println("---车辆轨迹索引已經存在----");
        }
    }

    /**
     * 根据索引名称，映射相应的esmapper文件查询的id
     * @param indexName
     * @return
     */
    public String  indexNameToXmlId(String indexName){
        switch (indexName){
            case OnlineCarIndexNameDao.INFO_INDEX:return "createNbmdUnitInfoIndex";
            case OnlineCarIndexNameDao.ONLINE_CAR_COMPANY_INDEX:return "createNbmdUnitOnlinecarCompanyIndex";
            case OnlineCarIndexNameDao.ONLINE_CAR_DRIVER_INDEX:return "createNbmdUnitOnlinecarDriveIndex";
            case OnlineCarIndexNameDao.ONLINE_CAR_INDEX:return "createNbmdUnitOnlinecarCarIndex";
            case OnlineCarIndexNameDao.ONLINE_CAR_LOG_INDEX:return "createNbmdUnitOnlinecarCarlogIndex";
            case OnlineCarIndexNameDao.VEHICLE_MANAGER_INDEX:return "createNbmdUnitVehicleManagerIndex";
            case OnlineCarIndexNameDao.ONLINE_CAR_MDT_INDEX:return "createNbmdUnitOnlinecarMdtIndex";
            default:break;
        }
        return "";
    }
}
