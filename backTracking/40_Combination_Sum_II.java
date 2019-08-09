class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, result, list, 0);
        return result;
    }
    
    private void combinationSum2Helper(int[] candidates, int remain, List<List<Integer>> result, List<Integer> list, int pos) {
        if (remain == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = pos; i < candidates.length; i++) {
                if (i != pos && candidates[i] == candidates[i - 1] || candidates[i] > remain) { // 注意是后面是 或 关系
                    continue;
                }
                list.add(candidates[i]);
                combinationSum2Helper(candidates, remain - candidates[i], result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
