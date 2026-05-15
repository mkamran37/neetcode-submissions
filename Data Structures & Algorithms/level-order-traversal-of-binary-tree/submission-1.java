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
        Deque<TreeNode> list = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        result.add(Arrays.asList(root.val));
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.pop();
                if (node.left != null) {
                    tmp.add(node.left.val);
                    list.add(node.left);
                } 
                if (node.right != null) {
                    tmp.add(node.right.val);
                    list.add(node.right);
                }
            }
            if (!tmp.isEmpty()) result.add(tmp);
        }
        return result;
    }
}
