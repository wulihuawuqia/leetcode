package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description : https://leetcode.cn/problems/3sum/
 * @Author : wuqia
 * @Date : 2022/12/5 21:37
 * @Version : 1.0
 **/
public class ThreeSum15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList(0);
        }
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int a = nums[i];
            maps.put(a, i);
        }
        // 两数之和的所有情况
        List<List<Integer>> result = new LinkedList<>();
        Set<List<Integer>> stringSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer a = nums[i];
                Integer b = nums[j];
                Integer count = -(a + b);
                Integer seq = maps.get(count);
                if (null != seq && seq > j) {
                    List<Integer> temp = Arrays.asList(a, b, count);
                    temp.sort(Comparator.reverseOrder());
                    if (stringSet.add(temp)) {
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[] {0,0,0});
    }
}
