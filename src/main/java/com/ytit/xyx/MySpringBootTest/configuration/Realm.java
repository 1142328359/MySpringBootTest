package com.ytit.xyx.MySpringBootTest.configuration;

//import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.ytit.xyx.MySpringBootTest.dao.UserDao;
import com.ytit.xyx.MySpringBootTest.doman.User;
import com.ytit.xyx.MySpringBootTest.service.UserService;

/**
 * 
 * @author jiangcheng
 * @email 1142328359@qq.com
 * @data 2018年8月21日
 * @description:MySpringBootTest
 *		add:Realm 类，继承自AuthorizingRealm，
 *		自定义我们自己的授权和认证的方法
 *		访问特定于应用程序的安全性数据（如用户，角色和权限）的组件
 *		https://blog.csdn.net/stackfing/article/details/79145013
 */

@Component	//把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>
public class Realm extends AuthorizingRealm{
	
	private static final Logger logger = LoggerFactory.getLogger(Realm.class);
		
	@Autowired
	private UserService userService;
	//@Autowired
	//private UserRoleService userRoleService;
	/*// 角色操作授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 从凭证中获得用户名
		//String username = (String) SecurityUtils.getSubject().getPrincipal();
		//修改时间20180808
		String username = (String)principalCollection.getPrimaryPrincipal();
		// 根据用户名查询用户对象
		UserModel usermodel = userService.getUserByUserName(username);
		// 查询用户拥有的角色
		List<UserRoleModel> list = userRoleService.findByUserId(usermodel.getUserid());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (UserRoleModel userRoleModel : list) {
			// 赋予用户角色
			logger.info("---> 当前用户 " + username + " --->角色操作权限 " + userRoleModel.getRole());
			info.addRole(userRoleModel.getRole());
			info.addStringPermission(userRoleModel.getRole());
		}
		return info;
	}*/
		
	//用户拦截登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
		//获取当前用户的用户名
		String username = (String) token.getPrincipal();
		//从数据库中根据用户名去查找用户
		User user = userService.getUserByUserName(username);
		if (userService.getUserByUserName(username) == null) {
			throw new UnknownAccountException("没有在本系统中找到对应的用户信息。");
		}
		//getName由shiro框架提供
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),
				user.getPassword(),getName());
		//当验证都通过后，把用户信息放到session里
		logger.info("---> 当前用户 " + username);
		//Session session = SecurityUtils.getSubject().getSession();
		// session.setAttribute("userSession", admin);
        //session.setAttribute("userSessionId", admin.getUserid());
				
		return info;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}
	
//	/**
//  * 清除所有用户的缓存
//  */
// public void clearAuthorizationInfoCache() {
//     Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//     if(cache!=null) {
//         cache.clear();
//     }
// }
//
// /**
//  * 清除指定用户的缓存
//  * @param user
//  */
// private void clearAuthorizationInfoCache(UserModel userModel,UserRoleModel userRoleModel) {
//     Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//     cache.remove(userModel.getUserid());
//     cache.remove(userRoleModel.getUserid());
//     cache.remove(userModel.getUsername());
// }
	
	
	/**
  * 指定principalCollection 清除
  */
	/*
 public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
     SimplePrincipalCollection principals = new SimplePrincipalCollection(
             principalCollection, getName());
     super.clearCachedAuthorizationInfo(principals);
 }
	*/	
}
/**
 * doGetAuthenticationInfo()权限认证（为当前登录的Subject授予角色和权限）
 * 该方法的调用时机为需授权资源被访问时，并且每次访问需授权资源都会执行该方法中的逻辑，这表明本例中并未启用AuthorizationCache，
 * 如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），
 * 超过这个时间间隔再刷新页面，该方法会被执行
 *
 * doGetAuthorizationInfo()是权限控制，
 * 当访问到页面的时候，使用了相应的注解或者shiro标签才会执行此方法否则不会执行，
 * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可
 */	