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

import java.util.Collection;

/**
 * TODO 缓存接口
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public interface Cache {

	/**
	 * 将指定值与指定键关联
	 * @param key 键
	 * @param value 值
	 */
	void putInCache(Object key, Object value);

	/**
	 * 获得指定键对应的值
	 * @param key 键
	 * @return
	 */
	Object getFromCache(Object key);

	/**
	 * 删除指定映射关系
	 * @param key
	 * @return
	 */
	Object remove(Object key);

	/**
	 * 判断缓存中是否存在指定映射关系
	 * @param key 键
	 * @return 如果存在，返回true
	 */
	boolean containsKey(Object key);

	/**
	 * 获得所有值
	 * @return
	 */
	Collection<Object> getValues();

	/**
	 * 返回映射关系数
	 * @return
	 */
	int getSize();

	/**
	 * 清空缓存
	 */
	void clear();
}
