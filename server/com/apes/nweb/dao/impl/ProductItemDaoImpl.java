/*
 * File: $RCSfile$
 * Copyright (c) 2013-2014 by Apes Studio, Shanghai China.
 * This software is the confidential and proprietary information of Apes Studio.
 * You shall not disclose such confidential information and shall
 * use it only in accordance with the terms of the license agreement you entered into with Apes Studio.
 *
 */

package com.apes.nweb.dao.impl;

/**
 * TODO Description
 * 
 * @author wang xiaobing, Apes Studio
 * @version $Revision$
 */
public class ProductItemDaoImpl {

	private String id;
	private String itemId;
	private String itemName;
	private String relativePath;
	private double price;
	private String material;
	private String description;
	private String style;
	private String placeOrgin;
	private String itemSize;

	public ProductItemDaoImpl() {
		super();
	}

	public ProductItemDaoImpl(String id, String itemId, String itemName,
			String relativePath, double price, String material,
			String description, String style, String placeOrgin, String itemSize) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.itemName = itemName;
		this.relativePath = relativePath;
		this.price = price;
		this.material = material;
		this.description = description;
		this.style = style;
		this.placeOrgin = placeOrgin;
		this.itemSize = itemSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPlaceOrgin() {
		return placeOrgin;
	}

	public void setPlaceOrgin(String placeOrgin) {
		this.placeOrgin = placeOrgin;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
}

/**
 * History:
 * 
 * $Log$
 * 
 */
