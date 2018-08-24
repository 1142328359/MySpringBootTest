package com.ytit.xyx.MySpringBootTest.doman;

public class User {

	private int id;				//用户id
	private int power_id;		//权限id
	private String username;	//用户名
	private String password;	//密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPower_id() {
		return power_id;
	}
	public void setPower_id(int power_id) {
		this.power_id = power_id;
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
	
}
