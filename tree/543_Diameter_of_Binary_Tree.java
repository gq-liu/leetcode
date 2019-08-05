/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 二叉树中两个点之间最远的路径 不一定过root，所有节点的左右子树深度之和的最大值
class Solution {
    private int diameterOfBT = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) { return 0; }
        maxDepth(root);
        return diameterOfBT;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) { return 0; }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 用Math.max 更简洁
		//diameterOfBT = diameterOfBT > (leftDepth + rightDepth) ? diameterOfBT:(leftDepth + rightDepth);
        diameterOfBT = Math.max(diameterOfBT, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
