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
        
        Recursive:
            visit(node)
                visit left
                add node to result
                visit right
        
        Iterative:
            visit(node)
                nodeStack
                while stack is not empty:
                    
        
    */
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null) return result;
        
        // visitRecursive(root, result); // RECURSIVE
        visitIterative(root, result); // ITERATIVE
        
        return result;
    }
   
    private void visitIterative(TreeNode node, List<Integer> result){
        
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        
        TreeNode currNode = node;
        
        addLeftToStack(node, nodeStack);
        
        while(!nodeStack.isEmpty()){
            
            TreeNode pop = nodeStack.pop();
            
            if(pop.right != null) {
                addLeftToStack(pop.right, nodeStack);
            }
            
            result.add(pop.val);
        }
        
    }
    
    private void addLeftToStack(TreeNode node, Stack<TreeNode> nodeStack){
        TreeNode currNode = node;
        while(currNode != null){
            nodeStack.push(currNode);
            currNode = currNode.left;
        }
    }
    private void visitRecursive(TreeNode node, List<Integer> result){
        
        if(node == null) return;
        
        visitRecursive(node.left, result);
        result.add(node.val);
        visitRecursive(node.right, result);
        
    }
    
}