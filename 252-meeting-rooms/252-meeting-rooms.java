class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals == null) return false;
        if(intervals.length <= 1) return true;
        
        // Sort by start time
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        
        for(int i = 0; i < intervals.length - 1; i++){
            
            int[] interval = intervals[i];
            int[] nextInterval = intervals[i+1];
            
            // Protect against invalid intervals
            if (interval == null || interval.length != 2 || interval[1] < interval[0])
                return false;
            
            if (nextInterval == null || nextInterval.length != 2 || nextInterval[1] < nextInterval[0])
                return false;
            
            // Check for overlap
            if(nextInterval[0] < interval[1]){
                return false;
            }
        }
        return true;
    
    }
}