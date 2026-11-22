class Solution {
    boolean dp[][];
    public boolean isMatch(String s, String p) {
        int wordLength = s.length();
        int patternLength = p.length();
        dp = new boolean[wordLength + 1][patternLength + 1];
        return searchDP(0, 0, wordLength, patternLength, s, p);
    }

    private boolean searchDP(int i, int j, int wordLength, int patternLength, String word, String pattern) {
        if (j == patternLength)
            return i == wordLength;

        if (dp[i][j])
            return true;

        boolean match = i < wordLength && (word.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');

        if (j + 1 < patternLength && pattern.charAt(j + 1) == '*') {

            dp[i][j] = searchDP(i, j + 2, wordLength, patternLength, word, pattern) || (match && searchDP(i + 1, j,
                    wordLength,
                    patternLength, word, pattern));
        } else {
            dp[i][j] = match && searchDP(i + 1, j + 1, wordLength, patternLength, word, pattern);
        }

        return dp[i][j];

    }
}
