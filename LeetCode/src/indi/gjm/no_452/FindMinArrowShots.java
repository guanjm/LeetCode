package indi.gjm.no_452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * @author : guanjm
 * @Date: 2020/11/23
 *
 */
public class FindMinArrowShots {

    private static int getResult(int[][] points) {
        if (points.length == 0) return 0;
        int result = 1;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int currentArrow = points[0][1];
        for (int[] point : points) {
            if (currentArrow < point[0]) {
                currentArrow = point[1];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //2
        int[][] points1 = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        //4
        int[][] points2 = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        //2
        int[][] points3 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        //1
        int[][] points4 = new int[][]{{1, 2}};
        //1
        int[][] points5 = new int[][]{{2, 3}, {2, 3}};
        //1
        int[][] points6 = new int[][]{{-2147483648,2147483647}};
        System.out.println(getResult(points1));
        System.out.println(getResult(points2));
        System.out.println(getResult(points3));
        System.out.println(getResult(points4));
        System.out.println(getResult(points5));
        System.out.println(getResult(points6));
    }

}
