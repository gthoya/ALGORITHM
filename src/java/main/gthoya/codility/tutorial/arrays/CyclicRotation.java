package gthoya.codility.tutorial.arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (A == null || A.length == 0) {
            return A;
        }

        int arrSize =  A.length;
        int move = K % arrSize;
        int[] result = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            result[i] = A[(i + arrSize - move) % arrSize];
        }

        return result;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();

        System.out.println(cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3));
    }
}
