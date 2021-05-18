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
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * 网约车车辆信息实体类
 *
 * @author Blade
 * @since 2020-07-29
 */

@ToString
@Data
public class UnitOnlinecar {

	private static final long serialVersionUID = 1L;


	private Long id;
	/**
	* 公司编号
	*/

	private Long companyId;
	/**
	* 车牌
	*/

	private String carNo;
	/**
	* 真实车牌
	*/

	private String realCarNo;
	/**
	* 车架号
	*/

	private String vehicleIdentificationNumber;
	/**
	* 颜色。[1,蓝色][2,黄'][3,黑色][4,白色][9,其他]
	*/
//		@ApiModelProperty(value = "颜色。[1,蓝色][2,黄'][3,黑色][4,白色][9,其他]")
		private String color;
	/**
	* 经营许可证号
	*/

	private String certificateId;
	/**
	* 年审有效起始日期
	*/

	private LocalDate carefulTime;
	/**
	* 投保日期
	*/

	private LocalDate insuranceTime;
	/**
	* 公司名称
	*/

	private String companyName;
	/**
	* 车辆类型名称（车辆厂家)
	*/

	private String taxiManufacturer;
	/**
	* 车主
	*/

	private Long carOwnerId;
	/**
	* 设备编号
	*/

	private Long mdtId;
	/**
	* 车辆类型
	*/

	private Long carType;
	/**
	* 车辆类型名称
	*/

	private String carTypeName;
	/**
	* 车辆范畴编号
	*/

	private Long categoryId;
	/**
	* 车辆用途 IC卡号 1 巡游车 2 专车 21 舒适型专车 22 豪华型专车 23 商务型专车 3 顺风车 4 货的 41 0.4吨
	*/

	private String useType;
	/**
	* 报警位 十进制
	*/

	private Long carAlarmNum;
	/**
	* 状态位 十进制
	*/

	private Long carState;
	/**
	* 最后一次位置汇报时间
	*/

	private Date lastResponseTime;
	/**
	* 经度
	*/

		private BigDecimal lon;
	/**
	* 纬度
	*/

		private BigDecimal lat;
	/**
	* 速度 km/h
	*/

		private BigDecimal speed;
	/**
	* 角度
	*/

		private Integer angle;
	/**
	* 车辆里程 km
	*/

		private Integer mileage;
	/**
	* 车辆剩余电量
	*/

		private Integer soc;

	/**
	 * 状态
	 */

	private Integer status;

}
