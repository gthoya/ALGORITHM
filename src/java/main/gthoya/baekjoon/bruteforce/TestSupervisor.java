package gthoya.baekjoon.bruteforce;

import java.util.Scanner;

public class TestSupervisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testLocationCount = scanner.nextInt();
        int tester[] = new int[testLocationCount];
        for (int i = 0; i < testLocationCount; i++) {
            tester[i] = scanner.nextInt();
        }

        int majorSupervisor = scanner.nextInt();
        int minorSupervisor = scanner.nextInt();
        long result = 0;

        for (int i = 0; i < testLocationCount; i++) {
            if (tester[i] <= majorSupervisor) {
                result++;
            } else {
                int remainTester = tester[i] - majorSupervisor;
                long minorSuperVisorCount = remainTester / minorSupervisor;
                if (remainTester % minorSupervisor != 0) {
                    minorSuperVisorCount++;
                }

                result += minorSuperVisorCount + 1;
            }
        }

        System.out.println(result);
    }
}
