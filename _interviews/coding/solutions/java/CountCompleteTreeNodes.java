/**
 * Time Complexity: O(N) where N is the number of nodes.
 * Space Complexity: O(d) to keep recursion stack where d is the tree depth.
 */
class Solution {
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    int count;

    void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        count++;
        dfs(root.left);
        dfs(root.right);
    }
}

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