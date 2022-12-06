package com.sort.base;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.log.StaticLog;
import com.sort.SortTest;

import java.util.Arrays;

/**
 * @Description : 选择排序：确定已排序区，然后遍历未排序区，每次选择最小的元素放到已排序区的最后
 * @Author : wuqia
 * @Date : 2022/8/12 09:06
 * @Version : 1.0
 **/
public class SelectSort {

    public static int[] sort(int[] arr) {
        if (null == arr || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i ++) {
            // 找最小的放到首位
            int min_pos = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] < arr[min_pos]) {
                    min_pos = j;
                }
            }
            // 交换位置
            if (min_pos != i) {
                int t = arr[i];
                arr[i] = arr[min_pos];
                arr[min_pos] = t;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr1 = Arrays.copyOf(SortTest.arr, SortTest.arr.length);
        Arrays.sort(arr1);
        StaticLog.error("arr:{}", Arrays.toString(sort(SortTest.arr)));
        Assert.isTrue(ArrayUtil.equals(arr1, sort(SortTest.arr)));
    }
}
