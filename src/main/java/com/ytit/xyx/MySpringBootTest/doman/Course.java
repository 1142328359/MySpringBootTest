package com.ytit.xyx.MySpringBootTest.doman;

public class Course {

	private int id;			//课程id
	private int user_id;	//用户id
	private String cname;	//课程名称
	private String curl;	//课程链接
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCurl() {
		return curl;
	}
	public void setCurl(String curl) {
		this.curl = curl;
	}
	
	
}
