package com.ytit.xyx.MySpringBootTest.configuration;

import java.util.LinkedHashMap;
import java.util.Map;


import org.apache.shiro.spring.LifecycleBeanPostProcessor;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;

/**
 * 2018年8月1日---下午8:13:20 springboot_crmcom.laojie.config
 * 
 * @author laojie QQ:2928547073
 *      
 *        
 */

@Configuration
public class ShiroConfig {

	private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);

	//shiro生命周期处理器
	 @Bean
	    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
	        return new LifecycleBeanPostProcessor();
	    }
	 
	 /*//自定义拦截接口
	 @Bean
		public ShiroRolesAuthorizationFilter authorizatiomFilter()
		{
			return new ShiroRolesAuthorizationFilter();
		}*/
	
	//shiro拦截配置工厂
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		log.info("By logger.info : <--- ShiroConfig.ShiroFilterFactoryBean拦截工厂开始注入 --->");
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//通过编码方式启动安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		//设置登录的url网址
		shiroFilterFactoryBean.setLoginUrl("/login");
		//设置登录成功的url网址
		shiroFilterFactoryBean.setSuccessUrl("/index");
		//shiroFilterFactoryBean.setUnauthorizedUrl("/crm_error/error40402");//返回跳转controller
		
		/*//自定义过滤器
		Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
		filters.put("roles", authorizatiomFilter());*/
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 以下是过滤链，按顺序过滤，所以/**需要放最后
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/icheck/**", "anon");
		filterChainDefinitionMap.put("/image/**", "anon");
		filterChainDefinitionMap.put("/error/**", "anon");
		filterChainDefinitionMap.put("/javascript/**", "anon");
		filterChainDefinitionMap.put("/laydate/**", "anon");
		filterChainDefinitionMap.put("/layui/**", "anon");
		filterChainDefinitionMap.put("/pages/**", "anon");
		filterChainDefinitionMap.put("/addlogin", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		
		//filterChainDefinitionMap.put("/login", "roles[admin]");这个用于权限管理置顶admin有通过的权限
		
		//filterChainDefinitionMap.put("/loginout", "anon");
		//filterChainDefinitionMap.put("/loginout", "logout");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		// 自定义realm权限认证授权
		defaultWebSecurityManager.setRealm(realm());
		// 自定义缓存实现 使用EhCache
		// securityManager.setCacheManager(ehCacheManager());
		//20180807shiro整合redis替代ehcache二级缓存注释
		//defaultWebSecurityManager.setCacheManager(redisCacheManager());
		
		// 自定义session管理 使用redis
		//defaultWebSecurityManager.setSessionManager(sessionManager());

		// 注入记住我管理器;
		defaultWebSecurityManager.setRememberMeManager(rememberMeManager());// 认证成功后由rememberMeManager提供cookie管理对象组

		return defaultWebSecurityManager;
	}

	
	
	
	@Bean
	public Realm realm() {
		log.info("By logger.info : <--- ShiroConfig.Realm自定义realm认证权限控制已注入 --->");
		Realm realm = new Realm();
		//20180807shiro整合redis替代ehcache二级缓存注释
		//realm.setCacheManager(ehCacheManager());
		
		//授权认证初始化设参
		//realm.setCacheManager(redisCacheManager());
		//realm.setAuthenticationCachingEnabled(true);
		//realm.setAuthorizationCachingEnabled(true);
		return realm;
		
		
		
	}
	
	
	

	
	public SimpleCookie rememberMeCookie() {
		//这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		//如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
//	    simpleCookie.setHttpOnly(true);
		//记住我cookie生效时间,默认30天 ,单位秒：60 * 60 * 24 * 30
		simpleCookie.setMaxAge(2592000);
		return simpleCookie;
	}

	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		//rememberme cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位），
		//通过以下代码可以获取
	    //KeyGenerator keygen = KeyGenerator.getInstance("AES");
	    //SecretKey deskey = keygen.generateKey();
	    //System.out.println(Base64.encodeToString(deskey.getEncoded()));
		cookieRememberMeManager.setCookie(rememberMeCookie());
		cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
		return cookieRememberMeManager;
	}
	
	
}
