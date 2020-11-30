package indi.gjm.no_5;

/**
 * 最长回文子串
 * @Author : guanjm
 * @Date: 2020/11/13 15:32
 *
 */
public class LongestPalindrome {

    //动态规划
    private static String getResult1(String s) {
        String result = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int distance = 0; distance < n; distance++) {
            for(int i = 0; i < n - distance; i++) {
                int j = i + distance;
                if (distance == 0) {
                    dp[i][j] = true;
                } else if (distance == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                if (result.length() <= distance && dp[i][j]) {
                    result = s.substring(i, i+distance+1);
                }
            }
        }
        return result;
    }

    //中心扩展法
    private static String getResult2(String s) {
        String result = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            boolean flag1 = true;
            boolean flag2 = true;
            for (int distance = 0; i - distance + 1 >= 0 && distance + i < n; distance ++) {
                if (distance == 0) {
                    flag1 = true;
                    flag2 = true;
                } else {
                    flag1 = flag1 && i - distance >= 0 && s.charAt(i - distance) == s.charAt(i + distance);
                    flag2 = flag2 && s.charAt(i - distance + 1) == s.charAt(i + distance);
                }
                if (flag1) {
                    if (result.length() <= distance * 2 + 1) {
                        result = s.substring(i - distance, i + distance + 1);
                    }
                } else if (flag2) {
                    if (result.length() <= distance * 2) {
                        result = s.substring(i - distance + 1, i + distance + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "bb";
        String s5 = "ccc";
        String s6 = "aaaa";
        System.out.println(getResult2(s1));
        System.out.println(getResult2(s2));
        System.out.println(getResult2(s3));
        System.out.println(getResult2(s4));
        System.out.println(getResult2(s5));
        System.out.println(getResult2(s6));
    }

}
