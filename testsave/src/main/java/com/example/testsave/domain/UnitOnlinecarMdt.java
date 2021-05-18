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
package com.example.testsave.domain;


import lombok.Data;

/**
 * 网约车车辆终端基础信息实体类
 *
 * @author Blade
 * @since 2020-07-29
 */
@Data

public class UnitOnlinecarMdt {

    private static final long serialVersionUID = 1L;

    /**
     * id编号
     */

    private Long id;
    /**
     * 终端编号
     */

    private Long mdtid;
    /**
     * 电话号码
     */

    private String phoneNo;
    /**
     * 正在使用
     */

    private Boolean inUse;
    /**
     * 前置机编号
     */

    private Integer gatewayId;
    /**
     * esn信息
     */

    private Integer esn;
    /**
     * 终端类型
     */

    private String type;
    /**
     * 模块
     */

    private String module;
    /**
     * IP地址
     */

    private String mac;
    /**
     * 备注
     */

    private String remark;
    /**
     * 协议版本号
     */

    private String protocalversion;
    /**
     * ic卡号
     */

    private Integer iccid;
    /**
     * 组标识
     */

    private Long groupId;
    /**
     * 终端版本
     */

    private String firmware;
    /**
     * 通道数量
     */

    private Integer channelNo;
    /**
     * 通道号,逗号分隔:车内前排,车外前方,车内后排,行李舱,驾驶员行为分析
     */

    private String ways;


}
