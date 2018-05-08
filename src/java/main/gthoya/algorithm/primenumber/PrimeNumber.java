package gthoya.algorithm.primenumber;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        int minNumber = scanner.nextInt();
        int maxNumber = scanner.nextInt();

        boolean[] checkNotPrimeNumber = new boolean[maxNumber + 1];
        checkNotPrimeNumber[0] = true;
        checkNotPrimeNumber[1] = true;

        for (int i = 2; i <= maxNumber; i++) {
            if (checkNotPrimeNumber[i] == true) {
                continue;
            }

            for (int k = i * 2; k <= maxNumber; k += i) {
                checkNotPrimeNumber[k] = true;
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
