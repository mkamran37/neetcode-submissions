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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(TreeNode curr, Integer min, Integer max) {
        if (curr == null) {
            return true;
        }
        if (min >= curr.val || max <= curr.val) return false;
        return valid(curr.left, min, curr.val)
        && valid(curr.right, curr.val, max);
    }
}
