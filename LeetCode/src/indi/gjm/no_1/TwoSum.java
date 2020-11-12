package indi.gjm.no_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @Author : ex_guanjm
 * @Date: 2020/11/11 17:06
 *
 */
public class TwoSum {

    private static int[] getResult(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer no = tmp.get(target - nums[i]);
            if (no != null) {
                index[0] = no;
                index[1] = i;
            }
            tmp.put(nums[i], i);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        int target = 25;
        int[] result = getResult(arrays, target);
        System.out.println(result[0] + " " + result[1]);
    }

}
