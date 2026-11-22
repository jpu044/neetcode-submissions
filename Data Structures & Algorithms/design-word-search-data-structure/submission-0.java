class WordDictionary {

    TrieNode root;

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean endOfWord = false;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int j, TrieNode root) {
        TrieNode curr = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Map.Entry<Character, TrieNode> child : curr.children.entrySet()) {
                    return search(word, i + 1, child.getValue());
                }
                return false;
            } else {
                if (!curr.children.containsKey(c))
                    return false;
                curr = curr.children.get(c);
            }
        }
        return curr.endOfWord;
    }
}
