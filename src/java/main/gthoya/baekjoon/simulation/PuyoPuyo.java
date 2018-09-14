package gthoya.baekjoon.simulation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PuyoPuyo {
    private static final int HEIGHT = 12;
    private static final int WIDTH = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        char[][] input = new char[HEIGHT][WIDTH];
        boolean [][] visited = new boolean[HEIGHT][WIDTH];
        boolean [][] discovered = new boolean[HEIGHT][WIDTH];
        int clearBlockCount = -1;

        for (int i = 0; i < HEIGHT; i++) {
            inputLine = scanner.next();

            for (int j = 0; j < WIDTH; j++) {
                input[i][j] = inputLine.charAt(j);
            }
        }

        int cnt = 0;
        while (clearBlockCount != 0) {
            clear(visited, discovered);
            clearBlockCount = bfs(input, visited, discovered);

            if (clearBlockCount >= 4) {
                cnt++;
                down(input, visited);
            }
        }

        System.out.println(cnt);
    }

    static int bfs(char[][] input, boolean[][] visited, boolean[][] discovered) {
        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};
        int clearBlockCount = 0;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (discovered[i][j]) {
                    continue;
                }

                if (input[i][j] == '.') {
                    continue;
                }

                int connectedBlocks = 1;

                Queue<Node> queue = new LinkedList<>();
                Queue<Node> storedQueue = new LinkedList<>();
                queue.add(new Node(i, j));
                storedQueue.add(new Node(i, j));

                discovered[i][j] = true;

                while (!queue.isEmpty()) {
                    Node u = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nextRow = u.row + dRow[k];
                        int nextCol = u.col + dCol[k];

                        if (nextRow < 0 || nextCol < 0 || nextRow >= 12 || nextCol >= 6) {
                            continue;
                        }

                        if (discovered[nextRow][nextCol]) {
                            continue;
                        }

                        if (input[nextRow][nextCol] != input[i][j]) {
                            continue;
                        }

                        queue.add(new Node(nextRow, nextCol));
                        storedQueue.add(new Node(nextRow, nextCol));
                        discovered[nextRow][nextCol] = true;
                        connectedBlocks++;
                    }
                }

                if (connectedBlocks >= 4) {
                    clearBlockCount += connectedBlocks;

                    while (!storedQueue.isEmpty()) {
                        Node node = storedQueue.poll();
                        visited[node.row][node.col] = true;
                    }
                }
            }
        }

        return clearBlockCount;
    }

    static void down(char[][] input, boolean[][] visited) {
        Queue<Character> colBlocks = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {

                if (!visited[j][i]) {
                    colBlocks.add(input[j][i]);
                }
            }

            for (int j = 11; j >= 0; j--) {
                if (!colBlocks.isEmpty()) {
                    input[j][i] = colBlocks.poll();
                } else {
                    input[j][i] = '.';
                }
            }
        }
    }

    static void clear(boolean[][] visited, boolean[][] discovered) {
        for (int i = 0; i < 12; i++) {
            Arrays.fill(visited[i], false);
            Arrays.fill(discovered[i], false);
        }
    }
}

class Node {
    public int row, col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}