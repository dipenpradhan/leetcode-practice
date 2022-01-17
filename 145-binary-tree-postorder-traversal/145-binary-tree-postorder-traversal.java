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
        POST ORDER TRAVERSAL
        
        LEFT->RIGHT->PARENT
        
        Implement recursively as:
            visit(node):
                visit(left)
                add node to result
                visit(right)
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        visitRecursive(root, result);
        
        return result;
        
    }
    
    private void visitRecursive(TreeNode node, List<Integer> result){
        
        if(node == null) return;
        
        visitRecursive(node.left, result);
        visitRecursive(node.right, result);
        result.add(node.val);
    }
    
}