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

import java.time.LocalDateTime;

/**
 * 网约车司机基础数据表实体类
 *
 * @author Blade
 * @since 2020-07-29
 */
@Data

public class UnitOnlinecarDriver{

	private static final long serialVersionUID = 1L;


	private Long id;
	/**
	* 姓名
	*/

		private String name;
	/**
	* 性别，默认true
	*/

		private Boolean male;
	/**
	* 电话
	*/

		private String phone;
	/**
	* 	积分，默认0
	*/

		private Integer score;
	/**
	* 几星级驾驶员
	*/

		private Integer grade;
	/**
	* 	登陆口令
	*/

		private String password;
	/**
	* 身份证号
	*/

	private String personalId;
	/**
	* 地址
	*/

		private String address;
	/**
	* 家电
	*/

	private String homeTel;
	/**
	* 	出生日期
	*/

	private LocalDateTime bornDate;
	/**
	* 司机工号
	*/

	private String serviceNo;
	/**
	* 所在公司
	*/

	private Integer companyId;
	/**
	* 对应车辆编号
	*/

	private Integer carId;
	/**
	* 	最后更新时间
	*/

	private String latestUpdateTime;
	/**
	* 照片存放的路径
	*/

	private String photoPath;
	/**
	* 运营证号
	*/

	private String certificateId;
	/**
	* 从业资格类别
	*/

	private String certificateType;
	/**
	* 发证机关
	*/

	private String certificateOrganization;
	/**
	* 监督部门
	*/

	private String superviseDepartment;
	/**
	* 监督电话1
	*/

	private String supervisePhone1;
	/**
	* 监督电话2
	*/

	private String supervisePhone2;
	/**
	* 从业资格证有效开始日期
	*/

	private LocalDateTime validityStartTime;
	/**
	* 投诉电话
	*/

	private String complaintPhone;
	/**
	* 从业资格证有效截止日期
	*/

	private LocalDateTime validityTime;
	/**
	* 档案号
	*/

	private String recordNumber;
	/**
	* 外卡号
	*/

	private String wildCard;
	/**
	* 是否主驾,默认:true
	*/

		private Boolean major;
	/**
	* 用户注册时间
	*/

	private LocalDateTime registerDate;
	/**
	* 是否开通对讲服务，默认:0
	*/

	private Integer isChat;
	/**
	* 加入组时间
	*/

	private String joinGroupDate;
	/**
	* 信誉等级，0:B级; 1:A级; 2:AA级; 3:AAA级。默认:3
	*/

	private Integer creditLevel;
	/**
	* 从业时间
	*/

	private LocalDateTime workTime;
	/**
	* true:单班
	*/

	private Boolean singleShift;
	/**
	* 	指纹仪文件路径
	*/

	private String datPath;
	/**
	* 支付宝支付码图片路径
	*/

		private String codepath;
	/**
	* 微信支付码图片路径
	*/

	private String wxCodePath;
	/**
	* 营运证照片路径
	*/

	private String certifiPhoto;
	/**
	* 银行商户号
	*/

	private String bankMerCode;
	/**
	* 违规积分，秦皇岛用的，默认0
	*/

	private Integer violationScore;
	/**
	* 备注
	*/

		private String remark;
	/**
	* 民族，默认0
	*/

		private Integer nation;
	/**
	* 邮编
	*/

		private String zipcode;
	/**
	* 	电子邮箱
	*/

		private String email;
	/**
	* 联系地址
	*/

	private String contactAddress;
	/**
	* 证照状态,默认正常
	*/

	private Integer certificateStatus;
	/**
	* 驾驶证
	*/

	private String driverLicense;
	/**
	* 从业状态，默认0
	*/

	private Integer employmentStatus;
	/**
	* 考核起始日期
	*/

	private LocalDateTime assessmentStartTime;
	/**
	* 考核结束日期
	*/

	private LocalDateTime assessmentEndTime;
	/**
	* 诚信考核日期
	*/

	private LocalDateTime integrityAssessmentTime;
	/**
	* 诚信考核等级，默认0
	*/

	private Integer assessmentLv;
	/**
	* 诚信考核记录
	*/

	private String assessmentRecord;
	/**
	* 考核周期累积积分，默认0
	*/

	private Integer assessmentCore;
	/**
	* 诚信考核机构
	*/

	private String assessmentCompany;
	/**
	* 二维码图片路径
	*/

	private String qrcodPath;
	/**
	* 二维码中存放的http路径或者其他内容（第三方）
	*/

	private String httpQrcodContent;
	/**
	* 银行卡号
	*/

	private String bankCard;
	/**
	* 驾驶员信息版本
	*/

	private LocalDateTime driverVersion;
	/**
	* 驾驶员照片版本
	*/

	private LocalDateTime photoVersion;
	/**
	* 支付宝二维码版本
	*/

	private LocalDateTime alipayVersion;
	/**
	* 微信二维码版本
	*/

	private LocalDateTime wechatVersion;
	/**
	* 翼支付二维码版本
	*/

	private LocalDateTime yzfVersion;
	/**
	* 指纹版本
	*/

	private LocalDateTime datVersion;
	/**
	* 营运证照片版本
	*/

	private LocalDateTime certifiPhotoVersion;
	/**
	* 认证策略,0:表示采用后台的策略配置 1:人车绑定 3:人企绑定 4:不限 默认:0
	*/

	private Integer authStrategy;
	/**
	* 公司名称
	*/

	private String companyName;
	/**
	* 车牌号
	*/

	private String carNo;
	/**
	* 司机国籍
	*/

		private String nationality;

	public UnitOnlinecarDriver() {
	}

	public UnitOnlinecarDriver(Long id, String name, Boolean male, String phone, Integer score, Integer grade, String password, String personalId, String address, String homeTel, LocalDateTime bornDate, String serviceNo, Integer companyId, Integer carId, String latestUpdateTime, String photoPath, String certificateId, String certificateType, String certificateOrganization, String superviseDepartment, String supervisePhone1, String supervisePhone2, LocalDateTime validityStartTime, String complaintPhone, LocalDateTime validityTime, String recordNumber, String wildCard, Boolean major, LocalDateTime registerDate, Integer isChat, String joinGroupDate, Integer creditLevel, LocalDateTime workTime, Boolean singleShift, String datPath, String codepath, String wxCodePath, String certifiPhoto, String bankMerCode, Integer violationScore, String remark, Integer nation, String zipcode, String email, String contactAddress, Integer certificateStatus, String driverLicense, Integer employmentStatus, LocalDateTime assessmentStartTime, LocalDateTime assessmentEndTime, LocalDateTime integrityAssessmentTime, Integer assessmentLv, String assessmentRecord, Integer assessmentCore, String assessmentCompany, String qrcodPath, String httpQrcodContent, String bankCard, LocalDateTime driverVersion, LocalDateTime photoVersion, LocalDateTime alipayVersion, LocalDateTime wechatVersion, LocalDateTime yzfVersion, LocalDateTime datVersion, LocalDateTime certifiPhotoVersion, Integer authStrategy, String companyName, String carNo, String nationality) {
		this.id = id;
		this.name = name;
		this.male = male;
		this.phone = phone;
		this.score = score;
		this.grade = grade;
		this.password = password;
		this.personalId = personalId;
		this.address = address;
		this.homeTel = homeTel;
		this.bornDate = bornDate;
		this.serviceNo = serviceNo;
		this.companyId = companyId;
		this.carId = carId;
		this.latestUpdateTime = latestUpdateTime;
		this.photoPath = photoPath;
		this.certificateId = certificateId;
		this.certificateType = certificateType;
		this.certificateOrganization = certificateOrganization;
		this.superviseDepartment = superviseDepartment;
		this.supervisePhone1 = supervisePhone1;
		this.supervisePhone2 = supervisePhone2;
		this.validityStartTime = validityStartTime;
		this.complaintPhone = complaintPhone;
		this.validityTime = validityTime;
		this.recordNumber = recordNumber;
		this.wildCard = wildCard;
		this.major = major;
		this.registerDate = registerDate;
		this.isChat = isChat;
		this.joinGroupDate = joinGroupDate;
		this.creditLevel = creditLevel;
		this.workTime = workTime;
		this.singleShift = singleShift;
		this.datPath = datPath;
		this.codepath = codepath;
		this.wxCodePath = wxCodePath;
		this.certifiPhoto = certifiPhoto;
		this.bankMerCode = bankMerCode;
		this.violationScore = violationScore;
		this.remark = remark;
		this.nation = nation;
		this.zipcode = zipcode;
		this.email = email;
		this.contactAddress = contactAddress;
		this.certificateStatus = certificateStatus;
		this.driverLicense = driverLicense;
		this.employmentStatus = employmentStatus;
		this.assessmentStartTime = assessmentStartTime;
		this.assessmentEndTime = assessmentEndTime;
		this.integrityAssessmentTime = integrityAssessmentTime;
		this.assessmentLv = assessmentLv;
		this.assessmentRecord = assessmentRecord;
		this.assessmentCore = assessmentCore;
		this.assessmentCompany = assessmentCompany;
		this.qrcodPath = qrcodPath;
		this.httpQrcodContent = httpQrcodContent;
		this.bankCard = bankCard;
		this.driverVersion = driverVersion;
		this.photoVersion = photoVersion;
		this.alipayVersion = alipayVersion;
		this.wechatVersion = wechatVersion;
		this.yzfVersion = yzfVersion;
		this.datVersion = datVersion;
		this.certifiPhotoVersion = certifiPhotoVersion;
		this.authStrategy = authStrategy;
		this.companyName = companyName;
		this.carNo = carNo;
		this.nationality = nationality;
	}
}
