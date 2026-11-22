class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.right = this.tail;
        this.tail.left = this.head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.getValue();
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));

        Node node = new Node(key, value);
        map.put(key, node);
        add(node);


        if (map.size() > this.capacity) {
            Node lru = this.head.right;
            remove(lru);
            map.remove(lru.getKey());

        }
    }

    private void add(Node node) {
        node.left = this.tail.left;
        tail.left.right = node;
        node.right = this.tail;
        this.tail.left = node;
    }

    private void remove(Node node) {
        Node next = node.right;
        Node prev = node.left;
        prev.right = next;
        next.left = prev;

    }

    private class Node {
        private final int key;
        private final int value;
        private Node left;
        private Node right;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
