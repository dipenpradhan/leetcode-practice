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
        PRE ORDER TRAVERSAL
        
        PARENT->LEFT->RIGHT
        
        Implement recursively as:
            visit(node):
                add node to result
                visit(left)
                visit(right)
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        visitRecursive(root, result);
        
        return result;
    }
    
    private void visitRecursive(TreeNode node, List<Integer> result){
        
        if(node == null) return;
        
        result.add(node.val);
        visitRecursive(node.left, result);
        visitRecursive(node.right, result);
        
    }
}