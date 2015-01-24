/**  
 * @Title: AuthenticatorT.java
 * @Package org.myblog.user.shiro
 * @Description: TODO
 * @author bobmeek
 * @date Jan 19, 2015 3:57:37 PM
 * @version V1.0  
 */
package org.myblog.user.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: AuthenticatorT
 * @Description: TODO
 * @author bobmeek
 * @date Jan 19, 2015 3:57:37 PM
 */
public class AuthenticatorT
{

	/*@Test
	public void testAllSuccessfulStrategyWithSuccess()
	{
		login("classpath:org/myblog/user/shiro/config/shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();

		// 得到一个身份集合，其包含了Realm验证成功的身份信息
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(2, principalCollection.asList().size());
	}

	@Test(expected = UnknownAccountException.class)
	public void testAllSuccessfulStrategyWithFail()
	{
		login("classpath:org/myblog/user/shiro/config/shiro-authenticator-all-fail.ini");
		Subject subject = SecurityUtils.getSubject();
	}
	
	@Test
	public void testAtLeastOneSuccessfulStrategyWithSuccess()
	{
		login("classpath:org/myblog/user/shiro/config/shiro-authenticator-atLeastOne-success.ini");
		Subject subject = SecurityUtils.getSubject();

		// 得到一个身份集合，其包含了Realm验证成功的身份信息
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(2, principalCollection.asList().size());
	}


	@Test
	public void testFirstOneSuccessfulStrategyWithSuccess()
	{
		login("classpath:org/myblog/user/shiro/config/shiro-authenticator-first-success.ini");
		Subject subject = SecurityUtils.getSubject();

		// 得到一个身份集合，其包含了第一个Realm验证成功的身份信息
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(1, principalCollection.asList().size());
	}

	@Test
	public void testAtLeastTwoStrategyWithSuccess()
	{
		login("classpath:org/myblog/user/shiro/config/shiro-authenticator-atLeastTwo-success.ini");
		Subject subject = SecurityUtils.getSubject();

		// 得到一个身份集合，因为myRealm1和myRealm4返回的身份一样所以输出时只返回一个
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(1, principalCollection.asList().size());
	}

	@Test
	public void testOnlyOneStrategyWithSuccess()
	{
		login("classpath:org/myblog/user/shiro/config/shiro-authenticator-onlyone-success.ini");
		Subject subject = SecurityUtils.getSubject();

		// 得到一个身份集合，因为myRealm1和myRealm4返回的身份一样所以输出时只返回一个
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(1, principalCollection.asList().size());
	}

	private void login(String configFile)
	{
		// 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(configFile);

		// 2、得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

		subject.login(token);
	}*/
}
