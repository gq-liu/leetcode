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
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }
    private void invertTreeHelper(TreeNode root) {
        if (root == null) { return; }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
