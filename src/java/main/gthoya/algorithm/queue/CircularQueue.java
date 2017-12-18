package gthoya.algorithm.queue;

public class CircularQueue<E> implements Queue<E>  {
    private Object[] queue;

    private int capacity;
    private int deQueueIndex;
    private int enQueueIndex;

    public CircularQueue(int capacity) throws Exception {
        if (capacity <= 0) {
            throw new Exception();
        }

        this.capacity = capacity + 1;
        this.queue = new Object[this.capacity];
    }

    public void enqueue(E values) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        queue[enQueueIndex] = values;
        enQueueIndex = (enQueueIndex + 1) % capacity;
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        E result = (E) queue[deQueueIndex];
        deQueueIndex = (deQueueIndex + 1) % capacity;

        return result;
    }

    private boolean isEmpty() {
        return deQueueIndex == enQueueIndex;
    }

    private boolean isFull() {
        return deQueueIndex == (enQueueIndex + 1) % capacity;
    }
}
