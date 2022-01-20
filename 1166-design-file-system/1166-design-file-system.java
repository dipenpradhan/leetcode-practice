class FileSystem {
    
 static final class TrieNode{
    
    Map<String, TrieNode> dirs = new HashMap<String, TrieNode>();
    int val;
    
    TrieNode(int val){
      this.val = val;
    }
    
    public boolean insert(String dir, int val){
      
      if(dirs.containsKey(dir)) return false;
      
      dirs.put(dir, new TrieNode(val));
      
      return true;
    }
    

    
  }
  
    TrieNode root;
  
    public FileSystem() {
         root = new TrieNode(0);
    }
    

  public boolean createPath(String path, int val){
    
    String[] dirs = path.split("/");
    TrieNode tn = search(path, dirs, dirs.length-1);
    
    return tn != null && tn.insert(dirs[dirs.length-1], val);
  }
  

  public int get(String path){
    String[] dirs = path.split("/");
    TrieNode tn = search(path, dirs, dirs.length);
    
    return tn!=null?tn.val:-1;
    
  }

  private TrieNode search(String path, String[] dirs, int end){
    TrieNode c = root;
    
    for(int i = 1; i < end; i++){
      
      String d = dirs[i];
      
      c = c.dirs.getOrDefault(d, null);
      
      if(c == null){
        return null;
      }
    }
    return c;
  }
  
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */