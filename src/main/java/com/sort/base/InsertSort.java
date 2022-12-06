package com.sort.base;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.log.StaticLog;
import com.sort.SortTest;

import java.util.Arrays;

/**
 * @Description : 插入排序：确认已排序区，每次选取一个未排序区元素，从后往前和已排序区元素对比，如果未排元素小于已排元素，则将已排元素后移，将未排元素插入
 * @Author : wuqia
 * @Date : 2022/8/10 10:14
 * @Version : 1.0
 **/
public class InsertSort {

    public static int[] sort(int[] arr) {
        if (null == arr || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        // 默认1
        for (int i = 1; i < arr.length; i++) {
            //记录需要插入的值
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j --) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }

            if (j < i - 1) {
                // 注意上面循环之后 j 会多减 1
                arr[j+1] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr1 = Arrays.copyOf(SortTest.arr, SortTest.arr.length);
        Arrays.sort(arr1);
        StaticLog.error("arr:{}", Arrays.toString(InsertSort.sort(SortTest.arr)));
        Assert.isTrue(ArrayUtil.equals(arr1, InsertSort.sort(SortTest.arr)));
    }
}
