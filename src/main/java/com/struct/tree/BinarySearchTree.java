package com.struct.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description : 二叉查找树
 * @Author : wuqia
 * @Date : 2023/1/9 21:10
 * @Version : 1.0
 **/
public class BinarySearchTree {

    public TreeNode tree;


    public void insert(int val) {
        if (null == tree) {
            tree = new TreeNode(val);
            return;
        }
        TreeNode p = tree;
        while (null != p) {
            if (val > p.getVal()) {
                if (null == p.right) {
                    p.right = new TreeNode(val);
                    return;
                } else {
                    p = p.right;
                }
            } else {
                if (null == p.left) {
                    p.left = new TreeNode(val);
                    return;
                } else {
                    p = p.left;
                }
            }
        }
    }

    public void delete(int val) {
        // 首先找到节点
        if (null == tree) {
            return;
        }
        TreeNode p = tree;
        TreeNode fp = tree;
        boolean isLeft = Boolean.TRUE;
        while (null != p) {
            if (p.val == val) {
                break;
            } else if (p.val > val) {
                fp = p;
                p = p.left;
            } else {
                fp = p;
                p = p.right;
                isLeft = Boolean.FALSE;
            }

        }
        if (null == p) {
            return;
        }
        // 如果没有子节点直接删除
        if (null != p.left && null != p.right) {
            // 如果有两个子节点，则找右子树的最小节点，替换原有节点，然后删除最小节点的关系
            TreeNode min = p.right;
            TreeNode minFather = p;
            while (null != min.left) {
                minFather = min;
                min = min.left;
            }
            if (isLeft) {
                fp.left.setVal(min.getVal());
            } else {
                fp.right.setVal(min.getVal());
            }
            minFather.left = null;
        } else if (null != p.right) {
            // 如果只有一个子节点，直接替换要删除的节点即可
            if (isLeft) {
                fp.left = p.right;
            } else {
                fp.right = p.right;
            }
        } else if (null != p.left) {
            if (isLeft) {
                fp.left = p.left;
            } else {
                fp.right = p.left;
            }
        } else {
            if (val > fp.getVal()) {
                fp.right = null;
            } else {
                fp.left = null;
            }
        }

    }

    public TreeNode find (int val) {
        if (null == tree) {
            return null;
        }
        TreeNode p = tree;
        while (null != p) {
            if (p.val == val) {
                return p;
            } else if (p.val > val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p;
    }

    public void print () {
        TreeNode p = tree;
        print(p);
    }

    /**
     * 打印 中序遍历
     *
     * @param treeNode 节点
     */
    public void print(TreeNode treeNode) {
        if (null != treeNode) {
            print(treeNode.left);
            System.out.print(treeNode.val + ",");
            print(treeNode.right);
        }
    }

    public void printLayer() {
        // 暂存数据
        List<TreeNode> list = new ArrayList<>();
        list.add(tree);
        while (!list.isEmpty()) {
            // 输出本层，如果这层数据有子节点，则把节点存入list
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode1 : list) {
                System.out.print(treeNode1.val + " ");
                if (null != treeNode1.left) {
                    temp.add(treeNode1.left);
                }
                if (null != treeNode1.right) {
                    temp.add(treeNode1.right);
                }
            }
            System.out.println();
            list = temp;
        }
    }

    public void printLayer1() {
        // 暂存数据
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode treeNode1 = queue.poll();
            System.out.print(treeNode1.val + " ");
            if (null != treeNode1.left) {
                queue.add(treeNode1.left);
            }
            if (null != treeNode1.right) {
                queue.add(treeNode1.right);
            }
        }
    }

    @Data
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(33);
        binarySearchTree.insert(16);
        binarySearchTree.insert(50);
        binarySearchTree.insert(13);
        binarySearchTree.insert(18);
        binarySearchTree.insert(34);
        binarySearchTree.insert(58);
        binarySearchTree.insert(15);
        binarySearchTree.insert(17);
        binarySearchTree.insert(25);
        binarySearchTree.insert(51);
        binarySearchTree.insert(66);
        binarySearchTree.insert(19);
        binarySearchTree.insert(27);
        binarySearchTree.insert(55);
        binarySearchTree.printLayer();
        binarySearchTree.printLayer1();
        binarySearchTree.print();
        System.out.println(binarySearchTree.find(55));
        System.out.println(binarySearchTree.find(54));
        binarySearchTree.delete(13);
        binarySearchTree.delete(18);
        binarySearchTree.delete(55);
        binarySearchTree.print();
    }
}
