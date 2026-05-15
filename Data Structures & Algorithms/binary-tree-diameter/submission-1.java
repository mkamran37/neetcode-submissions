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
        int[] result = new int[1];
        diameter(root, result);
        return result[0];
    }

    private int diameter(TreeNode curr, int[] result) {
        if (curr == null) {
            return 0;
        }
        int ldiam = diameter(curr.left, result);
        int rdiam = diameter(curr.right, result);
        result[0] = Math.max(result[0], ldiam + rdiam);
        return Math.max(ldiam, rdiam) + 1;
    }
}
