package com.struct.heap;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * @Description : 堆实现
 * @Author : wuqia
 * @Date : 2023/1/11 09:57
 * @Version : 1.0
 **/
public class Heap {
    private int[] datas;

    private int n;

    private int count;

    public Heap(int n) {
        datas = new int[n + 1];
        this.n = n;
    }

    /**
     * 插入
     * 递归判定与父节点大小，如果大于则交换位置
     * 当前节点位置 为i 则父节点位置为i/2
     * @param data 数据
     */
    public void insert(int data) {
        if (count + 1 > n) {
            return;
        }
        int i = ++count;
        datas[i] = data;
        int fatherPosition = i/2;
        while(fatherPosition > 0 && datas[fatherPosition] < datas[i]) {
            int temp = datas[fatherPosition];
            datas[fatherPosition] = datas[i];
            datas[i] = temp;
            i = fatherPosition;
            fatherPosition = i/2;
        }
    }

    public int removeMax() {
        if (count == 0) {
            return -1;
        }
        int result = datas[1];
        datas[1] = datas[count];
        --count;
        heapify(datas, count, 1);
        return result;
    }

    private void heapify(int []datas, int n, int i) {
        // 依次比对头节点和子节点大小，判定是否需要交换位置。
        while (true) {
            int maxPosition = i;
            int leftPosition = i * 2;
            int rightPositon = i * 2 +1;
            if(leftPosition < n && datas[leftPosition] > datas[maxPosition]) {
                maxPosition = leftPosition;
            }
            if (rightPositon < n && datas[rightPositon] > datas[maxPosition]) {
                maxPosition = rightPositon;
            }
            // 如果位置未改变，则代表已经全部对比完
            if (maxPosition == i) {
                break;
            }
            // 交换位置
            int temp = datas[i];
            datas[i] = datas[maxPosition];
            datas[maxPosition] = temp;
            i = maxPosition;
        }
    }

    public String toString() {
        return Arrays.toString(datas);
    }

    public int[] sort() {
        int [] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = removeMax();
        }
        return temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(6);
        heap.insert(1);
        heap.insert(2);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        System.out.println(heap);
        System.out.println(Arrays.toString(heap.sort()));
    }

}
