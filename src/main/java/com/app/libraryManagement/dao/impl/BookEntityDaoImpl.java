/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: BookEntityDaoImpl.java
 */
package com.app.libraryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.app.libraryManagement.dao.IBookEntityDao;
import com.app.libraryManagement.entity.model.BookEntity;
import com.app.libraryManagement.utils.EntityManagerUtils;
// TODO: Auto-generated Javadoc
/**
 * The Class BookEntityDaoImpl.
 *
 * @author pintu
 */
@Component("BookEntityDaoImpl")
public class BookEntityDaoImpl implements IBookEntityDao{

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BookEntityDaoImpl.class);
	
	/**
	 * Create a Book.
	 *
	 * @param bookEntity the book entity
	 * @return the book entity
	 */
	@Override
	public BookEntity createBook(BookEntity bookEntity) {
		// TODO Auto-generated method stub
		logger.info("Inside @class "+this.getClass().getName()+" @method createBook @param ISBN : "+bookEntity.getIsbn());
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			bookEntity=entityManager.merge(bookEntity);
	    	entityManager.getTransaction().commit();
	    	logger.info("Inside @class "+this.getClass().getName()+" @method updateBook @param id : "+bookEntity.getId());
	    	
		}catch(Exception ex){
			
			logger.error("exception occurred @method createBook",ex);
			return null;
			
		}finally {
			entityManager.close();
		}
		
		return bookEntity;
	}

	/**
	 * update a Book.
	 *
	 * @param bookEntity the book entity
	 * @return the book entity
	 */
	@Override
	public BookEntity updateBook(BookEntity bookEntity) {
		// TODO Auto-generated method stub
		logger.info("Inside @class "+this.getClass().getName()+" @method updateBook @param id : "+bookEntity.getId());
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			bookEntity=entityManager.merge(bookEntity);
	    	entityManager.getTransaction().commit();
	    	
	    	logger.info("Inside @class "+this.getClass().getName()+" @method updateBook @param id : "+bookEntity.getId());
		}catch(Exception ex){
			
			logger.error("exception occurred @method updateBook",ex);
			return null;
			
		}finally {
			entityManager.close();
		}
		
		return bookEntity;
	}

	/**
	 * Fetch all the books who has quantity more than ZERO.
	 *
	 * @return the books
	 */
	@Override
	public List<BookEntity> getBooks() 
	{
		logger.info("Inside @class "+this.getClass().getName()+" @method getBooks ");
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			String query="Select bookEntity from BookEntity bookEntity where bookEntity.noOfCopies>0";
			
			Query queryObj=entityManager.createQuery(query);
	    	
	        List<BookEntity> list=queryObj.getResultList();
	        if(CollectionUtils.isNotEmpty(list))
	        {
	        	logger.info("Inside @class "+this.getClass().getName()+" @method getBooks @param size : "+list.size());
	        	return list;
	        }
		}catch(Exception ex){
			
			logger.error("exception occurred @method getBooks",ex);
			return null;
			
		}finally {
			entityManager.close();
		}
		return null;
		
	}
	
	
	/**
	 * Fetch all the books by Id.
	 *
	 * @param bookId the book id
	 * @return the book by book id
	 * @throws Exception the exception
	 */
	@Override
	public BookEntity getBookByBookId(int bookId) throws Exception 
	{
		logger.info("Inside @class "+this.getClass().getName()+" @method getBookByBookId @param bookId :: "+bookId);
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		try
		{
			BookEntity bookEntity=entityManager.find(BookEntity.class,new Long(bookId));
			
			entityManager.detach(bookEntity);
	        
	        if(bookEntity==null)
	        {
	        	logger.error("Inside @class "+this.getClass().getName()+" @method getBookByBookId @result BOOK NOT FOUND WITH ID :: "+bookId);
	        	throw new Exception("Invalid Book Id");
	        }
	        logger.info("Inside @class "+this.getClass().getName()+" @method getBookByBookId @result BOOK FOUND WITH ID :: "+bookId);
	        return bookEntity;
	        
		}catch(Exception ex){
			
			logger.error("exception occurred @method getBooks",ex);
			throw new Exception("Invalid Book Id");
			
		}finally {
			entityManager.close();
		}
		
	}
	
	

}
