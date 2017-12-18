package gthoya.algorithm.queue;

public class LinearQueue<E> implements Queue<E> {
    private Object[] queue;

    private int capacity;
    private int enQueueIndex;
    private int deQueueIndex;

    public LinearQueue(int capacity) throws Exception {
        if (capacity <= 0) {
            throw new Exception();
        }

        this.capacity = capacity;
        this.queue = new Object[capacity];
    }

    public void enqueue(E values) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        queue[enQueueIndex++] = values;
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return (E) queue[deQueueIndex++];
    }

    private boolean isEmpty() {
        if (deQueueIndex == enQueueIndex) {
            return true;
        }

        return false;
    }

    private boolean isFull() {
        if (enQueueIndex == capacity) {
            return true;
        }

        return false;
    }
}
