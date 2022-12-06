package com.algorithm.topsort;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.LinkedList;

/**
 * @Description : TODO
 * source(依赖方) -> target（被依赖）
 * 先把被依赖方输出，然后打印依赖方
 * @Author : wuqia
 * @Date : 2022/10/25 09:26
 * @Version : 1.0
 **/
public class Dfs {


    static String[] name = new String[] {
            "0-内裤","1-裤子","2-鞋子","3-腰带","4-袜子","5-衬衣","6-外套","7-领带"
    };

    static boolean[] isPrint = new boolean[8];

    public static void print(LinkedList<Integer> linkedList, LinkedList<Integer>[] dataTable) {
        // 遍历映射关系
        for (Integer pos : linkedList) {
            if (!dataTable[pos].isEmpty()) {
                print(dataTable[pos], dataTable);
            }
            print(pos);
        }
    }

    public static void dfs(Graph graph) {
        // 遍历所有节点
        for (int i = 0; i < graph.getPointNum(); i ++) {
            if(!graph.getDataTable()[i].isEmpty()) {
                print(graph.getDataTable()[i], graph.getDataTable());
            }
            print(i);
        }
    }

    public static void print(int i) {
        if (!isPrint[i]) {
            System.out.print("->" + name[i]);
            isPrint[i] = true;
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);
        dfs(graph);
    }

}
