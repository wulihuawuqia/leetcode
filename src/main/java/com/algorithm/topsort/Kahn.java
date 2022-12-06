package com.algorithm.topsort;

import javax.management.Query;
import java.util.LinkedList;

/**
 * @Description : Kahn  基于贪心
 * source(被依赖方) -> target（依赖方）
 * 1、如果某个顶点入度为0就表示没有其他节点要先于它
 * 2、找到入度为0的节点，输出后，将所有依赖它的节点入度减1
 * 如果输出节点数小于总节点数，代表有环形结构
 * @Author : wuqia
 * @Date : 2022/10/24 20:19
 * @Version : 1.0
 **/
public class Kahn {

    static String[] name = new String[] {
        "0-内裤","1-裤子","2-鞋子","3-腰带","4-袜子","5-衬衣","6-外套","7-领带"
    };

    public static void sort(Graph graph) {
        //统计入度为0的节点
        int[] inDegree = new int[graph.getPointNum()];
        for (LinkedList<Integer> linkedList : graph.getDataTable()) {
            for (Integer integer : linkedList) {
                inDegree[integer]++;
            }
        }
        // 初始化入度为0的节点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.getPointNum(); i++) {
            if (0 == inDegree[i]) {
                queue.add(i);
            }
        }
        // 遍历queue
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + name[i]);
            // 遍历依赖此节点的其他节点
            for (int j : graph.getDataTable()[i]) {
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    queue.add(j);
                }
            }
        }


    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(7, 6);
        sort(graph);
    }

}
