# Producer–Consumer Problem in Java

## Aim
To implement the Producer–Consumer problem in Java using inter-thread communication with `wait()` and `notify()`.

## Problem Statement
Write a Java program that creates a shared buffer using a LinkedList with fixed capacity. The producer adds items to the buffer, and the consumer removes items from it.

## Concepts Used
- Java Threads
- LinkedList
- Synchronization
- `synchronized` methods
- `wait()` method
- `notify()` method

## Algorithm
1. Create a shared buffer using LinkedList.
2. Set the buffer capacity to 3.
3. Create a Producer thread to add items.
4. Create a Consumer thread to remove items.
5. Use `wait()` when the buffer is full or empty.
6. Use `notify()` to wake up the waiting thread.
7. Start both threads using `start()`.

## Program File
`ProducerConsumer.java`

## How to Run

Compile the program:

```bash
javac ProducerConsumer.java
```

Run the program:

```bash
java ProducerConsumer
```

## Sample Output

```text
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Produced: 4
Consumed: 3
Produced: 5
Consumed: 4
Consumed: 5
```

**Note:** The output order may vary because threads execute concurrently.

## Result
The Producer–Consumer problem was successfully implemented in Java using LinkedList, synchronization, `wait()`, and `notify()`.
