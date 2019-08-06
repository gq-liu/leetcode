/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int result = 0;
    public int pathSum(TreeNode root, int sum) {
        pathSumHelper(root, sum);
        return result;
    }
    private void pathSumHelper(TreeNode root, int sum) {
        if (root == null) { return; }
        pathSumFromRoot(root, sum);
        pathSumHelper(root.left, sum);
        pathSumHelper(root.right, sum);
    }
    private void pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) { return; }
        if (root.val == sum) { result++; }
        pathSumFromRoot(root.left, sum - root.val);
        pathSumFromRoot(root.right, sum - root.val);
    }
}

// Attempt 2 
class Solution {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) { return 0; }
		int result = pathSumFromRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		return result;
	}
	private int pathSumFromRoot(TreeNode root, int sum) {
		if (root == null) { return 0; }
		int sumNow = 0;
		if (root.val == sum) { sumNow++; }
		sumNow += pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right, sum - root.val);
		return sumNow;
	}

}
