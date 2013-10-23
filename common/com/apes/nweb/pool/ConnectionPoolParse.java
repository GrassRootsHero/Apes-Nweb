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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * TODO 数据库连接池配置信息
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class ConnectionPoolParse {
	private String name;
	private String driver;
	private String url;
	private String user;
	private String password;
	private Integer minconn;
	private Integer maxconn;

	private Document doc = null;

	public ConnectionPoolParse(String path) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(path);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void load() {
		load(IConnectionPoolConstant.DEFAULT);
	}

	public void load(String name) {
		NodeList nodeList = doc.getElementsByTagName(IConnectionPoolConstant.CONFIG);
		Element e = null;
		if (IConnectionPoolConstant.DEFAULT.equals(name) || nodeList.getLength() == 1) {
			e = (Element) nodeList.item(0);
		} else {
			for (int i = 0; i < nodeList.getLength(); i++) {
				e = (Element) nodeList.item(i);
				String _name = e.getElementsByTagName(IConnectionPoolConstant.NAME).item(0).getTextContent();
				if (_name.equals(name)) {
					break;
				}
			}
		}
		this.setName(e.getElementsByTagName(IConnectionPoolConstant.NAME).item(0).getTextContent());
		this.setDriver(e.getElementsByTagName(IConnectionPoolConstant.DRIVER).item(0).getTextContent());
		this.setUrl(e.getElementsByTagName(IConnectionPoolConstant.URL).item(0).getTextContent());
		this.setUser(e.getElementsByTagName(IConnectionPoolConstant.USER).item(0).getTextContent());
		this.setPassword(e.getElementsByTagName(IConnectionPoolConstant.PASSWORD).item(0).getTextContent());
		this.setMinconn(Integer.parseInt(e.getElementsByTagName(IConnectionPoolConstant.MINCONN).item(0).getTextContent()));
		this.setMaxconn(Integer.parseInt(e.getElementsByTagName(IConnectionPoolConstant.MAXCONN).item(0).getTextContent()));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMinconn() {
		return minconn;
	}

	public void setMinconn(Integer minconn) {
		this.minconn = minconn;
	}

	public Integer getMaxconn() {
		return maxconn;
	}

	public void setMaxconn(Integer maxconn) {
		this.maxconn = maxconn;
	}
}
