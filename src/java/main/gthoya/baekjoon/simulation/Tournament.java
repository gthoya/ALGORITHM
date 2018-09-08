package gthoya.baekjoon.simulation;

import java.util.Scanner;

public class Tournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalParticipator = scanner.nextInt();
        int jimin = scanner.nextInt();
        int hansoo = scanner.nextInt();
        int result = 0;

        while (true) {
            if (jimin + hansoo > totalParticipator) {
                while (totalParticipator / 2 > 0) {
                    totalParticipator /= 2;
                    result++;
                }

                break;
            } else {
                totalParticipator /= 2;
            }
        }

        System.out.println(result);
    }
}
