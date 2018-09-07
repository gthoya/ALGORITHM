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
            public int compare(int[] start, int[] end) {
                if (start[1] == end[1]) {
                    return Integer.compare(start[0], end[0]);
                }

                return Integer.compare(start[1], end[1]);
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