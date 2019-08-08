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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) { return true; }
        if (t1 == null || t2 == null) { return false; }
        if (t1.val != t2.val) { return false; }
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
}

// // Wrong Solution   // 转化为中序遍历序列 但是顺拐的特例无法避免还
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         StringBuilder midOrderString = new StringBuilder();
//         midOrder(root, midOrderString);
//         String temp = midOrderString.toString();
//         for (int i = 0; i < temp.length() / 2; i++) {
//             if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     private void midOrder(TreeNode root, StringBuilder midOrderString) {
//         if (root == null) {
//             midOrderString.append('#');
//             return;
//         }
//         midOrder(root.left, midOrderString);
//         midOrderString.append(root.val);
//         midOrder(root.right, midOrderString);
//     }
// }
