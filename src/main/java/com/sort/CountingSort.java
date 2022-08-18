package com.sort;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description : 计数排序
 * @Author : wuqia
 * @Date : 2022/8/18 11:38
 * @Version : 1.0
 **/
@Slf4j
public class CountingSort {
    public static int[] sort(int[] arr) {
        // 分桶 最大100 的数 分到 10个桶里面  0-9、10-19、、、90-99
        int[] counts = new int[arr.length];
        Date cur = new Date();
        for (int i : arr) {
            counts[i]++;
        }
        log.error("{}条 计数耗时：{}", arr.length, DateUtil.formatBetween(cur, new Date()));

        // 赋值 因为数组覆盖了区域数据，所以直接赋值数组下标即可
        int j = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count > 0) {
                for (int k = 0; k < count; k++) {
                    arr[j] = i;
                    j++;
                }
            }
        }
        log.error("{}条 合并耗时：{}", arr.length, DateUtil.formatBetween(cur, new Date()));
        return arr;
    }
    /*
    10:59:12.555 [main] ERROR com.sort.BucketSort - 1000000条 普通排序耗时：32毫秒
    10:59:12.560 [main] ERROR com.sort.BucketSort - 1000000条 桶排序耗时：3毫秒

    */
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(10000000);
        }
        int [] arr1 = Arrays.copyOf(arr, arr.length);
        Date cur = new Date();
        Arrays.sort(arr1);
        log.error("{}条 普通排序耗时：{}", arr.length, DateUtil.formatBetween(cur, new Date()));
        cur = new Date();
        sort(arr);
        log.error("{}条 桶排序耗时：{}", arr.length, DateUtil.formatBetween(cur, new Date()));
        Assert.isTrue(ArrayUtil.equals(arr1, arr));
    }
}
