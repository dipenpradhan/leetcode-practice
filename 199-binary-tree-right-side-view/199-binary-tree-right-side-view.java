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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int N = q.size();
            
            int i = 0;
            TreeNode tn = null;
            while(i < N){
                
                tn = q.poll();
            
                if(tn.left!=null) q.offer(tn.left);
                if(tn.right!=null) q.offer(tn.right);

                i++;
            }
            
            res.add(tn.val);
            
        }
        
        return res;
    }
}