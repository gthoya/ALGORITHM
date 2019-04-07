package gthoya.baekjoon.simulation;

import java.util.Scanner;

public class Retire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int [][] payPerDay = new int[day][2];
        int [] totalPay = new int[day];
        int result = 0, maxPay = 0;

        for (int i = 0; i < day; i++) {
            payPerDay[i][0] = scanner.nextInt();
            payPerDay[i][1] = scanner.nextInt();
        }

        for (int i = day - 1; i >= 0; i--) {
            if (day < payPerDay[i][0] + i) {
                continue;
            }

            totalPay[i] = payPerDay[i][1];
            if (payPerDay[i][0] + i < day) {
                maxPay = 0;
                for (int j = payPerDay[i][0]; j < day - i; j++) {
                    if (maxPay < totalPay[i + j]) {
                        maxPay = totalPay[i + j];
                    }
                }

                totalPay[i] += maxPay;
            }
        }

        for (int i = 0; i < day; i++) {
            if (result < totalPay[i]) {
                result = totalPay[i];
            }
        }

        System.out.println(result);
    }
}
