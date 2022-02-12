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

    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root, 1);
        return res;
    }
    
    private int dfs(TreeNode n, int c){
        if(n == null) return c;
        if(!res) return -1;
        int l = dfs(n.left, c+1);
        int r = dfs(n.right, c+1);
        if(Math.abs(l-r) > 1) res = false;
        
        return Math.max(l, r); 
    }
}