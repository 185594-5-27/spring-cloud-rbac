package com.rbac.rbacshow.common.util.uuid;

import java.util.Random;
import java.util.UUID;

/*
* 类描述：生成
* @auther linzf
* @create 2018/1/24 0024 
*/
public class Uuid {

    //token --------uuid
    public static String getUUid(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    //六位随机数
    public static String getRandomNum(int pwd_len){
        //35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 36;
        int i; //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while(count < pwd_len){
            //生成随机数，取绝对值，防止生成负数，
            i = Math.abs(r.nextInt(maxNum)); //生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count ++;
            }
        }

        return pwd.toString();
    }

}
