package com.sort;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;

import java.util.Arrays;

/**
 * @Description : TODO
 * @Author : wuqia
 * @Date : 2022/8/10 10:07
 * @Version : 1.0
 **/
public class SortTest {
    public static int[] arr = new int[]{4,5,6,3,2,1};

    static {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(100);
        }
    }

    public static void main(String[] args) {
        int [] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);
        Assert.isTrue(ArrayUtil.equals(arr1, BubbleSort.sort(arr)));
        StaticLog.error("arr:{}", Arrays.toString(BubbleSort.sort(arr)));


        Assert.isTrue(ArrayUtil.equals(arr1, InsertSort.sort(arr)));
        StaticLog.error("arr:{}", Arrays.toString(InsertSort.sort(arr)));
    }


}
