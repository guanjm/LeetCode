package indi.gjm.no_164;

import java.util.Arrays;

/**
 * 最大间距
 * @author : guanjm
 * @Date: 2020/11/26
 */
public class MaximumGap {

    private static int getResult(int[] nums) {
        if (nums.length < 2) return 0;
        int result = 0;
        Arrays.sort(nums);
        int currentNum = nums[0];
        for (int num : nums) {
           result = Math.max(num - currentNum, result);
           currentNum = num;
        }
        return result;
    }

    public static void main(String[] args) {
        //3
        int[] nums1 = new int[]{3, 6, 9, 1};
        //0
        int[] nums2 = new int[]{10};
        System.out.println(getResult(nums1));
        System.out.println(getResult(nums2));
    }

}
