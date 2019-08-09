class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(candidates, target, result, list, 0);
        return result;
    }
    
    private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int pos) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = pos; i < candidates.length; i++) {
                if (candidates[i] > target) { continue; }
                list.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], result, list, i); // NOT i + 1, 可以复用第i项
                list.remove(list.size() - 1);
            }
        }
    }  
}
