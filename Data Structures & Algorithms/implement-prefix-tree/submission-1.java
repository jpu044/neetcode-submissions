class PrefixTree {

    TrieNode root;

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean endOfWord = false;
    }

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        var curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;

    }

    public boolean search(String word) {
        var curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        var curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return true;
    }
}
