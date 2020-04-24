/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: UserApi.java
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

import com.app.libraryManagement.api.model.UserApiModel;

import io.swagger.annotations.ApiParam;

// TODO: Auto-generated Javadoc
/**
 * The Class UserApi.
 */
@Path("/user")

@Service
@Controller
@io.swagger.annotations.Api(value = "/user", description = "the user API")
public class UserApi  {

   /** The delegate. */
  // private final UserApiService delegate = UserApiServiceFactory.getUserApi();

	@Autowired
	private UserApiRest delegate;
    /**
     * Adds the user.
     *
     * @param body the body
     * @return the response
     */
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new User for the library", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response addUser(@ApiParam(value = "User object that needs to be introduced to the library" ,required=true ) UserApiModel body)
    {
    return delegate.addUser(body);
    }
    
    /**
     * Gets the users.
     *
     * @return the users
     */
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get existing users", notes = "", response = UserApiModel.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid status value"),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input") })

    public Response getUsers()
    {
    return delegate.getUsers();
    }
}

