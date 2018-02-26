package com.rbac.rbacshow.common.util.user;

import com.base.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* 类描述：用户操作类
* @auther linzf
* @create 2018/1/24 0024 
*/
public class UserInfoUtil {

    /**
     * 功能描述：获取当前登陆的用户的信息
     * 注释：强转一个null对象不会产生报错
     * @return
     */
    public static User getUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        return (User) Optional.ofNullable(securityContextImpl.getAuthentication().getPrincipal()).orElse(null);
    }

    /**
     * 功能描述：获取request对象
     * @return
     */
    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 功能描述：获取当前登陆的用户的权限集合
     * @return
     */
    public static List<GrantedAuthority> getGrantedAuthority(){
        return (List<GrantedAuthority>)Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).orElse(new ArrayList<>());
    }

    /**
     * 功能描述：判断当前的用户是否包含某一个权限
     * @param authority
     * 注释：
     *      allMatch：Stream 中全部元素符合传入的 predicate，返回 true
     *      anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
     *      noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
     * @return
     */
    public static boolean hasAuthority(String authority){
        return getGrantedAuthority().stream().anyMatch(obj->obj.getAuthority().equalsIgnoreCase(authority));
    }

}
