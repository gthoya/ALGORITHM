package gthoya.swexpertacademy.level3;

import java.util.Scanner;

public class Solution1216 {
    private static final int MAX_LENGTH = 100;

    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        char[][] input = new char[MAX_LENGTH][MAX_LENGTH];
        String inputLine;
        int result;
        boolean isPalindrome;

        for (int i = 1; i <= 10; i++) {
            scanner.nextInt();
            for (int j = 0; j < MAX_LENGTH; j++) {
                inputLine = scanner.next();
                for (int k = 0; k < MAX_LENGTH; k++) {
                    input[j][k] = inputLine.charAt(k);
                }
            }

            result = 0;
            for (int j = 0; j < MAX_LENGTH; j++) {
                for (int k = 0; k < MAX_LENGTH; k++) {
                    for (int l = k; l < MAX_LENGTH; l++) {
                        if (input[j][k] != input[j][l]) {
                            continue;
                        } else {
                            isPalindrome = true;
                            for (int m = 0; m < l - k; m++) {
                                if (input[j][k + m] != input[j][l - m]) {
                                    isPalindrome = false;
                                    break;
                                }
                            }

                            if (isPalindrome) {
                                result = (result > l - k + 1? result : l - k + 1);
                            }
                        }
                    }
                }
            }

            for (int j = 0; j < MAX_LENGTH; j++) {
                for (int k = 0; k < MAX_LENGTH; k++) {
                    for (int l = k; l < MAX_LENGTH; l++) {
                        if (input[k][j] != input[l][j]) {
                            continue;
                        } else {
                            isPalindrome = true;
                            for (int m = 0; m < l - k; m++) {
                                if (input[k + m][j] != input[l - m][j]) {
                                    isPalindrome = false;
                                    break;
                                }
                            }

                            if (isPalindrome) {
                                result = (result > l - k + 1 ? result : l - k + 1);
                            }
                        }
                    }
                }
            }

            System.out.println("#" + i + " " + result);
        }
    }
}
