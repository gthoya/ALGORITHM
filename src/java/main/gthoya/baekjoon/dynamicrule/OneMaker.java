package gthoya.baekjoon.dynamicrule;

import java.util.Scanner;

public class OneMaker {
    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int[] result = new int[inputNumber + 1];

        for (int i = 2; i <= inputNumber; i++) {
            result[i] = result[i - 1] + 1;
            calculateMinResult(result, i, 2);
            calculateMinResult(result, i, 3);
        }

        System.out.println(result[inputNumber]);
    }

    private static void calculateMinResult(int[] result, int i, int j) {
        if (i % j == 0) {
            result[i] = Integer.min(result[i], result[i / j] + 1);
        }
    }
}
