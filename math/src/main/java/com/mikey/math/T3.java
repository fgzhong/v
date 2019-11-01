package com.mikey.math;

import java.util.HashSet;
import java.util.Set;

/**
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class T3 {

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int i=0,j=0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (i<n && j<n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        short[] indexes = new short[128];
        int start = 1, max = 0;
        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            if (indexes[ch] >= start) {
                start = indexes[ch] + 1;
            } else {
                max = Math.max(max, i - start + 1);
            }
            indexes[ch] = (short) i;
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if (unqinue(s, i, j)) ans = Math.max(ans, j-i);
                else break;
            }
        }
        return ans;
    }

    public boolean unqinue(String s, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int k = i; k < j; k++) {
            if (set.contains(s.charAt(k))) {
                return false;
            }
            set.add(s.charAt(k));
        }
        return true;
    }
}
