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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * TODO 数据库连接管理类
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class ConnectionPoolManager {
	private static Map<String, ConnectionPool> pools;

	private static ConnectionPoolParse parse = null;

	static {
		pools = new HashMap<String, ConnectionPool>();
		String path = ConnectionPoolManager.class.getClassLoader().getResource("pool.xml").getPath();
		parse = new ConnectionPoolParse(path);
	}

	public ConnectionPoolManager() {
		this(IConnectionPoolConstant.DEFAULT);
	}

	public ConnectionPoolManager(String name) {
		parse.load(name);
		if (pools.containsKey(name)) {
			System.out.println("连接池已存在");
		} else {
			init(name);
		}
	}

	private void init(String name) {
		ConnectionPool pool = new ConnectionPool(parse.getDriver(), parse.getUrl(), parse.getUser(), parse.getPassword(), parse.getMinconn(), parse.getMaxconn());
		pools.put(name, pool);
	}

	/**
	 * 获得默认连接池
	 * @return
	 */
	public static ConnectionPool getConnectionPool() {
		return getConnectionPool(IConnectionPoolConstant.DEFAULT);
	}

	/**
	 * 根据连接池名称获得连接池
	 * @param name
	 * @return
	 */
	public static ConnectionPool getConnectionPool(String name) {
		ConnectionPool pool = pools.get(name);
		if (pool == null) {
			parse.load(name);
			pool = new ConnectionPool(parse.getDriver(), parse.getUrl(), parse.getUser(), parse.getPassword(), parse.getMinconn(), parse.getMaxconn());
			pools.put(name, pool);
		}
		return pool;
	}

	public synchronized void close() {
		Iterator<String> it = pools.keySet().iterator();
		while (it.hasNext()) {
			ConnectionPool pool = pools.get(it.next());
			if (pool != null) {
				pool.closeConnectionPool();
			}
		}
		pools.clear();
	}

}

/**
 * History:
 * 
 * $Log$
 * 
 */
