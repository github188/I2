package com.bullx.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "bullx_i2")
public class Users implements java.io.Serializable {

	// Fields

	private String userId;
	private String pwd;
	private String userName;
	private String role;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public Users(String userId, String pwd, String userName, String role) {
		this.userId = userId;
		this.pwd = pwd;
		this.userName = userName;
		this.role = role;
	}

	// Property accessors
	@Id
	@Column(name = "User_ID", unique = true, nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PWD", length = 20)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "User_Name", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Role", length = 20)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}