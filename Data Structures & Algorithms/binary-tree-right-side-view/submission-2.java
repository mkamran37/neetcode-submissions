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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> tr = new ArrayList<>();
        tr.add(root);
        while(!tr.isEmpty()) {
            int size = tr.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode tmp = tr.remove(0);
                if (tmp.left != null)
                tr.add(tmp.left);
                if (tmp.right != null)
                tr.add(tmp.right);
                list.add(tmp.val);
            }
            result.add(list.get(list.size() - 1));
        }
        return result;
    }
}
