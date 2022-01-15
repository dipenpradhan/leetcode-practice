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
        maxSum = -min int;
        
        fn maxSum(root):
            findMax(root);
            return maxSum
            
        fn findMax(node):
            
            compare between:
                1.max including current node
                2.max returned by left child and curr node
                3.max returned by right child and curr node
            
            update maxSum with max including current node if required
            return whichever is highest for this node between 2 & 3
            
    
    */
    
    
    private int maxPathSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxPathSum;
    }
    
    private int findMax(TreeNode node){
        if(node == null) return 0;
        // Find max of left path, if negative, ignore left path
        int leftMax = findMax(node.left);
        if(leftMax < 0) leftMax = 0;
        
        // Find max of right path, if negative, ignore left path
        int rightMax = findMax(node.right);
        if(rightMax < 0) rightMax = 0;
        
        // Check what max value can be achieved by passing path through curr node
        int currMax = node.val + leftMax + rightMax;
        
        // If curr node can beat max known sum, update maxsum
        if(currMax > maxPathSum) maxPathSum = currMax;
        
        // Return either left path or right path to recursion caller
        // This enables the caller to make their decision without caring about whether subtree has max or not
        // The leftMax and rightMax added here can be zero based on conditions above (if negative subtree then ignore)
        return node.val+(leftMax>=rightMax?leftMax:rightMax);
        
    }
}