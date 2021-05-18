/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package com.example.testbbosselasticsearchboot.domain;


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 单位车辆管理实体类
 *
 * @author Blade
 * @since 2020-06-17
 */
@Data

public class UnitVehicleManager {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */

    private Integer id;
    /**
     * 单位类型
     */

    private String unitTypeName;
    /**
     * 单位名称
     */

    private String unitName;
    /**
     * 单位名称编码
     */

    private String unitNameCode;
    /**
     * 单位类型编码
     */

    private String unitTypeCode;
    /**
     * 车牌号码
     */

    private String plateNo;
    /**
     * 车牌颜色
     */

    private String plateColor;
    /**
     * 车辆负责人
     */

    private String vehicleHead;
    /**
     * 负责人联系方式
     */

    private String headCallPhone;
    /**
     * 线路名称
     */

    private String lineName;
    /**
     * 线路标识符
     */

    private String lineId;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 是否删除
     */

    private Integer isDeleted;

    public UnitVehicleManager() {
    }

    public UnitVehicleManager(List<Object> list) {
        this.unitTypeName = String.valueOf(list.get(0));
        this.unitName = String.valueOf(list.get(1));
        this.lineName = String.valueOf(list.get(2));
        this.lineId = String.valueOf(list.get(2));
        this.plateNo = String.valueOf(list.get(3));
        this.vehicleHead = String.valueOf(list.get(5));
        this.headCallPhone = String.valueOf(list.get(6));
        this.isDeleted = 0;
        this.createTime = new Date();
    }
}
