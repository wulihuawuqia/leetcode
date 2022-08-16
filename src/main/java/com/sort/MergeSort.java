package com.sort;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.log.StaticLog;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Description : 归并排序
 * 先分堆，然后进行合并。整个过程递归
 * @Author : wuqia
 * @Date : 2022/8/16 09:09
 * @Version : 1.0
 **/
@Slf4j
public class MergeSort {

    public static int[] sort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int i = left + (right - left)/2;
        sort(arr, left, i);
        sort(arr, i+1, right);
        merge(arr, left, i, right);
        return arr;
    }

    public static void merge(int[] arr, int left, int center, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = center + 1;
        int k = 0;
        while (i <= center || j <= right) {
            if (i <= center && j <= right) {
                if (arr[i] <= arr[j]) {
                    temp[k] = arr[i];
                    i++;
                } else {
                    temp[k] = arr[j];
                    j++;
                }
            } else if (j > right) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // 新数组赋值回原数组
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
        log.error("arr:{}", Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int [] arr1 = Arrays.copyOf(SortTest.arr, SortTest.arr.length);
        Arrays.sort(arr1);
        StaticLog.error("arr:{}", Arrays.toString(sort(SortTest.arr, 0, SortTest.arr.length - 1)));
        Assert.isTrue(ArrayUtil.equals(arr1, InsertSort.sort(SortTest.arr)));
    }
}
