/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfsPreOrder(root, result);
        result.setLength(result.length()-1);
        // System.out.println(result);
        
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] nodes = data.split("_");
        
        TreeNode result = dfsDeserialize(nodes);
        
        for(String n:nodes){
            System.out.print(n+" ");
        }
        return result;
    }
    int pos = 0;
    private TreeNode dfsDeserialize(String[] nodes){
        if(pos >= nodes.length) return null;
        TreeNode node = new TreeNode();
        if(nodes[pos].equals(".")){
            return null;
        }else{
            node.val = Integer.parseInt(nodes[pos]);
            pos++;
            node.left = dfsDeserialize(nodes);
            pos++;
            node.right = dfsDeserialize(nodes);
        }
        
        return node;
    }
    
    private void dfsPreOrder(TreeNode node, StringBuilder result){
        
        if(node == null){
            result.append("._");
            return;
        }
        
        result.append(node.val);
        result.append("_");
        
        dfsPreOrder(node.left, result);
        dfsPreOrder(node.right, result);
        
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));