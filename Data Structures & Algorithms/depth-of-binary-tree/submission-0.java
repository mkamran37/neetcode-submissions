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
        return findMax(root);
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1 + findMax(root.left);
        int rdepth = 1 + findMax(root.right);
        return Math.max(depth, rdepth);
    }
}
