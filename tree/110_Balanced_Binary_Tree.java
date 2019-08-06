/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 利用 maxDepth 计算的程序
// 设置一个isBalanced 全局变量
class Solution {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) { return true; }
        int depth = isBalancedHelper(root);
        return isBalanced;
    }
    private int isBalancedHelper(TreeNode root) {
        if (root == null) { return 0; }
        int leftDepth = isBalancedHelper(root.left);
        int rightDepth = isBalancedHelper(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }
        // 下面错误的原因：不能把isBalanced 改回true
		//isBalanced = Math.abs(leftDepth - rightDepth) <= 1 ? true:false; 
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
