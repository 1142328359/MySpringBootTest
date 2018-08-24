package com.ytit.xyx.MySpringBootTest.dao;

//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ytit.xyx.MySpringBootTest.doman.User;


//@Mapper
public interface UserDao {
	/**
	 * 根据登录名和密码查询用户
	 * @param String username
	 * @param String password
	 * @return 找到返回User对象，没有找到返回null
	 * 
	 */
	
	@Select("select * from k_user where username = #{username} and password = #{password}")
	 User findWithUsernameAndPassword(@Param("username")String username,
			@Param("password") String password);
	
	@Select("select * from k_user where username = #{username}")
	 User findByName(@Param("username")String username);

}
