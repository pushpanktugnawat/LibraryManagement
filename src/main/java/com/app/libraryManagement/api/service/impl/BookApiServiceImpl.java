/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: BookApiServiceImpl.java
 */
package com.app.libraryManagement.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.libraryManagement.api.model.BookApiModel;
import com.app.libraryManagement.api.model.UserApiModel;
import com.app.libraryManagement.dao.IBookEntityDao;
import com.app.libraryManagement.entity.model.BookEntity;
import com.app.libraryManagement.utils.CommonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class BookApiServiceImpl.
 */
@Service
public class BookApiServiceImpl {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BookApiServiceImpl.class);

	/** The book entity dao. */
	@Autowired
	@Qualifier("BookEntityDaoImpl")
	private IBookEntityDao bookEntityDao;
	
	@Autowired
	private UserApiServiceImpl userApiServiceImpl;
	
	/**
	 * this method is used to convert UI Object to entity object.
	 *
	 * @param bookApiModel the book api model
	 * @return the book entity
	 */
	public BookEntity convertBookApiModelToEntityModel(BookApiModel bookApiModel)
	{
		logger.info("Inside @class "+getClass().getName()+" @method convertBookApiModelToEntityModel with ISBN "+bookApiModel.getIsbn());
		BookEntity bookEntity=new BookEntity();
		if(bookApiModel.getBookId()!=null && bookApiModel.getBookId().longValue()>0L)
		{
			bookEntity.setId(bookApiModel.getBookId());
		}
		bookEntity.setAuthor(bookApiModel.getAuthor());
		bookEntity.setCreatedTime(new Date());
		bookEntity.setIsbn(bookApiModel.getIsbn());
		bookEntity.setName(bookApiModel.getBookName());
		bookEntity.setNoOfCopies(bookApiModel.getNoOfCopies());
		return bookEntity;
		
	}
	
	/**
	 * this method is used to convert UI Object to entity object.
	 *
	 * @param bookEntity the book entity
	 * @return the book api model
	 */
	public BookApiModel convertBookEntityToApiModel(BookEntity bookEntity)
	{
		logger.info("Inside @class "+getClass().getName()+" @method convertBookEntityToApiModel with ISBN "+bookEntity.getIsbn());
		BookApiModel bookApiModel=new BookApiModel();
		
		bookApiModel.setAuthor(bookEntity.getAuthor());
		bookApiModel.setCreatedTime(CommonUtils.convertDateToString(bookEntity.getCreatedTime()));
		bookApiModel.setIsbn(bookEntity.getIsbn());
		bookApiModel.setBookName(bookEntity.getName());
		bookApiModel.setNoOfCopies(bookEntity.getNoOfCopies());
		bookApiModel.setBookId(bookEntity.getId());
		return bookApiModel;
		
	}
	
	
	/**
	 * this method is used to create book.
	 *
	 * @param bookApiModel the book api model
	 * @return the book api model
	 */
	public BookApiModel createBook(BookApiModel bookApiModel)
	{
		logger.info("Inside @class "+getClass().getName()+" @method createBook ");
		
		BookEntity bookEntity=bookEntityDao.createBook(convertBookApiModelToEntityModel(bookApiModel));
		
		if(bookEntity!=null && bookEntity.getId()!=null)
		{
			logger.info("Inside @class "+getClass().getName()+" @method createBook Book entity Created successfully");
			return convertBookEntityToApiModel(bookEntity);
		}
		return null;
		
	}
	
	/**
	 * this method is used to fetch book api models from db.
	 *
	 * @return the books
	 */
	public List<BookApiModel> getBooks()
	{
		logger.info("Inside @class "+getClass().getName()+" @method getBooks ");
		
		List<BookApiModel> bookApiModels=new ArrayList<BookApiModel>();
		List<BookEntity> bookEntities=bookEntityDao.getBooks();
		
		if(CollectionUtils.isNotEmpty(bookEntities))
		{
			logger.info("Inside @class "+getClass().getName()+" @method getBooks bookEntities found :: "+bookEntities.size());
			
			for(BookEntity bookEntity:bookEntities)
			{
				BookApiModel bookApiModel=new BookApiModel();
				bookApiModel=convertBookEntityToApiModel(bookEntity);
				bookApiModels.add(bookApiModel);
			}
		}
		return bookApiModels;
		
	}
	
	/**
	 * this method is used for borrowing book from library.
	 *
	 * @param userApiModel the user api model
	 * @return the user api model
	 * @throws Exception the exception
	 */
	public UserApiModel borrowBook(UserApiModel userApiModel) throws Exception {
		logger.info("Inside @class "+getClass().getName()+" @method borrowBook "+userApiModel.getBookIds());
		
		/*Business Logic to tackle Scenario 2/3*/
		
		/**
		 * Scenario 1 : If user borrow a book than Book Ids must be present
		 * */
		if(CollectionUtils.isEmpty(userApiModel.getBookIds()))
		{
			throw new Exception(CommonUtils.NO_BOOK_SELECTED);
		}
		
		/**
		 * Scenario 2 : User are not allowed to carry more than 2 books at a time from library
		 * */
		if(userApiModel.getBookIds().size()>2)
		{
			throw new Exception(CommonUtils.USER_PREVILIGED_NOT_TO_GET_MORE_THAN_2_BOOKS);
		}

		
		int bookId=0;
		
		int userId=userApiModel.getUserid().intValue();boolean isBookExist;
		
		List<Integer> bookIds=new ArrayList<Integer>();
		
		List<BookApiModel> bookApiModels=new ArrayList<BookApiModel>(); 
		/**
		 * Scenario 3 : Books should not be identical and this should not exist in userbucket 
		 * */
		
		for(BookApiModel bookApiModel:userApiModel.getBookIds())
		{
			logger.info("Inside @class "+getClass().getName()+" @method bookApiModel.getBookId() "+userApiModel.getBookIds()+" bookIds "+bookIds+" bookApiModel.getBookId().intValue() "+bookApiModel.getBookId().intValue());
			
			bookId=bookApiModel.getBookId()!=null?bookApiModel.getBookId().intValue():CommonUtils.ZERO;
			
			if(bookId==CommonUtils.ZERO)
			{
				throw new Exception(CommonUtils.INVALID_BOOK_ID);
			}
			
			if(!bookIds.contains(bookId))
			{
				logger.info("Inside @class "+getClass().getName()+" @method borrowbook @param bookId "+bookId);
				
				BookEntity bookEntity=bookEntityDao.getBookByBookId(bookId);
				if(bookEntity==null)
				{
					throw new Exception(CommonUtils.INVALID_BOOK_ID);
				}else if(bookEntity!=null && bookEntity.getNoOfCopies()==CommonUtils.ZERO) {
					throw new Exception(CommonUtils.BOOK_NOT_AVAILABLE);
				}
				bookIds.add(bookId);
				
				isBookExist=userApiServiceImpl.checkUserBookAssociation(userId, bookId);
				
				logger.info("Inside @class "+getClass().getName()+" @method borrowbook @param isBookExist "+isBookExist);
				
				if(isBookExist)
				{
					throw new Exception("User already have this book : "+bookEntity.getName());
				}
				bookApiModels.add(convertBookEntityToApiModel(bookEntity));
				
			}else
			{
				throw new Exception("User are not allowed to choose Identical Books from Library");
			}
		}
		/*we are adding this again so from UI ID can work*/
		userApiModel.setBookIds(bookApiModels);
		userApiModel= userApiServiceImpl.saveUser(userApiModel);
		
		/**
		 * Update Book Quantity in Library
		 * */
		for(int associatedBookId:bookIds)
		{
			BookEntity book=bookEntityDao.getBookByBookId(associatedBookId);
			
			if(book!=null)
			{
				logger.info("No of copies present "+book.getNoOfCopies()+" for book Id "+book.getId());
				int quantity=book.getNoOfCopies();
				book.setNoOfCopies(quantity-=1);
				bookEntityDao.updateBook(book);
			}
		}
		return userApiModel;
	
	}

	/**
	 * Return book.
	 *
	 * @param userApiModel the user api model
	 * @throws Exception the exception
	 */
	public void returnBook(UserApiModel userApiModel) throws Exception {
		
		logger.info("Inside @class "+getClass().getName()+" @method returnBook "+userApiModel.getBookIds());
		
		
		if(CollectionUtils.isNotEmpty(userApiModel.getBookIds()))
		{
			int userId=userApiModel.getUserid().intValue();
			logger.info("@method returnBook with userId "+userId);
			
			for(BookApiModel bookApiModel:userApiModel.getBookIds())
			{
				
				int bookId=bookApiModel.getBookId().intValue();
				BookEntity bookEntity=bookEntityDao.getBookByBookId(bookId);
				if(bookEntity!=null)
				{
					
					boolean isBookExist=userApiServiceImpl.checkUserBookAssociation(userId, bookId);
					
					if(!isBookExist)
					{
						throw new Exception("User does not have this book : "+bookEntity.getName());
					}
					
					boolean isSuccess=userApiServiceImpl.deleteUserBook(userId,bookId);
					if(isSuccess)
					{
						int noOfCopies=bookEntity.getNoOfCopies();
						bookEntity.setNoOfCopies(noOfCopies+=1);
						bookEntityDao.updateBook(bookEntity);
					}
				}else{
					throw new Exception(CommonUtils.INVALID_BOOK_ID);
				}
			}
		}else{
			
			logger.error("@method returnBook , No Book Selected to return");
			throw new Exception(CommonUtils.NO_BOOK_SELECTED_TO_RETURN);
		}
		
			
	}
	
	
	
	
	
}
