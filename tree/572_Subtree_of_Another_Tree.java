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

// 利用把树用先序遍历转化为字符串，在用KMP算法的匹配问题。注意需要自习考虑加入的分隔符，正确的分割各个子树。
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder spre = new StringBuilder();
        StringBuilder tpre = new StringBuilder();
        preOrder(s, spre.append(',')); // 树和各个子树用，开头
        preOrder(t, tpre.append(','));
        return spre.toString().contains(tpre.toString());
    }
    public void preOrder(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#,");  // #表示null，空树，不要忘了后面加分割
            return;
        }
        str.append(root.val).append(',');
        preOrder(root.left, str);
        preOrder(root.right, str);
    }
}

