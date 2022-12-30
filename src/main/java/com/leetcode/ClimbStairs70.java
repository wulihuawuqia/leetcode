package com.leetcode;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.hash.Hash;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : https://leetcode.cn/problems/climbing-stairs/submissions/391161864/
 * @Author : wuqia
 * @Date : 2022/12/26 17:36
 * @Version : 1.0
 **/
@Slf4j
public class ClimbStairs70 {

    /**
     * 超时
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else{
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

    }

    /**
     * 缓存中间结果
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if(n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int []aa = new int[n - 1];
            aa[0] = 1;
            aa[1] = 2;
            for (int i = 2; i < n-1; i++) {
                aa[i] = aa[i - 1] + aa [i - 2];
            }
            return aa[n-2] + aa[n-3];
        }

    }

    /**
     * 缓存中间结果
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if(n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int a = 1;
            int b = 2;
            int c = a + b;
            for (int i = 2; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }

    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("1");
        int result = climbStairs3(45);
        stopWatch.stop();
        log.error("n:45 result :{}, 耗时：{}", result,  stopWatch.getTotalTimeMillis());
        stopWatch = new StopWatch("1234");
        stopWatch.start("1");
        result = climbStairs2(45);
        stopWatch.stop();
        log.error("n:45 result :{}, 耗时：{}", result,  stopWatch.getTotalTimeMillis());
    }
}
