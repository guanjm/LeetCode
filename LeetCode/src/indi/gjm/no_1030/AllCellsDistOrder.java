package indi.gjm.no_1030;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 距离顺序排序矩阵单元格
 * @Author : guanjm
 * @Date: 2020/11/17 14:26
 *
 */
public class AllCellsDistOrder {

    private static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[count++] = new int[]{i, j};
            }
        }
        Arrays.sort(result, Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
        return result;
    }

    public static void main(String[] args) {
        int[][] cells = allCellsDistOrder(2, 3, 1, 2);
        for (int[] cell : cells) {
            System.out.println("["+cell[0]+", "+ cell[1]+"])");
        }
    }

}
