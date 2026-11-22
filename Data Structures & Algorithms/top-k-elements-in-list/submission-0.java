class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] frequencyArray = new List[nums.length+1];

        for (int i=0;i<nums.length;i++)
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0)+1);

        for(int i=0;i<frequencyArray.length;i++)
            frequencyArray[i] = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            frequencyArray[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for(int i=frequencyArray.length-1;i>0;i--){
            for(int a: frequencyArray[i]){
                result[index++] = a;
                if(index == k)
                return result;
            }
        }
        return result;
        
    }
}
