import java.util.*;

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacity = sc.nextInt();
        LRUCache lru = new LRUCache(capacity);

        int q = sc.nextInt(); // Number of operations

        while (q-- > 0) {
            String operation = sc.next();

            if (operation.equalsIgnoreCase("put")) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                lru.put(key, value);
            } else if (operation.equalsIgnoreCase("get")) {
                int key = sc.nextInt();
                System.out.println(lru.get(key));
            }
        }

        sc.close();
    }
}
