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
        return max(root, 0);
    }

    private int max(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } else if (root.left == null && root.right == null) {
            return depth + 1;
        }
        return Math.max(max(root.right, depth + 1), max(root.left, depth + 1));
    }
}
