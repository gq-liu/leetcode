//216. Combination Sum III
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinationSum3Helper(nums, k, n, result, list, 0);
        return result;
    }
    
    private void combinationSum3Helper(int[] nums, int num, int remain, List<List<Integer>> result, List<Integer> list, int pos) {
        if (list.size() == num && remain == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = pos; i < nums.length; i++) {
                if (list.size() == num || nums[i] > remain) { continue; }
                list.add(nums[i]);
                combinationSum3Helper(nums, num, remain - nums[i], result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
