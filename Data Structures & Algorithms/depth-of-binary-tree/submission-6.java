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
        if (root == null) {
            return 0;
        }
        return Math.max(findMax(root.left, 1), findMax(root.right, 1));
    }

    private int findMax(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(findMax(root.left, depth + 1), findMax(root.right, depth + 1));
    }
}
