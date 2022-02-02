class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        int i = 1;
        int s = intervals[0][0], e=intervals[0][1];
        while(i < intervals.length){
            int sn = intervals[i][0];
            int en = intervals[i][1];
            
            if(e<sn){
                res.add(new int[]{s,e});
                s=sn;
                e=en;
            }else{
                e = Math.max(e, en);
            }
            i++;
        }
        res.add(new int[]{s,e});
        
        int[][] result = new int[res.size()][];
        for(int r = 0; r < res.size(); r++){
            result[r] = res.get(r);
        }
        
        return result;
    }
}