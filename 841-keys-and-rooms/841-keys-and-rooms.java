class Solution {
    
    /*
      dfs(0, rooms, []
            
      fn dfs(room, rooms, visited
        
        if visited size == no. of rooms
          exit TRUE
        
        if room is present in visited set
          exit FALSE
        
        
        add room to visited

        loop through keys for room:
          
          if dfs(key, rooms, visited is true
            exit TRUE
          
        exit FALSE      
      
  */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    
    if(rooms == null || rooms.size() == 0){
      return false;
    }
    
    Set<Integer> visited = new HashSet<Integer>();
    
    return dfs(0, rooms, visited);
    
  }
  
  // [[1],[2, 1],[3],[]]
  
  private boolean dfs(int room, List<List<Integer>> rooms, Set<Integer> visited){

    
    if(visited.contains(room)){
      return false;
    }
    
    visited.add(room);

    if(visited.size() == rooms.size()){
      return true;
    }
    
    List<Integer> keys = rooms.get(room);
    
    if(keys == null){
      return false;
    }
    
    for(int key: keys){
       boolean success = dfs(key, rooms, visited);  
       // 1, rooms, [0] // 2 [0,1] // 3 [0,1,2] // [0,1,2,3]
       
      if(success){
        return true;
      }
    }
    
    return false;
  }
  
}