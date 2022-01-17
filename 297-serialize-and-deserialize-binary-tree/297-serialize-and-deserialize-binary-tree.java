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
    
    private static final boolean DEBUG = false;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        
        // dfsSerializePreOrder(root, result);
        bfsSerializeLevelOrder(root, result);
        
        result.setLength(result.length()-1);
        if(DEBUG)
            System.out.println("Serialized string = "+result.toString());
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] nodes = data.split("_");
        if(DEBUG){
            System.out.println("Deserialized nodes = ");
            for(String s: nodes){
                System.out.print(s+" ");
            }
        }
            
        
        // return dfsDeserializePreOrder(nodes);
         return bfsDeserializeLevelOrder(nodes);
    }

    
    
    /************ BFS LEVEL ORDER ************/
    
    private TreeNode bfsDeserializeLevelOrder(String[] nodes){
        
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        
        int pos = 0;
        if(nodes == null || nodes.length == 0 || nodes[0].equals(".")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[pos]));
        nodeQ.offer(root);
        
        while(!nodeQ.isEmpty()){
            TreeNode currNode = nodeQ.poll();
            pos++;
            if(nodes[pos].equals(".")){
                currNode.left = null;
            }else{
                currNode.left = new TreeNode(Integer.parseInt(nodes[pos]));
                nodeQ.offer(currNode.left);
            }
            pos++;
            if(nodes[pos].equals(".")){
                currNode.right = null;
            }else{
                currNode.right = new TreeNode(Integer.parseInt(nodes[pos]));
                nodeQ.offer(currNode.right);
            }
        }
        
        return root;
    }
    
    
    private void bfsSerializeLevelOrder(TreeNode node, StringBuilder result){
        
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        
        nodeQ.offer(node);
        
        while(!nodeQ.isEmpty()){
            
            TreeNode polled = nodeQ.poll();
            
            if(polled == null){
                result.append("._");
                continue;
            }else{
                result.append(polled.val);
                result.append("_");    
            }
            
            nodeQ.offer(polled.left);
            nodeQ.offer(polled.right);
            
        }
        
    }
    
    
    
    /************ DFS PREORDER ************/
    
    int pos = 0;
    
    private TreeNode dfsDeserializePreOrder(String[] nodes){
        if(pos >= nodes.length) return null;
        TreeNode node = new TreeNode();
        if(nodes[pos].equals(".")){
            return null;
        }else{
            node.val = Integer.parseInt(nodes[pos]);
            pos++;
            node.left = dfsDeserializePreOrder(nodes);
            pos++;
            node.right = dfsDeserializePreOrder(nodes);
        }
        
        return node;
    }
    
    private void dfsSerializePreOrder(TreeNode node, StringBuilder result){
        
        if(node == null){
            result.append("._");
            return;
        }
        
        result.append(node.val);
        result.append("_");
        
        dfsSerializePreOrder(node.left, result);
        dfsSerializePreOrder(node.right, result);
        
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));