/*
 * File: $RCSfile$
 * Copyright (c) 2013-2014 by Apes Studio, Shanghai China.
 * This software is the confidential and proprietary information of Apes Studio.
 * You shall not disclose such confidential information and shall
 * use it only in accordance with the terms of the license agreement you entered into with Apes Studio.
 *
 */

package com.apes.nweb.domain;

/**
 * TODO Description
 * 
 * @author wang xiaobing, Apes Studio
 * @version $Revision$
 */
public class ProductCategory {

	private String categoryId;
	private String catroyrName;
	private String hierarchy;
	private String parentId;

	
	/**
	 * constructor
	 */
	public ProductCategory() {
		super();
	}

	/**
	 * constructor
	 * @param categoryId
	 * @param catroyrName
	 * @param hierarchy
	 * @param parentId
	 */
	public ProductCategory(String categoryId, String catroyrName,
			String hierarchy, String parentId) {
		super();
		this.categoryId = categoryId;
		this.catroyrName = catroyrName;
		this.hierarchy = hierarchy;
		this.parentId = parentId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatroyrName() {
		return catroyrName;
	}

	public void setCatroyrName(String catroyrName) {
		this.catroyrName = catroyrName;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}

/**
 * History:
 * 
 * $Log$
 * 
 */
