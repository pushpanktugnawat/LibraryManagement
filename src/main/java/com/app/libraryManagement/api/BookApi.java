/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: BookApi.java
 */
package com.app.libraryManagement.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.app.libraryManagement.api.model.BookApiModel;
import com.app.libraryManagement.api.model.UserApiModel;

import io.swagger.annotations.ApiParam;

// TODO: Auto-generated Javadoc
/**
 * The Class BookApi.
 */
@Path("/book")

@Service
@Controller
@io.swagger.annotations.Api(value = "/book", description = "the book API")
public class BookApi  {

   /** The delegate. */
	@Autowired
	private BookApiRest delegate;

    /**
     * Adds the book.
     *
     * @param body the body
     * @return the response
     */
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new book to the library", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response addBook(@ApiParam(value = "BookApiModel object that needs to be added to the library" ,required=true ) BookApiModel body)
    {
    return delegate.addBook(body);
    }
    
    /**
     * Borrow book.
     *
     * @param body the body
     * @return the response
     */
    @POST
    @Path("/borrowBook")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "A User can borrow multiple book from Library", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response borrowBook(@ApiParam(value = "A User can borrow multiple book from Library" ,required=true ) UserApiModel body)
    {
    return delegate.borrowBook(body);
    }
    
    /**
     * Return book.
     *
     * @param body the body
     * @return the response
     */
    @POST
    @Path("/returnBook")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Return a book from User to the library", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response returnBook(@ApiParam(value = "User can return Multiple Books to the Library at same time" ,required=true ) UserApiModel body)
    {
    return delegate.returnBook(body);
    }
    
    /**
     * Gets the books.
     *
     * @return the books
     */
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get books from library", notes = "", response = BookApiModel.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid status value"),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response getBooks()
    {
    return delegate.getBooks();
    }
}

