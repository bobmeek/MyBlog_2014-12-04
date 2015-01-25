package org.myblog.shiro.realm;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.myblog.model.ResourceVO;
import org.myblog.model.RoleVO;
import org.myblog.model.UserVO;
import org.myblog.service.facade.ResourceServcie;
import org.myblog.service.facade.RoleService;
import org.myblog.service.facade.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
  
public class UserRealm extends AuthorizingRealm{  
  
    @Resource(name = "userServiceImpl")
    private UserService userService;  
    
    @Resource(name = "roleServiceImpl")
    private RoleService roleService;
    
    @Resource(name = "resourceServiceImpl")
    private ResourceServcie resourceServcie;
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
        List<RoleVO> roles = roleService.findByName(username);
        List<ResourceVO> resources = resourceServcie.findByName(username);
        Set<String> rolesSet = new HashSet<String>();
        Set<String> resourcesSet = new HashSet<String>();
        for (RoleVO role : roles)
		{
        	rolesSet.add(role.getRole());
		}
        for (ResourceVO resource : resources)
		{
        	resourcesSet.add(resource.getPermission());
		}
        authorizationInfo.setRoles(rolesSet);
        authorizationInfo.setStringPermissions(resourcesSet);
        
        return authorizationInfo;
    }  
  
    /** 
     * 登录认证; 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	
    	String username = (String)token.getPrincipal();

        UserVO user = userService.findByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(Boolean.TRUE.equals(user.getIsDisabled())) {
            throw new LockedAccountException(); //帐号锁定
        }

//        交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getUserpwd(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
        
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