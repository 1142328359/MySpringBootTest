package com.ytit.xyx.MySpringBootTest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.ytit.xyx.MySpringBootTest.dao.UserDao;

@Controller
public class ShiroController {

//	private static final Logger log = LoggerFactory.getLogger(ShiroController.class);
//	
//	@Autowired
//	private UserDao userDao;
	
	// mapping映射多个URL注意不能使用error
	@RequestMapping(value = { "error404", "errortest" })
	// @ResponseBody//声明返回json数据
	public String moreMappingUrl() {
		return "error404";
	}
	
	
	//shiro登录验证
	//@RequestMapping(value="/login")
//	@RequestMapping(value="/addlogin",method=RequestMethod.GET)
	@RequestMapping("/addlogin")
	public ModelAndView login(ModelAndView modelAndView,HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,RedirectAttributes redirectAttributes) {
		System.out.println("登录的数据传进来了");
		//获取你前台页面输入的验证码username，password
		String username = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");

		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(token);
			modelAndView.setViewName("redirect:/index");
		} catch (LockedAccountException lae) {
			token.clear();
			modelAndView.addObject("info", "用户已经被锁定不能登录，请与管理员联系！");
            modelAndView.setViewName("login");
		} catch (AuthenticationException ae) {
            token.clear();
            modelAndView.addObject("info", "用户或密码不正确！");
            modelAndView.setViewName("login");
        }
		
		return modelAndView;
	}
	
	
	//注销认证
//	@RequestMapping(value="/loginout",method=RequestMethod.GET)
	@RequestMapping("/loginout")
	public String loginout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		//重新定向Url跳转至登录页面
		return "redirect:/login";
	}
}
