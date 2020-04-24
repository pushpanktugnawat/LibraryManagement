/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: BookApiModel.java
 */
package com.app.libraryManagement.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





// TODO: Auto-generated Javadoc
/**
 * The Class BookApiModel.
 */
@ApiModel(description = "")
public class BookApiModel  {
  
  
  
  /** The book id. */
  private Long bookId = null;
  
  
  /** The book name. */
  private String bookName = null;
  
  
  /** The no of copies. */
  private Integer noOfCopies = null;
  
  
  /** The created time. */
  private String createdTime = null;
  
  
  /** The author. */
  private String author = null;
  
  
  /** The isbn. */
  private String isbn = null;

  
  /**
   * Unique Id for Each BookApiModel.
   *
   * @return the book id
   */
  @ApiModelProperty(value = "Unique Id for Each BookApiModel")
  @JsonProperty("bookId")
  public Long getBookId() {
    return bookId;
  }
  
  /**
   * Sets the book id.
   *
   * @param bookId the new book id
   */
  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  
  /**
   * Name of the BookApiModel.
   *
   * @return the book name
   */
  @ApiModelProperty(value = "Name of the BookApiModel")
  @JsonProperty("bookName")
  public String getBookName() {
    return bookName;
  }
  
  /**
   * Sets the book name.
   *
   * @param bookName the new book name
   */
  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  
  /**
   * Number of Copies present.
   *
   * @return the no of copies
   */
  @ApiModelProperty(value = "Number of Copies present")
  @JsonProperty("noOfCopies")
  public Integer getNoOfCopies() {
    return noOfCopies;
  }
  
  /**
   * Sets the no of copies.
   *
   * @param noOfCopies the new no of copies
   */
  public void setNoOfCopies(Integer noOfCopies) {
    this.noOfCopies = noOfCopies;
  }

  
  /**
   * Create time in DB.
   *
   * @return the created time
   */
  @ApiModelProperty(value = "Create time in DB")
  @JsonProperty("createdTime")
  public String getCreatedTime() {
    return createdTime;
  }
  
  /**
   * Sets the created time.
   *
   * @param createdTime the new created time
   */
  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  
  /**
   * Author of the BookApiModel.
   *
   * @return the author
   */
  @ApiModelProperty(value = "Author of the BookApiModel")
  @JsonProperty("author")
  public String getAuthor() {
    return author;
  }
  
  /**
   * Sets the author.
   *
   * @param author the new author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  
  /**
   * ISBN Code for the book.
   *
   * @return the isbn
   */
  @ApiModelProperty(value = "ISBN Code for the book")
  @JsonProperty("isbn")
  public String getIsbn() {
    return isbn;
  }
  
  /**
   * Sets the isbn.
   *
   * @param isbn the new isbn
   */
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookApiModel {\n");
    
    sb.append("  bookId: ").append(bookId).append("\n");
    sb.append("  bookName: ").append(bookName).append("\n");
    sb.append("  noOfCopies: ").append(noOfCopies).append("\n");
    sb.append("  createdTime: ").append(createdTime).append("\n");
    sb.append("  author: ").append(author).append("\n");
    sb.append("  isbn: ").append(isbn).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
