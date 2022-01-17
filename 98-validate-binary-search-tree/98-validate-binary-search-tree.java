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
        Using recursion, check if left subtree is valid and right subtree is valid
        Validity of subtree in BST:
            - all nodes in left subtree are less than parent
            - all nodes in right subtree are greater than parent
        Use long datatype to protect against integer max and min value existing in tree    
        fn isValidRecurse(node, min, max):
            if node is less than min or greater than max:
                FAIL
            if isValidRecurse(left, min, node) and isValidRecurse(right, node, max) are true:
                SUCCESS
            else
                FAIL
    */
    public boolean isValidBST(TreeNode root) {
           
        return validBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    
    private boolean validBSTRecursive(TreeNode node, long minVal, long maxVal){
        
        if(node == null) return true;
        
        if(node.val <= minVal || node.val >= maxVal){
            return false;
        }
        
        if(validBSTRecursive(node.left, minVal, node.val) 
           && validBSTRecursive(node.right, node.val, maxVal)
           ){
            return true;
        }

        return false;
    }
}