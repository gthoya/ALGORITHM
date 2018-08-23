package gthoya.swexpertacademy.level4;

import java.util.Scanner;
import java.util.Stack;

public class Solution1249 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node[][] matrix;
        int[][] minRecovery;
        int orderCount = scanner.nextInt();
        int size, tempData;
        String input;

        Stack<Node> stack;
        Node currentNode, rightNode, bottomNode;

        for (int i = 1; i <= orderCount; i++) {
            size = scanner.nextInt();
            matrix = new Node[size][size];
            minRecovery = new int[size][size];

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = new Node();
                }
            }

            for (int j = 0; j < size; j++) {
                input = scanner.next();

                for (int k = 0; k < size; k++) {
                    minRecovery[j][k] = Integer.MAX_VALUE;
                    matrix[j][k].insert(Integer.parseInt(String.valueOf(input.charAt(k))), k, j);

                    if (j != (size - 1)) {
                        matrix[j + 1][k].top = matrix[j][k];
                    }

                    if (j != 0) {
                        matrix[j - 1][k].bottom = matrix[j][k];
                    }

                    if (k != (size - 1)) {
                        matrix[j][k + 1].left = matrix[j][k];
                    }

                    if (k != 0) {
                        matrix[j][k - 1].right = matrix[j][k];
                    }
                }
            }

            stack = new Stack<>();
            stack.push(matrix[0][0]);
            while (!stack.isEmpty()) {
                currentNode = stack.pop();

                if (currentNode.left != null) {
                    tempData = currentNode.data + currentNode.left.data;
                    if (tempData < minRecovery[currentNode.left.y][currentNode.left.x] && tempData < minRecovery[size - 1][size - 1]) {
                        rightNode = new Node(currentNode.data + currentNode.left.data, currentNode.left.x, currentNode.left.y);
                        rightNode.left = currentNode.left.left;
                        rightNode.right = currentNode.left.right;
                        rightNode.top = currentNode.left.top;
                        rightNode.bottom = currentNode.left.bottom;

                        stack.push(rightNode);
                        minRecovery[currentNode.left.y][currentNode.left.x] = tempData;
                    }
                }

                if (currentNode.right != null) {
                    tempData = currentNode.data + currentNode.right.data;
                    if (tempData < minRecovery[currentNode.right.y][currentNode.right.x] && tempData < minRecovery[size - 1][size - 1]) {
                        rightNode = new Node(currentNode.data + currentNode.right.data, currentNode.right.x, currentNode.right.y);
                        rightNode.left = currentNode.right.left;
                        rightNode.right = currentNode.right.right;
                        rightNode.top = currentNode.right.top;
                        rightNode.bottom = currentNode.right.bottom;

                        stack.push(rightNode);
                        minRecovery[currentNode.right.y][currentNode.right.x] = tempData;
                    }
                }

                if (currentNode.top != null) {
                    tempData = currentNode.data + currentNode.top.data;
                    if (tempData < minRecovery[currentNode.top.y][currentNode.top.x] && tempData < minRecovery[size - 1][size - 1]) {
                        rightNode = new Node(currentNode.data + currentNode.top.data, currentNode.top.x, currentNode.top.y);
                        rightNode.left = currentNode.top.left;
                        rightNode.right = currentNode.top.right;
                        rightNode.top = currentNode.top.top;
                        rightNode.bottom = currentNode.top.bottom;

                        stack.push(rightNode);
                        minRecovery[currentNode.top.y][currentNode.top.x] = tempData;
                    }
                }

                if (currentNode.bottom != null) {
                    tempData = currentNode.data + currentNode.bottom.data;
                    if (tempData < minRecovery[currentNode.bottom.y][currentNode.bottom.x] && tempData < minRecovery[size - 1][size - 1]) {
                        bottomNode = new Node(currentNode.data + currentNode.bottom.data, currentNode.bottom.x, currentNode.bottom.y);
                        bottomNode.left = currentNode.bottom.left;
                        bottomNode.right = currentNode.bottom.right;
                        bottomNode.top = currentNode.bottom.top;
                        bottomNode.bottom = currentNode.bottom.bottom;

                        stack.push(bottomNode);
                        minRecovery[currentNode.bottom.y][currentNode.bottom.x] = tempData;
                    }
                }
            }

            System.out.println("#" + i + " " + minRecovery[size - 1][size - 1]);
        }
    }

    private static class Node {
        public int data, x, y;
        public Node left, right, top, bottom;

        public Node() {

        }

        public Node(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }

        public void insert(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }
    }
}
