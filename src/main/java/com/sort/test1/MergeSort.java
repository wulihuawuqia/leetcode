package com.sort.test1;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.log.StaticLog;
import com.sort.SortTest;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @Description : 不断的将元素拆分，到小的区块，然后先将小的区块排序，最后合并
 * @Author : wuqia
 * @Date : 2022/12/27 09:40
 * @Version : 1.0
 **/
@Slf4j
public class MergeSort {

    public static int[] sort(int [] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        // 拆分
        int i = left + (right - left) / 2;
        sort(arr, left, i);
        sort(arr, i+1, right);
        // 合并数组
        merge(arr, left, i, right);
        return arr;
    }

    public static void merge(int [] arr, int left, int center, int right) {
        //log.info("left,{}, center:{}, right:{}", left, center, right);
        int []temp = new int[right - left + 1];
        int l = left;
        int c = center + 1;
        for (int i = 0; i < temp.length; i++) {
            if (c <= right && l <= center) {
                if (arr[l] < arr[c]) {
                    temp[i] = arr[l];
                    l++;
                } else {
                    temp[i] = arr[c];
                    c++;
                }
            } else if (l > center) {
                temp[i] = arr[c];
                c++;
            } else {
                temp[i] = arr[l];
                l++;
            }
        }
        // 替换原数组
        for (int i = 0; i < temp.length; i++) {
            arr[left] = temp[i];
            left++;
        }
    }
    public static void main(String[] args) {
        int [] arr1 = Arrays.copyOf(SortTest.arr, SortTest.arr.length);
        Arrays.sort(arr1);
        StaticLog.error("arr:{}", Arrays.toString(sort(SortTest.arr, 0, SortTest.arr.length - 1)));
        Assert.isTrue(ArrayUtil.equals(arr1, sort(SortTest.arr, 0, SortTest.arr.length - 1)));
    }
}
