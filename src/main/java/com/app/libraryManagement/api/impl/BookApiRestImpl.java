/*
 *  Copyright (c) 2020. All Rights Reserved.
 *  
 *  Filename: BookApiRestImpl.java
 */
package com.app.libraryManagement.api.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.app.libraryManagement.api.ApiResponseMessage;
import com.app.libraryManagement.api.BookApiRest;
import com.app.libraryManagement.api.model.BookApiModel;
import com.app.libraryManagement.api.model.UserApiModel;
import com.app.libraryManagement.api.service.impl.BookApiServiceImpl;
import com.app.libraryManagement.utils.CommonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class BookApiRestImpl.
 */

@Service
@Controller
public class BookApiRestImpl extends BookApiRest {
	
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BookApiRestImpl.class);
	
	@Autowired
	private BookApiServiceImpl bookApiServiceImpl;
	
    /* (non-Javadoc)
     * @see com.app.libraryManagement.api.BookApiService#addBook(com.app.libraryManagement.api.model.BookApiModel)
     */
    @Override
    public Response addBook(@NotNull @Valid BookApiModel body)
    {
    	logger.info("Inside @ classname "+getClass().getName()+" @method addBook ");
    	
    	
    	body=bookApiServiceImpl.createBook(body);
    	
    	if(body!=null)
    	{
    		logger.info("Inside @ classname "+getClass().getName()+" @method addBook success");
	        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, CommonUtils.BOOK_CREATED_SUCCESSFULLY)).entity(body).build();
    	}
    	logger.info("Inside @ classname "+getClass().getName()+" @method addBook failure");
    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, CommonUtils.SOMETHING_WENT_WRONG)).build();
    }
    
    /* (non-Javadoc)
     * @see com.app.libraryManagement.api.BookApiService#borrowBook(com.app.libraryManagement.api.model.UserApiModel)
     */
    @Override
    public Response borrowBook(UserApiModel body){
    	logger.info("Inside @ classname "+getClass().getName()+" @method borrowBook ");
    	
    	try 
    	{
			body=bookApiServiceImpl.borrowBook(body);
			if(body!=null)
	    	{
	    		logger.info("Inside @ classname "+getClass().getName()+" @method borrowBook success");
		        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, CommonUtils.BOOK_BORROWED_SUCCESSFULLY)).build();
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Inside @ classname "+getClass().getName()+" @method borrowBook failure");
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage())).build();
		}
    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, CommonUtils.SOMETHING_WENT_WRONG)).build();
    	
    	
    }
    
    /* (non-Javadoc)
     * @see com.app.libraryManagement.api.BookApiService#returnBook(com.app.libraryManagement.api.model.UserApiModel)
     */
    @Override
    public Response returnBook(UserApiModel body)
    {
    	logger.info("Inside @ classname "+getClass().getName()+" @method returnBook ");
    	
    	try {
			bookApiServiceImpl.returnBook(body);
			logger.info("Inside @ classname "+getClass().getName()+" @method returnBook success");
	    	return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, CommonUtils.BOOK_RETURN_SUCCESSFULLY)).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Inside @ classname "+getClass().getName()+" @method returnBook failure");
	    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage())).build();
		}
    }
    
   /**
    * this method is used to fetch books present in library.
    *
    * @return the books
    */
    @Override
    public Response getBooks(){
    	logger.info("Inside @ classname "+getClass().getName()+" @method getBooks ");
    	
    	List<BookApiModel> bookApiModels=bookApiServiceImpl.getBooks();
    	logger.info("Inside @ classname "+getClass().getName()+" @method getBooks success");
	    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, CommonUtils.BOOK_CREATED_SUCCESSFULLY)).entity(bookApiModels).build();
    	
    }
}
