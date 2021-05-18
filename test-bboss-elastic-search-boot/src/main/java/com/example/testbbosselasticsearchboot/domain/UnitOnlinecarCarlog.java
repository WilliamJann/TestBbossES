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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;

/**
 * 网约车历史车辆轨迹实体类
 *
 * @author Blade
 * @since 2020-09-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitOnlinecarCarlog {

    private static final long serialVersionUID = 1L;




    private String carNo;
    /**
     * 经度
     */

    private BigDecimal lon;
    /**
     * 纬度
     */

    private BigDecimal lat;
    /**
     * 速度
     */

    private BigDecimal speed;
    /**
     * 方向
     */

    private Integer angle;
    /**
     * 时间
     */


    private String  time;
    /**
     * 传送标识 0实时上传 1补传
     */

    private Integer source;
    /**
     * 电量
     */

    private Integer soc;
    /**
     * 充电状态
     */

    private Integer socStatus;
    /**
     * 终端IP
     */

    private String ip;
    /**
     * IC卡号
     */

    private String iccId;
    /**
     * 当前电量可行驶里程 km
     */

    private BigDecimal mileage;
    /**
     * 状态位
     */

    private Long carState;
    /**
     * 报警位
     */

    private Long alarmState;
    /**
     * 司机从业资格证号
     */

    private String certificateId;


}
