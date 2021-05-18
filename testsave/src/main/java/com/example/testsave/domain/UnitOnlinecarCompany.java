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
 * 网约车公司信息实体类
 *
 * @author Blade
 * @since 2020-07-29
 */
@Data

public class UnitOnlinecarCompany{

	private static final long serialVersionUID = 1L;


	private Integer id;
	/**
	* 	名称
	*/

		private String name;
	/**
	* 公司全名称
	*/

	private String fullName;
	/**
	* 	父级id
	*/

	private Integer parentId;
	/**
	* 父级名称
	*/

	private String parentName;
	/**
	* 父级路径
	*/

	private String parentPath;
	/**
	* 城市编码用电话区号去零表达
	*/

		private Integer code;


}
