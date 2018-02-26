package com.rbac.rbacshow.common.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/*
* 类描述：实现根据不同的权限实现登陆的时候页面的跳转
* @auther linzf
* @create 2017/11/13 0013 
*/
public class LoginSuccessHandle  implements AuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String path = request.getContextPath() ;
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
       // if (roles.contains("ROLE_DINER")){
           // response.sendRedirect(basePath+"diningTable");
           // return;
       // }
        response.sendRedirect(basePath+"main");
    }
}
