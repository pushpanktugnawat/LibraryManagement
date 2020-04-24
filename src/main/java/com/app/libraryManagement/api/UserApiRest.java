/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: UserApiService.java
 */
package com.app.libraryManagement.api;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.app.libraryManagement.api.model.UserApiModel;

// TODO: Auto-generated Javadoc
/**
 * The Class UserApiService.
 */
@Service
@Controller
public abstract class UserApiRest {
    
    /**
     * Adds the user.
     *
     * @param body the body
     * @return the response
     */
    public abstract Response addUser(UserApiModel body);
    
    /**
     * Gets the users.
     *
     * @return the users
     */
    public abstract Response getUsers();
}

