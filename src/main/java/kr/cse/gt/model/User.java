package kr.cse.gt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	
	@NotNull
	private String androidToken;
	
	
	private Integer androidAlert;
	
	
	private Integer emailAlert;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAndroidAlert() {
		return androidAlert;
	}

	public void setAndroidAlert(Integer androidAlert) {
		this.androidAlert = androidAlert;
	}

	public Integer getEmailAlert() {
		return emailAlert;
	}

	public void setEmailAlert(Integer emailAlert) {
		this.emailAlert = emailAlert;
	}
}
