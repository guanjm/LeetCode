package indi.gjm.no_3;

import java.util.*;

/**
 * 无重复字符的最长子串
 * @Author : guanjm
 * @Date: 2020-11-13 00:42
 *
 */
public class LengthOfLongestSubstring {

    private static int getResult(String s) {
        List<Character> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (result.contains(c)) {
                Iterator<Character> iterator = result.iterator();
                while (iterator.hasNext()) {
                    Character next = iterator.next();
                    iterator.remove();
                    if (next == c) {
                        break;
                    }
                }
            }
            result.add(c);
        }
        return result.size();
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(getResult(s));
    }

}
