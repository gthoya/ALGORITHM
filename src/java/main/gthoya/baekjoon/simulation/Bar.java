package gthoya.baekjoon.simulation;

import java.util.Scanner;

public class Bar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bar = {1, 2, 4, 8, 16, 32, 64};
        int order = scanner.nextInt();
        int result = 0;
        int bar2 = 64, result2 = 0, order2 = order;

        for (int i = 6; i >= 0; i--) {
            if (bar[i] < order) {
                result++;
                order -= bar[i];
            } else if (bar[i] == order) {
                result++;
                break;
            }
        }

        while (bar2 > 0) {
            if (order2 > bar2) {
                result2++;
                order2 -= bar2;
            } else if (order2 == bar2) {
                result2++;
                break;
            }

            bar2 /= 2;
        }

        System.out.println(result);
        System.out.println(result2);
    }
}
