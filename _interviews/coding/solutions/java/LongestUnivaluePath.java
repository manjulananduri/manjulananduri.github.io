/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return res - 1;
    }

    int res = 0;

    int dfs(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        res = Math.max(res, 1 + left + right);
        if (prev != root.val) {
            return 0;
        }
        return 1 + Math.max(left, right);
    }
}