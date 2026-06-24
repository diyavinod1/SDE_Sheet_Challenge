import java.util.Scanner;

class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public ArrayQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void push(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = x;
        System.out.println(x + " inserted into queue");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return queue[front++];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        ArrayQueue queue = new ArrayQueue(size);

        while (true) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. isEmpty");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int x = sc.nextInt();
                    queue.push(x);
                    break;

                case 2:
                    int removed = queue.pop();
                    if (removed != -1)
                        System.out.println("Removed Element: " + removed);
                    break;

                case 3:
                    int frontElement = queue.peek();
                    if (frontElement != -1)
                        System.out.println("Front Element: " + frontElement);
                    break;

                case 4:
                    System.out.println("Is Empty: " + queue.isEmpty());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
