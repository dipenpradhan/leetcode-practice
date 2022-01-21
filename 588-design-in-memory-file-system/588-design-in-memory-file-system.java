class FileSystem {

    static final class TNode{
        Map<String, TNode> links = new HashMap<String, TNode>(); // Use TreeMap for pre-sorting
        StringBuilder data;
        
        boolean isFile(){
            return data!=null;
        }
        void append(String d){
            if(data==null) data = new StringBuilder();
            data.append(d);
        }
    }
    
    TNode root = new TNode();
    
    public FileSystem() {
        
    }
    TNode search(TNode tn, String[] dirs, int end){
        for(int i = 1; i < end; i++){
            String d = dirs[i];
            if(!tn.links.containsKey(d)){
                return null;
            }
            tn = tn.links.get(d);
        }
        return tn;
    }
    public List<String> ls(String path) {
        
        String[] dirs = path.split("/");
        TNode tn = search(root, dirs, dirs.length-1);
        List<String> res = new ArrayList<String>();
        
        if(path.equals("/")) {
            res.addAll(root.links.keySet());
            Collections.sort(res); // Remove if using TreeMap
            return res;
        }
        
        String last = dirs.length > 0? dirs[dirs.length-1] : null;
        
        if(last != null && tn!=null && tn.links.containsKey(last) && tn.links.get(last).isFile()){
            res.add(last);
        }else if(tn.links.containsKey(last)){
            res.addAll(tn.links.get(last).links.keySet());
        }
        Collections.sort(res); // remove if using TreeMap
        return res;
    }
    
    public void mkdir(String path) {
        String[] dirs = path.split("/");
        mkdir(dirs, dirs.length);
        
    }
    TNode mkdir(String[] dirs, int end){
        TNode tn = root;
        for(int i = 1; i < end; i++){
            String d = dirs[i];
            if(!tn.links.containsKey(d)){
                tn.links.put(d, new TNode());
            }
            tn = tn.links.get(d);
        }
        return tn;
    }
    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        TNode tn = mkdir(dirs, dirs.length-1);
        
        String fnam = dirs[dirs.length-1];
            if(!tn.links.containsKey(fnam)){
                tn.links.put(fnam, new TNode());
            }
        TNode f = tn.links.get(fnam);
        f.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        TNode tn = search(root, dirs, dirs.length);
        return tn!=null ? tn.isFile() ? tn.data.toString():null:null;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */