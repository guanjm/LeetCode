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
        List<Character> result = new ArrayList<>();
        List<Character> container = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (container.contains(s.charAt(i))) {
                if (container.size() > result.size()) {
                    result.clear();
                    result.addAll(container);
                }
                Iterator<Character> iterator = container.iterator();
                while (iterator.hasNext()) {
                    Character c = iterator.next();
                    iterator.remove();
                    if (c == s.charAt(i)) {
                        break;
                    }
                }
            }
            container.add(s.charAt(i));
        }
        return Math.max(result.size(), container.size());
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(getResult(s));
    }

}
