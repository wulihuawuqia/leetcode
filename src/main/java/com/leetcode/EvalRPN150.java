package com.leetcode;

import cn.hutool.core.lang.Assert;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description : 逆波兰表达式求值
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * @Author : wuqia
 * @Date : 2022/12/15 09:46
 * @Version : 1.0
 **/
public class EvalRPN150 {

    public static int evalRPN(String[] tokens) {
        // 中间结果存储
        Deque<String> stack = new LinkedList<>();
        for (String str : tokens) {
            Integer a, b;
            switch (str) {
                case "+":
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a + b));
                    break;
                case "-":
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b - a));
                    break;
                case "*":
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a * b));
                    break;
                case "/":
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b/a));
                    break;
                default:
                    stack.push(str);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Assert.equals(9, evalRPN(new String[]{"2","1","+","3","*"}));
        Assert.equals(6, evalRPN(new String[]{"4","13","5","/","+"}));
        Assert.equals(22, evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}
