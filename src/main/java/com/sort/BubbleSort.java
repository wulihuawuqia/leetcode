package com.sort;

/**
 * @Description : 冒泡排序
 * @Author : wuqia
 * @Date : 2022/8/10 09:56
 * @Version : 1.0
 **/
public class BubbleSort {

    public static int[] sort(int[] arr) {
        if (null == arr || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            // 如果没有交换代表已经有序
            boolean flag = Boolean.FALSE;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                    flag = Boolean.TRUE;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }




}
