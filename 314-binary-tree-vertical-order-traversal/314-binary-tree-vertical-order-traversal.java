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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<Integer, List<Pair<Integer, Integer>>>();
        
        List<Integer> keys = new ArrayList<Integer>();
        dfs(root, 0, 0, map);

        keys.addAll(map.keySet());
        Collections.sort(keys);
        for(int k: keys){
            List<Pair<Integer, Integer>> v = map.get(k);
            Collections.sort(v, (a,b)->a.getKey()-b.getKey());
            List<Integer> r = new ArrayList<Integer>();
            for(Pair<Integer, Integer> p : v){
                r.add(p.getValue());
            }
            res.add(r);
            
        }
        
        return res;
    }
    
    private void dfs(TreeNode n, int r, int c, Map<Integer, List<Pair<Integer, Integer>>> map){
        
        if(n==null) return;
        
        List<Pair<Integer,Integer>> v = map.getOrDefault(c, new ArrayList<Pair<Integer, Integer>>());
        v.add(new Pair<Integer, Integer>(r, n.val));
        map.put(c, v);
        
        dfs(n.left, r+1, c-1, map);
        dfs(n.right, r+1, c+1, map);
        
    }
}