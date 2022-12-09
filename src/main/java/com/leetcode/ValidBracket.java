package com.leetcode;

import cn.hutool.core.lang.Assert;
import java.util.Objects;

import java.util.Stack;

/**
 * @Description : 有效括号
 * https://leetcode.cn/problems/valid-parentheses/
 * @Author : wuqia
 * @Date : 2022/12/9 09:33
 * @Version : 1.0
 **/
public class ValidBracket {

    public static boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if ('{' == character || '(' == character || '[' == character) {
                stack.push(character);
            } else if (!stack.empty()) {
                Character temp = stack.pop();
                if (!('{' == temp && '}' == character || '(' == temp && ')' == character || '[' == temp && ']' == character)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Assert.isTrue(isValid("()"));
        Assert.isFalse(isValid("]"));
    }

}
