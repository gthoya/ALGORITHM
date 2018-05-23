package gthoya.swexpertacademy.level3;

import java.util.Scanner;

public class Solution1216 {
    private static final int MAX_LENGTH = 100;

    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        char[][] input = new char[MAX_LENGTH][MAX_LENGTH];
        String inputLine;
        int tempCount, maxPalindrome;

        for (int i = 1; i <= 10; i++) {
            scanner.nextInt();
            for (int j = 0; j < MAX_LENGTH; j++) {
                inputLine = scanner.next();
                for (int k = 0; k < MAX_LENGTH; k++) {
                    input[j][k] = inputLine.charAt(k);
                }
            }

            tempCount = 0;
            maxPalindrome = 0;
            for (int j = 0; j < MAX_LENGTH; j++) {
                for (int k = 0; k < MAX_LENGTH; k++) {
                    for (int l = 0; l < MAX_LENGTH; l++) {
                        if (input[j][k] == input[j][l]) {

                        }
                    }
                }
            }

            for (int j = 0; j < MAX_LENGTH; j++) {
                for (int k = 0; k < MAX_LENGTH; k++) {
                    for (int l = 0; l < MAX_LENGTH; l++) {
                        if (input[j][k] == input[j][k + l]) {

                        }
                    }
                }
            }

            System.out.println("#" + i + " " + maxPalindrome);
        }
    }
}
