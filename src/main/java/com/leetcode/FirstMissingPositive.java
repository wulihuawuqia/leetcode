package com.leetcode;

import cn.hutool.core.lang.Assert;

/**
 * @Description : https://leetcode.cn/problems/first-missing-positive/
 * 将数组按照顺序对号入座，然后找第一个不等于当前位置的数据，则当前位置就是最小正整数
 * @Author : wuqia
 * @Date : 2022/12/6 20:58
 * @Version : 1.0
 **/
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //
        for (int i = 0; i < len; i++) {
            int pos = nums[i] - 1;
            // 如果位置不对，需要替换到正确的位置，
            while (nums[i] > 0 && nums[i] <= len && pos != i) {
                pos = nums[i] - 1;
                int temp = nums[pos];
                // 如果原位置上已经有正确的数，则跳过
                if (temp == nums[i]) {
                    break;
                } else {
                    nums[pos] = nums[i];
                    // 新数据可能也要调整位置
                    nums[i] = temp;
                }
            }
        }
        // 找第一个与当前位置不符合的数据
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public static int firstMissingPositiveVersion1(int[] nums) {
        int len = nums.length;
        //
        for (int i = 0; i < len; i++) {
            // 如果位置不对，需要替换到正确的位置，
            if (nums[i] > 0 && nums[i] <= len && nums[i] - 1 != i) {
                int pos = nums[i] - 1;
                while (true) {
                    int temp = nums[pos];
                    // 如果原位置上已经有正确的数，则把当前数标记为无效
                    if (temp == nums[i]) {
                        nums[i] = -1;
                        break;
                    } else {
                        nums[pos] = nums[i];
                        // 新数据可能也要调整位置
                        nums[i] = temp;
                        if (nums[i] > 0 && nums[i] <= len && nums[i] - 1 != i) {
                            pos = nums[i] - 1;
                        } else {
                            break;
                        }
                    }
                }

            }
        }
        // 找第一个与当前位置不符合的数据
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        //System.out.println(firstMissingPositive(new int[] {1,2,0}));
        //System.out.println(firstMissingPositive(new int[] {7,8,9,11,12}));
        //System.out.println(firstMissingPositive(new int[] {3,4,-1,1}));
        Assert.equals(firstMissingPositive(new int[] {1,2,6,3,5,4}), 7);

    }

}
