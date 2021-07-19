package cn.euro.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// leetcode.76 最小覆盖子串
public class MinimumWindowSubstring {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    public String minWindow(String s, String t) {
        int tLength = t.length();
        int sLength = s.length();
        int j = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        // 初始化need
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (!check()) {
                continue;
            } else {
                while (check() && j <= i) {
                    if (i - j < len) {
                        len = i - j;
                        ansR = i;
                        ansL = j;
                    }
                    j += 1;
                    char firstchar = s.charAt(j);
                    window.put(firstchar, window.get(firstchar) - 1);
                }
            }
        }
        // 右指针移动 说明有结果
        if (ansR != -1) {
            return s.substring(ansL + 1, ansR + 1);
        } else return "";
    }
    // 检查window是否满足要求
    public boolean check() {
        Iterator<Map.Entry<Character, Integer>> iter = need.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry= iter.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > window.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
