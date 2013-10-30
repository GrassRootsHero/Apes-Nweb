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

package com.apes.cache.factory;

import java.util.HashMap;
import java.util.Map;

import com.apes.cache.base.Cache;
import com.apes.cache.entity.MapCache;

/**
 * TODO 缓存工厂类
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class CacheFactory {
	private static Map<String, Cache> cacheMap = null;

	private static CacheFactory factory = null;

	/**
	 * 获得缓存工厂
	 * @return
	 */
	public static CacheFactory getInstance() {
		if (factory == null) {
			synchronized (factory) {
				factory = new CacheFactory();
				cacheMap = new HashMap<String, Cache>();
			}
		}
		return factory;
	}
	
	/**
	 * 创建缓存
	 * @param name 缓存名称
	 * @return 缓存对象
	 */
	public synchronized Cache createCache(String name){
		Cache cache = new MapCache();
		cacheMap.put(name, cache);
		return cache;
	}
	
	/**
	 * 获得缓存
	 * @param name 缓存名称
	 * @return 缓存对象
	 */
	public Cache getCache(String name){
		return cacheMap.get(name);
	}
	
	/**
	 * 删除缓存
	 * @param name 缓存名称
	 * @return 缓存对象
	 */
	public Cache removeCache(String name){
		return cacheMap.remove(name);
	}
}
