/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: UserApiRestImpl.java
 */
package com.app.libraryManagement.api.impl;

import java.util.List;
// TODO: Auto-generated Javadoc

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.app.libraryManagement.api.ApiResponseMessage;
import com.app.libraryManagement.api.UserApiRest;
import com.app.libraryManagement.api.model.UserApiModel;
import com.app.libraryManagement.api.service.impl.UserApiServiceImpl;
import com.app.libraryManagement.utils.CommonUtils;

/**
 * The Class UserApiRestImpl.
 */
@Service
@Controller
public class UserApiRestImpl extends UserApiRest {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(UserApiRestImpl.class);
	
	@Autowired
	private UserApiServiceImpl userApiServiceimpl;
	
    /* (non-Javadoc)
     * @see com.app.libraryManagement.api.UserApiService#addUser(com.app.libraryManagement.api.model.UserApiModel)
     */
    @Override
    public Response addUser(UserApiModel body){
    	logger.info("Inside @ classname "+getClass().getName()+" @method addUser ");
    	
    	
    	body=userApiServiceimpl.saveUser(body);
    	
    	if(body!=null)
    	{
    		logger.info("Inside @ classname "+getClass().getName()+" @method addUser success");
	        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, CommonUtils.BOOK_CREATED_SUCCESSFULLY)).entity(body).build();
    	}
    	logger.info("Inside @ classname "+getClass().getName()+" @method addUser failure");
    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, CommonUtils.SOMETHING_WENT_WRONG)).build();
    
    }
    
    /* (non-Javadoc)
     * @see com.app.libraryManagement.api.UserApiService#getUsers()
     */
    @Override
    public Response getUsers(){
        logger.info("Inside @ classname "+getClass().getName()+" @method getUsers ");
    	List<UserApiModel> userApiModels=userApiServiceimpl.getUsers();
    	logger.info("Inside @ classname "+getClass().getName()+" @method getUsers success");
	    return Response.ok().entity(userApiModels).build();
    	

    }
}
