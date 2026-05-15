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
        if (root == null) {
            return result;
        }
        List<TreeNode> bfs = new ArrayList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(bfs.get(0).val);
                TreeNode tr = bfs.remove(0);
                if (tr.left != null)
                    bfs.add(tr.left);
                if (tr.right != null)
                    bfs.add(tr.right);
            }
            result.add(list);
        }
        return result;
    }
}
