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

package com.apes.nweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.apes.nweb.pool.ConnectionPoolManager;

/**
 * TODO Description
 * 
 * @author shitf, Apes Studio
 * @version $Revision$
 */
public class ConnectionPoolFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

	}

	public void init(FilterConfig arg0) throws ServletException {
		new ConnectionPoolManager();
	}

}
