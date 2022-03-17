class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> result = new ArrayList<int[]>();
        int s = -1, e = -1;
        Arrays.sort(intervals,(a,b)->{
            int diff = a[0]-b[0];
            if(diff == 0) return a[1]-b[1];
            return diff;
            }
                );
        for(int[] ivl: intervals){
            int st = ivl[0], en = ivl[1];
            if(s==-1 || e == -1){
                s = st;
                e = en;
            }else if(e>=st){
                e = Math.max(e,en);
            }else{
                result.add(new int[]{s,e});
                s = st;
                e = en;
            }
        }
        if(s>=0 && e>=0)
            result.add(new int[]{s,e});
        
        int[][] res = new int[result.size()][];
        for(int i=0; i<result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
}