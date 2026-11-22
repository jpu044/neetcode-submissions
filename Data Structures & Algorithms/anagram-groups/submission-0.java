class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();


        for (int i=0;i<strs.length;i++) {
            String key = hash(strs[i]);
            if(!map.containsKey(key)) {

                map.put(key, result.size());
                result.add(new ArrayList<>());
            }

            result.get(map.get(key)).add(strs[i]);
        }
        
        return result;
        
    }

    private String hash(String str) {
        int[] frequency = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()) {
            frequency[c-'a']++;

        }
        for(int i=0;i<26;i++) {
            sb.append(frequency[i]);
            sb.append("$");
        }
        return sb.toString();
    }
}
