package gthoya.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Coin0 {
    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int coinCount = scanner.nextInt();
        int resultCount = 0, temp = 0, index = coinCount - 1, input = scanner.nextInt();
        int[] coin = new int[coinCount];

        for (int i = 0; i < coinCount; i++) {
            coin[i] = scanner.nextInt();
        }

        Arrays.sort(coin);

        while (temp != input) {
            if (temp + coin[index] > input) {
                index--;
                continue;
            }

            temp += coin[index];
            resultCount++;
        }

        System.out.println(resultCount);
    }
}
