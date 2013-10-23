/*
 * File: $RCSfile$
 * Copyright (c) 2013-2014 by Apes Studio, Shanghai China.
 * This software is the confidential and proprietary information of Apes Studio.
 * You shall not disclose such confidential information and shall
 * use it only in accordance with the terms of the license agreement you entered into with Apes Studio.
 *
 */

package com.apes.nweb.dao;	

import java.util.List;

import com.apes.nweb.domain.ProductItem;

/**
 * TODO Description
 *
 * @author   wang xiaobing, Apes Studio 
 * @version  $Revision$
 */
public interface ProductItemDao {
	
	/**
	 * Get product id by category
	 * @param categoryId
	 * @return
	 */
	public List getItemsByCategror(String categoryId);

	
	/**
	 * Get product item by id
	 * @param itemId
	 * @return
	 */
	public ProductItem getItemById(String itemId);
	
	/**
	 * Add product item
	 * @param item
	 */
	public void addItem(ProductItem item);
	
	/**
	 * Delete item by id
	 * @param itemId
	 */
	public void deleteItem(String itemId);
	
	/**
	 * Modify item by id
	 * @param item
	 */
	public void modiftItem(String itemId);
	
	/**
	 * Get item by name
	 * @param itemName
	 */
	public void getItemByName(String itemName);
}


/**
 * History:
 *
 * $Log$
 *
 */