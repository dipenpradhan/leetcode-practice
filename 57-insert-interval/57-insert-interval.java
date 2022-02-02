class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> res = new ArrayList<int[]>();
      int sn = newInterval[0];
      int en = newInterval[1];
      
      int i = 0;
      while(i < intervals.length){
          int s = intervals[i][0];
          int e = intervals[i][1];
        
          if(e < sn){
              res.add(intervals[i]);
          }else if(s>en){
              break;
          }else{
              sn = Math.min(s, sn);
              en = Math.max(e, en);
          }
          i++;

      }
      res.add(new int[]{sn, en});
      while(i < intervals.length){
         res.add(intervals[i]);
          i++;
      }
      int[][] result = new int[res.size()][];
      for(int r = 0; r < res.size(); r++){
         result[r] = res.get(r);
      }
    
    return result;
    
  }
}