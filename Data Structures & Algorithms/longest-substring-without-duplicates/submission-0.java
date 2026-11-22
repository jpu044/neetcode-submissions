class Solution {
    public int lengthOfLongestSubstring(String str) {
        int result = 0;
        int left = 0;
        Map<Character, Integer> frequency = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            frequency.put(str.charAt(right), frequency.getOrDefault(str.charAt(right), 0) + 1);
            while (frequency.get(str.charAt(right)) > 1) {
                frequency.put(str.charAt(left), frequency.get(str.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
