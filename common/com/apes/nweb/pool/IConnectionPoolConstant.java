/*
 * File: $RCSfile$
 *
 * Copyright (c) 2013-2014 by Apes Studio, Shanghai China.
 *
 * This software is the confidential and proprietary information
 * of Apes Studio.
 *
 * You shall not disclose such confidential information and shall
 * use it only in accordance with the terms of the license agreement
 * you entered into with Apes Studio.
 *
 */

package com.apes.nweb.pool;

/**
 * TODO 数据库连接池常量类
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class IConnectionPoolConstant {
	
	/**
	 * 默认连接池名称
	 */
	static String DEFAULT = "apes_default";
	
	/**
	 * 根节点
	 */
	static String CONFIG = "config";

	/**
	 * 连接池名称
	 */
	static String NAME = "name";

	/**
	 * 数据库连接渠动
	 */
	static String DRIVER = "driver";

	/**
	 * 数据库URL
	 */
	static String URL = "url";

	/**
	 * 连接数据库的用户名
	 */
	static String USER = "user";

	/**
	 * 连接数据库的用户名密码
	 */
	static String PASSWORD = "password";

	/**
	 * 连接池最小连接数
	 */
	static String MINCONN = "minConn";

	/**
	 * 连接池最大连接数
	 */
	static String MAXCONN = "maxConn";
}
