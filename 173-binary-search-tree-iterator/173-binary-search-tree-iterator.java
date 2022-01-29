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
class BSTIterator {

    private int curr = -1;
    private Stack<TreeNode> stk = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        visitLeft(root, stk);
    }
    
    public int next() {
        if(!hasNext()) return -1;
        TreeNode p = stk.pop();
        
        visitLeft(p.right, stk);
        
        
         return p.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
    
    private void visitLeft(TreeNode n, Stack<TreeNode> stk){
        while(n!=null){
            stk.push(n);
            n = n.left;
        }
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */