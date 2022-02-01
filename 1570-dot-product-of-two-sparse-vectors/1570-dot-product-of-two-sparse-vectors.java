class SparseVector {
    Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        this.map = buildMap(nums);
    }
    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        Map<Integer, Integer> sm = map.size()>vec.map.size()?vec.map:map;
        Map<Integer, Integer> lg = map.size()>vec.map.size()?map:vec.map;
        
        for(Map.Entry<Integer, Integer> en: sm.entrySet()){
            res += en.getValue() * lg.getOrDefault(en.getKey(), 0);
        }
        return res;
    }
    
    
    private Map<Integer, Integer> buildMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(n>0){
                map.put(i, n);
            }
        }
        return map;
    }
	
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);