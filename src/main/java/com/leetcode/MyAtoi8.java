package com.leetcode;

import cn.hutool.core.lang.Assert;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : https://leetcode.cn/problems/string-to-integer-atoi/
 * @Author : wuqia
 * @Date : 2023/1/4 20:08
 * @Version : 1.0
 **/
@Slf4j
public class MyAtoi8 {



    /**
     * 状态机实现
     *              ' '	    +/-	        number	    other
     * start	    start	signed	    in_number	end
     * signed	    error	error	        in_number	end
     * in_number    end	    end	        in_number	end
     * @param s 年代
     * @return int
     */
    public static int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (char c : s.toCharArray()) {
            if (!automaton.get(c)) {
                break;
            }
        }
        if (automaton.ans == Integer.MIN_VALUE) {
            return (int) automaton.ans;
        }
        return automaton.sign * (int) automaton.ans;
    }

    static class Automaton {
        /**
         * 定义当前状态位
         */
        private String state = "start";

        long ans = 0;

        int sign = 1;


        public boolean get(char c) {
            if ("start".equals(state)) {
                if (c == ' ') {
                    state = "start";
                } else if (c == '+' || c == '-') {
                    state = "signed";
                    if (c == '-') {
                        sign = -1;
                    }
                } else if (c >= '0' && c <= '9') {
                    state = "in_number";
                    append(c);
                } else {
                    return false;
                }
            } else if ("signed".equals(state) || "in_number".equals(state)) {
                if (c >= '0' && c <= '9') {
                    state = "in_number";
                    append(c);
                } else {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        }

        public boolean append(char c) {
            ans = ans * 10 + (c - '0');
            if (ans > Integer.MAX_VALUE || ans < 0) {

                if (sign < 0) {
                    ans = Integer.MIN_VALUE;
                } else {
                    ans = Integer.MAX_VALUE;
                }
                return false;
            }
            return true;
        }
    }



    /**
     * 穷举实现
     *
     * @param s 年代
     * @return int
     */
    public static int myAtoi1(String s) {
        StringBuilder num = new StringBuilder();
        char one = ' ';
        char [] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length; i++) {
            char c = chars[i];
            char ttt = chars[Integer.max(0, i - 1)];
            // 错误格式识别，如果之前有数字，后面又出现非数字则中断读数
            if (ttt >= '0' && ttt <= '9' && (c < '0' || c > '9')) {
                break;
            }
            if (((c == ' ' || c == '0') && num.length() == 0)) {
                continue;
            }
            // 正负号后0忽略
            if (num.length() == 1 && c== '0') {
                char tt =  num.toString().toCharArray()[0];
                if (tt == '+' || tt == '-') {
                    continue;
                }
            }
            if (num.length() == 0 && (c == '+' || c == '-')) {
                num.append(c);
                one = c;
            } else if (c >= '0' && c <= '9') {
                num.append(c);
            } else {
                break;
            }

        }
        if (num.length() == 0 || (num.length() == 1 && one != ' ')) {
            return 0;
        }
        // 越界处理
        if (num.length() > 11) {
            if (one == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        long t = Long.parseLong(num.toString());
        if (t > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (t < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) t;
    }

    public static void main(String[] args) {
        Assert.equals(myAtoi("-91283472332"), -2147483648);
        Assert.equals(myAtoi("-2147483647"), -2147483647);
        Assert.equals(myAtoi("21474836460"), 2147483647);

        Assert.equals(myAtoi("   -42"), -42);
        Assert.equals(myAtoi("  0000000000012345678"), 12345678);

        Assert.equals(myAtoi("0  123"), 0);

        Assert.equals(myAtoi("42"), 42);
        Assert.equals(myAtoi("4193 with words"), 4193);

        Assert.equals(myAtoi("+-12"), 0);
        Assert.equals(myAtoi("3.14159"), 3);
        Assert.equals(myAtoi("010"), 10);
        Assert.equals(myAtoi("  -0012a42"), -12);
        Assert.equals(myAtoi("00000-42a1234"), 0);


        //log.error("min:{}, max:{}", Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
