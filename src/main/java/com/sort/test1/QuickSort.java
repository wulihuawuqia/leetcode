package com.sort.test1;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.log.StaticLog;
import com.sort.SortTest;

import java.util.Arrays;

/**
 * @Description : 每次选取一个中间元素，然后将其他元素放到两侧
 *
 * @Author : wuqia
 * @Date : 2022/12/28 19:57
 * @Version : 1.0
 **/
public class QuickSort {

    public static int[] sort(int [] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int center = patition(arr, left, right);
        sort(arr, left, center -1);
        sort(arr, center + 1, right);
        return arr;
    }

    public static int patition(int[] arr, int left, int right) {
        // 选取一个中间元素，默认选最后一个,如果是移动小的，则选最后一个元素，如果是移动大的，需要选第一个元素
        int cVal = arr[right];
        // 最终中间位置的
        int cPos = left;
        // 将元素放到中间元素旁边，最后一个是中间节点，忽略
        for (int i = left; i < right; i++) {
            // 如果小于中间值则将元素放到左侧起点
            if (arr[i] < cVal) {
                // 值交换
                int temp = arr[i];
                arr[i] = arr[cPos];
                arr[cPos] = temp;
                // 中间节点位置后移
                cPos ++;
            }
        }
        // 将中间节点
        arr[right] = arr[cPos];
        arr[cPos] = cVal;
        return cPos;
    }

    public static void main(String[] args) {
        int arr [] = new int[] {913, 63, 339, 163, 911, 378, 186, 863, 93, 828};
        int [] arr1 = Arrays.copyOf(SortTest.arr, SortTest.arr.length);
        int [] arr2 = Arrays.copyOf(SortTest.arr, SortTest.arr.length);
/*        int [] arr1 = Arrays.copyOf(arr, arr.length);
        int [] arr2 = Arrays.copyOf(arr, arr.length);*/
        StaticLog.error("arr:{}", Arrays.toString(arr1));
        Arrays.sort(arr1);
        StaticLog.error("arr1:{}", Arrays.toString(arr1));
        StaticLog.error("arr2:{}", Arrays.toString(sort(arr2, 0, SortTest.arr.length - 1)));
        Assert.isTrue(ArrayUtil.equals(arr1, arr2));
    }
}
