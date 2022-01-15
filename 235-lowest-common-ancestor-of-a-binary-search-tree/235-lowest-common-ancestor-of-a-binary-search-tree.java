/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
            
                1. check node less than p and greater than q then node is least
                2. check node greater p than and less than q then node is least
                3. if node is equal to either p or q node is least
            
        
        */
        
        if(root == null) return null;
        
        if((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)){
            return root;
        }else{
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            
            return left!=null?left:right;
        }
        
        
    }
}