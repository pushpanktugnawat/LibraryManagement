/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: UserEntity.java
 */
package com.app.libraryManagement.entity.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class UserEntity.
 */
@Entity
@Table(name="users")
public class UserEntity {
	
	/** Primary key of Table Users. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
    private Long id;
	
	/** Full name of user : First name + Last name. */
	@Column(name="full_name")
	private String fullname;
	
	/** Email Id of User. */
	@Column(name="email_id")
	private String emailId;
	
	/** Phone number of a User. */
	@Column(name="phone_no")
	private String phoneNo;
	
	
	/** The user book entity. */
	@ManyToMany(targetEntity=BookEntity.class, fetch=FetchType.LAZY)
	@JoinTable(name="user_book",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="book_id"))
	private Set<BookEntity> userBookEntity; 

	
	/**
	 * Gets the user book entity.
	 *
	 * @return the user book entity
	 */
	public Set<BookEntity> getUserBookEntity() {
		return userBookEntity;
	}

	/**
	 * Sets the user book entity.
	 *
	 * @param userBookEntity the new user book entity
	 */
	public void setUserBookEntity(Set<BookEntity> userBookEntity) {
		this.userBookEntity = userBookEntity;
	}

	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the fullname.
	 *
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * Sets the fullname.
	 *
	 * @param fullname the new fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
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
	 * Gets the phone no.
	 *
	 * @return the phone no
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", fullname=" + fullname + ", emailId=" + emailId + ", phoneNo=" + phoneNo
				+ "]";
	}

	
	
	

}
