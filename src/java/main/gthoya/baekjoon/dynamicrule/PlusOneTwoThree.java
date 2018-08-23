package gthoya.baekjoon.dynamicrule;

import java.util.Scanner;

public class PlusOneTwoThree {
    private static final int SIZE = 10;

    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int orderCount = scanner.nextInt();
        int digits;

        int[] calculator = new int[SIZE];
        calculator[0] = 1;
        calculator[1] = 2;
        calculator[2] = 4;

        for (int i = 0; i < orderCount; i++) {
            digits = scanner.nextInt();

            for (int j = 3; j < digits; j++) {
                calculator[j] = calculator[j - 1] + calculator[j - 2] + calculator[j - 3];
            }

            System.out.println(calculator[digits - 1]);
        }
    }
}
