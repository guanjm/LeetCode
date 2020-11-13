package indi.gjm.no_4;

/**
 * 寻找两个正序数组的中位数
 * @Author : guanjm
 * @Date: 2020/11/13 11:16
 *
 */
public class FindMedianSortedArrays {

    private static double getResult(int[] nums1, int[] nums2) {
        Integer result1 = null;
        Integer result2 = null;
        int totalSize = nums1.length + nums2.length;
        int no1 = 0;
        int no2 = 0;
        for (int i = 0; i < totalSize / 2 + 1; i++) {
            Integer tmp1 = nums1.length != no1 ? nums1[no1] : null;
            Integer tmp2 = nums2.length != no2 ? nums2[no2] : null;
            if (totalSize % 2 == 0) {
                result1 = result2;
            }
            if (tmp1 != null && tmp2 != null) {
                if (tmp1 > tmp2) {
                    result2 = tmp2;
                    no2++;
                } else {
                    result2 = tmp1;
                    no1++;
                }
            } else{
                if (tmp1 != null) {
                    result2 = tmp1;
                    no1++;
                } else {
                    result2 = tmp2;
                    no2++;
                }
            }
        }
        return result1 != null ? (result1 + result2) /2.0 : result2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(getResult(nums1, nums2));
    }

}
