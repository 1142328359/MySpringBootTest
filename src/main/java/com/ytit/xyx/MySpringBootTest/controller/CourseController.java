package com.ytit.xyx.MySpringBootTest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytit.xyx.MySpringBootTest.dao.CourseDao;
import com.ytit.xyx.MySpringBootTest.doman.Course;

@RestController
public class CourseController {

	@Autowired
	private CourseDao courseDao;
	
	//按照课程名查询
	@RequestMapping("/select")
	public List<Course> select(HttpServletRequest req) throws Throwable{
		req.setCharacterEncoding("UTF-8");
		
		//获取前端的数据
		String content = req.getParameter("content");
		System.out.println(content);
		
		//建立一个数组来存储数据库返回的数据
		ArrayList<Course> course = courseDao.selectByString(content);
		
		//return的目的是方便jsp页面接收数据
		return course;
	}
	
	/**
	 * 通过id查找课程
	 */
	@RequestMapping("/getone")
	public List<Course> getone(int id) {
		return courseDao.findById(id);
	}
	
	
	/** 
	 * 获取所有的用户信息 
	 * 
	 * @return 
	 */
	@RequestMapping("/getall")
	public Object getAllCourse() {
		List<Course> list = courseDao.findAllCourse();
		if (null == list || list.size() == 0) {
			return "暂无数据";
		} else {
			return list;
		}
	}
	
	
	/** 
	 * 删除指定id用户 
	 * 
	 * @param id 
	 * @return 
	 */
	@RequestMapping("/deletecourse")
	public Object deleteCourse(int id) {
		List<Course> course = courseDao.findById(id);
		if (null == course) {
			return "删除课程失败:" + id + "没找到该课程";
		} else {
			courseDao.deleteCourse(id);
			return "删除用户成功" + id;
		}
		
	}
	
	//增加课程
	@RequestMapping("/addcourse")
	public Object addCourse(String cname,int user_id,String curl) {
		
		Course course = new Course();
		course.setCname(cname);
		course.setUser_id(user_id);
		course.setCurl(curl);
		
		//添加课程信息
		courseDao.insertByCourse(course);
		
		return "添加成功";
	}
	
	/**
	 * 更新课程
	 */
	@RequestMapping("/updateCourse")
	public int updateCourse(Course course) {
		courseDao.updateById(course);
		return 1;
	} 
	
}
