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

package com.apes.cache.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.apes.cache.base.Cache;
import com.apes.cache.base.CacheEntry;

/**
 * TODO Mapª∫¥Ê¿‡
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class MapCache implements Cache {

	private Map<Object, CacheEntry> cacheMap = null;

	public MapCache() {
		cacheMap = new HashMap<Object, CacheEntry>();
	}

	public void putInCache(Object key, Object value) {
		CacheEntry entry = new CacheEntry();
		entry.setKey(key);
		entry.setContent(value);
		cacheMap.put(key, entry);
	}

	public Object getFromCache(Object key) {
		CacheEntry entry = cacheMap.get(key);
		return entry.getContent();
	}

	public Object remove(Object key) {
		return cacheMap.remove(key);
	}

	public boolean containsKey(Object key) {
		return cacheMap.containsKey(key);
	}

	public Collection<Object> getValues() {
		Collection<CacheEntry> entrys = cacheMap.values();
		Iterator<CacheEntry> it = entrys.iterator();
		Collection<Object> list = new ArrayList<Object>();
		while (it.hasNext()) {
			list.add(it.next().getContent());
		}
		return list;
	}

	public int getSize() {
		return cacheMap.size();
	}

	public void clear() {
		cacheMap.clear();
	}

}
