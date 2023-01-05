package com.leetcode;

/**
 * @Description : https://leetcode.cn/problems/reverse-string/
 * @Author : wuqia
 * @Date : 2022/12/30 11:31
 * @Version : 1.0
 **/
public class ReverseString344 {
    public static void reverseString(char[] s) {
        int i = 0; int j = s.length - 1;
        while (j > i) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[] {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
        s = new char[] {'h','e','l','a','l','o'};
        reverseString(s);
        System.out.println(s);
    }
}
