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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * TODO 数据库连接池
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class ConnectionPool {
	private List<PoolConnection> freeConnections = null;

	private String driver;
	private String url;
	private String user;
	private String password;
	private Integer minConn;
	private Integer maxConn;

	ConnectionPool(String driver, String url, String user, String password, Integer minConn, Integer maxConn) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		this.minConn = minConn;
		this.maxConn = maxConn;
		initPool();
	}

	/**
	 * 获得一个数据库连接
	 * 
	 * @return
	 */
	public synchronized Connection getConnection() {
		Connection conn = getFreeConnection();
		while (conn == null) {
			wait(500);
			conn = getFreeConnection();
		}
		return conn;
	}

	/**
	 * 释放一个数据库连接
	 * 
	 * @param conn
	 */
	public void release(Connection conn) {
		if (freeConnections == null) {
			return;
		}
		for (PoolConnection pConn : freeConnections) {
			if (pConn.getConnection() == conn) {
				pConn.setBusy(false);
				break;
			}
		}
	}

	/**
	 * 关闭数据库连接池
	 * 
	 * @throws SQLException
	 */
	public synchronized void closeConnectionPool() {
		if (freeConnections == null) {
			return;
		}
		for (PoolConnection pConn : freeConnections) {
			if (pConn.isBusy()) {
				wait(2000);
			}
			closeConnection(pConn.getConnection());
			freeConnections.remove(pConn);
		}
		freeConnections = null;
	}

	private void initPool() {
		freeConnections = new ArrayList<PoolConnection>();
		for (int i = 0; i < minConn; i++) {
			freeConnections.add(new PoolConnection(newConnection()));
		}
	}

	private Connection newConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private Connection getFreeConnection() {
		Connection conn = null;
		if (freeConnections == null) {
			return null;
		}
		for (PoolConnection pConn : freeConnections) {
			if (!pConn.isBusy()) {
				conn = pConn.getConnection();
				pConn.setBusy(true);
				break;
			}
		}
		if (conn == null && freeConnections.size() < this.maxConn) {
			conn = newConnection();
			freeConnections.add(new PoolConnection(conn));
		}
		return conn;
	}

	private void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void wait(int mSeconds) {
		try {
			Thread.sleep(mSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PoolConnection {
	Connection connection = null;
	boolean busy = false;

	public PoolConnection(Connection conn) {
		this.connection = conn;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

}

/**
 * History:
 * 
 * $Log$
 * 
 */
