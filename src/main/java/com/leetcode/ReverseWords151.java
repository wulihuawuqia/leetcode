package com.leetcode;

import org.junit.platform.commons.util.StringUtils;

import java.util.StringJoiner;

/**
 * @Description : https://leetcode.cn/problems/reverse-words-in-a-string/
 * @Author : wuqia
 * @Date : 2022/12/30 11:39
 * @Version : 1.0
 **/
public class ReverseWords151 {
    public static String reverseWords(String s) {
        //找出所有单词
        String [] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = strings.length - 1; j >= 0; j--) {
            String a = strings[j].replace(" ","");
            if (!a.equals("")) {
                stringBuilder.append(a);
                stringBuilder.append(" ");
            }
        }
        String result = stringBuilder.toString();
        if (result.endsWith(" ")) {
            return result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
