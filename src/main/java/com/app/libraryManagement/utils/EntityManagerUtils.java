/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: EntityManagerUtils.java
 */
package com.app.libraryManagement.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// TODO: Auto-generated Javadoc
/**
 * The Class EntityManagerUtils.
 *
 * @author pintu
 */
public class EntityManagerUtils {

	/** The Constant factory. */
	private static final EntityManagerFactory factory;
	
	static
	{
		factory=Persistence.createEntityManagerFactory(CommonUtils.LIBRARY_MANAGEMENT);
	}
	
	/**
	 * static method returning Entity manager.
	 *
	 * @return the entity manager
	 */
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
}
