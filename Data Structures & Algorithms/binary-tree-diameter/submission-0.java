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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        maxDepth(root, res);
        return res[0];
    }

    private int maxDepth(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int ldepth = maxDepth(root.left, result);
        int rdepth = maxDepth(root.right, result);
        result[0] = Math.max(result[0], ldepth + rdepth);
        return Math.max(ldepth, rdepth) + 1;
    }
}
