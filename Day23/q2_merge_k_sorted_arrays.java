import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                pq.offer(sc.nextInt());
            }
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
