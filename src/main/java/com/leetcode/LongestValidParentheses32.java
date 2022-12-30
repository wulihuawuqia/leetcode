package com.leetcode;

import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Test;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description : 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <a href="https://leetcode.cn/problems/longest-valid-parentheses/">详细地址</a>
 * @Author : wuqia
 * @Date : 2022/12/12 09:15
 * @Version : 1.0
 **/
public class LongestValidParentheses32 {


    /**
     * 累计的方式，无法处理中间有间隔的情况？
     *
     * @param s 年代
     * @return int
     */
    public static int longestValidParentheses(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Deque<Character> stack = new LinkedList();
        int sum = 0;
        int sumOld = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        for (Character character : arr) {
            if ('(' == character) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    if (max < sum) {
                        max = sum;
                    }
                    sumOld = sum;
                    sum = 0;
                } else {
                    stack.pop();
                    sum += 2;
                    if (stack.isEmpty()) {

                    }
                }

            }
        }
        if (max < sum) {
            max = sum;
        }
        return max;
    }

    public static int longestValidParentheses1(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static int longestValidParentheses2(String s) {
        int maxans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left == right) {
                maxans = Math.max(right * 2, maxans);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left == right) {
                maxans = Math.max(right * 2, maxans);
            } else if (right < left) {
                left = 0;
                right = 0;
            }
        }

        return maxans;
    }

    @Test
    public void longestValidParentheses2() {
        Assert.equals(longestValidParentheses2("(()"), 2);
        Assert.equals(longestValidParentheses2(")()())"), 4);
        Assert.equals(longestValidParentheses2(")(()()))"), 6);
        Assert.equals(longestValidParentheses2(")())())"), 2);
        Assert.equals(longestValidParentheses2(""), 0);
    }

    @Test
    public void longestValidParentheses1() {
        //Assert.equals(longestValidParentheses1("(()"), 2);
        Assert.equals(longestValidParentheses1(")()())"), 4);
        //Assert.equals(longestValidParentheses1(")(()()))"), 6);
        //Assert.equals(longestValidParentheses1(")())())"), 2);
        //Assert.equals(longestValidParentheses1(""), 0);
    }

    public static void main(String[] args) {
        Assert.equals(longestValidParentheses("(()"), 2);
        Assert.equals(longestValidParentheses(")()())"), 4);
        Assert.equals(longestValidParentheses1(")())())"), 2);
        Assert.equals(longestValidParentheses(""), 0);
    }
}
