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
            
            if left is less than node and right is greater than node, this has to be least common
                1. check node less than or equal to p/q
                2. check node greater than or equal to p/q
                3. if node is equal to either p or q
            
        
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