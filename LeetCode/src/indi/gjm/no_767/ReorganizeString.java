package indi.gjm.no_767;

import java.util.HashMap;
import java.util.Map;

/**
 * 重构字符串
 * @author : guanjm
 * @date: 2020/11/30
 *
 */
public class ReorganizeString {

    private static String getResult(String s) {
        String result = "";
//        char maxChar = ;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.computeIfAbsent(c, (key) -> 0);
            map.put(c, ++count);
//            if (maxLength < count) {
//                maxChar = c;
//            }
        }
//        if (map.get(maxChar))
        return result;
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aaab";
        System.out.println(getResult(s1));
        System.out.println(getResult(s2));
    }

}
