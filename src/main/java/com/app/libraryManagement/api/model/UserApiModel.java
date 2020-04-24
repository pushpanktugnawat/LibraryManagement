/*
 *  Copyright (c) 2020 . All Rights Reserved.
 *  
 *  Filename: UserApiModel.java
 */
package com.app.libraryManagement.api.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





// TODO: Auto-generated Javadoc
/**
 * The Class UserApiModel.
 */
@ApiModel(description = "")
public class UserApiModel  {
  
  
  
  /** The userid. */
  private Long userid = null;
  
  
  /** The full name. */
  private String fullName = null;
  
  
  /** The email id. */
  private String emailId = null;
  
  
  /** The phone no. */
  private String phoneNo = null;

  /** The book ids. */
  private List<BookApiModel> bookIds = new ArrayList<BookApiModel>();
  
  /**
   * Unique Id for each user.
   *
   * @return the userid
   */
  @ApiModelProperty(value = "Unique Id for each user")
  @JsonProperty("userid")
  public Long getUserid() {
    return userid;
  }
  
  /**
   * Sets the userid.
   *
   * @param userid the new userid
   */
  public void setUserid(Long userid) {
    this.userid = userid;
  }

  
  /**
   * Full name of a User.
   *
   * @return the full name
   */
  @ApiModelProperty(value = "Full name of a User")
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }
  
  /**
   * Sets the full name.
   *
   * @param fullName the new full name
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  
  /**
   * Email Id of a User.
   *
   * @return the email id
   */
  @ApiModelProperty(value = "Email Id of a User")
  @JsonProperty("emailId")
  public String getEmailId() {
    return emailId;
  }
  
  /**
   * Sets the email id.
   *
   * @param emailId the new email id
   */
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  
  /**
   * Phone Number of a user.
   *
   * @return the phone no
   */
  @ApiModelProperty(value = "Phone Number of a user")
  @JsonProperty("phoneNo")
  public String getPhoneNo() {
    return phoneNo;
  }
  
  /**
   * Sets the phone no.
   *
   * @param phoneNo the new phone no
   */
  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  /**
   * List of BookIds which User wants to select.
   *
   * @return the book ids
   */
  @ApiModelProperty(value = "List of BookIds which User wants to select")
  @JsonProperty("bookIds")
  public List<BookApiModel> getBookIds() {
    return bookIds;
  }
  
  /**
   * Sets the book ids.
   *
   * @param bookIds the new book ids
   */
  public void setBookIds(List<BookApiModel> bookIds) {
    this.bookIds = bookIds;
  }
  

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserApiModel {\n");
    
    sb.append("  userid: ").append(userid).append("\n");
    sb.append("  fullName: ").append(fullName).append("\n");
    sb.append("  emailId: ").append(emailId).append("\n");
    sb.append("  phoneNo: ").append(phoneNo).append("\n");
    sb.append("  bookIds: ").append(bookIds).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
