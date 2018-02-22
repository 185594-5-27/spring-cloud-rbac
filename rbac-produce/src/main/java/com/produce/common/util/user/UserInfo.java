package com.produce.common.util.user;


import com.base.entity.Tree;
import com.base.entity.User;
import com.produce.common.util.node.NodeUtil;
import com.produce.sys.service.TreeService;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 功能描述：加载菜单节点的数据
     * @return
     */
    public static List<Tree> loadUserTree(TreeService treeService, User user){
        Map<Long,Tree> treeMap = new HashMap<Long,Tree>();
        for(Tree tree:treeService.loadUserTree(user)){
            treeMap.put(tree.getId(),tree);
        }
        List<Tree> treeList = NodeUtil.getChildNodes(new ArrayList<Tree>(treeMap.values()),0l);
        return treeList;
    }



}
