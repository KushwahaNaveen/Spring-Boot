package com.nav.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date logtime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", logtime=" + logtime + "]";
	}
	
	

}
