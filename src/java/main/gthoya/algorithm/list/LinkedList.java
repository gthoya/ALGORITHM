package gthoya.algorithm.list;

import java.util.Scanner;

public class LinkedList {
    private Node head;

    public static void main(String[] ar) {
        Scanner scanner = new Scanner(System.in);

        LinkedList linkedList = new LinkedList();
        int orderCount;

        do {
            System.out.print("1. 입력   2. 삭제   3. 출력   0. 종료 : ");
            orderCount = scanner.nextInt();

            switch (orderCount) {
                case 1 :
                    System.out.print("입력 값 : ");
                    linkedList.append(scanner.nextInt());
                    break;

                case 2 :
                    System.out.print("삭제 값 : ");
                    linkedList.delete(scanner.nextInt());
                    break;

                case 3 :
                    linkedList.printAll();
                    break;

                case 0 :
                    break;

                default :
                    System.out.println("잘못된 입력");
                    break;
            }
        } while (orderCount != 0);
    }

    private void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node prev = head;
        Node current = head;

        while (current != null) {
            if (current.getData() == data) {
                System.out.println("Data is already exists");
                return;
            }

            prev = current;
            current = current.getNext();
        }

        prev.setNext(new Node(data));
    }

    private void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node prev = head;
        Node current = head;

        while (current != null) {
            if (current.getData() == data) {
                if (current == head) {
                    head = head.getNext();
                } else {
                    prev.setNext(current.getNext());
                }

                current = null;
                return;
            }

            prev = current;
            current = current.getNext();
        }

        System.out.println("Data is not exists");
    }

    private void printAll() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.getData());

            if (current.getNext() == null) {
                System.out.println();
                break;
            }

            System.out.print(" -> ");
            current = current.getNext();
        }
    }
}
