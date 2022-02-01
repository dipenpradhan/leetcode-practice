class SparseVector {
    Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        this.map = buildMap(nums);
    }
    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for(Map.Entry<Integer, Integer> en: vec.map.entrySet()){
            res += en.getValue() * map.getOrDefault(en.getKey(), 0);
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