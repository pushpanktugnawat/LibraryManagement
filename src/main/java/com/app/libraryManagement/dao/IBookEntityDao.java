/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: IBookEntityDao.java
 */
package com.app.libraryManagement.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.libraryManagement.entity.model.BookEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBookEntityDao.
 *
 * @author pintu
 */
@Component("IBookEntityDao")
public interface IBookEntityDao {

	/**
	 * Creates the book.
	 *
	 * @param bookEntity the book entity
	 * @return the book entity
	 */
	public BookEntity createBook(BookEntity bookEntity);
	
	/**
	 * Update book.
	 *
	 * @param bookEntity the book entity
	 * @return the book entity
	 */
	public BookEntity updateBook(BookEntity bookEntity);
	
	/**
	 * Gets the books.
	 *
	 * @return the books
	 */
	public List<BookEntity> getBooks();

	/**
	 * Gets the book by book id.
	 *
	 * @param bookId the book id
	 * @return the book by book id
	 * @throws Exception the exception
	 */
	BookEntity getBookByBookId(int bookId) throws Exception;
}
