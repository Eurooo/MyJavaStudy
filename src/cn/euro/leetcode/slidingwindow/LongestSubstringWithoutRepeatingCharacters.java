package cn.euro.leetcode.slidingwindow;

import java.util.HashSet;

// leetcode.3 无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int length = s.length();
        int rk = 0;
        for (int i = 0; i < length; i ++) {
            while (rk < length && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk += 1;
            }
            ans = Math.max(ans, rk - i);
            set.remove(s.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int ans = solution.lengthOfLongestSubstring("aabcb");
        System.out.println(ans);
    }
}
