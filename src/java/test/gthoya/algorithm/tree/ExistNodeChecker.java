package gthoya.algorithm.tree;

import java.util.Scanner;

public class ExistNodeChecker {
    private Node root;

    private void insertNode(int data) {
        insertNode(this.root, data);
    }

    private void insertNode(Node currentNode, int data) {
        if (this.root == null) {
            this.root = new Node(data);
            return;
        }

        if (currentNode.getData() < data) {
            if (currentNode.getRight() == null) {
                currentNode.setRight(new Node(data));
            } else {
                insertNode(currentNode.getRight(), data);
            }
        } else if (currentNode.getData() > data) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(new Node(data));
            } else {
                insertNode(currentNode.getLeft(), data);
            }
        }
    }

    private int searchNode(int data) {
        return searchNode(this.root, data);
    }

    private int searchNode(Node currentNode, int data) {
        if (currentNode == null) {
            return 0;
        }

        if (currentNode.getData() == data) {
            return 1;
        } else if (currentNode.getData() < data) {
            return searchNode(currentNode.getRight(), data);
        } else if (currentNode.getData() > data) {
            return searchNode(currentNode.getLeft(), data);
        }

        return 0;
    }

    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);
        ExistNodeChecker existNodeChecker = new ExistNodeChecker();
        int inputCount = scanner.nextInt();

        for (int i = 0; i < inputCount; i++) {
            existNodeChecker.insertNode(scanner.nextInt());
        }

        int searchCount = scanner.nextInt();

        for (int i = 0; i < searchCount; i++) {
            System.out.println(existNodeChecker.searchNode(scanner.nextInt()));
        }
    }

    class Node {
        private int data;

        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
