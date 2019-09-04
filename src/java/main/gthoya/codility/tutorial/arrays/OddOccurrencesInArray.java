package gthoya.codility.tutorial.arrays;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int a : A) {
            Integer temp = result.get(a);
            result.put(a, temp == null ? 1 : temp + 1);
        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
    public static void main(String[] ar) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

        System.out.println(oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }
}
