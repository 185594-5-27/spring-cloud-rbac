package com.produce.common.util.user;


import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class UserInfo {


    /**
     * 功能描述：实现对密码进行加盐值得MD5加密
     * @param password
     * @return
     */
    public static String encode(String password,String salt){
        password = password + "{"+salt +"}";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(password.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }






}
