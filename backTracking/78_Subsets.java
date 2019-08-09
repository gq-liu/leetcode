class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsetsHelper(nums, 0, list, result);
        return result;
    }
    private void subsetsHelper(int[] nums, int pos, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list)); 
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
    
}
