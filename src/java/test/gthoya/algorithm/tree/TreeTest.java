package gthoya.algorithm.tree;

public class TreeTest {
    public static void main(String[] ar) {
        Tree tree = new BinaryTree();

        tree.insertNode(0);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.deleteNode(0);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.deleteNode(5);
        tree.insertNode(5);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.insertNode(3);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.insertNode(7);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.insertNode(9);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.insertNode(8);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.insertNode(3);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.insertNode(4);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.insertNode(1);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.deleteNode(7);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.deleteNode(3);
        tree.printAll();

        System.out.println();
        System.out.println();

        tree.deleteNode(5);
        tree.printAll();
    }
}
