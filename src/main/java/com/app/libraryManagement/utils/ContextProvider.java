/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ContextProvider.java
 */
package com.app.libraryManagement.utils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * This class is responsible for providing the Spring ApplicationContext  object.
 * It implements ApplicationContextAware interface and so, is notified of the ApplicationContext that it runs in. 
 * @author pintu
 * @version 1.0
 *
 */
public class ContextProvider implements ApplicationContextAware
{

	/** The app context. */
	private static ApplicationContext appContext;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException
	{
		this.appContext = appContext;
		
	}
	
	/**
	 * Getter for the Application Context Object
	 * @return ApplicationContext
	 */
	public static ApplicationContext getContext()
	{
		return appContext;
	}
	
	
}

