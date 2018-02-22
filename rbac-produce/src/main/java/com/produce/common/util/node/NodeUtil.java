package com.produce.common.util.node;







import com.base.entity.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
* 类描述：
* @auther linzf
* @create 2017/9/20 0020 
*/
public class NodeUtil {

    private static List<Tree> returnList = new ArrayList<Tree>();

    /**
     * 根据父节点的ID获取所有子节点
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @return String
     */
    public static List<Tree> getChildNodes(List<Tree> list, Long typeId) {
        returnList = new ArrayList<Tree>();
        if(list == null && typeId == null) return new ArrayList<Tree>();
        for (Iterator<Tree> iterator = list.iterator(); iterator.hasNext();) {
            Tree node = (Tree) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getpId()==0 && typeId==node.getId()) {
                recursionFn(list, node);
            }
            // 二、遍历所有的父节点下的所有子节点
            if (node.getpId()==0) {
                recursionFn(list, node);
            }
        }
        // 对顶层菜单按照treeOrder从大到小进行进行排序
        Collections.sort(returnList);
        return returnList;
    }

    private static void recursionFn(List<Tree> list, Tree node) {
        List<Tree> childList = getChildList(list, node);// 得到子节点列表
        if (hasChild(list, node)) {// 判断是否有子节点
            Iterator<Tree> it = childList.iterator();
            while (it.hasNext()) {
                Tree n = (Tree) it.next();
                if(hasChild(list,n)){// 判断子节点是否还有相应的子节点，若有则再次递归遍历
                    recursionFn(list, n);
                }
            }
            node.setChild(childList);
            returnList.add(node);
        }
    }

    // 得到子节点列表
    private static List<Tree> getChildList(List<Tree> list, Tree node) {
        List<Tree> nodeList = new ArrayList<Tree>();
        Iterator<Tree> it = list.iterator();
        while (it.hasNext()) {
            Tree n = (Tree) it.next();
            if (n.getpId() == node.getId()) {
                nodeList.add(n);
            }
        }
        Collections.sort(nodeList);
        return nodeList;
    }

    // 判断是否有子节点
    private static boolean hasChild(List<Tree> list, Tree node) {
        return getChildList(list, node).size() > 0 ? true : false;
    }

}
