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

import com.apes.nweb.domain.ProductCategory;

public interface ProductCategoryDao {

	/**
	 * Add product category
	 * @param category
	 */
	public void addCategory(ProductCategory category);
	
	/**
	 * Delete category by id
	 * @param categoryId
	 */
	public void deleteCategoryById(String categoryId);
	
	
	/**
	 * Get all categories
	 * @return all categories
	 */
	public List<ProductCategory> getAllCategory();
}

/**
 * History:
 *
 * $Log$
 *
 */