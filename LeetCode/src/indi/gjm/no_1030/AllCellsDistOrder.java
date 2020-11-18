package indi.gjm.no_1030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 距离顺序排序矩阵单元格
 * @Author : guanjm
 * @Date: 2020/11/17 14:26
 *
 */
public class AllCellsDistOrder {

    private static int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
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

    private static int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][];
        int count = 0;
        int maxDistance = Math.max(R - r0, r0) + Math.max(C - c0, c0);
        int distance = 0;
        while (maxDistance >= distance) {
            for (int i = -distance; i <= distance; i++) {
                int r = r0 + i;
                int tmp = distance - Math.abs(r - r0);
                int c1 = c0 + tmp;
                int c2 = c0 - tmp;
                if (tmp == Math.abs(c0 - c1)) {
                    if (0 <= r && r < R && 0 <= c1 && c1 < C) {
                        result[count++] = new int[]{r, c1};
                    }
                }
                if (tmp == Math.abs(c0 - c2) && c1 != c2) {
                    if (0 <= r && r < R && 0 <= c2 && c2 < C) {
                        result[count++] = new int[]{r, c2};
                    }
                }
            }
            distance++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] cells = allCellsDistOrder2(2, 3, 1, 2);
        for (int[] cell : cells) {
            System.out.println("["+cell[0]+", "+ cell[1]+"]");
        }
    }

}
