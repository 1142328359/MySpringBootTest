package com.ytit.xyx.MySpringBootTest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ytit.xyx.MySpringBootTest.doman.Course;

//@Mapper
public interface CourseDao {

	//课程名模糊查询
	//CONCAT(CONCAT('%', #{content}),'%')
	//concat函数就是SQL语句的拼接函数
	@Select("select * from k_course where cname like CONCAT('%', #{content},'%')")
	ArrayList<Course> selectByString(String content);
	
	//查询所有
	@Select("select * from k_course")
	List<Course> findAllCourse();
	
	//按课程id查询
	@Select("select * from k_course where id like #{id}")
	  List<Course> findById(int id);
	
	//根据id删除
	@Delete("delete from k_course where id like #{id}")
	void deleteCourse(int id);
	
	//插入一条数据
	@Insert("insert into k_course(id,user_id,cname,curl) values(#{id},#{user_id},#{cname},#{curl})")
	void insertByCourse(Course course);
	
	//更新数据
	@Update("update k_course set cname=#{cname},user_id=#{user_id},curl=#{curl} where id=#{id}")
	void updateById(Course course);
}
