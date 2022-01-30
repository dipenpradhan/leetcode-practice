class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        int i = num.length-1;
        int c = 0;
        
        while(i>=0 || k>0){
            
            int d = i>=0?num[i--]:0;
            int r = d + k%10 + c;
            res.add(r%10);
            c=r/10;
            k/=10;
        }
        if(c>0)res.add(c);
        Collections.reverse(res);
        return res;
    }
}