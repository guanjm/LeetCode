package indi.gjm.no_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高重建队列
 * @Author : guanjm
 * @Date: 2020/11/16 14:25
 *
 */
public class ReconstructQueue {

    private static int[][] getResult(int[][] people) {
        List<int[]> result = new ArrayList<>();
        //身高不相同时，h身高倒序
        //身高相同时，k值顺序
        Arrays.sort(people, (person1, person2) ->
                person1[0] == person2[0] ? person1[1] - person2[1] : person2[0] - person1[0]
        );
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = getResult(people);
        System.out.println(result);
    }

}
