package gthoya.algorithm.primenumber;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int minNumber = scanner.nextInt();
        int maxNumber = scanner.nextInt();
        int maxPrimeNumber = 2;

        boolean[] checkNotPrimeNumber = new boolean[maxNumber + 1];
        checkNotPrimeNumber[0] = true;
        checkNotPrimeNumber[1] = true;

        for (int i = 2; i <= maxNumber; i++) {
            if (checkNotPrimeNumber[i] == true) {
                continue;
            }

            for (int j = maxPrimeNumber; j <= i; j++) {
                if (i % j == 0) {
                    maxPrimeNumber = j;
                    for (int k = j * 2; k <= maxNumber; k += j) {
                        checkNotPrimeNumber[k] = true;
                    }
                }
            }
        }

        for (int i = minNumber; i <= maxNumber; i++) {
            if (checkNotPrimeNumber[i] == true) {
                continue;
            }

            System.out.println(i);
        }
    }
}
