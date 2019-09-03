package gthoya.codility.tutorial;

public class BinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        int[] arr = new int[32];
        int m, index = 31;
        int n = N;
        while (n > 0) {
            m = n % 2;
            n = n / 2;

            arr[index--] = m;
        }

        int maxGap = 0;
        int currentGap = 0;
        boolean flag = false;
        for (int i = index; i < 32; i++) {
            if (arr[i] == 0) {
                if (flag) {
                    currentGap++;
                }
            } else {
                if (flag) {
                    maxGap = (maxGap > currentGap ? maxGap : currentGap);
                    currentGap = 0;
                } else {
                    flag = true;
                }
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();

        System.out.println(binaryGap.solution(805306373));
    }
}
