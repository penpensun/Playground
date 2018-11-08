package org.peng.web;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


public class MyShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        if (!username.equals("admin"))
            return null;
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                UserService.getPassword(username),
                ByteSource.Util.bytes(UserService.getCredentialsSalt(username)),
                getName()
        );
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String)principalCollection.getPrimaryPrincipal();
        if(username.equals("admin"))
            authorizationInfo.addStringPermission("admin");
        return authorizationInfo;
    }
}
