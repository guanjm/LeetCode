package indi.gjm.no_53;

/**
 * 最大子序和
 * @Author : guanjm
 * @Date: 2020/11/16 17:49
 *
 */
public class MaxSubArray {

    //暴力
    private static int getResult1(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    //动态规划
    private static int getResult2(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int num : nums) {
            if (pre > 0) {
                pre = pre + num;
            } else {
                pre = num;
            }
            if (pre > max) {
                max = pre;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getResult2(nums));
    }

}
