class Trie {
  
    public Trie() {
        
    }
    
    
  static final class TNode{
    TNode[] links = new TNode[26];
    int pfx = 0, end = 0;
  }
  
  TNode root = new TNode();
  
  TNode search(TNode root, String word){
    
    TNode tn = root;
    for(char c : word.toCharArray()){
      TNode nxt = tn.links[c-'a'];
      if(nxt ==null) return null;
      tn = nxt;
    }
    return tn;
  }
  
  void insert(String word){
    // Inserts the string word into the trie.
    
    TNode tn = root;
    
    for(char c: word.toCharArray()){
      
      if(tn.links[c-'a'] == null) tn.links[c-'a'] = new TNode();
      
      tn.links[c-'a'].pfx++;
      tn = tn.links[c-'a'];
    }
    tn.end++;
  }
  int countWordsEqualTo(String word){
    TNode tn = search(root, word);
    
    return tn == null ? 0 : tn.end;
  }
  int countWordsStartingWith(String prefix){
    // Returns the number of strings in the trie that have the string prefix as a prefix.
    TNode tn = search(root, prefix);
    
    return tn == null ? 0 : tn.pfx;
  }
  void erase(String word){
   // Erases the string word from the trie.
   TNode tn = root;
    
    for(char c: word.toCharArray()){
      
      if(tn == null || tn.links[c-'a'] == null) return;
      tn.links[c-'a'].pfx--;
      if(tn.links[c-'a'].pfx == 0){
        tn.links[c-'a'] = null;
      }
      tn = tn.links[c-'a'];
    }
    if(tn!=null){
      tn.end--;
    }
  }
 
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */