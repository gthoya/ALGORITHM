package gthoya.baekjoon.dynamicrule;

import java.util.Scanner;

public class PinaryNumber {
    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        long[] inputArr = new long[(input > 2) ? input : 2];
        inputArr[0] = 1;
        inputArr[1] = 1;

        for (int i = 2; i < input; i++) {
            inputArr[i] = inputArr[i - 1] + inputArr[i - 2];
        }

        System.out.println(inputArr[input - 1]);
    }
}
