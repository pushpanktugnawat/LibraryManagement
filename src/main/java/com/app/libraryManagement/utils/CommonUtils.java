/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: CommonUtils.java
 */
package com.app.libraryManagement.utils;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

// TODO: Auto-generated Javadoc
/**
 * 	Common Utils which will cover all the generic functions and constants
 * 
 * *.
 */
public class CommonUtils {

	
	/** The Constant USER_CREATED_SUCCESSFULLY. */
	public static final String USER_CREATED_SUCCESSFULLY="User created successfully";
	
	/** The Constant BOOK_CREATED_SUCCESSFULLY. */
	public static final String BOOK_CREATED_SUCCESSFULLY="Book entry created successfully";
	
	/** The Constant BOOK_BORROWED_SUCCESSFULLY. */
	public static final String BOOK_BORROWED_SUCCESSFULLY="Book borrowed successfully";
	
	/** The Constant BOOK_RETURN_SUCCESSFULLY. */
	public static final String BOOK_RETURN_SUCCESSFULLY="Book returned successfully";
	
	/** The Constant YOU_ARE_NOT_ALLOWED_TO_BORROW_TWO_COPIES_OF_A_BOOK. */
	public static final String YOU_ARE_NOT_ALLOWED_TO_BORROW_TWO_COPIES_OF_A_BOOK="Sorry ! You are not allowed to borrow two copies of same book";
	
	/** The Constant LIBRARY_MANAGEMENT. */
	public static final String LIBRARY_MANAGEMENT="libraryManagementDB";
	
	/** The Constant DATE_FORMAT_YYYY_MM_DD_HH_MM_SS. */
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss";
	
	/** The Constant SOMETHING_WENT_WRONG. */
	public static final String SOMETHING_WENT_WRONG="Something went wrong";

	/** The Constant INVALID_BOOK_ID. */
	public static final String INVALID_BOOK_ID = "Invalid Book Id";

	/** The Constant NO_BOOK_SELECTED_TO_RETURN. */
	public static final String NO_BOOK_SELECTED_TO_RETURN = "No Book Selected to Return";

	/** The Constant BOOK_NOT_AVAILABLE. */
	public static final String BOOK_NOT_AVAILABLE = "Book is not available in Library";

	/** The Constant NO_BOOK_SELECTED. */
	public static final String NO_BOOK_SELECTED = "NO BOOK SELECTED";

	/** The Constant USER_PREVILIGED_NOT_TO_GET_MORE_THAN_2_BOOKS. */
	public static final String USER_PREVILIGED_NOT_TO_GET_MORE_THAN_2_BOOKS = "Users are priviliged to own 2 books only at a time.";

	/** The Constant ZERO. */
	public static final int ZERO = 0;
	
	
	/**
	 * Generic function to convert date to String.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String convertDateToString(Date date) {
		
		return DateFormatUtils.format(date, CommonUtils.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
		
	}
}
