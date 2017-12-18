package gthoya.algorithm.stack;

public class LinearStack<E> implements Stack<E> {
    private Object[] stack;

    private int capacity;
    private int topIndex;

    public LinearStack(int capacity) throws Exception {
        if (capacity <= 0) {
            throw new Exception();
        }

        this.capacity = capacity;
        stack = new Object[capacity];
    }

    public void push(E values) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }

        stack[topIndex++] = values;
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        E result = (E) stack[--topIndex];
        stack[topIndex] = null;

        return result;
    }

    private boolean isFull() {
        return topIndex == capacity;
    }

    private boolean isEmpty() {
        return topIndex == 0;
    }
}
