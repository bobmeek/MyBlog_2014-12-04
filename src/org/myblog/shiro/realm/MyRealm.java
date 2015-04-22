package org.myblog.shiro.realm;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.myblog.model.ResourceVO;
import org.myblog.model.RoleVO;
import org.myblog.model.UserVO;
import org.myblog.service.facade.ResourceService;
import org.myblog.service.facade.RoleService;
import org.myblog.service.facade.UserService;
  
public class MyRealm extends AuthorizingRealm{  
  
    @Resource(name = "userServiceImpl")
    private UserService userService;  
    
    @Resource(name = "roleServiceImpl")
    private RoleService roleService;
    
    @Resource(name = "resourceServiceImpl")
    private ResourceService resourceServcie;
    /** 
     * 权限认证 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
        //获取登录时输入的用户名  
        String username = (String)principals.getPrimaryPrincipal();
        //到数据库查是否有此对象  
        //UserVO user=userService.findByUsername(username);  
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<RoleVO> roleList = roleService.findByName(username);
        Set<String> roles = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        if(null!=roleList)
        {
	        for (RoleVO role : roleList) roles.add(role.getRole());
	        for (RoleVO role : roleList)
			{
				List<ResourceVO> res = role.getListResource();
				for (ResourceVO r : res) permissions.add(r.getPermission());
			}
        }
        
        //设置角色
        authorizationInfo.setRoles(roles);
        //设置资源权限
        authorizationInfo.setStringPermissions(permissions);
        
        return authorizationInfo;
    }  
  
    /** 
     * 登录认证; 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)throws AuthenticationException {
    	
    	 //获取基于用户名和密码的令牌  
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
        //两个token的引用都是一样的,本例中是org.apache.shiro.authc.UsernamePasswordToken@33799a1e  
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
        UserVO user = userService.findByUsername(token.getUsername());
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if(user.getIsDisabled()==0){
        	throw new LockedAccountException(); //帐号锁定
        }
    	//使用登录原始密码校验
    	
    	/* 如使用这种方式,则是与登录时候填写的密码进行校验。
    	 * <bean id="myRealm" class="org.myblog.shiro.realm.MyRealm" />
    	 * AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getUserpwd(), getName());
    	 */
    	
    	/*  如果spring-shiro的配置中使用了credentialsMatcher,那需要用用户名+盐的方式去验证,交给shiro去做即可.
    	 *  <bean id="myRealm" class="org.myblog.shiro.realm.MyRealm">
    	 *	  <property name="credentialsMatcher" ref="credentialsMatcher"/>
    	 *	</bean>
    	 */
    	//使用用户名+盐后生成的密码校验
    	AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getUserpwd(),ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
    	this.setSession("currentUser", user);  
    	return authcInfo;  
        
    }
    
    /** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  
    
    
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
  
}  