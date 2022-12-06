package com.leetcode;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 众数
 * https://leetcode.cn/problems/majority-element/
 * @Author : wuqia
 * @Date : 2022/12/6 09:30
 * @Version : 1.0
 **/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (null == nums && nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i : nums) {
            maps.merge(i, 1, Integer::sum);
        }
        int max = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

}
