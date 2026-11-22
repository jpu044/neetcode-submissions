class LRUCache {

    int capacity;
    Map<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.setNext(tail);
        tail.setPrev(head);
    }

    private void remove(Node node) {
        Node prev = node.getPrev();
        Node next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
    }

    private void add(Node node) {
        Node prev = tail.getPrev();
        prev.setNext(node);
        node.setPrev(prev);
        node.setNext(tail);
        tail.setPrev(node);
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        remove(node);
        add(node);
        return node.getValue();
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        add(newNode);
        cache.put(key, newNode);

        if (cache.size() > this.capacity) {
            Node lru = head.getNext();
            remove(lru);
            cache.remove(lru.getKey());
        }

    }

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
