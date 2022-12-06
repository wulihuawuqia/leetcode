package com.struct.trie;

import lombok.Data;

/**
 * @Description : 多叉树节点
 * @Author : wuqia
 * @Date : 2022/10/19 20:50
 * @Version : 1.0
 **/
@Data
public class TrieNode {


    /**
     * 数据
     */
    private char data;

    /**
     * 孩子 节点，由于只存储26个字母，所以初始化为26
     */
    private TrieNode[] children = new TrieNode[26];

    private boolean isEndingChar = false;

    public TrieNode(char data, boolean isEndingChar) {
        this.data = data;
        this.isEndingChar = isEndingChar;
    }
}
