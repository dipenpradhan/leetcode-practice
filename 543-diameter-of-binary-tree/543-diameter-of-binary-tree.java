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
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    
    
    int dfs(TreeNode n){
        if(n == null) return 0;
        
        int l = dfs(n.left);
        int r = dfs(n.right);
        
        max = Math.max(l+r, max);
        
        return Math.max(l,r)+1;
    }
}