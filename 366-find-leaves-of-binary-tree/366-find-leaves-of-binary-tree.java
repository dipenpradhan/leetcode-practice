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
    
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while(root != null){
            List<Integer> r = new ArrayList<Integer>();
            if(leaves(root, r)) root = null;
            res.add(r);
        }
        return res;
    }
    
    private boolean leaves(TreeNode n, List<Integer> r){
        
        if(n == null) return true;
        
        if(n.left == null && n.right == null){
          r.add(n.val);
          return true;
        } 
        if(leaves(n.left, r)){
            n.left = null;
        }
        if(leaves(n.right, r)){
            n.right = null;
        }
        return false;
    }
}