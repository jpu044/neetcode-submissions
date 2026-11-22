class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i=0;i<nums.length; i++) {
            int diff = target-nums[i];
            if(countMap.containsKey(diff))
                return new int[]{i> countMap.get(diff)? countMap.get(diff) : i, i< countMap.get(diff)? countMap.get(diff) : i};
            countMap.putIfAbsent(nums[i], i);
            
        }
        return new int[]{};
        
    }
}
