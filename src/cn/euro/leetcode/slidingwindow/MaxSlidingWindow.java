package cn.euro.leetcode.slidingwindow;

import java.util.Arrays;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ansLength = nums.length - k + 1;
        int[] ans = new int[ansLength];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int tempMax = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j ++) {
                if (nums[j] > tempMax) tempMax = nums[j];
            }
            ans[i] = tempMax;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow solution = new MaxSlidingWindow();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
