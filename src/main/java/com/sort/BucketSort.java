package com.sort;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.log.StaticLog;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Description : 桶排序，先将数据进行分桶，每个分桶使用快排等排序算法，然后按照顺序归并
 * @Author : wuqia
 * @Date : 2022/8/18 09:20
 * @Version : 1.0
 **/
@Slf4j
public class BucketSort {

    public static int[] sort(int[] arr) {
        // 分桶 最大100 的数 分到 10个桶里面  0-9、10-19、、、90-99
        List<Integer>[] buckets = new List[10];
        for (int i : arr) {
            // 桶序号
            int seq = i/10;
            List<Integer> list = buckets[seq];
            if (null == list) {
                list = new ArrayList<>();
                buckets[seq] = list;
            }
            list.add(i);
        }
        // 遍历桶，边排序，边合并
        int i = 0;
        for (List<Integer> list : buckets) {
            if (CollUtil.isEmpty(list)) {
                continue;
            }
            // 排序
            list.sort(Comparator.comparing(e -> e));
            // 合并元素
            for (Integer integer : list) {
                arr[i] = integer;
                i++;
            }
        }
        return arr;
    }
/*
10:59:12.555 [main] ERROR com.sort.BucketSort - 1000000条 普通排序耗时：32毫秒
10:59:12.560 [main] ERROR com.sort.BucketSort - 1000000条 桶排序耗时：3毫秒

*/
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(100);
        }
        int [] arr1 = Arrays.copyOf(arr, arr.length);
        Date cur = new Date();
        Arrays.sort(arr1);
        log.error("{}条 普通排序耗时：{}", arr.length, DateUtil.formatBetween(cur, new Date()));
        cur = new Date();
        sort(SortTest.arr);
        log.error("{}条 桶排序耗时：{}", arr.length, DateUtil.formatBetween(cur, new Date()));
    }

    @Test
    public void test() {
        log.error("9/10={}",9/10);
        log.error("19/10={}",19/10);
        log.error("29/10={}",29/10);
        log.error("39/10={}",39/10);

    }

}
