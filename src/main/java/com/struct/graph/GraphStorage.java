package com.struct.graph;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @Description : TODO
 * @Author : wuqia
 * @Date : 2023/1/19 20:17
 * @Version : 1.0
 **/
public class GraphStorage {

    /**
     * 矩阵
     */
    private int[][] matrix;

    /**
     * 表格
     */
    private LinkedList<Integer>[] table;

    public GraphStorage (int size) {
        table = new LinkedList[size];
    }

    public void put(int value, int other) {
        if (null == table[value]) {
            table[value] = new LinkedList<>();
        }
        table[value].add(other);
    }

    public void printBFS() {
        Set<Integer>[] bfsArr = new HashSet[table.length];
        // 默认从0开始
        bfs(table[0], 0, bfsArr);
        for (Set<Integer> list1 : bfsArr) {
            System.out.println(JSONUtil.toJsonStr(list1));
        }
    }

    public void dfsFind(int t, Stack<Integer> stack) {
        int start = stack.pop();
        LinkedList<Integer> linkedLists = table[start];
        if (null != linkedLists) {
            stack.add(start);
            for (Integer i : linkedLists) {
                stack.add(i);
                if (i == t) {
                    return;
                } else {
                    dfsFind(t, stack);
                }
            }
        }
    }

    public void bfs(LinkedList<Integer> vertexs, int distance, Set<Integer>[] bfsArr) {
        if (CollUtil.isEmpty(vertexs)) {
            return;
        }
        if (bfsArr[distance] == null) {
            bfsArr[distance] = new HashSet<>();
        }
        for (Integer val : vertexs) {
            bfsArr[distance].add(val);
            bfs(table[val], distance + 1, bfsArr);
        }
    }

    public static class Vertex {
        private int value;
        private int distance;
    }

    public static void main(String[] args) {
        GraphStorage graphStorage = new GraphStorage(8);
        graphStorage.put(0, 1);
        graphStorage.put(0, 3);
        graphStorage.put(1, 2);
        graphStorage.put(1, 4);
        graphStorage.put(3, 4);
        graphStorage.put(2, 5);
        graphStorage.put(4, 5);
        graphStorage.put(4, 6);
        graphStorage.put(5, 7);
        graphStorage.put(6, 7);
        // graphStorage.printBFS();
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        graphStorage.dfsFind(7, stack);
        System.out.println(JSONUtil.toJsonStr(stack));
    }


}
