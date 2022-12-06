package com.algorithm.shortpath;

import cn.hutool.poi.exceptions.POIException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

/**
 * @Description : 有向，有权图
 * @Author : wuqia
 * @Date : 2022/10/26 20:13
 * @Version : 1.0
 **/
@Data
public class Graph {

    @Data
    @AllArgsConstructor
    public class Edge {

        /**
         * 源
         */
        private int source;

        /**
         * 目标
         */
        private int target;

        /**
         * 权重
         */
        private int weight;


    }

    private LinkedList<Edge>[] dataTable;

    private int pointNum;


    public Graph(int pointNum) {
        this.pointNum = pointNum;
        this.dataTable = new LinkedList[pointNum];
        for (int i = 0; i < pointNum; i++) {
            this.dataTable[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int target, int weight) {
        this.dataTable[source].add(new Edge(source, target, weight));
    }
}
