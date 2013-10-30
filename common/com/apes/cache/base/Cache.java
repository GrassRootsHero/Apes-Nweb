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
 * TODO ����ӿ�
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public interface Cache {

	/**
	 * ��ָ��ֵ��ָ��������
	 * @param key ��
	 * @param value ֵ
	 */
	void putInCache(Object key, Object value);

	/**
	 * ���ָ������Ӧ��ֵ
	 * @param key ��
	 * @return
	 */
	Object getFromCache(Object key);

	/**
	 * ɾ��ָ��ӳ���ϵ
	 * @param key
	 * @return
	 */
	Object remove(Object key);

	/**
	 * �жϻ������Ƿ����ָ��ӳ���ϵ
	 * @param key ��
	 * @return ������ڣ�����true
	 */
	boolean containsKey(Object key);

	/**
	 * �������ֵ
	 * @return
	 */
	Collection<Object> getValues();

	/**
	 * ����ӳ���ϵ��
	 * @return
	 */
	int getSize();

	/**
	 * ��ջ���
	 */
	void clear();
}
