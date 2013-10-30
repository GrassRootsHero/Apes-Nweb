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

package com.apes.cache.base;

/**
 * TODO 缓存实体类
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class CacheEntry {

	/**
	 * 实体的key
	 */
	private Object key;
	
	/**
	 * 实体的内容
	 */
	private Object content;

	public CacheEntry() {
	}

	public CacheEntry(Object key, Object content) {
		this.key = key;
		this.content = content;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
