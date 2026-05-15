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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        result.add(List.of(root.val));
        Deque<TreeNode> tracker = new ArrayDeque<>();
        tracker.add(root);
        while (!tracker.isEmpty()){
            int size = tracker.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = tracker.pop();
                if (curr.left != null) {
                    tracker.add(curr.left);
                    tmp.add(curr.left.val);
                }
                if (curr.right != null) {
                    tracker.add(curr.right);
                    tmp.add(curr.right.val);
                }
            }
            if (!tmp.isEmpty()) result.add(tmp);
        }
        return result;
    }
}
