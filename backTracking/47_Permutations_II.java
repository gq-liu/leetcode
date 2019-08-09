class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> currIndex = new ArrayList<>();
        permuteUniqueHelper(nums, result, list, currIndex);
        return result;
    }
    private void permuteUniqueHelper(int[] nums, List<List<Integer>> result, List<Integer> list, List<Integer> currIndex) {
		if (list.size() == nums.length && !result.contains(list)) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (currIndex.contains(i)) { // skip 访问过的index
                continue;
            }
            list.add(nums[i]);
            currIndex.add(i);
            permuteUniqueHelper(nums, result, list, currIndex);
            list.remove(list.size() - 1);
            currIndex.remove(currIndex.size() - 1);
        }
    }
}
