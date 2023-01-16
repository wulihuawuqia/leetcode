package com.struct.tree;

import cn.hutool.core.lang.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : https://leetcode.cn/problems/validate-binary-search-tree/
 * @Author : wuqia
 * @Date : 2023/1/16 09:46
 * @Version : 1.0
 **/
public class IsValidBST98 {

    public static boolean isValidBST(BinarySearchTree.TreeNode root) {
        if(null == root) {
            return false;
        } else {
            if (null != root.left) {
                if (!isValidBST(root.left) || root.left.val >= root.val) {
                    return false;
                }
            }
            if (null != root.right) {
                if (!isValidBST(root.right) || root.right.val <= root.val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidBST1(BinarySearchTree.TreeNode root) {
        if(null == root) {
            return true;
        }
        // 获得中序遍历结果
        List<Integer> list = new ArrayList();
        append(root, list);
        // 判定是否有序
        for(int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static void append(BinarySearchTree.TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        append(root.left, list);
        list.add(root.val);
        append(root.right, list);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        Assert.isTrue(isValidBST(binarySearchTree.tree));
    }
}
