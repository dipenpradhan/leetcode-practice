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
    
    /*
        INORDER TRAVERSAL
        LEFT -> PARENT -> RIGHT
    */
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null) return result;
        
        visit(root, result);
        
        return result;
    }
   
    
    private void visit(TreeNode node, List<Integer> result){
        
        if(node == null) return;
        
        visit(node.left, result);
        result.add(node.val);
        visit(node.right, result);
        
    }
    
}