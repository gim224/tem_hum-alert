package kr.cse.gt.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{
	private static final long serialVersionUID = 5974121690378085051L;

	@Id
	@GeneratedValue
	private Integer id;

	//user가 입력한 ID입니다.
	@NotNull(message = "비워둘 수 없습니다")
	@Size(min=1, message = "이름을 입력하세요")
	@Column(unique=true)
	private String username;

	@NotNull(message = "비워둘 수 없습니다")
	@Size(min=1, message = "아이디를 입력하세요")	
	private String fullName;

	@NotNull(message = "비워둘 수 없습니다")
	@Size(min=1, message = "비밀번호를 입력하세요")
	private String password;

	@NotNull(message = "비워둘 수 없습니다")
	@Size(min=1, message = "이메일을 입력하세요")
	@Column(unique=true)
	private String email;

	// @NotNull
	private String androidToken;

	// @Type(type="true_false") //not working for '1' and '0' in NUMERIC(1) field
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@NotNull(message = "비워둘 수 없습니다")	
	private Boolean emailAlert;

	// @Type(type="true_false") //not working for '1' and '0' in NUMERIC(1) field
	@Type(type = "org.hibernate.type.NumericBooleanType")
	// @NotNull(message = "비워둘 수 없습니다")
	private Boolean androidAlert;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean isEnabled;

	

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

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



	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getAndroidToken() {
		return androidToken;
	}

	public void setAndroidToken(String androidToken) {
		this.androidToken = androidToken;
	}

	public Boolean getEmailAlert() {
		return emailAlert;
	}

	public void setEmailAlert(Boolean emailAlert) {
		this.emailAlert = emailAlert;
	}

	public Boolean getAndroidAlert() {
		return androidAlert;
	}

	public void setAndroidAlert(Boolean androidAlert) {
		this.androidAlert = androidAlert;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		User other = (User)obj;
		return this.username.equals(other.username);
	}
	
	

}
