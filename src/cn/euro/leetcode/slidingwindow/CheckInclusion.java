package cn.euro.leetcode.slidingwindow;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for (int i = 0; i < s1Length; i++) {
            char ch = s1.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s2Length - s1Length + 1; i++) {
            HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
            for (int j = i; j < i + s1Length; j++) {
                char ch = s2.charAt(j);
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }
            if (check(target, temp)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(HashMap<Character, Integer> target, HashMap<Character, Integer> temp) {
        Iterator<Map.Entry<Character, Integer>> iter= target.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry = iter.next();
            Character c = entry.getKey();
            Integer i = entry.getValue();
            if (!temp.getOrDefault(c, 0).equals(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckInclusion solution = new CheckInclusion();
        boolean flag = solution.checkInclusion("ab", "eidboaoo");
        System.out.println(flag);
    }
}
