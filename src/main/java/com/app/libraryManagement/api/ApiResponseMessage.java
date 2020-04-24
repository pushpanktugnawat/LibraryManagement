/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: ApiResponseMessage.java
 */
package com.app.libraryManagement.api;

import javax.xml.bind.annotation.XmlTransient;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiResponseMessage.
 */
@javax.xml.bind.annotation.XmlRootElement
public class ApiResponseMessage {
	
	/** The Constant ERROR. */
	public static final int ERROR = 1;
	
	/** The Constant WARNING. */
	public static final int WARNING = 2;
	
	/** The Constant INFO. */
	public static final int INFO = 3;
	
	/** The Constant OK. */
	public static final int OK = 4;
	
	/** The Constant TOO_BUSY. */
	public static final int TOO_BUSY = 5;

	/** The code. */
	int code;
	
	/** The type. */
	String type;
	
	/** The message. */
	String message;
	
	/**
	 * Instantiates a new api response message.
	 */
	public ApiResponseMessage(){}
	
	/**
	 * Instantiates a new api response message.
	 *
	 * @param code the code
	 * @param message the message
	 */
	public ApiResponseMessage(int code, String message){
		this.code = code;
		switch(code){
		case ERROR:
			setType("error");
			break;
		case WARNING:
			setType("warning");
			break;
		case INFO:
			setType("info");
			break;
		case OK:
			setType("ok");
			break;
		case TOO_BUSY:
			setType("too busy");
			break;
		default:
			setType("unknown");
			break;
		}
		this.message = message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	@XmlTransient
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
