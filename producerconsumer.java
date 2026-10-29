
import java.util.LinkedList;

class SharedBuffer {
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;

    public synchronized void produce(int item)
            throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }

        buffer.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized void consume()
            throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }

        int item = buffer.removeFirst();
        System.out.println("Consumed: " + item);
        notify();
    }
}

class Producer extends Thread {
    private final SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private final SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
