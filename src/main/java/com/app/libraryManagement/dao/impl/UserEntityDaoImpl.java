/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: UserEntityDaoImpl.java
 */
package com.app.libraryManagement.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.app.libraryManagement.dao.IUserEntityDao;
import com.app.libraryManagement.entity.model.BookEntity;
import com.app.libraryManagement.entity.model.UserEntity;
import com.app.libraryManagement.utils.EntityManagerUtils;


// TODO: Auto-generated Javadoc
/**
 * The Class UserEntityDaoImpl.
 *
 * @author pintu
 */
@Component("UserEntityDaoImpl")
public class UserEntityDaoImpl implements IUserEntityDao{

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(UserEntityDaoImpl.class);
	
	/**
	 * Persist the user entity in DB.
	 *
	 * @param user the user
	 * @return the user entity
	 */
	@Override
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		logger.info("Inside @class "+this.getClass().getName()+" @method saveUser @param fullName : "+user.getFullname());
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			
			if(user.getId()!=null && user.getId().intValue()>0 && CollectionUtils.isNotEmpty(user.getUserBookEntity()))
			{
				
				Set<BookEntity> bookEntity=user.getUserBookEntity();
				
				UserEntity userEntity=this.getUserByUserId(user.getId().intValue());
				
				if(CollectionUtils.isNotEmpty(userEntity.getUserBookEntity()))
				{
					Set<BookEntity> userBookEntities=new HashSet<BookEntity>();
					userBookEntities.addAll(bookEntity);
					userBookEntities.addAll(userEntity.getUserBookEntity());
					user.setUserBookEntity(userBookEntities);
				}
				
			}
			
			user=entityManager.merge(user);
	    	entityManager.getTransaction().commit();
	    	logger.info("Inside @class "+this.getClass().getName()+" @method saveUser @param id : "+user.getId());
	    	
		}catch(Exception ex){
			
			logger.error("exception occurred @method saveUser",ex);
			return null;
			
		}finally {
			entityManager.close();
		}
		
		return user;
	}
	
	


	/* (non-Javadoc)
	 * @see com.app.libraryManagement.dao.IUserEntityDao#getUsers()
	 */
	@Override
	public List<UserEntity> getUsers() {
		logger.info("Inside @class "+this.getClass().getName()+" @method getUsers ");
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			String query="Select userEntity from UserEntity userEntity";
			
			Query queryObj=entityManager.createQuery(query);
	    	
	        List<UserEntity> list=queryObj.getResultList();
	        if(CollectionUtils.isNotEmpty(list))
	        {
	        	logger.info("Inside @class "+this.getClass().getName()+" @method getUsers @param size : "+list.size());
	        	return list;
	        }
		}catch(Exception ex){
			
			logger.error("exception occurred @method getUsers",ex);
			return null;
			
		}finally {
			entityManager.close();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.app.libraryManagement.dao.IUserEntityDao#getUserByUserId(int)
	 */
	@Override
	public UserEntity getUserByUserId(int userId) throws Exception{
		logger.info("Inside @class "+this.getClass().getName()+" @method getUserByUserId ");
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			UserEntity userEntity=entityManager.find(UserEntity.class,new Long(userId));
			
			entityManager.detach(userEntity);
	        
	        if(userEntity==null)
	        {
	        	logger.error("Inside @class "+this.getClass().getName()+" @method getUserByUserId @result USER NOT FOUND WITH ID :: "+userId);
	        	throw new Exception("Invalid USER Id");
	        }
	        logger.info("Inside @class "+this.getClass().getName()+" @method getUserByUserId @result USER FOUND WITH ID :: "+userId);
	        return userEntity;
	        
		}catch(Exception ex){
			
			logger.error("exception occurred @method getUserByUserId",ex);
			throw new Exception("Invalid User Id");
			
		}finally {
			entityManager.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.app.libraryManagement.dao.IUserEntityDao#checkUserHaveSameBook(int, int)
	 */
	@Override
	public boolean checkUserHaveSameBook(int userId,int bookId) {
		logger.info("Inside @class "+this.getClass().getName()+" @method checkUserHaveSameBook @param  userID :: "+userId+" :: bookId :: "+bookId);
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			Query queryObj=entityManager.createNativeQuery("select count(*) from user_book where user_id =:userId and book_id =:bookId").setParameter("userId",userId).setParameter("bookId",bookId);
	    	logger.info("Query Created successfully @method checkUserHaveSameBook");
	        java.math.BigInteger result=(java.math.BigInteger)queryObj.getSingleResult();
	        logger.info("Inside @class "+this.getClass().getName()+" @method checkUserHaveSameBook @param result : "+result.intValue());
	        if(result.intValue()>0)
	        {
	        	logger.info("Inside @class "+this.getClass().getName()+" @method checkUserHaveSameBook @param result : "+result.intValue());
	        	return true;
	        }
		}catch(Exception ex){
			
			logger.error("exception occurred @method checkUserHaveSameBook",ex);
			return false;
			
		}finally {
			entityManager.close();
		}
		return false;
	}
	

	/* (non-Javadoc)
	 * @see com.app.libraryManagement.dao.IUserEntityDao#deleteUserBook(int, int)
	 */
	@Override
	public boolean deleteUserBook(int userId,int bookId) {
		logger.info("Inside @class "+this.getClass().getName()+" @method deleteUserBook @param  userID :: "+userId+" :: bookId :: "+bookId);
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			Query queryObj=entityManager.createNativeQuery("delete from user_book where user_id =:userId and book_id =:bookId").setParameter("userId",userId).setParameter("bookId",bookId);
	    	int result=queryObj.executeUpdate();
	    	if(result>0)
	    	{
				entityManager.getTransaction().commit();
	    		return true;
	    	}
	    	
	        
		}catch(Exception ex){
			
			logger.error("exception occurred @method deleteUserBook",ex);
			return false;
			
		}finally {
			entityManager.close();
		}
		return true;
	}
	
	
}
