/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// sum 值从上往下递减，判断叶子上的value 是否等于 最后递减后的sum值
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false;}
        if (root.right == null && root.left == null && root.val == sum) { return true; }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
