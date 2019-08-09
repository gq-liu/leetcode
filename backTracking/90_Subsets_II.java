class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0, result, list);
        return result;
        
    }
    private void subsetsWithDupHelper(int[] nums, int pos, List<List<Integer>>result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) { continue; } // skip duplicate
            list.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
