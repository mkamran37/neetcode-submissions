/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
    }

    private int maxDepth(TreeNode curr, int currDepth) {
        if (curr == null) return currDepth;
        if (curr.left == null && curr.right == null) return currDepth + 1;
        return Math.max(maxDepth(curr.left, currDepth + 1), maxDepth(curr.right, currDepth + 1));
    }
}
