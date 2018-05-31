package gthoya.swexpertacademy.level3;

import java.util.Scanner;

public class Solution1220 {
    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int size, firstN, lastS, numberCount, notDeadlockCount;
        int[][] square;

        for (int i = 1; i <= 10; i++) {
            size = scanner.nextInt();
            square = new int[size][size];
            numberCount = 0;
            notDeadlockCount = 0;

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    square[j][k] = scanner.nextInt();
                }
            }

            for (int j = 0; j < size; j++) {
                firstN = -1;
                lastS = -1;

                for (int k = 0; k < size; k++) {
                    if (square[k][j] == 1) {
                        numberCount++;
                        if (firstN == -1) {
                            firstN = k;
                        }
                    } else if (square[k][j] == 2) {
                        numberCount++;
                        lastS = k;
                    }
                }

                for (int k = 0; k < firstN; k++) {
                    if (square[k][j] == 2) {
                        notDeadlockCount++;
                    }
                }

                for (int k = lastS + 1; k < size; k++) {
                    if (square[k][j] == 1) {
                        notDeadlockCount++;
                    }
                }
            }

            System.out.println("#" + i + " " + (numberCount - notDeadlockCount));
        }
    }
}
