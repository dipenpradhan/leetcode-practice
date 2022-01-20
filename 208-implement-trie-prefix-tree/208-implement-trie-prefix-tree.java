class Trie {

 static final class TrieNode{
    
    TrieNode[] children = new TrieNode[26];
    
    boolean end = false;
    
  }
    private TrieNode root;
    
    Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
      TrieNode tn = root;
      
      for(char c : word.toCharArray()){
         if(tn.children[c-'a'] == null) tn.children[c-'a'] = new TrieNode();
         tn = tn.children[c-'a'];
      }
      tn.end = true;
      
    }
    
    public boolean search(String word){
      TrieNode r = searchTrie(root, word);
      return r != null && r.end;
    }
    
    public boolean startsWith(String word){
      TrieNode r = searchTrie(root, word);
      return r != null;
    }
    
    private TrieNode searchTrie(TrieNode root, String word){
        
      TrieNode tn = root;
      
      for(char c : word.toCharArray()){
        
        if(tn.children[c-'a'] == null){
          return null;
        }
        tn = tn.children[c-'a'];
      }
      
      return tn;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */