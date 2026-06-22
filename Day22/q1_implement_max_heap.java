import java.util.Scanner;

class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        // Heapify Up
        while (current > 0) {
            int parent = (current - 1) / 2;

            if (heap[parent] < heap[current]) {
                int temp = heap[parent];
                heap[parent] = heap[current];
                heap[current] = temp;

                current = parent;
            } else {
                break;
            }
        }
    }

    void display() {
        System.out.println("Max Heap:");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        MaxHeap heap = new MaxHeap(n);

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            heap.insert(x);
        }

        heap.display();

        sc.close();
    }
}
