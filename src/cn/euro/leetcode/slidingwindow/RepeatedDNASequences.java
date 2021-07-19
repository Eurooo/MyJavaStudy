package cn.euro.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// leetcode.187
// 窗口长度也可以固定！！！
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> temp = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        int sLength = s.length();
        for (int i  = 0; i + 9 < sLength; i++) {
            if (!temp.contains(s.substring(i, i + 10))) {
                temp.add(s.substring(i, i + 10));
            } else ans.add(s.substring(i, i + 10));
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        RepeatedDNASequences solution = new RepeatedDNASequences();
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
