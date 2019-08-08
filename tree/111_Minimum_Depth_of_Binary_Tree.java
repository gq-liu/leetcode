/*111. Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if (root == null) { return 0; }
		// 其中一个子树为空，计算深度只考虑另外一个子树的深度，否则取min就出错
        if (root.left == null) { return 1 + minDepth(root.right); }
        if (root.right == null) { return 1 + minDepth(root.left); }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
