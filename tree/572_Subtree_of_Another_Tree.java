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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) { return false; }
        return isEqualTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t); 
    }
    
    public boolean isEqualTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) { return true; }
        if (t1 == null || t2 == null) { return false; }
        if (t1.val != t2.val) { return false; }
        return isEqualTree(t1.left, t2.left) && isEqualTree(t1.right, t2.right);
    }
}
