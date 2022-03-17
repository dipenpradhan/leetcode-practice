class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int s = -1, e = -1;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        for(int i = 0; i < intervals.length; i++){
            int si = intervals[i][0];
            int ei = intervals[i][1];
            if(e>si){
                return false;
            }else{
                s = si;
                e = ei;
            }
        }
        return true;
    }
}