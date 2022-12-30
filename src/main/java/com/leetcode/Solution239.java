package com.leetcode;

import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description : 滑动最大窗口
 * https://leetcode.cn/problems/sliding-window-maximum/
 * @Author : wuqia
 * @Date : 2022/12/21 14:37
 * @Version : 1.0
 **/
public class Solution239 {


    /**
     * 超时
     *
     * @param nums
     * @param k    k
     * @return {@link int[]}
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] resul = new int[1];
        int max = Integer.MIN_VALUE;
        if (nums.length <= k) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            resul[0] = max;
        } else {
            resul = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            resul[0] = max;
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                } else {
                    if (nums[i - k] >= max) {
                        max = Integer.MIN_VALUE;
                        for (int j = i - k + 1; j <= i; j++) {
                            if (nums[j] > max) {
                                max = nums[j];
                            }
                        }
                    }
                }
                resul[i - k + 1] = max;
            }
        }
        return resul;
    }

    /**
     * 超时
     *
     * @param nums 全国矿工工会
     * @param k    k
     * @return {@link int[]}
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] resul = new int[1];
        int max = Integer.MIN_VALUE;
        if (nums.length <= k) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            resul[0] = max;
        } else {
            resul = new int[nums.length - k + 1];
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
                if (queue.size() == 2) {
                    queue.remove();
                }
            }
            resul[0] = queue.peek();
            for (int i = k; i < nums.length; i++) {
                // 移出具体元素，需要遍历，所以会超时
                queue.remove(nums[i - k]);
                queue.add(nums[i]);
                resul[i - k + 1] = queue.peek();
            }
        }
        return resul;
    }

    /**
     * 超时
     *
     * @param nums 全国矿工工会
     * @param k    k
     * @return {@link int[]}
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int[] resul = new int[1];
        int max = Integer.MIN_VALUE;
        if (nums.length <= k) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            resul[0] = max;
        } else {
            resul = new int[nums.length - k + 1];
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
                }
            });
            for (int i = 0; i < k; i++) {
                queue.add(new int[]{nums[i], i});
            }
            resul[0] = queue.peek()[0];
            for (int i = k; i < nums.length; i++) {
                queue.add(new int[] {nums[i], i});
                // 如果堆顶坐标不在当前窗口则移出
                while (queue.peek()[1] <= i - k) {
                    queue.poll();
                }
                resul[i - k + 1] = queue.peek()[0];
            }
        }
        return resul;
    }

    public static void main(String[] args) {
        Assertions.assertArrayEquals(maxSlidingWindow3(new int[]{1,3,-1,-3,5,3,6,7}, 3), new int[]{3,3,5,5,6,7});
        Assertions.assertArrayEquals(maxSlidingWindow3(new int[]{1,-1}, 1), new int[]{1,-1});
    }
}
