package gthoya.swexpertacademy.level3;

import java.util.Scanner;

public class Solution2805 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orderCount = scanner.nextInt();
        int size, half, result;
        int[][] farm;
        String temp;

        for (int i = 1; i <= orderCount; i++) {
            size = scanner.nextInt();
            half = (size / 2);
            farm = new int[size][size];
            result = 0;

            for (int j = 0; j < size; j++) {
                temp = scanner.next();
                for (int k = 0; k < size; k++) {
                    farm[j][k] = Integer.parseInt(String.valueOf(temp.charAt(k)));
                }
            }

            for (int j = 0; j < size; j++) {
                if (j <= half) {
                    result += farm[j][half];
                    for (int k = 1; k <= j; k++) {
                        result += farm[j][half + k];
                        result += farm[j][half - k];
                    }
                } else {
                    result += farm[j][half];
                    for (int k = j; k < (size - 1); k++) {
                        result += farm[j][half + (size - 1 - k)];
                        result += farm[j][half - (size - 1 - k)];
                    }
                }
            }

            System.out.printf("#%d %d\n", i, result);
        }
    }
}
