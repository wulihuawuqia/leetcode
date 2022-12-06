package com.struct.trie;

import cn.hutool.core.lang.Assert;

/**
 * @Description : TODO
 * @Author : wuqia
 * @Date : 2022/10/19 20:55
 * @Version : 1.0
 **/
public class TrieTree {

    private TrieNode root = new TrieNode('/', false);

    /**
     * 插入
     *
     * @param text 文本
     */
    public void insert(char[] text) {
        if (null == text) {
            return;
        }
        // 遍历数组，元素写入
        TrieNode trieNode = root;
        int count = 0;
        for (char item : text) {
            int index = item - 'a';
            // 获取一个元素
            TrieNode temp = trieNode.getChildren()[index];
            // 如果当前字母不存在，则需要构造
            if (null == temp) {
                temp = new TrieNode(item, count == text.length - 1);
                trieNode.getChildren()[index] = temp;
            }
            trieNode = trieNode.getChildren()[index];
            count ++;
        }
    }

    public boolean find(char[] pattern) {
        if (null != pattern) {
            TrieNode trieNode = root;
            //遍历查询数组
            for (char item : pattern) {
                int index = item - 'a';
                // 获取一个元素
                trieNode = trieNode.getChildren()[index];
                if (null == trieNode) {
                    return false;
                } else {
                    System.out.print(item);
                }
            }
            // 打印模糊匹配的所有字符串
            print(trieNode);
            return true;
        }
        return false;
    }

    private void print(TrieNode trieNode) {
        if (trieNode.isEndingChar()) {
            System.out.println();
        }
        for (TrieNode children : trieNode.getChildren()) {
            if (null != children) {
                System.out.print(children.getData());
                print(children);
            }
        }
    }

    public static void main(String[] args) {
        // 初始化树
        TrieTree trieTree = new TrieTree();
        trieTree.insert(new char[] {'h','o','w'});
        trieTree.insert(new char[] {'h','i'});
        trieTree.insert(new char[] {'h','e','r'});
        trieTree.insert(new char[] {'h','e','l','l','o'});
        Assert.isTrue(trieTree.find(new char[] {'h','o'}));
        Assert.isTrue(trieTree.find(new char[] {'h','e'}));
        Assert.isTrue(trieTree.find(new char[] {'h','e','l'}));
        Assert.isFalse(trieTree.find(new char[] {'h','e','k'}));
    }
}
