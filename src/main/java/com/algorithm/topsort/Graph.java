package com.algorithm.topsort;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

/**
 * @Description : TODO
 * @Author : wuqia
 * @Date : 2022/10/24 20:55
 * @Version : 1.0
 **/
@Getter
@Setter
public class Graph {
    /**
     * 顶点数量
     */
    private int pointNum;

    /**
     * 数据表
     */
    private LinkedList<Integer>[] dataTable;

    public Graph(int pointNum) {
        this.pointNum = pointNum;
        this.dataTable = new LinkedList[pointNum];
        for (int i = 0; i < pointNum; i++) {
            this.dataTable[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边缘
     *
     * @param source 源
     * @param target 目标
     */
    public void addEdge(Integer source, Integer target) {
        this.dataTable[source].add(target);
    }
}
