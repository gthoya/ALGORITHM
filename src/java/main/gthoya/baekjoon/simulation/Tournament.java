package gthoya.baekjoon.simulation;

import java.util.Scanner;

public class Tournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

        int jimin = scanner.nextInt();
        int hansoo = scanner.nextInt();
        int result = 0;

        while (jimin != hansoo) {
            jimin = (jimin + 1) / 2;
            hansoo = (hansoo + 1) / 2;
            result++;
        }

        System.out.println(result);
    }
}
