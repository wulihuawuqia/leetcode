package com.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description : https://leetcode.cn/problems/sqrtx/description/
 * @Author : wuqia
 * @Date : 2022/12/28 20:03
 * @Version : 1.0
 **/
@Slf4j
public class MySqrt69 {

    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    public static int mySqrt(int x) {
        return mySqrt(x, 1, x);
    }

    public static int mySqrt(int x, int start, int end) {
        int a = (end - start) / 2 + start;
        if (a == 0) {
            return start;
        }
        long k = (long) a * a;
        if (k < 0) {
            k = Integer.MAX_VALUE;
        }
        if (k == x) {
            return a;
        } else if (k < x){
            int c = a + 1;
            k = (long) c * c;
            if (k > x || k < 0) {
                return a;
            }
            return mySqrt(x, a, end);
        } else {
            return mySqrt(x, start, a);
        }
    }

    public static void main(String[] args) {
        log.error("2147483647 Sqrt:{}", mySqrt(2147483647));
        log.error("2147395599 Sqrt:{}", mySqrt(2147395599));
        log.error("36 Sqrt:{}", mySqrt(36));
        log.error("5 Sqrt:{}", mySqrt(5));
        log.error("4 Sqrt:{}", mySqrt(4));
        log.error("8 Sqrt:{}", mySqrt(8));
    }
}
