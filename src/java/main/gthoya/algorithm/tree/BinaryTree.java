package gthoya.algorithm.tree;

import gthoya.algorithm.tree.model.Node;

public class BinaryTree implements Tree {
    private Node root;

    public BinaryTree() {}

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void insertNode(int data) {
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
        } else {
            System.out.println("Data already exists");
        }
    }


    public void deleteNode(int data) {
        deleteNode(this.root, null, data);
    }

    private void deleteNode(Node currentNode, Node preNode, int data) {
        if (currentNode == null) {
            System.out.println("Data not found");
            return;
        }

        if (currentNode.getData() == data) {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                if (preNode == null) {
                    this.root = null;
                } else {
                    if (preNode.getData() < currentNode.getData()) {
                        preNode.setRight(null);
                    } else {
                        preNode.setLeft(null);
                    }
                }
            } else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                if (preNode != null) {
                    preNode.setRight(currentNode.getRight());
                }
            } else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                if (preNode != null) {
                    preNode.setLeft(currentNode.getLeft());
                }
            } else {
                Node tempNode = currentNode;
                currentNode = currentNode.getRight();

                while(currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                }

                currentNode.setLeft(tempNode.getLeft());

                if (preNode == null) {
                    this.root = tempNode.getRight();
                } else {
                    preNode.setLeft(currentNode);
                }
            }
        } else if (currentNode.getData() < data) {
            deleteNode(currentNode.getRight(), currentNode, data);
        } else if (currentNode.getData() > data) {
            deleteNode(currentNode.getLeft(), currentNode, data);
        }
    }

    public void printAll() {
        printAll(this.root);
    }

    private void printAll(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        if (currentNode.getLeft() != null) {
            printAll(currentNode.getLeft());
        }

        System.out.println(currentNode.getData());

        if (currentNode.getRight() != null) {
            printAll(currentNode.getRight());
        }
    }
}
