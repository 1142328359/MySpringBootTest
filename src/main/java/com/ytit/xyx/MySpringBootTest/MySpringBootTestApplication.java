package com.ytit.xyx.MySpringBootTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author jiangcheng
 * @email 1142328359@qq.com
 * @data 2018年8月21日
 * @description:MySpringBootTest	启动类
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.ytit.xyx.MySpringBootTest.*"})
@MapperScan("com.ytit.xyx.MySpringBootTest.dao")
public class MySpringBootTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootTestApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		      
		        return builder.sources(MySpringBootTestApplication.class);
	 }
}
