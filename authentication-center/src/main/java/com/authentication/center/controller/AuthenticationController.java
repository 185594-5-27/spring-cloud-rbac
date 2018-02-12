package com.authentication.center.controller;

import com.base.entity.Identify;
import com.base.entity.User;
import com.base.util.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* 类描述：鉴权中心业务处理类controller
* @auther linzf
* @create 2018/02/12 0024
*/
@RestController
public class AuthenticationController {

    @Autowired
    private RedisCache redisCache;

    @RequestMapping(value = "/identify", method= RequestMethod.POST)
    public  Map<String,Object> identify(@RequestBody Identify identify){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("result",false);
        result.put("msg","用户非法登陆");
        if(identify !=null&& identify.getToken()!=null&&!identify.getToken().equals("")&& identify.getIp()!=null&&!identify.getIp().equals("")){
            System.out.println("鉴权中心收到的token的值是："+ identify.getIp()+"--"+ identify.getToken());
            User user = redisCache.getObject(identify.getIp()+"-"+ identify.getToken(),User.class);
            if(user==null){
                result.put("result",false);
                result.put("msg","用户未登陆，请重新登陆以后再操作！");
                return result;
            }
            result.put("result",true);
            result.put("msg","权限鉴定通过");
        }
        return result;
    }

}
