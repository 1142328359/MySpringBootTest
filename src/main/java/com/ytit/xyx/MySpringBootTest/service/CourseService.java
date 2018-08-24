package com.ytit.xyx.MySpringBootTest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytit.xyx.MySpringBootTest.dao.CourseDao;
import com.ytit.xyx.MySpringBootTest.doman.Course;

@Service
public class CourseService{

	@Autowired
	private CourseDao courseDao;
	
	//查询所有
	public List<Course> findAll() {
		return courseDao.findAllCourse();
	}

	//按id查询
	public List<Course> findOne(int id) {
		return courseDao.findById(id);
	}

	//根据id删除
	public void delete(int id) {
		courseDao.deleteCourse(id);
	}

	//课程名模糊查询
	public ArrayList<Course> select(String content) {
		return courseDao.selectByString(content);
	}

	//插入一条数据
	public void insert(Course course) {
		courseDao.insertByCourse(course);
	}
	
	//更新课程
	public void update(Course course) {
		courseDao.updateById(course);
	}
	
	
}
