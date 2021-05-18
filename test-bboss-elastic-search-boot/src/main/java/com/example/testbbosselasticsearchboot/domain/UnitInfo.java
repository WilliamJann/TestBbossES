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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 单位详情表实体类
 *
 * @author Blade
 * @since 2020-05-25
 */
@Data

public class UnitInfo {

	private static final long serialVersionUID = 1L;

	/**
	* 主键标识符
	*/

	private Integer id;
	/**
	* 类别
	*/

		private String categoryType;
	/**
	 * 节点的编码
	 */

	private String nodeCode;
	/**
	* 所属区域
	*/

		private String underControlArea;
	/**
	* 所属区域名称
	*/

		private String underControlAreaName;
	/**
	* 单位名称
	*/

		private String unitName;
	/**
	* 单位负责人
	*/

		private String headOfUnit;
	/**
	* 联系电话
	*/

		private String callPhone;
	/**
	* 管辖单位
	*/
		private String controlUnitCode;
	/**
	* 管辖民警
	*/
		private String controlPoliceCode;
	/**
	 * 管辖单位
	 */

	private String controlUnitName;
	/**
	 * 管辖民警
	 */

	private String controlPoliceName;
	/**
	* 经度
	*/
		private BigDecimal longitude;
	/**
	* 纬度
	*/

		private BigDecimal latitude;
	/**
	 * 图片
	 */

	private String unitImg;
	/**
	 * 设备的数量
	 */

//	@JsonSerialize(nullsUsing = IntZeroSerializer.class)
	private Integer deviceNum;
	/**
	 * 创建时间
	 */

	private Date createTime;

	public UnitInfo() {
	}

	public UnitInfo(List<Object> list) {
		this.underControlAreaName = String.valueOf(list.get(1));
		this.unitName = String.valueOf(list.get(2));
		this.headOfUnit = String.valueOf(list.get(3));
		this.callPhone = String.valueOf(list.get(4));
		this.longitude = new BigDecimal(Double.parseDouble(String.valueOf(list.get(5))));
		this.latitude = new BigDecimal(Double.parseDouble(String.valueOf(list.get(6))));
		this.controlUnitName = String.valueOf(list.get(7));
		this.createTime = new Date();
	}

}
