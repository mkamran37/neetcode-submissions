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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        return findCommon(root, p, q);
    }

    private TreeNode findCommon(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
            return root;
        }
        if (p.val <= root.val && q.val <= root.val) {
            return findCommon (root.left, p, q);
        } else {
            return findCommon(root.right, p, q);
        }
    }
}
