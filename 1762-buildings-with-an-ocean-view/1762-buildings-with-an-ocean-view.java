class Solution {
    public int[] findBuildings(int[] h) {
        
        int max = -1;
        List<Integer> lst = new ArrayList<Integer>();
        
        for(int i = h.length-1; i >= 0; i--){
            if(h[i] > max){
                lst.add(i);
                max = h[i];
            }
        }
        
        int[] res = new int[lst.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = lst.get(res.length - 1 - i);
        }

        return res;
    }
}