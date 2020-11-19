package indi.gjm.no_134;

/**
 * 加油站
 * @author : guanjm
 * @Date: 2020/11/19 11:51
 *
 */
public class CanCompleteCircuit {

    private static int getResult1(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int gasTotal = 0;
            int costTotal = 0;
            for (int j = 0; j < length; j++) {
                int no = (j + i) % length;
                gasTotal += gas[no];
                costTotal += cost[no];
                if (gasTotal < costTotal) {
                    break;
                }
                if (j == length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int getResult2(int[] gas, int[] cost) {
        int rest = 0, lastRest = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            lastRest += gas[i] - cost[i];
            rest += gas[i] - cost[i];
            if (lastRest < 0) {
                lastRest = 0;
                start = i + 1;
            }
        }
        return rest < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas  = new int[] {2, 3, 4};
        int[] cost = new int[] {3, 4, 3};
        System.out.println(getResult2(gas, cost));
    }

}
