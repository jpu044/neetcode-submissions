class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSumUtil(nums, currentList, result, 0, target);
        return result;
    }

    private void combinationSumUtil(int[] nums, List<Integer> currentList, List<List<Integer>> result, int startIndex, int target) {
        if(target < 0 || startIndex == nums.length) 
        return;
        if(target == 0){
        result.add(new ArrayList<>(currentList));
        return;
        }     

        currentList.addLast(nums[startIndex]);
        combinationSumUtil(nums, currentList, result, startIndex, target - nums[startIndex]);
        currentList.removeLast();
        combinationSumUtil(nums, currentList, result, startIndex+1, target);

    }
}
