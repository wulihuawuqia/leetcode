package com.algorithm.shortpath;

import com.sun.javafx.geom.Edge;
import lombok.Data;

import java.util.PriorityQueue;

/**
 * @Description : Dijkstra
 * @Author : wuqia
 * @Date : 2022/10/26 20:22
 * @Version : 1.0
 **/
public class Dijkstra {

    @Data
    private static class Vertex implements Comparable<Vertex> {

        private int id;

        private int dist;

        @Override
        public int compareTo(Vertex o) {
            // 顺序
            if (o.dist > this.dist) {
                return -1;
            }
            return 1;
        }

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public static void dijkstra(int source, int target, Graph graph) {
        // 还原最短路径
        int[] predecessor = new int[graph.getPointNum()];
        // 记录 source -> 某个节点的最短距离
        Vertex[] vertices = new Vertex[graph.getPointNum()];
        // 初始化 dist
        for (int i = 0;  i < graph.getPointNum(); i++) {
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // 优先级队列
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        boolean[] inQueue = new boolean[graph.getPointNum()];
        vertices[source].dist = 0;
        inQueue[source] = true;
        queue.add(vertices[source]);
        while (!queue.isEmpty()) {
            // 取dist 最小的顶点
            Vertex minVertex = queue.poll();
            // 已产生最短路径
            if (minVertex.getId() == target) {
                break;
            }
            // 遍历当前节点的边
            for (int i = 0; i < graph.getDataTable()[minVertex.id].size(); i++) {
                // 取出一条边
                Graph.Edge edge = graph.getDataTable()[minVertex.id].get(i);
                // 取出下个节点到source 的距离
                Vertex nextVertex = vertices[edge.getTarget()];
                // 下个节点的距离大于当前节点的和，则更新最短距离
                if(nextVertex.dist > minVertex.getDist() + edge.getWeight()) {
                    nextVertex.id = edge.getTarget();
                    nextVertex.dist = minVertex.getDist() + edge.getWeight();
                    // 更新前驱节点
                    predecessor[nextVertex.getId()] = minVertex.id;
                    // 同时需要将此节点加入队列
                    if (!inQueue[edge.getTarget()]) {
                        queue.add(nextVertex);
                        inQueue[edge.getTarget()] = true;
                    }
                }
            }
        }
        System.out.println("dist:" + vertices[target]);
        // 输出最短路径
        System.out.print(source);
        print(source, target, predecessor);
    }

    private static void print(int source, int target, int[] predecessor) {
        if(source == target) {
            return;
        }
        print(source, predecessor[target], predecessor);
        System.out.print("->" + target);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        //graph.addEdge(0, 5, 10);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        graph.addEdge(4, 5, 10);
        dijkstra(0, 5, graph);
    }
}
