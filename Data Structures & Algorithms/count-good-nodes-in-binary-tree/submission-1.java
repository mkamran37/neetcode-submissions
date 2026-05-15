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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);
    }

    private int dfs(TreeNode curr, int val) {
        if (curr == null) {
            return 0;
        }
        int res = (curr.val >= val) ? 1 : 0;
        val = Math.max(curr.val, val);
        res += dfs(curr.left, val);
        res += dfs(curr.right,val);
        return res;
    }
}
