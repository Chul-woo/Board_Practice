package kr.kcw.practice.VO;

import java.util.Date;

public class UserVO {

	private String id;
	private String email;
	private String name;
	private String password;
	private String agree;
	private Date regdate;
	
	public UserVO() {}
	
	public UserVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public UserVO(String id, String email, String password, String agree) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.agree = agree;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
