package com.ytit.xyx.MySpringBootTest.doman;

public class Question {

	private int id;				//题目id
	private int course_id;		//课程id
	private int answer_id;		//答案id
	private int score;			//题目分数
	private String qname;		//题目名称
	private String qcontent;	//题目内容
	private String qcontent_a;	//题目A选项
	private String qcontent_b;	//题目B选项
	private String qcontent_c;	//题目C选项
	private String qcontent_d;	//题目D选项
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQcontent_a() {
		return qcontent_a;
	}
	public void setQcontent_a(String qcontent_a) {
		this.qcontent_a = qcontent_a;
	}
	public String getQcontent_b() {
		return qcontent_b;
	}
	public void setQcontent_b(String qcontent_b) {
		this.qcontent_b = qcontent_b;
	}
	public String getQcontent_c() {
		return qcontent_c;
	}
	public void setQcontent_c(String qcontent_c) {
		this.qcontent_c = qcontent_c;
	}
	public String getQcontent_d() {
		return qcontent_d;
	}
	public void setQcontent_d(String qcontent_d) {
		this.qcontent_d = qcontent_d;
	}
	
}
