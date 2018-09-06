package gthoya.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int result = 0, orderCount = scanner.nextInt();
        int[] time = new int[orderCount];

        for (int i = 0; i < orderCount; i++) {
            time[i] = scanner.nextInt();
        }

        Arrays.sort(time);

        for (int i = 0; i < orderCount; i++) {
            result += time[i] * (orderCount - i);
        }

        System.out.println(result);
    }
}
