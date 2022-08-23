package com.find;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import com.sort.SortTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.Arrays;

/**
 * @Description : 二分查找
 * @Author : wuqia
 * @Date : 2022/8/23 18:39
 * @Version : 1.0
 **/
@Slf4j
public class BSearch {

    public static int search(int[] arr, int a) {
        int k;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            k = start + ((end - start)>>1);
            if (arr[k] == a) {
                return k + 1;
            } else if (arr[k] < a) {
                start = k+1;
            } else {
                end = k-1;
            }
        }
        return -1;
    }

    public static int searchFirst(int[] arr, int a) {
        int i = search(arr, a);
        if (i == -1) {
            return i;
        }
        int t = i - 2;
        while (t >= 0 && arr[t] == a) {
            t --;
        }
        return t < i - 2 ? t + 1 : i;
    }

    public static int searchLast(int[] arr, int a) {
        int i = search(arr, a);
        if (i == -1) {
            return i;
        }
        int t = i;
        while (t < arr.length && arr[t] == a) {
            t ++;
        }
        return t;
    }

    public static int search2(int[] arr, int a, int start, int end) {
        if (start > end) {
            return -1;
        }
        int k = start + ((end - start)>>1);
        if (arr[k] == a) {
            return k+1;
        } else if (arr[k] < a) {
            return search2(arr, a, k + 1, end);
        } else {
            return search2(arr, a, start, k - 1);
        }
    }

    double sqrt(double a, double p) {
        double x = 1.0; double check;
        do {
            x = (a / x + x) / 2.0;
            check = x * x - a;
        } while (Math.abs(check) > p);
        return x;
    }

    @Test
    public void sqrtTest() {
        log.error("2.0:{} , Math.sqrt(2.0):{}", sqrt(4.0, 0.0001),  Math.sqrt(4.0));
    }

    @Test
    public void firstTest () {
        SortTest.arr = new int[]{9, 24, 24, 35, 53, 66, 69, 76, 79, 83, 83};
        int a = 24;
        log.error(" 在{}中，{} first位于 {}, last位于 {}",Arrays.toString(SortTest.arr), a, searchFirst(SortTest.arr, a), searchLast(SortTest.arr, a));
        a = 83;
        log.error(" 在{}中，{} first位于 {}, last位于 {}",Arrays.toString(SortTest.arr), a, searchFirst(SortTest.arr, a), searchLast(SortTest.arr, a));
        a = 9;
        log.error(" 在{}中，{} first位于 {}, last位于 {}",Arrays.toString(SortTest.arr), a, searchFirst(SortTest.arr, a), searchLast(SortTest.arr, a));
    }

    public static void main(String[] args) {
        //Arrays.sort(SortTest.arr);
        SortTest.arr = new int[]{9, 19, 24, 35, 53, 66, 69, 76, 79, 83};
        int i = RandomUtil.randomInt(SortTest.arr.length);
        i = 9;
        log.error("search 在{}中，{} 位于 {}",Arrays.toString(SortTest.arr), SortTest.arr[i], search(SortTest.arr, SortTest.arr[i]));
        log.error("search2 在{}中，{} 位于 {}",Arrays.toString(SortTest.arr), SortTest.arr[i], search2(SortTest.arr, SortTest.arr[i], 0 , SortTest.arr.length - 1));
    }

    @Test
    public void test() {
        log.error("4>>1:{}", 4>>1);
    }
}
