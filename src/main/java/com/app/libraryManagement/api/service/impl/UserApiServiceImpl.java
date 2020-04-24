/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: UserApiServiceImpl.java
 */
package com.app.libraryManagement.api.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.libraryManagement.api.model.BookApiModel;
import com.app.libraryManagement.api.model.UserApiModel;
import com.app.libraryManagement.dao.IUserEntityDao;
import com.app.libraryManagement.entity.model.BookEntity;
import com.app.libraryManagement.entity.model.UserEntity;
import com.app.libraryManagement.utils.ContextProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class UserApiServiceImpl.
 *
 * @author pintu
 */
@Service
public class UserApiServiceImpl {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);

	
	/** The user dao. */
	
//	UserEntityDaoImpl userDao=new UserEntityDaoImpl();
	@Autowired
	@Qualifier("UserEntityDaoImpl")
	private IUserEntityDao userDao;
	
	/**
	 * this method is used to convert UI Object to entity object.
	 *
	 * @param userApiModel the user api model
	 * @return the user entity
	 */
	public UserEntity convertUserApiModelToEntityModel(UserApiModel userApiModel)
	{
		logger.info("Inside @class "+getClass().getName()+" @method convertUserApiModelToEntityModel with userApiModel.getName "+userApiModel.getFullName());
		UserEntity userEntity=new UserEntity();
		
		userEntity.setEmailId(userApiModel.getEmailId());
		userEntity.setFullname(userApiModel.getFullName());
		userEntity.setPhoneNo(userApiModel.getPhoneNo());
		
		if(userApiModel.getUserid()!=null && userApiModel.getUserid().longValue()>0L)
		{
			userEntity.setId(userApiModel.getUserid());
		}
		
		if(CollectionUtils.isNotEmpty(userApiModel.getBookIds()))
		{
			logger.info("Inside @class "+getClass().getName()+" @method convertUserApiModelToEntityModel with userApiModel.getBookIds() size ::"+userApiModel.getBookIds().size());
			Set<BookEntity> bookEntities=new HashSet<BookEntity>();
			
			BookApiServiceImpl bookAdapter=ContextProvider.getContext().getBean(BookApiServiceImpl.class);
			
			for(BookApiModel bookApiModel:userApiModel.getBookIds())
			{
				BookEntity bookEntity=bookAdapter.convertBookApiModelToEntityModel(bookApiModel);
				bookEntities.add(bookEntity);
			}
			userEntity.setUserBookEntity(bookEntities);
			
		}
		
		return userEntity;
		
	}
	
	/**
	 * this method is used to convert Entity Object to UI object.
	 *
	 * @param userEntity the user entity
	 * @return the user api model
	 */
	public UserApiModel convertUserEntityToApiModel(UserEntity userEntity)
	{
		logger.info("Inside @class "+getClass().getName()+" @method convertUserEntityToApiModel with userEntity.getId "+userEntity.getId());
		UserApiModel userApiModel=new UserApiModel();
		
		userApiModel.setEmailId(userEntity.getEmailId());
		userApiModel.setFullName(userEntity.getFullname());
		userApiModel.setPhoneNo(userEntity.getPhoneNo());
		userApiModel.setUserid(userEntity.getId());
		
		if(CollectionUtils.isNotEmpty(userEntity.getUserBookEntity()))
		{
			logger.info("Inside @class "+getClass().getName()+" @method convertUserEntityToApiModel with userEntity.getUserBookEntity() size ::"+userEntity.getUserBookEntity().size());
			List<BookApiModel> bookApiModels=new ArrayList<BookApiModel>();
			BookApiServiceImpl bookAdapter=new BookApiServiceImpl();
			for( BookEntity bookEntity:userEntity.getUserBookEntity())
			{
				BookApiModel bookApiModel=bookAdapter.convertBookEntityToApiModel(bookEntity);
				bookApiModels.add(bookApiModel);
			}
			userApiModel.setBookIds(bookApiModels);
			
		}
		return userApiModel;
		
	}
	
	
	
	/**
	 * Save user.
	 *
	 * @param userApiModel the user api model
	 * @return the user api model
	 */
	public UserApiModel saveUser(UserApiModel userApiModel)
	{
		logger.info("Inside @class "+getClass().getName()+" @method saveUser ");
		
		UserEntity userEntity=userDao.saveUser(convertUserApiModelToEntityModel(userApiModel));
		
		if(userEntity!=null && userEntity.getId()!=null)
		{
			logger.info("Inside @class "+getClass().getName()+" @method saveUser User entity Created successfully");
			return convertUserEntityToApiModel(userEntity);
		}
		return null;
		
	}
	
	/**
	 * Check user book association.
	 *
	 * @param userid the userid
	 * @param bookid the bookid
	 * @return true, if successful
	 */
	public boolean checkUserBookAssociation(int userid,int bookid)
	{
		logger.info("Inside @class "+getClass().getName()+" @method checkUserBookAssociation @param userid "+userid+" bookid "+bookid);
		
		return userDao.checkUserHaveSameBook(userid, bookid);
	}

	/**
	 * Delete user book.
	 *
	 * @param userId the user id
	 * @param bookId the book id
	 * @return true, if successful
	 */
	public boolean deleteUserBook(int userId, int bookId) {
		logger.info("Inside @class "+getClass().getName()+" @method deleteUserBook @param userid "+userId+" bookid "+bookId);
		
		return userDao.deleteUserBook(userId, bookId);
	}
	
	/**
	 * this method is used to fetch users api models from db.
	 *
	 * @return the users
	 */
	public List<UserApiModel> getUsers()
	{
		logger.info("Inside @class "+getClass().getName()+" @method getUsers ");
		
		List<UserApiModel> userApiModels=new ArrayList<UserApiModel>();
		List<UserEntity> userEntities=userDao.getUsers();
		
		if(CollectionUtils.isNotEmpty(userEntities))
		{
			logger.info("Inside @class "+getClass().getName()+" @method getUsers userEntities found :: "+userEntities.size());
			
			for(UserEntity userEntity:userEntities)
			{
				UserApiModel userApiModel=new UserApiModel();
				userApiModel=convertUserEntityToApiModel(userEntity);
				userApiModels.add(userApiModel);
			}
		}
		return userApiModels;
		
	}
}

