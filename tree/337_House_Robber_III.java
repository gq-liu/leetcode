/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Attemp 1: naive
1.Termination condition: when do we know the answer to rob(root) without any calculation? Of course when the tree is empty ---- we've got nothing to rob so the amount of money is zero.
2.Recurrence relation: i.e., how to get rob(root) from rob(root.left), rob(root.right), ... etc. From the point of view of the tree root, there are only two scenarios at the end: root is robbed or is not. If it is, due to the constraint that "we cannot rob any two directly-linked houses", the next level of subtrees that are available would be the four "grandchild-subtrees" (root.left.left, root.left.right, root.right.left, root.right.right). However if root is not robbed, the next level of available subtrees would just be the two "child-subtrees" (root.left, root.right). We only need to choose the scenario which yields the larger amount of money.
*/
class Solution {
    public int rob(TreeNode root) {
        if (root == null) { return 0; }
        int value1 = root.val;
        if (root.left != null) { value1 += rob(root.left.left) + rob(root.left.right); }
        if (root.right != null) { value1 += rob(root.right.left) + rob(root.right.right); }
        int value2 = rob(root.left) + rob(root.right);
        return Math.max(value1, value2);
    }
}

/*
Attmep 1  to obtain rob(root), we need rob(root.left), rob(root.right), rob(root.left.left), rob(root.left.right), rob(root.right.left), rob(root.right.right); but to get rob(root.left), we also need rob(root.left.left), rob(root.left.right), similarly for rob(root.right). The naive solution above computed these subproblems repeatedly, which resulted in bad time performance. 
two conditions for dynamic programming: "optimal substructure" + "overlapping of subproblems", we actually have a DP problem. A naive way to implement DP here is to use a hash map to record the results for visited subtrees.
**/
class Solution {
    public int rob(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }
    private int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) { return 0; }
        if (map.containsKey(root)) { return map.get(root); }
        
        int value1 = root.val;
        if (root.left != null) { value1 += robHelper(root.left.left, map) + robHelper(root.left.right, map); }
        if (root.right != null) { value1 += robHelper(root.right.left, map) + robHelper(root.right.right, map); }
        int value2 = robHelper(root.left, map) + robHelper(root.right, map);
        int value = Math.max(value1, value2);
        map.put(root, value);
        return value;
    }
}

// Attemp 3
class Solution {
    public int rob(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }
    private int[] robHelper(TreeNode root) {
        if (root == null) { return new int[2]; }
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}

