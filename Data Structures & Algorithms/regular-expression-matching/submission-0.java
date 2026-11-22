class Solution {
    public boolean isMatch(String s, String p) {
        int wordLength = s.length();
        int patternLength = p.length();
        return search(0, 0, wordLength, patternLength, s, p);
    }

    private boolean search(int i, int j, int wordLength, int patternLength, String word, String pattern) {
        if (j == patternLength)
            return i == wordLength;

        boolean match = i < wordLength && (word.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');

        if (j + 1 < patternLength && pattern.charAt(j + 1) == '*') {
            return search(i, j + 2, wordLength, patternLength, word, pattern) || (match && search(i + 1, j, wordLength,
                    patternLength, word, pattern));
        }

        if (match)
            return search(i + 1, j + 1, wordLength, patternLength, word, pattern);

        return false;
    }
}
