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
        Perform in-order traversal using DFS approach
        During traversal, visit:
            1. left child
            2. current node
                increment count
                if count reaches k return value of current node
            3. right child
        
        Can be done recursively by checking count:
            after visiting left
            but before visiting right
            
        Can be done iteratively by checking count:
            after popping all left children from stack
            but before adding left children of right node to stack
    */
    
    private int count = 0, result = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        // inorderRecursive(root, k); // RECURSIVE in-order traversal - DFS
        inorderIterative(root, k); // ITERATIVE in-order traversal - DFS
        
        return result;
        
    }
        
    private void inorderIterative(TreeNode node, int k){
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        addLeftToStack(node, stack);
        
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            
            count++;
            
            if(count == k){
                result = pop.val;
                return;
            }
            addLeftToStack(pop.right, stack);
            
        }
    }
    
    private void addLeftToStack(TreeNode node, Stack<TreeNode> stack){
        TreeNode currNode = node;
        
        while(currNode!=null){
            stack.add(currNode);
            currNode = currNode.left;
        }
        
    }
    
    private void inorderRecursive(TreeNode node, int k){
        
        if(node == null) {
            return;
        }
        
        inorderRecursive(node.left, k);
        
        count++;
        
        if(count == k){
            result = node.val;
            return;
        }
        
        inorderRecursive(node.right, k);
        

    }
    
    
    
}