/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: BookApiService.java
 */
package com.app.libraryManagement.api;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.app.libraryManagement.api.model.BookApiModel;
import com.app.libraryManagement.api.model.UserApiModel;

// TODO: Auto-generated Javadoc
/**
 * The Class BookApiService.
 */
@Service
@Controller
public abstract class BookApiRest {
    
    /**
     * Adds the book.
     *
     * @param body the body
     * @return the response
     */
    public abstract Response addBook(BookApiModel body);
    
    /**
     * Borrow book.
     *
     * @param body the body
     * @return the response
     */
    public abstract Response borrowBook(UserApiModel body);
    
    /**
     * Return book.
     *
     * @param body the body
     * @return the response
     */
    public abstract Response returnBook(UserApiModel body);
    
    /**
     * Gets the books.
     *
     * @return the books
     */
    public abstract Response getBooks();
}

