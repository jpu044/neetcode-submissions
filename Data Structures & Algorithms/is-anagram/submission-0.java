class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> countMap = new HashMap<>();

        for(char c: s.toCharArray()) {
            
            countMap.computeIfPresent(c, (k, v) -> v+1);
            countMap.putIfAbsent(c, 1);
        }

        for(char c: t.toCharArray()) {
            if(!countMap.containsKey(c) || countMap.get(c) == 0 )
                return false;
            countMap.compute(c, (k, v) -> v-1);
        }
        return true;
    }
}
