/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: IUserEntityDao.java
 */
package com.app.libraryManagement.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.libraryManagement.entity.model.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserEntityDao.
 *
 * @author pintu
 */
@Component("IUserEntityDao")
public interface IUserEntityDao {

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user entity
	 */
	public UserEntity saveUser(UserEntity user);
	
	/**
	 * Gets the user by user id.
	 *
	 * @param userId the user id
	 * @return the user by user id
	 * @throws Exception the exception
	 */
	public UserEntity getUserByUserId(int userId) throws Exception;
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public List<UserEntity> getUsers();

	/**
	 * Check user have same book.
	 *
	 * @param userId the user id
	 * @param bookId the book id
	 * @return true, if successful
	 */
	boolean checkUserHaveSameBook(int userId, int bookId);

	/**
	 * Delete user book.
	 *
	 * @param userId the user id
	 * @param bookId the book id
	 * @return true, if successful
	 */
	boolean deleteUserBook(int userId, int bookId);
}
