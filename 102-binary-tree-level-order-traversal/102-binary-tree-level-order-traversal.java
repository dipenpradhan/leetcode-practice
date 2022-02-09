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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int N = q.size();
            List<Integer> r = new ArrayList<Integer>();
            while(N>0){
                TreeNode p = q.poll();
                r.add(p.val);
                if(p.left!=null)q.offer(p.left);
                if(p.right!=null)q.offer(p.right);
                N--;
            }
            res.add(r);
            
        }
        return res;
    }
}