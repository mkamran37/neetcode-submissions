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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        runInOrderDfs(root, k, result);
        return result.get(k - 1);
    }

    private void runInOrderDfs(TreeNode root, int k, List<Integer> result) {
        if (root == null || result.size() == k) {
            return;
        }
        runInOrderDfs(root.left, k, result);
        result.add(root.val);
        runInOrderDfs(root.right, k, result);
    }
}
