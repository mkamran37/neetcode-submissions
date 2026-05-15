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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)[0] == 1;
    }

    private int[] maxDepth(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }
        int[] ldepth = maxDepth(root.left);
        int[] rdepth = maxDepth(root.right);
        boolean balanced = (ldepth[0] == 1 && rdepth[0] == 1) && (Math.abs(ldepth[1] - rdepth[1]) <= 1);
        return new int[]{balanced ? 1 : 0, 1 + Math.max(ldepth[1], rdepth[1])};
    }
}
