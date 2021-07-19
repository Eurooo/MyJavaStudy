package cn.euro.leetcode.slidingwindow;

// leetcode.209
public class MinSubArrayLength {
    public int minSubArrayLen(int target, int [] nums) {
        int nLength = nums.length, sum = 0, left = -1, right = 0;
        int ans = Integer.MAX_VALUE;
//        while (right < nLength) {
//            sum += nums[right];
//            right += 1;
//            while (sum >= target) {
//                if (sum >= target) {
//                    ans = Math.min(ans, right - left);
//                }
//                sum -= nums[left];
//                left += 1;
//            }
//        }
//        if (ans != Integer.MAX_VALUE) {
//            return ans;
//        } else return 0;
        for (int i = 0; i < nLength; i++) {
            sum += nums[i];
            while (sum >= target) {
                if (sum >= target) {
                    ans = Math.min(ans, i - left);
                }
                left += 1;
                sum -= nums[left];
            }
        }
        if (ans != Integer.MAX_VALUE) {
            return ans;
        } else return 0;
    }

    public static void main(String[] args) {
        MinSubArrayLength solution = new MinSubArrayLength();
        int res = solution.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(res);
    }
}
