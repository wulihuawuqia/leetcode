package com.sort;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.log.StaticLog;

import java.util.Arrays;

/**
 * @Description : 快速排序
 * 首先选取一个中间节点，然后遍历数组，将小于的放到元素左边，大于的放到元素右边
 * 然后递归两侧区间
 * @Author : wuqia
 * @Date : 2022/8/17 09:01
 * @Version : 1.0
 **/
public class QuikSort {

    public static int[] sort(int[] arr, int left, int right) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        if (left >= right) {
            return arr;
        }
        int center = patationg(arr, left, right);
        sort(arr, left, center - 1);
        sort(arr, center + 1, right);
        return arr;
    }

    public static int patationg(int[] arr, int left, int right) {
        // 选取中间节点
        int center = right;
        // 左侧区级起始点
        int lTemp = left;
        // 暂存中间节点的值
        int cValue = arr[right];
        for (int i = left; i < right; i++) {
            // 如果小于中间节点的值，则将此元素放到左侧区间
            if (arr[i] < cValue) {
                int temp = arr[i];
                arr[i] = arr[lTemp];
                arr[lTemp] = temp;
                lTemp ++;
            }
        }
        // 赋值中间节点
        arr[center] = arr[lTemp];
        arr[lTemp] = cValue;
        return lTemp;
    }

    public static void main(String[] args) {
        int [] arr1 = Arrays.copyOf(SortTest.arr, SortTest.arr.length);
        Arrays.sort(arr1);
        StaticLog.error("arr:{}", Arrays.toString(sort(SortTest.arr, 0, SortTest.arr.length - 1)));
        Assert.isTrue(ArrayUtil.equals(arr1, sort(SortTest.arr, 0, SortTest.arr.length - 1)));
    }
}
