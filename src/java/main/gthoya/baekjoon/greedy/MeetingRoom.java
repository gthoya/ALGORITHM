package gthoya.baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MeetingRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int meetingCount = sc.nextInt();
        int[][] arr = new int[meetingCount][2];
        int result = 0, end = 0;

        for (int i = 0; i < meetingCount; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] before, int[] next) {
                if (before[1] == next[1]) {
                    return Integer.compare(before[0], next[0]);
                }

                return Integer.compare(before[1], next[1]);
            }
        });

        for (int i = 0; i < meetingCount; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}