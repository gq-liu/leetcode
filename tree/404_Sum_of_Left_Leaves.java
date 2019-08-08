//404. Sum of Left Leaves
// Attempt 1: Using global value
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
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root, false);
        return sum;
    }
    private void preOrder(TreeNode root, boolean isLeft) {
        if (root == null) { return; }
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
        }
        preOrder(root.left, true);
        preOrder(root.right, false);
    }
}
// 避免使用 全局变量的方法：
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) { return 0; }
        if (isLeave(root.left)) { 
            return root.left.val + sumOfLeftLeaves(root.right); 
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    private boolean isLeave(TreeNode root) {
        if (root == null) { return false; }
        return root.left == null && root.right == null;
    }
}
