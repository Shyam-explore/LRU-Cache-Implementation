import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list;

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList {
        Node head, tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeTail() {
            Node lru = tail.prev;
            removeNode(lru);
            return lru;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        list.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            list.moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                Node lru = list.removeTail();
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            list.addNode(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        System.out.println("Put(1, 1)");
        lruCache.put(1, 1);

        System.out.println("Put(2, 2)");
        lruCache.put(2, 2);

        System.out.println("Get(1): " + lruCache.get(1)); // Expected Output: 1

        System.out.println("Put(3, 3) - Evicts key 2");
        lruCache.put(3, 3);

        System.out.println("Get(2): " + lruCache.get(2)); // Expected Output: -1 (Evicted)

        System.out.println("Put(4, 4) - Evicts key 1");
        lruCache.put(4, 4);

        System.out.println("Get(1): " + lruCache.get(1)); // Expected Output: -1 (Evicted)
        System.out.println("Get(3): " + lruCache.get(3)); // Expected Output: 3
        System.out.println("Get(4): " + lruCache.get(4)); // Expected Output: 4
    }
}
