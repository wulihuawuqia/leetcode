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

    public Node tree;


    public void insert(int val) {
        if (null == tree) {
            tree = new Node(val);
            return;
        }
        Node p = tree;
        while (null != p) {
            if (val > p.getValue()) {
                if (null == p.right) {
                    p.right = new Node(val);
                    return;
                } else {
                    p = p.right;
                }
            } else {
                if (null == p.left) {
                    p.left = new Node(val);
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
        Node p = tree;
        Node fp = tree;
        boolean isLeft = Boolean.TRUE;
        while (null != p) {
            if (p.value == val) {
                break;
            } else if (p.value > val) {
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
            Node min = p.right;
            Node minFather = p;
            while (null != min.left) {
                minFather = min;
                min = min.left;
            }
            if (isLeft) {
                fp.left.setValue(min.getValue());
            } else {
                fp.right.setValue(min.getValue());
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
            if (val > fp.getValue()) {
                fp.right = null;
            } else {
                fp.left = null;
            }
        }

    }

    public Node find (int val) {
        if (null == tree) {
            return null;
        }
        Node p = tree;
        while (null != p) {
            if (p.value == val) {
                return p;
            } else if (p.value > val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p;
    }

    public void print () {
        Node p = tree;
        print(p);
    }

    /**
     * 打印 中序遍历
     *
     * @param node 节点
     */
    public void print(Node node) {
        if (null != node) {
            print(node.left);
            System.out.print(node.value + ",");
            print(node.right);
        }
    }

    public void printLayer() {
        // 暂存数据
        List<Node> list = new ArrayList<>();
        list.add(tree);
        while (!list.isEmpty()) {
            // 输出本层，如果这层数据有子节点，则把节点存入list
            List<Node> temp = new ArrayList<>();
            for (Node node1 : list) {
                System.out.print(node1.value + " ");
                if (null != node1.left) {
                    temp.add(node1.left);
                }
                if (null != node1.right) {
                    temp.add(node1.right);
                }
            }
            System.out.println();
            list = temp;
        }
    }

    public void printLayer1() {
        // 暂存数据
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            System.out.print(node1.value + " ");
            if (null != node1.left) {
                queue.add(node1.left);
            }
            if (null != node1.right) {
                queue.add(node1.right);
            }
        }
    }

    @Data
    class Node {
        private Node left;
        private Node right;
        private int value;
        public Node(int value) {
            this.value = value;
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
